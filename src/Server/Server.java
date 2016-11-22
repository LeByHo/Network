package Server;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Handler;

import javax.swing.JOptionPane;


public class Server {
	private static final int PORT = 9001;

	public static void main(String[] args) throws Exception {
		Server ser = new Server();
		ser.connect();
		System.out.println("The chat server is running.");

	}
	public void connect() throws IOException {
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			System.out.println("Server start...");
			while (true){
				try {
					Socket socket = serverSocket.accept();
					Thread t = new ServerThread(socket);
					t.start(); 
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	class ServerThread extends Thread {

		Socket socket = null;
		BufferedReader inFromclient = null;
		DataOutputStream outToClient = null;

		public ServerThread(Socket soc) {
			socket = soc;
			try {
				inFromclient = new BufferedReader(new InputStreamReader(socket.getInputStream() ) );
				outToClient = new DataOutputStream(socket.getOutputStream());
			}
			catch (IOException e){
				e.printStackTrace();
			}
		}

		public void run(){
			try {
				while(true){
					String packet = inFromclient.readLine();
					if (packet != null) 
						outToClient.writeBytes(check(packet)+'\n');
					else
						return;
				}
			} catch (IOException e) {
				System.out.println("qweqwe4");
				e.printStackTrace();
			}
			try {
				System.out.println("Server End");
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public String check(String packet){
			String[] arr = packet.split(" ");
			Connection conn;
			Statement stmt;
			String result=null;
			ResultSet rs = null;

			Scanner sc = new Scanner(System.in);
			try {
				Class.forName("com.mysql.jdbc.Driver");//드라이버 로딩: DriverManager에 등록
			}catch(ClassNotFoundException e) {
				System.err.print("ClassNotFoundException: ");
			}

			try {
				String jdbcUrl = "jdbc:mysql://localhost/member";//사용하는 데이터베이스명을 포함한 url
				String userId = "root";//사용자계정
				String userPass = "12345";//사용자 패스워드

				conn = DriverManager.getConnection(jdbcUrl, userId, userPass);//Connection 객체를 얻어냄
				stmt = conn.createStatement();//Statement 객체를 얻어냄

				System.out.println("제대로 연결되었습니다");//성공시 화면에 표시됨
				if(arr[0].equals("ID")){
					rs = stmt.executeQuery("select * from guest where id ='" + arr[1] + "' ");
					if(rs.next()==false) 
						result = "NULL";
					else{
						String pass = rs.getString("password");
						if(pass.equals(arr[2])){
							result = rs.getString("name")+" "+rs.getString("age")+" "+rs.getString("come");
						}
						else
							result = "Npass";
					}
				}
				else if(arr[0].equals("JOIN")){
					if(arr.length==5){
						int tem = Integer.parseInt(arr[2]);
						stmt.executeUpdate("insert into guest values('" + arr[1] + "','" + tem + "','" + arr[3] + "','" + arr[4] + "','" + 0 + "')");
						result = "com";
					}
					else{
						int tem = Integer.parseInt(arr[3]);
						stmt.executeUpdate("update guest set come='" + arr[3] + "' where id ='" + arr[1] + "'and password='" + arr[2] + "' ");
					}
				}
				else if(arr[0].equals("FIND")){
					if(arr.length<4){
						rs = stmt.executeQuery("select * from guest where name ='" + arr[1] + "'and age ='" + Integer.parseInt(arr[2]) + "' ");
						if(rs.next()==false)
							result = "NULL";

						else{
							String st = rs.getString("id");
							result =  st;
						}
					}
					else{
						rs = stmt.executeQuery("select * from guest where name ='" + arr[1] + "'and age ='" + Integer.parseInt(arr[2]) + "'and id ='" + arr[3] + "' ");
						if(rs.next()==false)
							result =  "NULL";
						else{
							String st = rs.getString("password");
							result =  st;
						}
					}
				}
				else{
					if(arr.length==1){
						rs = stmt.executeQuery("select * from room where room ='" + 0 + "' ");
						if(rs.next()!=false)
							result = rs.getString("room1")+" "+rs.getString("room2")+" "+rs.getString("room3")+" "+rs.getString("room4")
							+" "+rs.getString("room5")+" "+rs.getString("room6")+" "+rs.getString("room7")+" "+rs.getString("room8")+" "+rs.getString("room9");		
					}
					else{
						if(arr[1].equals("In"))
							stmt.executeUpdate("update room set "+arr[2]+" = "+arr[2]+" + '"+ 1 +"'");
						else
							stmt.executeUpdate("update room set "+arr[2]+" =  "+arr[2]+" - '"+ 1 +"'");
					}
				}
			}catch(SQLException e) {
				System.out.println("SQLException: " + e.getMessage());
			}
			return result;
		}
	}
}
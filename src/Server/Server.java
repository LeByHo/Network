package Server;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Handler;

import javax.swing.JOptionPane;


public class Server {
	private static ArrayList<String> names = new ArrayList<String>();
	private static ArrayList<DataOutputStream> writers = new ArrayList<DataOutputStream>();

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
		String name;
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
					if(packet!=null){
						if(packet.startsWith("chat")){
							String[] tep = packet.split(" ");
							chatting(tep[1]);
						}
						else
							outToClient.writeBytes(check(packet)+'\n');
					}
					else
						return;
				}
			} catch (IOException e) {
				System.out.println("t1");
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
				Class.forName("com.mysql.jdbc.Driver");//����̹� �ε�: DriverManager�� ���
			}catch(ClassNotFoundException e) {
				System.err.print("ClassNotFoundException: ");
			}

			try {
				String jdbcUrl = "jdbc:mysql://localhost/member";//����ϴ� �����ͺ��̽����� ������ url
				String userId = "root";//����ڰ���
				String userPass = "12345";//����� �н�����

				conn = DriverManager.getConnection(jdbcUrl, userId, userPass);//Connection ��ü�� ��
				stmt = conn.createStatement();//Statement ��ü�� ��

				//System.out.println("����� ����Ǿ����ϴ�");//������ ȭ�鿡 ǥ�õ�
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
				else if(arr[0].equals("word")){
					if(arr[1].equals("word")){
						rs = stmt.executeQuery("select word from economy");
						if(rs.next()!=false){
							result = rs.getString("word")+" ";
							while(rs.next()){
								result += rs.getString("word")+" ";
							}
						}
					}
					else{
						rs = stmt.executeQuery("select mean from economy");
						if(rs.next()!=false){
							result = rs.getString("mean")+" ";
							while(rs.next()){
								result += rs.getString("mean")+" ";
							}
						}
					}
					return result;
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
		public void chatting(String str) throws IOException {
			try{
				System.out.println("str1"+" "+str);
				while (true) {
					outToClient.writeBytes("SUBMITNAME"+'\n');
					name = str;
					System.out.println("str2"+" "+name);
					if (name == null) {
						return;
					}
					synchronized (names) {
						if (!names.contains(name)) {
							names.add(name);
							break;
						}
					}
				}

				//boardcast message that new client log in
				outToClient.writeBytes("NAMEACCEPTED"+'\n');
				writers.add(outToClient);
				for (DataOutputStream writer : writers) 
					writer.writeBytes("MESSAGE " + "  =>>" +name + " is log-in."+'\n');

				// if equal fomat that /w name, whisper cilent
				while (true) {
					String input = str;
					System.out.println("str3"+" "+input);
					if (input == null) {
						return;
					}
					String arr[] = input.split(" ");
					System.out.println("str4"+" "+arr[0]);
					String message = "";

					for(int a = 2; a < arr.length; a++) {
						message += arr[a] + " ";
					}
					if (arr[0].equals("/w") || arr[0].equals("/W")) {
						for (int i = 0; i < writers.size(); i++) {
							if(arr[1].equals(names.get(i))||(name.equals(names.get(i)))) { 
								writers.get(i).writeBytes("MESSAGE " + "  W) " + name + ": " + message+'\n');
							}
						}
					}
					else {
						for (DataOutputStream writer : writers) {
							writer.writeBytes("MESSAGE " + " ["+name + "] " + input+'\n');
						}
					}
				}
			} 
			catch (IOException e) {
				System.out.println(e);
			}
			//client exit chatting room print other cilent log-out massage
			finally  {
				String temp = null;
				if (name != null) {
					temp = name;
					names.remove(name);
				}
				if (outToClient != null) {
					writers.remove(outToClient);
					for (DataOutputStream writer : writers) {
						writer.writeBytes("MESSAGE " + "  =>>" +temp + " is log-out."+'\n');
					}
				}
			}
		}
	}
}

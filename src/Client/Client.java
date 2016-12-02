package Client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

import Login.Login;

public class Client {
	public static Socket Socket = null;
	public static Socket ChatSoc = null;
	static DataOutputStream outToServer = null;
	static BufferedReader inFromServer=null;
	public static PrintWriter out = null;
	public static BufferedReader in=null;
	public static void main(String[] args) throws Exception {
		Client client = new Client();
		client.run();
		init();
		Login lo = new Login();
		/*try {
			File file = new File("C:/Users/Han/workspace/Voca-Pop/gal.wav");
			AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(stream);
			clip.start();
			// stream.close();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}*/
	}

	private void run() throws IOException {
		String serverAddress = java.net.InetAddress.getLocalHost().getHostAddress();
		try{
			Socket = new Socket(serverAddress, 9001);
			ChatSoc = new Socket(serverAddress, 9002);
		}catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void init() throws IOException {
		out = new PrintWriter(ChatSoc.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(ChatSoc.getInputStream()));	
	}

	public static String Checkid(DTO dto) throws Exception {
		String str = "ID"+" "+dto.getId()+" "+dto.getPassword();
		outToServer = new DataOutputStream(Socket.getOutputStream());
		outToServer.writeBytes(str+'\n');
		inFromServer = new BufferedReader(new InputStreamReader(Socket.getInputStream()));
		String answer = inFromServer.readLine();
		return answer;
	}

	public static String repuId(DTO dto) throws IOException{
		String str = "ID"+" "+dto.getId()+" "+"temp";
		outToServer = new DataOutputStream(Socket.getOutputStream());
		outToServer.writeBytes(str+'\n');
		inFromServer = new BufferedReader(new InputStreamReader(Socket.getInputStream()));
		String answer = inFromServer.readLine();
		if(!(answer.equals("NULL")))
			return "NULL";
		return "0";
	}

	public static String Insertinfo(DTO dto) throws IOException{
		String str = "JOIN"+" "+dto.getName()+" "+dto.getAge()+" "+ dto.getId()+" "+dto.getPassword();
		outToServer = new DataOutputStream(Socket.getOutputStream());
		outToServer.writeBytes(str+'\n');
		inFromServer = new BufferedReader(new InputStreamReader(Socket.getInputStream()));
		String answer = inFromServer.readLine();
		if(answer.equals("com"))
			return "com";
		return "0";
	}

	public static String FindId(DTO dto) throws IOException{
		String str = "FIND"+" "+dto.getName()+" "+dto.getAge();
		outToServer = new DataOutputStream(Socket.getOutputStream());
		outToServer.writeBytes(str+'\n');
		inFromServer = new BufferedReader(new InputStreamReader(Socket.getInputStream()));
		String answer = inFromServer.readLine();
		if(!(answer.equals("NULL")))
			return answer;
		return "NULL";
	}

	public static String FindPw(DTO dto) throws IOException{
		String str = "FIND"+" "+dto.getName()+" "+dto.getAge()+" "+dto.getId();
		outToServer = new DataOutputStream(Socket.getOutputStream());
		outToServer.writeBytes(str+'\n');
		inFromServer = new BufferedReader(new InputStreamReader(Socket.getInputStream()));
		String answer = inFromServer.readLine();
		if(!(answer.equals("NULL")))
			return answer;
		return "NULL";
	}

	public static void Insertcome(DTO dto) throws IOException{
		String str = "JOIN"+" "+dto.getId()+" "+dto.getPassword()+" "+dto.getCome();
		outToServer = new DataOutputStream(Socket.getOutputStream());
		outToServer.writeBytes(str+'\n');
	}

	public static String GetRoomCount() throws IOException{
		outToServer = new DataOutputStream(Socket.getOutputStream());
		outToServer.writeBytes("Room"+'\n');
		inFromServer = new BufferedReader(new InputStreamReader(Socket.getInputStream()));
		String answer = inFromServer.readLine();
		return answer;
	}

	public static void Insertname(String str) throws IOException{
		outToServer = new DataOutputStream(Socket.getOutputStream());
		outToServer.writeBytes("Insert"+" "+str+'\n');
		inFromServer = new BufferedReader(new InputStreamReader(Socket.getInputStream()));
		String answer = inFromServer.readLine();
	}
	
	public static String Bringname() throws IOException{
		outToServer = new DataOutputStream(Socket.getOutputStream());
		outToServer.writeBytes("Bring"+'\n');
		inFromServer = new BufferedReader(new InputStreamReader(Socket.getInputStream()));
		String answer = inFromServer.readLine();
		return answer;
	}
	
	public static void InsertRoom(String str) throws IOException{
		outToServer = new DataOutputStream(Socket.getOutputStream());
		outToServer.writeBytes("Room"+" "+"In"+" "+str+'\n');
		inFromServer = new BufferedReader(new InputStreamReader(Socket.getInputStream()));
		String answer = inFromServer.readLine();
	}

	public static void DeletetRoom(String str) throws IOException{
		outToServer = new DataOutputStream(Socket.getOutputStream());
		outToServer.writeBytes("Room"+" "+"Out"+" "+str+'\n');
		inFromServer = new BufferedReader(new InputStreamReader(Socket.getInputStream()));
		String answer = inFromServer.readLine();
	}

	public static String getword(int cate) throws IOException{
		outToServer = new DataOutputStream(Socket.getOutputStream());
		outToServer.writeBytes("word"+" "+"word"+" "+cate+'\n');
		inFromServer = new BufferedReader(new InputStreamReader(Socket.getInputStream()));
		String answer = inFromServer.readLine();
		return answer;
	}

	public static String getmean(int cate) throws IOException{
		outToServer = new DataOutputStream(Socket.getOutputStream());
		outToServer.writeBytes("word"+" "+"mean"+" "+cate+'\n');
		inFromServer = new BufferedReader(new InputStreamReader(Socket.getInputStream()));
		String answer = inFromServer.readLine();
		return answer;
	}
}

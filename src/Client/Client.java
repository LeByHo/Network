package Client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Login.Login;

public class Client {
	public static Socket Socket = null;
	static DataOutputStream outToServer = null;
	static BufferedReader inFromServer=null;
	public static void main(String[] args) throws Exception {
		Client client = new Client();
		client.run();
		Login lo = new Login();
	}

	private void run() throws IOException {
		String serverAddress = java.net.InetAddress.getLocalHost().getHostAddress();
		try{
			Socket = new Socket(serverAddress, 9001);
		}catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
}

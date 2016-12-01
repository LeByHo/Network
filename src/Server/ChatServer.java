package Server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {

	/* The port that the server listens on.*/

	private static final int PORT = 9002;

	//Create arraylist for name
	private static ArrayList<String> names = new ArrayList<String>();

	private static ArrayList<PrintWriter> writers = new ArrayList<PrintWriter>();

	////Create thread when cilent connect
	public static void main(String[] args) throws Exception {
		System.out.println("The chat server is running.");
		ServerSocket listener = new ServerSocket(PORT);
		try {
			while (true) {
				new Handler(listener.accept()).start();
			}
		} finally {

			listener.close();
		}	
	}

	private static class Handler extends Thread {
		private String name;
		private Socket socket;
		private BufferedReader in;
		private PrintWriter out;


		public Handler(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			try {
				// Create character streams for the socket.
				in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream(), true);

				// Request a name from this client.  Keep requesting until
				// a name is submitted that is not already used.  Note that
				// checking for the existence of a name and adding the name
				// must be done while locking the set of names.
				while (true) {
					out.println("SUBMITNAME");
					name = in.readLine();
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
				out.println("NAMEACCEPTED");
				writers.add(out);
				for (PrintWriter writer : writers) {
					writer.println("MESSAGE " + "  =>>" +name + " is log-in.");
				}
				// if equal fomat that /w name, whisper cilent
				while (true) {
					String input = in.readLine();
					if (input == null) {
						return;
					}
					String arr[] = input.split(" ");
					String message = "";

					for(int a = 2; a < arr.length; a++) {
						message += arr[a] + " ";
					}
					if (arr[0].equals("/w") || arr[0].equals("/W")) {
						for (int i = 0; i < writers.size(); i++) {
							if(arr[1].equals(names.get(i))||(name.equals(names.get(i)))) { 
								writers.get(i).println("MESSAGE " + "  W) " + name + ": " + message);
							}
						}
					}
					else {
						for (PrintWriter writer : writers) {
							writer.println("MESSAGE " + " ["+name + "] " + input);
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
				if (out != null) {
					writers.remove(out);
					for (PrintWriter writer : writers) {
						writer.println("MESSAGE " + "  =>>" +temp + " is log-out.");
					}
				}
				try {
					socket.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
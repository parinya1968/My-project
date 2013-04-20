/**
 * 
 */

/**
 * @author Alfie
 *
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class simpleServer implements Runnable{
	public void run(){
			try{
				ServerSocket serverSocket = new ServerSocket(4446);
				Socket client = null;
				System.out.println("Server Started");
				String message = "Goodbye";
				while(true){
					client = serverSocket.accept();
					System.out.println("Client accept : " +client);
					try{
						BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
						String str = in.readLine();
						System.out.println("read: " +str);
						PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())),true);
						
						out.println(message);
						out.close();
						in.close();
					} catch(Exception e){
						client.close();
						System.out.println("close");
						System.out.println(e.getMessage());
						e.printStackTrace();
					}
				}
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
		
	}
	
	public static void main(String a[]){
		Thread desktopServerThread = new Thread(new simpleServer());
		desktopServerThread.start();
	}
}

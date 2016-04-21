package jsr356.tyrus.server;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.glassfish.tyrus.server.Server;




/**
 *  
 * @author kwang
 *
 */
public class ServerTest {

	public static void main(String[] args) {
		
		 Server server = new Server("localhost", 8025, "/websockets", null, EchoEndpoint.class);

		    try {
		        server.start();		
		        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		        System.out.print("Please press a key to stop the server.");
		        reader.readLine();
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        server.stop();
		    }
		
		
	}
}

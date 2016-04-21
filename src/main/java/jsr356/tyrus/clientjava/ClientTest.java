package jsr356.tyrus.clientjava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.websocket.ClientEndpointConfig;

import org.glassfish.tyrus.client.ClientManager;

public class ClientTest {
    private static CountDownLatch messageLatch;
    private static final String SENT_MESSAGE = "Hello World0000";

    public static void main(String [] args){
        try {
            messageLatch = new CountDownLatch(1);

            final ClientEndpointConfig cec = ClientEndpointConfig.Builder.create().build();

            ClientManager client = ClientManager.createClient();
            client.connectToServer(new ClientEndponit(), cec, new URI("ws://localhost:8025/websockets/echo"));
            messageLatch.await(100, TimeUnit.SECONDS);
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        System.out.print("Please press a key to stop the client.");
	        while (true) {
	        	String s = reader.readLine();
	        	if ("Y".equals( s)) {
	        		break;
				} else {
					System.out.println(s);
				}
	        	
				
			}
	       
	        
	        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
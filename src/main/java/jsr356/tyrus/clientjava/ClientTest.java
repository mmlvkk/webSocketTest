package jsr356.tyrus.clientjava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.websocket.ClientEndpointConfig;
import javax.websocket.Endpoint;

import org.glassfish.tyrus.client.ClientManager;

public class ClientTest {
    private static CountDownLatch messageLatch;
    private static final String SENT_MESSAGE = "Hello World0000";
    

    public static void main(String [] args){
        try {
            messageLatch = new CountDownLatch(1);

            final ClientEndpointConfig cec = ClientEndpointConfig.Builder.create().build();
            ClientManager client = ClientManager.createClient();
            ClientEndponit endpoint =  new ClientEndponit();
            client.connectToServer(endpoint, cec, new URI("ws://localhost:8025/websockets/echo"));
//            messageLatch.await(100, TimeUnit.SECONDS);
            
          
	        while (true) {
	        	  System.out.println("Please press a key to stop the client.");
	        	  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	  	       
	        	String s = reader.readLine();
	        	if ("Y".equals( s)) {
	        		break;
				} else {
					System.out.println("客户端发送："+s);
					endpoint.sendMessage(s);
				}
	        	
				
			}
	       
	        
	        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
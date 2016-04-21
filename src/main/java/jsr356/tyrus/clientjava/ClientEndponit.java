package jsr356.tyrus.clientjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;

public class ClientEndponit extends Endpoint{
	
	private Session session = null;


    @Override
    public void onOpen(Session session, EndpointConfig config) {
        try {
        	this.session=session;
            session.addMessageHandler(new MessageHandler.Whole<String>() {

                @Override
                public void onMessage(String message) {
                    System.out.println("Received message: "+message);
                   
                }
            });
            
//            session.getBasicRemote().sendText("12345");
	     
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void sendMessage(String message) {
    	try {
			session.getBasicRemote().sendText(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    


}

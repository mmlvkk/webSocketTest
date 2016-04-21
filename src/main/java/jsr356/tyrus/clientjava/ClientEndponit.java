package jsr356.tyrus.clientjava;

import java.io.IOException;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;

public class ClientEndponit extends Endpoint{


    @Override
    public void onOpen(Session session, EndpointConfig config) {
        try {
            session.addMessageHandler(new MessageHandler.Whole<String>() {

                @Override
                public void onMessage(String message) {
                    System.out.println("Received message: "+message);
                   
                }
            });
            session.getBasicRemote().sendText("ia app 客梯车");
            session.getBasicRemote().sendText("摆渡车");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

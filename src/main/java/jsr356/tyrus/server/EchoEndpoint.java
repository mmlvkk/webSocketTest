package jsr356.tyrus.server;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class EchoEndpoint {
	public static List<Basic> CLIENTS= new ArrayList<Basic>();

    @OnOpen
    public void onOpen(Session session) throws IOException {
    	CLIENTS.add(session.getBasicRemote());
        session.getBasicRemote().sendText("onOpen");
    }
    
//    @OnMessage
//    public String echo(String message) {
//    	System.out.println(l.size());
//    	System.out.println("接收到了客户端数据："+message);
//        return message + " (from your server)";
//    }
    @OnMessage
    public void echo(String message) {
    
    
    	for (int i = 0; i < CLIENTS.size(); i++) {
    		try {
				CLIENTS.get(i).sendText("服务器推送" +message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	
    	System.out.println("接收到了客户端数据："+message);
    }
    
    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
    }

    @OnClose
    public void onClose(Session session) {

    }
}
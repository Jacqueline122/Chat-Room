package edu.udacity.java.nano.chat;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WebSocket Server
 *
 * @see ServerEndpoint WebSocket Client
 * @see Session   WebSocket Session
 */

@Component
@ServerEndpoint("/chat/{username}")
public class WebSocketChatServer {

    /**
     * All chat sessions.
     */
    private static Map<String, Session> onlineSessions = new ConcurrentHashMap<>();


    private static void sendMessageToAll(String msg) {
        //TODO: add send message method.
        for (Session s: onlineSessions.values()){
            try {
                s.getBasicRemote().sendText(msg);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    /**
     * Open connection, 1) add session, 2) add user.
     */
    @OnOpen
    public void onOpen(Session session,  @PathParam("username") String username) {
        //TODO: add on open connection.
        onlineSessions.put(session.getId(), session);
        Message msg = new Message(" joined the chat room.", username,  onlineSessions.size(), "ENTER");
        sendMessageToAll(JSON.toJSONString(msg));

    }

    /**
     * Send message, 1) get username and session, 2) send message to all.
     */
    @OnMessage
    public void onMessage(Session session, String jsonStr) {
        //TODO: add send message.
        Message message = JSON.parseObject(jsonStr, Message.class);
        sendMessageToAll(JSON.toJSONString(new Message(message.getMsg(), message.getUsername(), onlineSessions.size(), "SPEAK")));
    }

    /**
     * Close connection, 1) remove session, 2) update user.
     */
    @OnClose
    public void onClose(Session session) {
        //TODO: add close connection.
        onlineSessions.remove(session.getId());
        Message msg = new Message(" Leave the chat.", "",onlineSessions.size(), "LEAVE");
        sendMessageToAll(JSON.toJSONString(msg));

    }

    /**
     * Print exception.
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

}






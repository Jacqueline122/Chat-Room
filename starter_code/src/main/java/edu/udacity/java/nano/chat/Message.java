package edu.udacity.java.nano.chat;

import com.alibaba.fastjson.JSON;

/**
 * WebSocket message model
 */
public class Message {
    // TODO: add message model.
    private String username;
    private String msg;
    private int onlineCount;
    private String type;


    public Message(String msg, String username, int onlineCount, String type) {

        this.msg = msg;
        this.username = username;
        this.onlineCount = onlineCount;
        this.type = type;
    }

    public String getUsername() {

        return username;
    }

    public void setName(String username) {

        this.username = username;
    }

    public int getOnlineCount() {

        return this.onlineCount;
    }


    public void setOnlineCount(int onlineCount) {

        this.onlineCount = onlineCount;
    }

    public String getType() {
        return type;
    }

    void setType(String type) {

        this.type = type;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }



}






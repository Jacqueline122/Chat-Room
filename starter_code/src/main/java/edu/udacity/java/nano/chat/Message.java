package edu.udacity.java.nano.chat;

/**
 * WebSocket message model
 */
public class Message {
    // TODO: add message model.
    private String username;
    private String msg;
    private int onlineCount;
    private String type;
    public Message() {
    }

    public Message(String text, String user, int onlineCount, String type) {

        this.msg = text;
        this.username = user;
        this.onlineCount = onlineCount;
        this.type = type;
    }

    public String getName() {

        return username;
    }

    public void setName(String name) {

        this.username = name;
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
}

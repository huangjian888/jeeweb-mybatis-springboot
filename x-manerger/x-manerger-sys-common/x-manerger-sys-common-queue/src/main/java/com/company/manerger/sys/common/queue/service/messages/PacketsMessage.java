package com.company.manerger.sys.common.queue.service.messages;

import com.corundumstudio.socketio.SocketIOClient;

import java.io.Serializable;

public class PacketsMessage implements Serializable {
    private static final long serialVersionUID = -1;
    private String userid;
    private String message;
    private String event;
    private SocketIOClient client;
    private PacketsMessage subPacketsMessage;
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public SocketIOClient getClient() {
        return client;
    }

    public void setClient(SocketIOClient client) {
        this.client = client;
    }

    public PacketsMessage getSubPacketsMessage() {
        return subPacketsMessage;
    }

    public void setSubPacketsMessage(PacketsMessage subPacketsMessage) {
        this.subPacketsMessage = subPacketsMessage;
    }
}

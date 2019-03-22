package com.company.manerger.sys.common.queue.bean;

import java.io.Serializable;

public class EventTopicBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private long startTime;
    private String host;
    private int port;
    private String event;
    private Object data;

    public EventTopicBean(String id, String event, Object data) {
        this.id = id;
        this.event = event;
        this.data = data;
    }

    public EventTopicBean(String id, long startTime, String host, int port) {
        this.id = id;
        this.startTime = startTime;
        this.host = host;
        this.port = port;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public long getStartTime() { return startTime; }
    public void setStartTime(long startTime) { this.startTime = startTime; }

    public String getEvent() {return event; }
    public void setEvent(String event) { this.event = event; }

    public int getPort() { return port; }
    public void setPort(int port) { this.port = port; }

    public String getHost() { return host; }
    public void setHost(String host) { this.host = host; }

    public Object getData() { return data; }
    public void setData(Object data) { this.data = data; }

}

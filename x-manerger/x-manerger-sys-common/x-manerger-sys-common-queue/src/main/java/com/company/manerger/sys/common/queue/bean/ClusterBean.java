package com.company.manerger.sys.common.queue.bean;

import java.io.Serializable;

public class ClusterBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private static ClusterBean mInstance = null;
    private boolean master = false;
    private String id;
    private long startTime;
    private String host;
    private int port;

    public static ClusterBean getInstance(){
        if(mInstance == null){
            synchronized (ClusterBean.class){
                if(mInstance == null){
                    mInstance = new ClusterBean();
                }
            }
        }
        return mInstance;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public long getStartTime() { return startTime; }
    public void setStartTime(long startTime) { this.startTime = startTime; }

    public String getHost() { return host; }
    public void setHost(String host) { this.host = host; }

    public int getPort() { return port; }
    public void setPort(int port) { this.port = port; }

    public boolean isMaster() { return master; }
    public void setMaster(boolean master) { this.master = master; }
}

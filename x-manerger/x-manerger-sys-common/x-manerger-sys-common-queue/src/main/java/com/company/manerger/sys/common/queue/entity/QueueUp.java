package com.company.manerger.sys.common.queue.entity;


import com.company.manerger.sys.common.queue.service.messages.PacketsMessage;

import java.io.Serializable;

/**
 * 排队状态
 */
public class QueueUp implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String userid; //用户id
    private PacketsMessage packetsMessage;
    private int onLineUsers; //当前在线总用户数
    private long totalQueueUpNum; //总排队用户数->排队队列中的总用户数量
    private long currentQueueUpNum;//当前用户排队数->当前用户排队位置

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getOnLineUsers() {
        return onLineUsers;
    }

    public void setOnLineUsers(int onLineUsers) {
        this.onLineUsers = onLineUsers;
    }

    public long getTotalQueueUpNum() {
        return totalQueueUpNum;
    }

    public void setTotalQueueUpNum(long totalQueueUpNum) {
        this.totalQueueUpNum = totalQueueUpNum;
    }

    public long getCurrentQueueUpNum() {
        return currentQueueUpNum;
    }

    public void setCurrentQueueUpNum(long currentQueueUpNum) {
        this.currentQueueUpNum = currentQueueUpNum;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public PacketsMessage getPacketsMessage() {
        return packetsMessage;
    }

    public void setPacketsMessage(PacketsMessage packetsMessage) {
        this.packetsMessage = packetsMessage;
    }
}

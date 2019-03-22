package com.company.manerger.sys.common.queue.service.handler;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.company.manerger.sys.common.queue.cache.hazelcast.HazelcastCacheHelper;
import com.company.manerger.sys.common.queue.clients.NettySockIoClients;
import com.company.manerger.sys.common.queue.entity.OnlineUser;
import com.company.manerger.sys.common.queue.entity.QueueUp;
import com.company.manerger.sys.common.queue.service.impl.QueueUpImpl;
import com.company.manerger.sys.common.queue.service.messages.PacketsMessage;
import com.company.manerger.sys.common.queue.utils.EventUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;


public class QueueEventHandler {
    protected SocketIOServer socketIOServer;

    @Autowired
    public QueueEventHandler(SocketIOServer socketIOServer) {
        this.socketIOServer = socketIOServer;
    }

    @OnConnect
    public void onConnect(SocketIOClient client){
        /**
         * 模拟操作（用户登录-》将用户信息写入OnlineUsersCacheImpl缓存-》将用户信息写入OnlineUsers在线用户表-》更新OnlineUsersCacheImpl缓存-》client和userid放入NettySockIoClients 进行绑定）
         */
        String userid = client.getHandshakeData().getSingleUrlParam("userid");
        /******************模拟数据*****************/
        OnlineUser onlineUser = new OnlineUser();
        onlineUser.setId("id");
        onlineUser.setUserid(userid);
        HazelcastCacheHelper.getInstance().getOnLineUserCacheBean().put(userid,onlineUser);
        /*******************************************/
        if(!StringUtils.isBlank(userid)){
            if(HazelcastCacheHelper.getInstance().getOnLineUserCacheBean().getHazelcastCacheObject(userid) != null){ //判断当前步骤是避免用户未登录就进行socket链接
                client.set("onlineUser",onlineUser);
                HazelcastCacheHelper.getInstance().getOnLineUserCacheBean().put(userid,onlineUser);
                NettySockIoClients.getInstance().putOnLineUserClient(userid,client);
            }
        }
    }

    @OnDisconnect
    public void onDisconnect(SocketIOClient client){
        OnlineUser onlineUser = client.get("onlineUser");
        if(onlineUser != null && !StringUtils.isBlank(onlineUser.getUserid())){
            /**
             * 当客户端断开链接的时候，需要重新计算每个客户端的当前排队数,并把当前的排队的总人数和当前客户端的排队数通知给客户端
             */
            QueueUpImpl.deleteToBusinessCacheBean(onlineUser.getUserid());
            QueueUpImpl.updateQueueUpCacheBean(onlineUser,client);
            HazelcastCacheHelper.getInstance().getOnLineUserCacheBean().delete(onlineUser.getUserid());
            QueueUpImpl.deleteOnLineUser(onlineUser.getUserid());
            NettySockIoClients.getInstance().removeOnLineUserClient(onlineUser.getUserid(),client.getSessionId().toString().replaceAll("-",""));
        }
    }

    @OnEvent("message")
    public void onEvent(SocketIOClient client, AckRequest ackRequest, PacketsMessage packetsMessage){
        /**
         * 模拟操作(检查当前是否需要进行排队->若需要排队，将请求加入排队队列->通知客户端当前排队状态)
         * 模拟一个操作只能同时有1个人，其余请求全部放入排队队列进行排队，当操作完成或者用户断开链接，需要刷新排队队列，并通知所有正在排队的用户更新当前的排队状态
         */
        OnlineUser onlineUser = client.get("onlineUser");
        boolean checkRet = QueueUpImpl.checkInServiceNum();
        QueueUpImpl.putToBusinessCacheBean(onlineUser.getUserid(),onlineUser);
        packetsMessage.setClient(client);
        if(checkRet){
            /**
             * 推到排队队列中进行排队处理,将当前排队状态发给客户端
             */
            QueueUp queueUp = QueueUpImpl.genQueueUp(onlineUser,packetsMessage);
            client.sendEvent("state",queueUp);
            NettySockIoClients.getInstance().putQueueUpClient(onlineUser.getUserid(),client);
        }else {
            /**
             * 直接处理逻辑
             */
            EventUtils.sendEventHandler(onlineUser.getUserid(),packetsMessage.getEvent(),packetsMessage);
        }
    }

}

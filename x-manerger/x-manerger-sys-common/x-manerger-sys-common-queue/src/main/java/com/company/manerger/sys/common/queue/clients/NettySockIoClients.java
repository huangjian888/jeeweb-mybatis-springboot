package com.company.manerger.sys.common.queue.clients;


import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIONamespace;
import com.company.manerger.sys.common.queue.utils.EventUtils;
import com.company.manerger.sys.common.utils.SpringContextHolder;

import java.util.List;

public class NettySockIoClients {
    private static NettySockIoClients mInstance = null;
    private NettySocketIoOnLineUserClient onLineUserClient = new NettySocketIoOnLineUserClient();
    private NettySocketIoQueueUpClient queueUpClient = new NettySocketIoQueueUpClient();

    public static NettySockIoClients getInstance(){
        if(mInstance == null){
            synchronized (NettySockIoClients.class){
                if(mInstance == null){
                    mInstance = new NettySockIoClients();
                }
            }
        }
        return mInstance;
    }

    public NettySocketIoOnLineUserClient getOnLineUserClient(){
        return onLineUserClient;
    }
    public void putOnLineUserClient(String key, SocketIOClient socketIOClient){ onLineUserClient.put(key,socketIOClient); }
    public void removeOnLineUserClient(String key,String sessionid){ onLineUserClient.remove(key,sessionid); }
    public void sendOnLineUserClientEventMessage(String key,String event,Object message,boolean useCluster){
        if(useCluster){
            EventUtils.sendOnLineUserClientEventMessage(key,event,message);
        }else{
            List<SocketIOClient> socketIOClients = onLineUserClient.get(key);
            if(socketIOClients != null && socketIOClients.size() > 0){
                for(SocketIOClient socketIOClient : socketIOClients){
                    socketIOClient.sendEvent(event,message);
                }
            }
        }
    }
    public NettySocketIoQueueUpClient getQueueUpClient(){return queueUpClient;}
    public void putQueueUpClient(String key,SocketIOClient socketIOClient){queueUpClient.put(key,socketIOClient);}
    public void removeQueueUpClient(String key,String sessionid){queueUpClient.remove(key,sessionid);}
    public void sendQueueUpClientEventMessage(String key,String event,Object message,boolean useCluster){
        if(useCluster){
            EventUtils.sendQueueUpClientEventMessage(key,event,message);
        }else{
            List<SocketIOClient> socketIOClients = queueUpClient.get(key);
            if(socketIOClients != null && socketIOClients.size() > 0){
                for(SocketIOClient socketIOClient : socketIOClients){
                    socketIOClient.sendEvent(event,message);
                }
            }
        }
    }

    public void sendBroadcastEventMessage(String beanName,String event,Object message,boolean useCluster){
        if(useCluster){
            EventUtils.sendBroadcastEventMessage(beanName,event,message);
        }else{
            SpringContextHolder.getApplicationContext().getBean(beanName,SocketIONamespace.class).getBroadcastOperations().sendEvent(event,message);
        }
    }
}

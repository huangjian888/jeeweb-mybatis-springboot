package com.company.manerger.sys.common.queue.service.impl;

import com.corundumstudio.socketio.SocketIOClient;
import com.company.manerger.sys.common.queue.cache.hazelcast.HazelcastCacheHelper;
import com.company.manerger.sys.common.queue.clients.NettySockIoClients;
import com.company.manerger.sys.common.queue.entity.OnlineUser;
import com.company.manerger.sys.common.queue.entity.QueueUp;
import com.company.manerger.sys.common.queue.service.messages.PacketsMessage;

import java.util.Collection;
import java.util.concurrent.locks.Lock;

/**
 * 排队队列实现类
 */
public class QueueUpImpl {

    public static void deleteOnLineUser(String userid){
        /**
         * 删除在线用户表中的userid的数据
         */
    }

    /**
     * 重新计算并更新排队缓存中的用户信息
     */
    public static void updateQueueUpCacheBean(OnlineUser onlineUser, SocketIOClient client){
        updateQueueUpCacheBean(onlineUser.getUserid(),client);
    }
    public static void updateQueueUpCacheBean(String userid, SocketIOClient client){
        Lock lock = HazelcastCacheHelper.getInstance().getQueueUpCacheBean().getLock("queueUpLock");
        lock.lock();
        try {
            QueueUp queueUp = (QueueUp) HazelcastCacheHelper.getInstance().getQueueUpCacheBean().getHazelcastCacheObject(userid);
            HazelcastCacheHelper.getInstance().getQueueUpCacheBean().delete(userid);
            NettySockIoClients.getInstance().removeQueueUpClient(userid,client.getSessionId().toString().replaceAll("-",""));
            Collection<QueueUp> queueUpList = (Collection<QueueUp>)HazelcastCacheHelper.getInstance().getQueueUpCacheBean().getAllHazelcastCacheObject();
            for(QueueUp _queueUp : queueUpList){
                _queueUp.setTotalQueueUpNum(getQueueUpNum());
                long currentQueueUpNum = _queueUp.getCurrentQueueUpNum();
                /**
                 * 重计算排在当前断开连接用户的之后的用户的当前排队数
                 */
                if(queueUp.getCurrentQueueUpNum() < currentQueueUpNum){
                    _queueUp.setCurrentQueueUpNum(currentQueueUpNum - 1);
                }
                NettySockIoClients.getInstance().sendQueueUpClientEventMessage(_queueUp.getUserid(),"state",_queueUp,true);
            }
        }finally {
            lock.unlock();
        }
    }
    public static QueueUp genQueueUp(OnlineUser onlineUser,PacketsMessage packetsMessage){
        Lock lock = HazelcastCacheHelper.getInstance().getQueueUpCacheBean().getLock("queueUpLock");
        lock.lock();
        try {
            QueueUp queueUp = new QueueUp();
            putToQueueUpCacheBean(onlineUser.getUserid(),queueUp);
            queueUp.setCurrentQueueUpNum(getQueueUpNum());
            queueUp.setUserid(onlineUser.getUserid());
            queueUp.setTotalQueueUpNum(getQueueUpNum());
            queueUp.setPacketsMessage(packetsMessage);
            return queueUp;
        }finally {
            lock.unlock();
        }
    }

    public static void putToQueueUpCacheBean(String key,Object value){
        Lock lock = HazelcastCacheHelper.getInstance().getQueueUpCacheBean().getLock("queueUpLock");
        lock.lock();
        try {
            HazelcastCacheHelper.getInstance().getQueueUpCacheBean().put(key,value);
        }finally {
            lock.unlock();
        }
    }

    /**
     * 查询当前排队用户总数
     * @return
     */
    public static long getQueueUpNum(){
        Lock lock = HazelcastCacheHelper.getInstance().getQueueUpCacheBean().getLock("queueUpLock");
        lock.lock();
        try {
            return HazelcastCacheHelper.getInstance().getQueueUpCacheBean().getSize();
        }finally {
            lock.unlock();
        }
    }

    public static void deleteToBusinessCacheBean(String key){
        Lock lock = HazelcastCacheHelper.getInstance().getBusinessCacheBean().getLock("inServiceNumLock");
        lock.lock();
        try {
            HazelcastCacheHelper.getInstance().getBusinessCacheBean().delete(key);
        }finally {
            lock.unlock();
        }
    }
    public static void putToBusinessCacheBean(String key,Object value){
        Lock lock = HazelcastCacheHelper.getInstance().getBusinessCacheBean().getLock("inServiceNumLock");
        lock.lock();
        try {
            HazelcastCacheHelper.getInstance().getBusinessCacheBean().put(key,value);
        }finally {
            lock.unlock();
        }
    }
    public static boolean checkInServiceNum(){
        Lock lock = HazelcastCacheHelper.getInstance().getBusinessCacheBean().getLock("inServiceNumLock");
        lock.lock();
        try{
            long size = HazelcastCacheHelper.getInstance().getBusinessCacheBean().getSize();
            if(size > 1){ //模拟一个条件
                return true;
            }
            return false;
        }finally {
            lock.unlock();
        }
    }
}

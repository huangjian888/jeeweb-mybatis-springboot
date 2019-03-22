package com.company.manerger.sys.common.queue.clients;

import com.corundumstudio.socketio.SocketIOClient;

import java.util.List;

public class NettySocketIoQueueUpClient extends AbsNettySocketIoClient{
    @Override
    public List<SocketIOClient> get(String key) {
        return super.get(key);
    }

    @Override
    public void put(String key, SocketIOClient socketIOClient) {
        super.put(key, socketIOClient);
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public void remove(String key, String sessionid) {
        super.remove(key, sessionid);
    }
}

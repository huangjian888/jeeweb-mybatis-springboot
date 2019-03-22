package com.company.manerger.sys.common.queue.clients;

import com.corundumstudio.socketio.SocketIOClient;
import com.google.common.collect.ArrayListMultimap;

import java.util.List;

/**
 * 一键多值Map
 */
public abstract class AbsNettySocketIoClient {
    protected ArrayListMultimap<String, SocketIOClient> clientsMap = ArrayListMultimap.create();
    public List<SocketIOClient> get(String key){
        return clientsMap.get(key);
    }
    public void put(String key,SocketIOClient socketIOClient){
        clientsMap.put(key,socketIOClient);
    }
    public int size(){
        return clientsMap.size();
    }
    public void remove(String key,String sessionid){
        List<SocketIOClient> socketIOClients = get(key);
        for(SocketIOClient socketIOClient : socketIOClients){
            if(sessionid.replaceAll("-","").equals(sessionid)) {
                socketIOClients.remove(socketIOClient);
                break;
            }
        }
    }
}

package com.company.manerger.sys.common.queue.service;

import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;
import com.company.manerger.sys.common.queue.enums.NettySocketIoNameSpace;
import com.company.manerger.sys.common.queue.service.handler.QueueEventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ServiceCommandLineRunner implements CommandLineRunner {
    private final SocketIOServer socketIOServer;
    private final SocketIONamespace queueSocketIONamespace;

    @Autowired
    public ServiceCommandLineRunner(SocketIOServer socketIOServer) {
        this.socketIOServer = socketIOServer;
        this.queueSocketIONamespace = socketIOServer.addNamespace(NettySocketIoNameSpace.NAMESPACE_QUEUE.toString());
    }

    @Bean(name = "queueSocketIONamespace")
    public SocketIONamespace QueueSocketIONamespace(SocketIOServer socketIOServer){
        queueSocketIONamespace.addListeners(new QueueEventHandler(socketIOServer));
        return queueSocketIONamespace;
    }

    @Override
    public void run(String... args) throws Exception {
        socketIOServer.start();
    }
}

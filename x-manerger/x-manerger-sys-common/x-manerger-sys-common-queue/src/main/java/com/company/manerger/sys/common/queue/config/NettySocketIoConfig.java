package com.company.manerger.sys.common.queue.config;

import com.corundumstudio.socketio.AuthorizationListener;
import com.corundumstudio.socketio.HandshakeData;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import com.company.manerger.sys.common.queue.exception.NettySocketIoExceptionListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;

@Configuration
public class NettySocketIoConfig {
    private SocketIOServer socketIOServer;

    @Value("queue.nettysocketio.port")
    private int port;
    @Value("queue.nettysocketio.workThreads")
    private int workThreads;

    @Bean
    public SocketIOServer socketIOServer(){
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        config.setPort(port);
        config.setWorkerThreads(workThreads);
        config.setAuthorizationListener(new AuthorizationListener(){
            public boolean isAuthorized(HandshakeData data) {
                return true;
            }
        });
        config.getSocketConfig().setReuseAddress(true);
        config.getSocketConfig().setSoLinger(0);
        config.getSocketConfig().setTcpNoDelay(true);
        config.getSocketConfig().setTcpKeepAlive(true);
        config.setExceptionListener(new NettySocketIoExceptionListener());
        socketIOServer = new SocketIOServer(config);
        return socketIOServer;
    }

    @Bean
    public SpringAnnotationScanner springAnnotationScanner(SocketIOServer socketIOServer){
        return new SpringAnnotationScanner(socketIOServer);
    }

    @PreDestroy
    public void destory(){
        socketIOServer.stop();
    }
}

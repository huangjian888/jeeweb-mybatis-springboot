package com.company.manerger.sys.common.queue.exception;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.ExceptionListenerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class NettySocketIoExceptionListener extends ExceptionListenerAdapter {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onEventException(Exception e, List<Object> data, SocketIOClient client) {
        logger.error(e.getMessage(), e);
        client.disconnect();
    }

    @Override
    public void onDisconnectException(Exception e, SocketIOClient client) {
        logger.error(e.getMessage(), e);
        client.disconnect();
    }

    @Override
    public void onConnectException(Exception e, SocketIOClient client) {
        logger.error(e.getMessage(), e);
        client.disconnect();
    }

    @Override
    public boolean exceptionCaught(ChannelHandlerContext ctx, Throwable e) throws Exception {
        logger.error(e.getMessage(), e);
        ctx.close();
        return true;
    }
}

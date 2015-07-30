package com.alibaba.middleware.race.rpc.api.impl;

import com.alibaba.middleware.race.rpc.api.RpcProvider;
import com.alibaba.middleware.race.rpc.netty.server.NettyServer;

import java.io.Serializable;

public class RpcProviderImpl extends RpcProvider implements Serializable{
    private Object impl;
    /**
     * set the instance which implements the service's interface
     * @param serviceInstance
     */
    public RpcProvider impl(Object serviceInstance){
        this.impl=serviceInstance;
        return this;
    }
    public void publish() throws InterruptedException {
        NettyServer server=new NettyServer();
        server.start(8888,impl);
    }
}

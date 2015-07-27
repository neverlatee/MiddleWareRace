package com.alibaba.middleware.race.rpc.api.impl;

import com.alibaba.middleware.race.rpc.api.RpcProvider;
import com.alibaba.middleware.race.rpc.netty.server.NettyServer;

public class RpcProviderImpl extends RpcProvider{
    public void publish() throws InterruptedException {
        NettyServer server=new NettyServer();
        server.start(8888);
    }
}

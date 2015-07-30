package com.alibaba.middleware.race.rpc.test.server;

import com.alibaba.middleware.race.rpc.api.impl.RpcProviderImpl;

/**
 * Created by THINK on 2015/7/27.
 */
public class Provider {
    public static void main(String[] args) throws InterruptedException {

        RpcProviderImpl provider=new RpcProviderImpl();
        provider.impl(new HelloServiceImpl());
        provider.publish();
    }
}

package com.alibaba.middleware.race.rpc.test.client;

import com.alibaba.middleware.race.rpc.api.RpcConsumer;
import com.alibaba.middleware.race.rpc.api.impl.RpcConsumerImpl;

import java.lang.reflect.Proxy;

/**
 * Created by THINK on 2015/7/27.
 */
public class Consumer {
    public static void main(String[] args) throws Exception {
        HelloService service = (HelloService) Proxy.newProxyInstance(Consumer.class.getClassLoader(),
                                                                    new Class<?>[]{HelloService.class}, new RpcConsumerImpl());

        String hello = service.sayHello("World" );
        System.out.println(hello);

    }
}

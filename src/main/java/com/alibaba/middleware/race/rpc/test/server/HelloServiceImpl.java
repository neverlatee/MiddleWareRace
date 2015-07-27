package com.alibaba.middleware.race.rpc.test.server;

import com.alibaba.middleware.race.rpc.test.client.HelloService;

/**
 * Created by THINK on 2015/7/27.
 */
public class HelloServiceImpl implements HelloService {


    public String sayHello(String name) {
        return "hello"+name;
    }
}

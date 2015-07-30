package com.alibaba.middleware.race.rpc.netty.server;

import java.lang.reflect.Method;

import com.alibaba.middleware.race.rpc.model.RpcRequest;

import com.alibaba.middleware.race.rpc.model.RpcResponse;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/** 
 * @author mengchenfei
 * @time   2015年7月26日 下午3:26:20 
 */
public class ServerEncodeHandle extends ChannelInboundHandlerAdapter {

//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        System.out.println("channelActive");
//        ctx.fireChannelActive();
//    }
    public Object instance;
    public ServerEncodeHandle(Object instance){
        this.instance=instance;
    };
	@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
    		throws Exception {
        System.out.println(" server received msg=="+msg);
        RpcRequest request=(RpcRequest)msg;
        Class clazz=request.getClass();
        System.out.println(clazz);
        Method method=request.getMethod();
        System.out.println(method);
        Object[] args=request.getArgs();
        System.out.println(args);
        Object object=method.invoke(instance,args);
        RpcResponse response=new RpcResponse();
        response.setAppResponse(object);
        ctx.writeAndFlush(response);

    }

    // @Override
    // public void channelReadComplete(ChannelHandlerContext ctx) throws
    // Exception {
    // ctx.flush();
    // ctx.close();
    // }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}

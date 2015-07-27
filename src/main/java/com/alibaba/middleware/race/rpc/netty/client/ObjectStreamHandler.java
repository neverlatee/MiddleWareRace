package com.alibaba.middleware.race.rpc.netty.client;

import java.io.Serializable;

import com.alibaba.middleware.race.rpc.model.RpcRequest;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.serialization.ObjectEncoder;

/** 
 * @author mengchenfei
 * @time   2015年7月26日 下午5:15:33 
 */
public class ObjectStreamHandler extends ChannelHandlerAdapter {
	public void sendRequest(RpcRequest request){
		ChannelHandlerContext ctx;
		ByteBuf out;
	}
	public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
	        ctx.write(msg, promise);
	}
}

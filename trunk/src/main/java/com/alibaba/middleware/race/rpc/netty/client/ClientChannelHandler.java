package com.alibaba.middleware.race.rpc.netty.client;

import com.alibaba.middleware.race.rpc.model.RpcRequest;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.channel.SimpleChannelInboundHandler;

/** 
 * @author mengchenfei
 * @param <I>
 * @time   2015年7月26日 下午4:25:40 
 */
public  class ClientChannelHandler<I> extends ChannelOutboundHandlerAdapter{
	private RpcRequest request;
	
	public ClientChannelHandler(RpcRequest request){
		this.request=request;
	}
	@Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        msg=request;
		ctx.write(msg, promise);
    }
}

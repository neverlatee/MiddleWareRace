package com.alibaba.middleware.race.rpc.netty.client;

import java.util.List;

import com.alibaba.middleware.race.rpc.model.RpcRequest;
import com.alibaba.middleware.race.rpc.model.RpcResponse;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.ByteToMessageDecoder;

/** 
 * @author mengchenfei
 * @time   2015年7月26日 下午2:09:55 
 */
public class ClientDecodeHandler extends ChannelInboundHandlerAdapter {
	private RpcRequest request;
	@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        RpcResponse response = (RpcResponse)msg;
        System.out.println(response);
    }
	public ClientDecodeHandler(RpcRequest request){
		this.request=request;
	}
		 @Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		        // Send the message to Server
		        super.channelActive(ctx);
		        ctx.writeAndFlush(request);
	}

}

package com.alibaba.middleware.race.rpc.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/** 
 * @author mengchenfei
 * @param <I>
 * @time   2015年7月26日 下午2:09:48 
 */
public class ClientEncodeHandler<RpcRequest> extends  MessageToByteEncoder<RpcRequest>{
	@Override
	protected void encode(ChannelHandlerContext ctx, RpcRequest msg, ByteBuf out)
			throws Exception {
			
		
	}

	
}

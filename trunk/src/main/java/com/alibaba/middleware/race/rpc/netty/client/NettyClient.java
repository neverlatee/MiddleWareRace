package com.alibaba.middleware.race.rpc.netty.client;

import java.io.ObjectInputStream.GetField;
import java.net.InetSocketAddress;

import javax.naming.spi.Resolver;

import org.omg.CORBA.ObjectHolder;

import com.alibaba.middleware.race.rpc.model.RpcRequest;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolver;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/** 
 * @author mengchenfei
 * @time   2015年7月26日 下午1:27:21 
 */
public class NettyClient {
	
	public static void start(String host,int port,final RpcRequest request) throws Exception{
		EventLoopGroup group = new NioEventLoopGroup();
		final ClassResolver resolver=ClassResolvers.softCachingResolver(NettyClient.class.getClassLoader());
		try {
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class).remoteAddress(new InetSocketAddress(host, port))
			 .handler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new ObjectEncoder());
							ch.pipeline().addLast(resolver.resolve("RpcRequest"));
						}
			 });
		 ChannelFuture f = b.connect().sync();
		 f.channel().closeFuture().sync();
		 } finally {
		 group.shutdownGracefully().sync();
		}

	}
	
}

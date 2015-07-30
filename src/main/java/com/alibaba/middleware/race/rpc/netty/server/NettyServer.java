package com.alibaba.middleware.race.rpc.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/** 
 * @author mengchenfei
 * @time   2015年7月26日 下午2:43:58 
 */
public class NettyServer {
	
	public static void start(int port, final Object instance) throws InterruptedException{
		System.out.println("server started");
		EventLoopGroup boss = new NioEventLoopGroup(); 
		EventLoopGroup work = new NioEventLoopGroup();
		try{
			ServerBootstrap b = new ServerBootstrap();
			b.group(boss, work).channel(NioServerSocketChannel.class)
			.childHandler(new ChannelInitializer<Channel>(){

				@Override
				protected void initChannel(Channel ch) throws Exception {
					// TODO Auto-generated method stub
					ch.pipeline().addLast(new ObjectDecoder(1024*1024, ClassResolvers.weakCachingConcurrentResolver(this.getClass()
					.getClassLoader())));
					ch.pipeline().addLast(new ObjectEncoder());
					ch.pipeline().addLast(new ServerEncodeHandle(instance));

				}} );
			ChannelFuture f = b.bind(port).sync();
			f.channel().closeFuture().sync();
		}finally{
			boss.shutdownGracefully().sync();
			work.shutdownGracefully().sync();
		}
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		NettyServer.start(8888,);
	}

}

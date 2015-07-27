package com.alibaba.middleware.race.rpc.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/** 
 * @author mengchenfei
 * @time   2015年7月26日 下午2:43:58 
 */
public class NettyServer {
	
	public void start(int port) throws InterruptedException{
		EventLoopGroup boss = new NioEventLoopGroup(); 
		EventLoopGroup work = new NioEventLoopGroup();
		try{
			ServerBootstrap b = new ServerBootstrap();
			b.group(boss, work).channel(NioServerSocketChannel.class).localAddress(port)
			.childHandler(new ChannelInitializer<Channel>(){

				@Override
				protected void initChannel(Channel ch) throws Exception {
					// TODO Auto-generated method stub
					ch.pipeline().addLast(new ServerDecodeHandle());
					ch.pipeline().addLast(new ServerEncodeHandle());
				}} );
				
		}finally{
			boss.shutdownGracefully().sync();
			work.shutdownGracefully().sync();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

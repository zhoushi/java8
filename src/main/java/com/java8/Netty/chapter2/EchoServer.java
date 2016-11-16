package com.java8.Netty.chapter2;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by Administrator on 2016/11/16.
 */
public class EchoServer {
    /**
     * 1；配置服务器功能，如线程、端口
     * 2：实现服务器处理程序，它包含业务逻辑，决定当有一个请求连接或接收数据时该做什么
     */

    private final int port;
    public EchoServer(int port){
        this.port = port;
    }

    public void start()throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            //1.通过ServerBootstrap来启动对象
            ServerBootstrap b = new ServerBootstrap();
            //2.
            //3.
            b.group(group).channel(NioServerSocketChannel.class).localAddress(port)
                    .childHandler(new ChannelInitializer<Channel >() {
                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            ch.pipeline().addLast(new EchoServerHandler());
                        }
                    });

            ChannelFuture f = b.bind().sync();
            System.out.println(EchoServer.class.getName() + " started and listen on " + f.channel().localAddress());

            f.channel().closeFuture().sync();

        }finally {
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String...args) throws Exception {
        new EchoServer(65535).start();
    }
}

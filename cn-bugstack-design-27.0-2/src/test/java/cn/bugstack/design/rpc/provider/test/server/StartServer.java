package cn.bugstack.design.rpc.provider.test.server;

import cn.bugstack.design.rpc.network.server.ServerSocket;

public class StartServer {

    public static void main(String[] args) {
        System.out.println("启动服务端开始");
        new Thread(new ServerSocket()).start();
        System.out.println("启动服务端完成");
    }

}

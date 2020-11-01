package cn.bugstack.design.rpc.provider.test.client;

import cn.bugstack.design.rpc.network.client.ClientSocket;
import cn.bugstack.design.rpc.network.future.SyncWrite;
import cn.bugstack.design.rpc.network.msg.Request;
import cn.bugstack.design.rpc.network.msg.Response;
import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelFuture;

public class StartClient {

    private static ChannelFuture future;

    public static void main(String[] args) {
        ClientSocket client = new ClientSocket();
        new Thread(client).start();

        while (true) {
            try {
                //获取future，线程有等待处理时间
                if (null == future) {
                    future = client.getFuture();
                    Thread.sleep(500);
                    continue;
                }
                //构建发送参数
                Request request = new Request();
                request.setResult("查询用户信息");
                SyncWrite s = new SyncWrite();
                Response response = s.writeAndSync(future.channel(), request, 1000);
                System.out.println("调用结果：" + JSON.toJSON(response));
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}


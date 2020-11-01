package cn.bugstack.design.rpc.network.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import cn.bugstack.design.rpc.network.msg.Request;
import cn.bugstack.design.rpc.network.msg.Response;
import cn.bugstack.design.rpc.util.ClassLoaderUtils;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Method;

public class MyServerHandler extends ChannelInboundHandlerAdapter {

    private ApplicationContext applicationContext;

    MyServerHandler(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object obj) {
        try {
            Request msg = (Request) obj;
            //调用
            Class<?> classType = ClassLoaderUtils.forName(msg.getNozzle());
            Method addMethod = classType.getMethod(msg.getMethodName(), msg.getParamTypes());
            Object objectBean = applicationContext.getBean(msg.getRef());
            Object result = addMethod.invoke(objectBean, msg.getArgs());
            //反馈
            Response request = new Response();
            request.setRequestId(msg.getRequestId());
            request.setResult(result);
            ctx.writeAndFlush(request);
            //释放
            ReferenceCountUtil.release(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

}

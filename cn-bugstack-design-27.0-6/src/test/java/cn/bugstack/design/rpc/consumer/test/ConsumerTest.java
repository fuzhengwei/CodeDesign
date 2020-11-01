package cn.bugstack.design.rpc.consumer.test;

import cn.bugstack.design.rpc.export.HelloService;
import cn.bugstack.design.rpc.export.domain.Hi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-config.xml")
public class ConsumerTest {

    @Resource(name = "helloService")
    private HelloService helloService;

    @Test
    public void test_rpc() {
        
        String hi = helloService.hi();
        System.out.println("测试结果：" + hi);

        String say = helloService.say("hello world");
        System.out.println("测试结果：" + say);

        Hi hiReq = new Hi();
        hiReq.setUserName("小傅哥");
        hiReq.setSayMsg("沉淀、分享、成长，让自己和他人都能有所收获！");
        String hiRes = helloService.sayHi(hiReq);

        System.out.println("测试结果：" + hiRes);
    }

}

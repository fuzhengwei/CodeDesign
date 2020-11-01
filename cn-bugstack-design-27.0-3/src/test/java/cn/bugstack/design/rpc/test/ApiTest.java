package cn.bugstack.design.rpc.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApiTest {

    public static void main(String[] args) {
        String[] configs = {"rpc-center.xml", "rpc-provider.xml", "rpc-consumer.xml"};
        new ClassPathXmlApplicationContext(configs);
    }

}

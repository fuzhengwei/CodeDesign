package cn.bugstack.design.rpc.config.spring;

import cn.bugstack.design.rpc.config.spring.bean.ConsumerBean;
import cn.bugstack.design.rpc.config.spring.bean.ProviderBean;
import cn.bugstack.design.rpc.config.spring.bean.ServerBean;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class MyNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("consumer", new MyBeanDefinitionParser(ConsumerBean.class));
        registerBeanDefinitionParser("provider", new MyBeanDefinitionParser(ProviderBean.class));
        registerBeanDefinitionParser("server", new MyBeanDefinitionParser(ServerBean.class));
    }

}

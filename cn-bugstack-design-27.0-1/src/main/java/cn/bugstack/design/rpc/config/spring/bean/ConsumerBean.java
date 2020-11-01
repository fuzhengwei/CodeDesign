package cn.bugstack.design.rpc.config.spring.bean;

import cn.bugstack.design.rpc.config.ConsumerConfig;
import org.springframework.beans.factory.FactoryBean;

public class ConsumerBean<T> extends ConsumerConfig<T> implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        System.out.format("消费者信息=> [接口：%s] [别名：%s] \r\n", nozzle, alias);
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

}

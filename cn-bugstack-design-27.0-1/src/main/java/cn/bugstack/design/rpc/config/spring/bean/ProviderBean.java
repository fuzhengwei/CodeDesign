package cn.bugstack.design.rpc.config.spring.bean;

import cn.bugstack.design.rpc.config.ProviderConfig;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ProviderBean extends ProviderConfig implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.format("生产者信息=> [接口：%s] [映射：%s] [别名：%s] \r\n", nozzle, ref, alias);
    }

}

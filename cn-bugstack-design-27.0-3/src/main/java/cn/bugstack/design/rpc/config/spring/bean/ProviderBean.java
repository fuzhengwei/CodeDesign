package cn.bugstack.design.rpc.config.spring.bean;

import com.alibaba.fastjson.JSON;
import cn.bugstack.design.rpc.config.ProviderConfig;
import cn.bugstack.design.rpc.domain.LocalServerInfo;
import cn.bugstack.design.rpc.domain.RpcProviderConfig;
import cn.bugstack.design.rpc.registry.RedisRegistryCenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ProviderBean extends ProviderConfig implements ApplicationContextAware {

    private Logger logger = LoggerFactory.getLogger(ProviderBean.class);

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        RpcProviderConfig rpcProviderConfig = new RpcProviderConfig();
        rpcProviderConfig.setNozzle(nozzle);   // 接口
        rpcProviderConfig.setRef(ref);   // 映射
        rpcProviderConfig.setAlias(alias);   // 别名
        rpcProviderConfig.setHost(LocalServerInfo.LOCAL_HOST);   // ip
        rpcProviderConfig.setPort(LocalServerInfo.LOCAL_PORT);   // 端口

        //注册生产者
        long count = RedisRegistryCenter.registryProvider(nozzle, alias, JSON.toJSONString(rpcProviderConfig));

        logger.info("注册生产者：{} {} {}", nozzle, alias, count);
    }

}

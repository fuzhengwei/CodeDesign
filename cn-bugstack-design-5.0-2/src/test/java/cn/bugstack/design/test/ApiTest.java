package cn.bugstack.design.test;

import cn.bugstack.design.application.CacheService;
import cn.bugstack.design.workshop.ICacheAdapter;
import cn.bugstack.design.factory.JDKProxyFactory;
import cn.bugstack.design.workshop.impl.EGMCacheAdapter;
import cn.bugstack.design.workshop.impl.IIRCacheAdapter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_CacheService() throws Exception {
        CacheService proxy_EGM = JDKProxyFactory.getProxy(CacheService.class, EGMCacheAdapter.class);
        proxy_EGM.set("user_name_01", "小傅哥");
        String val01 = proxy_EGM.get("user_name_01");
        logger.info("缓存服务 EGM 测试，proxy_EGM.get 测试结果：{}", val01);

        CacheService proxy_IIR = JDKProxyFactory.getProxy(CacheService.class, IIRCacheAdapter.class);
        proxy_IIR.set("user_name_01", "小傅哥");
        String val02 = proxy_IIR.get("user_name_01");
        logger.info("缓存服务 IIR 测试，proxy_IIR.get 测试结果：{}", val02);
    }

}

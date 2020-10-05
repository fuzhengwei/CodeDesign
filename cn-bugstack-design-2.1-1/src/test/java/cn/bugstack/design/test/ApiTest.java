package cn.bugstack.design.test;

import cn.bugstack.design.IVideoUserService;
import cn.bugstack.design.impl.GuestVideoUserService;
import cn.bugstack.design.impl.OrdinaryVideoUserService;
import cn.bugstack.design.impl.VipVideoUserService;
import org.junit.Test;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack) @2020
 */
public class ApiTest {

    @Test
    public void test_VideoUserService(){

        IVideoUserService guest = new GuestVideoUserService();
        guest.definition();
        guest.advertisement();

        IVideoUserService ordinary = new OrdinaryVideoUserService();
        ordinary.definition();
        ordinary.advertisement();

        IVideoUserService vip = new VipVideoUserService();
        vip.definition();
        vip.advertisement();

    }

}

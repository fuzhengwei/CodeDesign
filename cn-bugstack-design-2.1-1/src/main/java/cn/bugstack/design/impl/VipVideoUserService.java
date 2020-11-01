package cn.bugstack.design.impl;

import cn.bugstack.design.IVideoUserService;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack) @2020
 *
 * 用户类型；VIP用户
 */
public class VipVideoUserService implements IVideoUserService {

    public void definition() {
        System.out.println("VIP用户，视频1080P蓝光");
    }

    public void advertisement() {
        System.out.println("VIP用户，视频无广告");
    }

}

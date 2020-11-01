package cn.bugstack.design;

import java.util.List;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack) @2020
 * <p>
 * 抽奖接口
 */
public interface IDraw {

    // 获取中奖用户接口
    List<BetUser> prize(List<BetUser> list, int count);

}

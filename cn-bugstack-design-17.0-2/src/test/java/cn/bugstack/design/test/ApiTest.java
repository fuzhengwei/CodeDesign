package cn.bugstack.design.test;

import cn.bugstack.design.XiaoEr;
import cn.bugstack.design.cook.impl.GuangDongCook;
import cn.bugstack.design.cook.impl.JiangSuCook;
import cn.bugstack.design.cook.impl.ShanDongCook;
import cn.bugstack.design.cook.impl.SiChuanCook;
import cn.bugstack.design.cuisine.ICuisine;
import cn.bugstack.design.cuisine.impl.GuangDoneCuisine;
import cn.bugstack.design.cuisine.impl.JiangSuCuisine;
import cn.bugstack.design.cuisine.impl.ShanDongCuisine;
import cn.bugstack.design.cuisine.impl.SiChuanCuisine;
import org.junit.Test;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack) @2020
 */
public class ApiTest {

    @Test
    public void test_xiaoEr(){

        // 菜系 + 厨师；广东（粤菜）、江苏（苏菜）、山东（鲁菜）、四川（川菜）
        ICuisine guangDoneCuisine = new GuangDoneCuisine(new GuangDongCook());
        JiangSuCuisine jiangSuCuisine = new JiangSuCuisine(new JiangSuCook());
        ShanDongCuisine shanDongCuisine = new ShanDongCuisine(new ShanDongCook());
        SiChuanCuisine siChuanCuisine = new SiChuanCuisine(new SiChuanCook());

        // 点单
        XiaoEr xiaoEr = new XiaoEr();
        xiaoEr.order(guangDoneCuisine);
        xiaoEr.order(jiangSuCuisine);
        xiaoEr.order(shanDongCuisine);
        xiaoEr.order(siChuanCuisine);

        // 下单
        xiaoEr.placeOrder();

    }

}

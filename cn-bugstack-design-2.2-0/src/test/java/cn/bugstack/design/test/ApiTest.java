package cn.bugstack.design.test;

import cn.bugstack.design.ICalculationArea;
import cn.bugstack.design.impl.CalculationArea;
import cn.bugstack.design.impl.CalculationAreaExt;
import org.junit.Test;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack) @2020
 */
public class ApiTest {

    @Test
    public void test_math() {
        System.out.println(Math.sqrt(5));
    }

    @Test
    public void test_CalculationArea() {
        ICalculationArea calculationArea = new CalculationArea();
        // 计算面积，长方形
        double rectangle = calculationArea.rectangle(4, 6);
        System.out.println("长方形面积：" + rectangle);

        // 计算面积，三角形
        double triangle = calculationArea.triangle(3, 4, 5);
        System.out.println("三角形面积：" + triangle);

        // 计算面积，圆形
        double circular = calculationArea.circular(5);
        System.out.println("圆形形面积：" + circular);
    }

    @Test
    public void test_CalculationAreaExt(){
        ICalculationArea calculationArea = new CalculationAreaExt();

        // 计算面积，圆形
        double circular = calculationArea.circular(5);
        System.out.println("圆形形面积：" + circular);
    }

}

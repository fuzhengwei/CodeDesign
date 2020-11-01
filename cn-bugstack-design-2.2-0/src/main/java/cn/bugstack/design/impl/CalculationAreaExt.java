package cn.bugstack.design.impl;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack) @2020
 */
public class CalculationAreaExt extends CalculationArea {

    private final static double π = 3.141592653D;

    @Override
    public double circular(double r) {
        return π * r * r;
    }

}

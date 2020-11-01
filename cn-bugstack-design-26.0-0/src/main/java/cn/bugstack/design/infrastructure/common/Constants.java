package cn.bugstack.design.infrastructure.common;

public class Constants {

    public static final class Global {
        public static final Long TreeNullNode = 0L;    //空节点值
    }

    public static final class NodeType{
        public static final Integer STEM = 1;  //树茎
        public static final Integer FRUIT = 2; //果实
    }

    public static final class RuleLimitType {
        public static final int EQUAL = 1;    //等于
        public static final int GT = 2;       //大于
        public static final int LT = 3;       //小于
        public static final int GE = 4;       //大于等于
        public static final int LE = 5;       //小于等于
        public static final int ENUM = 6;     //枚举
    }

}

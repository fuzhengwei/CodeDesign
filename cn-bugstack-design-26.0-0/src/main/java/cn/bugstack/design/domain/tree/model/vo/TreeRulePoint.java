package cn.bugstack.design.domain.tree.model.vo;

public class TreeRulePoint {

    private String ruleKey;      //规则Key
    private String ruleDesc;     //规则描述

    public TreeRulePoint() {
    }

    public TreeRulePoint(String ruleKey, String ruleDesc) {
        this.ruleKey = ruleKey;
        this.ruleDesc = ruleDesc;
    }

    public String getRuleKey() {
        return ruleKey;
    }

    public void setRuleKey(String ruleKey) {
        this.ruleKey = ruleKey;
    }

    public String getRuleDesc() {
        return ruleDesc;
    }

    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc;
    }
}

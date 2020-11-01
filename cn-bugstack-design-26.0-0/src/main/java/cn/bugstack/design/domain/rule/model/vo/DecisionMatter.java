package cn.bugstack.design.domain.rule.model.vo;

import java.util.Map;

/**
 * 决策物料
 */
public class DecisionMatter {

    private Long treeId;                //规则树ID
    private String userId;              //用户ID
    private Map<String, Object> valMap; //决策值

    public Long getTreeId() {
        return treeId;
    }

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<String, Object> getValMap() {
        return valMap;
    }

    public void setValMap(Map<String, Object> valMap) {
        this.valMap = valMap;
    }

}

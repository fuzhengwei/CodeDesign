package cn.bugstack.design.interfaces.dto;

import java.util.Map;

public class DecisionMatterDTO {

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

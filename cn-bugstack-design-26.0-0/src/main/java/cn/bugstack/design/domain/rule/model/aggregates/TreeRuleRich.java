package cn.bugstack.design.domain.rule.model.aggregates;

import cn.bugstack.design.domain.rule.model.vo.TreeNodeInfo;
import cn.bugstack.design.domain.rule.model.vo.TreeRoot;

import java.util.Map;

/**
 * 规则树聚合
 */
public class TreeRuleRich {

    private TreeRoot treeRoot;                          //树根信息
    private Map<Long, TreeNodeInfo> treeNodeMap;        //树节点ID -> 子节点

    public TreeRoot getTreeRoot() {
        return treeRoot;
    }

    public void setTreeRoot(TreeRoot treeRoot) {
        this.treeRoot = treeRoot;
    }

    public Map<Long, TreeNodeInfo> getTreeNodeMap() {
        return treeNodeMap;
    }

    public void setTreeNodeMap(Map<Long, TreeNodeInfo> treeNodeMap) {
        this.treeNodeMap = treeNodeMap;
    }
}

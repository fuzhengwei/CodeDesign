package cn.bugstack.design.domain.tree.model.aggregates;

import cn.bugstack.design.domain.tree.model.vo.TreeInfo;
import cn.bugstack.design.domain.tree.model.vo.TreeRulePoint;

import java.util.List;

public class TreeCollect {

    private TreeInfo treeInfo;
    private List<TreeRulePoint> treeRulePointList;

    public TreeInfo getTreeInfo() {
        return treeInfo;
    }

    public void setTreeInfo(TreeInfo treeInfo) {
        this.treeInfo = treeInfo;
    }

    public List<TreeRulePoint> getTreeRulePointList() {
        return treeRulePointList;
    }

    public void setTreeRulePointList(List<TreeRulePoint> treeRulePointList) {
        this.treeRulePointList = treeRulePointList;
    }
    
}

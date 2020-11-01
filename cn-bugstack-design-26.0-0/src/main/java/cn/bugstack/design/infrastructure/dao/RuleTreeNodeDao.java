package cn.bugstack.design.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import cn.bugstack.design.infrastructure.po.RuleTreeNode;

import java.util.List;

@Mapper
public interface RuleTreeNodeDao {

    List<RuleTreeNode> queryRuleTreeNodeList(Long treeId);

    int queryTreeNodeCount(Long treeId);

    List<RuleTreeNode> queryTreeRulePoint(Long treeId);

}

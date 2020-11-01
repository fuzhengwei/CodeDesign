package cn.bugstack.design.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import cn.bugstack.design.infrastructure.po.RuleTreeNodeLine;

import java.util.List;

@Mapper
public interface RuleTreeNodeLineDao {

    List<RuleTreeNodeLine> queryRuleTreeNodeLineList(RuleTreeNodeLine req);

    int queryTreeNodeLineCount(Long treeId);

}

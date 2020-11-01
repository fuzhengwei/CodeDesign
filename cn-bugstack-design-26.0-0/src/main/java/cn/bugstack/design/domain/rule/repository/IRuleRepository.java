package cn.bugstack.design.domain.rule.repository;

import cn.bugstack.design.domain.rule.model.aggregates.TreeRuleRich;

/**
 * 微信公众号：bugstack虫洞栈 | 欢迎关注学习专题案例
 */
public interface IRuleRepository {

    TreeRuleRich queryTreeRuleRich(Long treeId);

}

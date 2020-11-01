package cn.bugstack.design.infrastructure.repository;

import cn.bugstack.design.domain.rule.model.aggregates.TreeRuleRich;
import cn.bugstack.design.domain.rule.repository.IRuleRepository;
import cn.bugstack.design.infrastructure.repository.cache.RuleCacheRepository;
import cn.bugstack.design.infrastructure.repository.mysql.RuleMysqlRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("ruleRepository")
public class RuleRepository implements IRuleRepository {

    @Resource(name = "ruleMysqlRepository")
    private RuleMysqlRepository ruleMysqlRepository;
    @Resource(name = "ruleCacheRepository")
    private RuleCacheRepository ruleCacheRepository;

    @Override
    public TreeRuleRich queryTreeRuleRich(Long treeId) {
        TreeRuleRich treeRuleRich = ruleCacheRepository.queryTreeRuleRich(treeId);
        if (null != treeRuleRich) return treeRuleRich;
        return ruleMysqlRepository.queryTreeRuleRich(treeId);
    }

}

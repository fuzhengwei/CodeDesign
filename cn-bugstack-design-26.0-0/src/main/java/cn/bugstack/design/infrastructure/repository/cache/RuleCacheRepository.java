package cn.bugstack.design.infrastructure.repository.cache;

import cn.bugstack.design.domain.rule.model.aggregates.TreeRuleRich;
import cn.bugstack.design.domain.rule.repository.IRuleRepository;
import cn.bugstack.design.infrastructure.util.CacheUtil;
import org.springframework.stereotype.Repository;

/**
 * 微信公众号：bugstack虫洞栈 | 欢迎关注学习专题案例
 */
@Repository("ruleCacheRepository")
public class RuleCacheRepository implements IRuleRepository {

    @Override
    public TreeRuleRich queryTreeRuleRich(Long treeId) {
        return (TreeRuleRich) CacheUtil.cacheMap.get(treeId);
    }

}

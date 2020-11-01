package cn.bugstack.design.domain.rule.service.engine.impl;

import cn.bugstack.design.domain.rule.model.aggregates.TreeRuleRich;
import cn.bugstack.design.domain.rule.model.vo.DecisionMatter;
import cn.bugstack.design.domain.rule.model.vo.EngineResult;
import cn.bugstack.design.domain.rule.model.vo.TreeNodeInfo;
import cn.bugstack.design.domain.rule.repository.IRuleRepository;
import cn.bugstack.design.domain.rule.service.engine.EngineBase;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 微信公众号：bugstack虫洞栈 | 专注原创技术专题案例
 */
@Service("ruleEngineHandle")
public class RuleEngineHandle extends EngineBase {

    @Resource
    private IRuleRepository ruleRepository;

    @Override
    public EngineResult process(DecisionMatter matter) throws Exception {
        //决策规则树
        TreeRuleRich treeRuleRich = ruleRepository.queryTreeRuleRich(matter.getTreeId());
        if (null == treeRuleRich) throw new RuntimeException("Tree Rule is null!");
        //决策节点
        TreeNodeInfo treeNodeInfo = engineDecisionMaker(treeRuleRich, matter);
        //决策结果
        return new EngineResult(matter.getUserId(), treeNodeInfo.getTreeId(), treeNodeInfo.getTreeNodeId(), treeNodeInfo.getNodeValue());
    }

}

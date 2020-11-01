package cn.bugstack.design.infrastructure.repository.mysql;

import cn.bugstack.design.domain.rule.model.aggregates.TreeRuleRich;
import cn.bugstack.design.domain.rule.model.vo.TreeNodeInfo;
import cn.bugstack.design.domain.rule.model.vo.TreeNodeLineInfo;
import cn.bugstack.design.domain.rule.model.vo.TreeRoot;
import cn.bugstack.design.domain.rule.repository.IRuleRepository;
import cn.bugstack.design.infrastructure.common.Constants;
import cn.bugstack.design.infrastructure.dao.RuleTreeDao;
import cn.bugstack.design.infrastructure.dao.RuleTreeNodeDao;
import cn.bugstack.design.infrastructure.dao.RuleTreeNodeLineDao;
import cn.bugstack.design.infrastructure.po.RuleTree;
import cn.bugstack.design.infrastructure.po.RuleTreeNode;
import cn.bugstack.design.infrastructure.po.RuleTreeNodeLine;
import cn.bugstack.design.infrastructure.util.CacheUtil;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("ruleMysqlRepository")
public class RuleMysqlRepository implements IRuleRepository {

    @Resource
    private RuleTreeDao ruleTreeDao;
    @Resource
    private RuleTreeNodeDao ruleTreeNodeDao;
    @Resource
    private RuleTreeNodeLineDao ruleTreeNodeLineDao;

    @Override
    public TreeRuleRich queryTreeRuleRich(Long treeId) {

        // 规则树
        RuleTree ruleTree = ruleTreeDao.queryRuleTreeByTreeId(treeId);
        TreeRoot treeRoot = new TreeRoot();
        treeRoot.setTreeId(ruleTree.getId());
        treeRoot.setTreeRootNodeId(ruleTree.getTreeRootNodeId());
        treeRoot.setTreeName(ruleTree.getTreeName());

        // 树节点->树连接线
        Map<Long, TreeNodeInfo> treeNodeMap = new HashMap<>();
        List<RuleTreeNode> ruleTreeNodeList = ruleTreeNodeDao.queryRuleTreeNodeList(treeId);
        for (RuleTreeNode treeNode : ruleTreeNodeList) {
            List<TreeNodeLineInfo> treeNodeLineInfoList = new ArrayList<>();
            if (Constants.NodeType.STEM.equals(treeNode.getNodeType())) {
                List<RuleTreeNodeLine> ruleTreeNodeLineList = queryRuleTreeNodeLineList(treeNode.getTreeId(), treeNode.getId());
                for (RuleTreeNodeLine nodeLine : ruleTreeNodeLineList) {
                    TreeNodeLineInfo treeNodeLineInfo = new TreeNodeLineInfo();
                    treeNodeLineInfo.setNodeIdFrom(nodeLine.getNodeIdFrom());
                    treeNodeLineInfo.setNodeIdTo(nodeLine.getNodeIdTo());
                    treeNodeLineInfo.setRuleLimitType(nodeLine.getRuleLimitType());
                    treeNodeLineInfo.setRuleLimitValue(nodeLine.getRuleLimitValue());
                    treeNodeLineInfoList.add(treeNodeLineInfo);
                }
            }
            TreeNodeInfo treeNodeInfo = new TreeNodeInfo();
            treeNodeInfo.setTreeId(treeNode.getTreeId());
            treeNodeInfo.setTreeNodeId(treeNode.getId());
            treeNodeInfo.setNodeType(treeNode.getNodeType());
            treeNodeInfo.setNodeValue(treeNode.getNodeValue());
            treeNodeInfo.setRuleKey(treeNode.getRuleKey());
            treeNodeInfo.setRuleDesc(treeNode.getRuleDesc());
            treeNodeInfo.setTreeNodeLineInfoList(treeNodeLineInfoList);

            treeNodeMap.put(treeNode.getId(), treeNodeInfo);
        }

        TreeRuleRich treeRuleRich = new TreeRuleRich();
        treeRuleRich.setTreeRoot(treeRoot);
        treeRuleRich.setTreeNodeMap(treeNodeMap);

        // 写入内存[可以放置在创建时写入]
        CacheUtil.cacheMap.put(treeId, treeRuleRich);

        return treeRuleRich;
    }

    private List<RuleTreeNodeLine> queryRuleTreeNodeLineList(Long treeId, Long treeNodeId) {
        RuleTreeNodeLine ruleTreeNodeLineReq = new RuleTreeNodeLine();
        ruleTreeNodeLineReq.setTreeId(treeId);
        ruleTreeNodeLineReq.setNodeIdFrom(treeNodeId);
        return ruleTreeNodeLineDao.queryRuleTreeNodeLineList(ruleTreeNodeLineReq);
    }

}

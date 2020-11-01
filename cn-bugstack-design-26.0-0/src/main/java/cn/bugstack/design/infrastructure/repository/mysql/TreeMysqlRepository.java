package cn.bugstack.design.infrastructure.repository.mysql;

import cn.bugstack.design.domain.tree.model.vo.TreeInfo;
import cn.bugstack.design.domain.tree.model.vo.TreeRulePoint;
import cn.bugstack.design.domain.tree.repository.ITreeRepository;
import cn.bugstack.design.infrastructure.dao.RuleTreeDao;
import cn.bugstack.design.infrastructure.dao.RuleTreeNodeDao;
import cn.bugstack.design.infrastructure.dao.RuleTreeNodeLineDao;
import cn.bugstack.design.infrastructure.po.RuleTree;
import cn.bugstack.design.infrastructure.po.RuleTreeNode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("treeMysqlRepository")
public class TreeMysqlRepository implements ITreeRepository {

    @Resource
    private RuleTreeDao ruleTreeDao;
    @Resource
    private RuleTreeNodeDao ruleTreeNodeDao;
    @Resource
    private RuleTreeNodeLineDao ruleTreeNodeLineDao;

    @Override
    public TreeInfo queryTreeInfo(Long treeId) {

        // 查询规则树简要信息
        RuleTree ruleTree = ruleTreeDao.queryTreeSummaryInfo(treeId);
        int nodeCount = ruleTreeNodeDao.queryTreeNodeCount(treeId);
        int nodeLineCount = ruleTreeNodeLineDao.queryTreeNodeLineCount(treeId);

        TreeInfo treeInfo = new TreeInfo();
        treeInfo.setTreeId(treeId);
        treeInfo.setTreeName(ruleTree.getTreeName());
        treeInfo.setTreeDesc(ruleTree.getTreeDesc());
        treeInfo.setNodeCount(nodeCount);
        treeInfo.setLineCount(nodeLineCount);

        return treeInfo;
    }

    @Override
    public List<TreeRulePoint> queryTreeRulePointList(Long treeId) {
        List<RuleTreeNode> treeNodeList = ruleTreeNodeDao.queryTreeRulePoint(treeId);
        List<TreeRulePoint> treeRulePointList = new ArrayList<>(treeNodeList.size());
        for (RuleTreeNode treeNode : treeNodeList) {
            treeRulePointList.add(new TreeRulePoint(treeNode.getRuleKey(),treeNode.getRuleDesc()));
        }
        return treeRulePointList;
    }

}

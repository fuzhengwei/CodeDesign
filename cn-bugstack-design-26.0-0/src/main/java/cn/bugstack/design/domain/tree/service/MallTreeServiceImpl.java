package cn.bugstack.design.domain.tree.service;

import cn.bugstack.design.application.MallTreeService;
import cn.bugstack.design.domain.tree.model.aggregates.TreeCollect;
import cn.bugstack.design.domain.tree.model.vo.TreeInfo;
import cn.bugstack.design.domain.tree.model.vo.TreeRulePoint;
import cn.bugstack.design.domain.tree.repository.ITreeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("mallTreeService")
public class MallTreeServiceImpl implements MallTreeService {

    private Logger logger = LoggerFactory.getLogger(MallTreeServiceImpl.class);

    @Resource
    private ITreeRepository treeRepository;

    @Override
    public TreeCollect queryTreeSummaryInfo(Long treeId) {
        TreeInfo treeInfo = treeRepository.queryTreeInfo(treeId);
        List<TreeRulePoint> treeRulePointList = treeRepository.queryTreeRulePointList(treeId);
        // 封装结果
        TreeCollect treeCollect = new TreeCollect();
        treeCollect.setTreeInfo(treeInfo);
        treeCollect.setTreeRulePointList(treeRulePointList);
        return treeCollect;
    }

}

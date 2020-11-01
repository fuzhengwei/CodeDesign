package cn.bugstack.design.infrastructure.repository;

import cn.bugstack.design.domain.tree.model.vo.TreeInfo;
import cn.bugstack.design.domain.tree.model.vo.TreeRulePoint;
import cn.bugstack.design.domain.tree.repository.ITreeRepository;
import cn.bugstack.design.infrastructure.repository.mysql.TreeMysqlRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("treeRepository")
public class TreeRepository implements ITreeRepository {

    @Resource
    private TreeMysqlRepository treeMysqlRepository;

    @Override
    public TreeInfo queryTreeInfo(Long treeId) {
        return treeMysqlRepository.queryTreeInfo(treeId);
    }

    @Override
    public List<TreeRulePoint> queryTreeRulePointList(Long treeId) {
        return treeMysqlRepository.queryTreeRulePointList(treeId);
    }

}

package cn.bugstack.design.application;

import cn.bugstack.design.domain.tree.model.aggregates.TreeCollect;

/**
 * 商超规则树服务；提供规则树查询功能
 */
public interface MallTreeService {

    /**
     * 查询规则树概要信息
     * @param treeId 规则树ID
     * @return       规则树简要汇总信息
     */
    TreeCollect queryTreeSummaryInfo(Long treeId);

}

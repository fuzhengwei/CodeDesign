package cn.bugstack.design.infrastructure.po;

import java.util.Date;

/**
 * 规则树
 */
public class RuleTree {

    private Long id;             //主键ID
    private String treeName;     //规则树名称
    private String treeDesc;     //规则树描述
    private Long treeRootNodeId; //规则树根ID
    private Date createTime;     //创建时间
    private Date updateTime;     //更新时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }

    public String getTreeDesc() {
        return treeDesc;
    }

    public Long getTreeRootNodeId() {
        return treeRootNodeId;
    }

    public void setTreeRootNodeId(Long treeRootNodeId) {
        this.treeRootNodeId = treeRootNodeId;
    }

    public void setTreeDesc(String treeDesc) {
        this.treeDesc = treeDesc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

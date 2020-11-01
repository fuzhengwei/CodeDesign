package cn.bugstack.design.domain.rule.service.logic.impl;

import cn.bugstack.design.domain.rule.model.vo.DecisionMatter;
import cn.bugstack.design.domain.rule.service.logic.BaseLogic;
import org.springframework.stereotype.Service;

@Service("userAgeFilter")
public class UserAgeFilter extends BaseLogic {

    @Override
    public String matterValue(DecisionMatter decisionMatter) {
        return decisionMatter.getValMap().get("age").toString();
    }

}

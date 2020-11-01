package cn.bugstack.design.domain.rule.service.logic.impl;

import cn.bugstack.design.domain.rule.model.vo.DecisionMatter;
import cn.bugstack.design.domain.rule.service.logic.BaseLogic;
import org.springframework.stereotype.Service;

@Service("userGenderFilter")
public class UserGenderFilter extends BaseLogic {

    @Override
    public String matterValue(DecisionMatter decisionMatter) {
        return decisionMatter.getValMap().get("gender").toString();
    }
    
}

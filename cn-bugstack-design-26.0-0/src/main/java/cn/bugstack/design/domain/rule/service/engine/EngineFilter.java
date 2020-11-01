package cn.bugstack.design.domain.rule.service.engine;

import cn.bugstack.design.domain.rule.model.vo.DecisionMatter;
import cn.bugstack.design.domain.rule.model.vo.EngineResult;

public interface EngineFilter {

    EngineResult process(final DecisionMatter matter) throws Exception;

}

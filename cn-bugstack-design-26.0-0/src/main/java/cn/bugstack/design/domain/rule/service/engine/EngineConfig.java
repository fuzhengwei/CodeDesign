package cn.bugstack.design.domain.rule.service.engine;

import cn.bugstack.design.domain.rule.service.logic.LogicFilter;
import cn.bugstack.design.domain.rule.service.logic.impl.UserAgeFilter;
import cn.bugstack.design.domain.rule.service.logic.impl.UserGenderFilter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 微信公众号：bugstack虫洞栈 | 专注原创技术专题案例
 */
public class EngineConfig {

    static Map<String, LogicFilter> logicFilterMap;

    static {
        logicFilterMap = new ConcurrentHashMap<>();
        logicFilterMap.put("userAge", new UserAgeFilter());
        logicFilterMap.put("userGender", new UserGenderFilter());
    }

    public Map<String, LogicFilter> getLogicFilterMap() {
        return logicFilterMap;
    }

    public void setLogicFilterMap(Map<String, LogicFilter> logicFilterMap) {
        this.logicFilterMap = logicFilterMap;
    }

}

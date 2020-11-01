package cn.bugstack.design.interfaces;

import com.alibaba.fastjson.JSON;
import cn.bugstack.design.application.MallRuleService;
import cn.bugstack.design.application.MallTreeService;
import cn.bugstack.design.domain.rule.model.vo.DecisionMatter;
import cn.bugstack.design.domain.rule.model.vo.EngineResult;
import cn.bugstack.design.domain.tree.model.aggregates.TreeCollect;
import cn.bugstack.design.interfaces.dto.DecisionMatterDTO;
import cn.bugstack.design.interfaces.dto.TreeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class DDDController {

    private Logger logger = LoggerFactory.getLogger(DDDController.class);

    @Resource
    private MallTreeService mallTreeService;
    @Resource
    private MallRuleService mallRuleService;

    /**
     * 测试接口：http://localhost:8080/api/tree/queryTreeSummaryInfo
     * 请求参数：{"treeId":10001}
     */
    @RequestMapping(path = "/api/tree/queryTreeSummaryInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity queryTreeSummaryInfo(@RequestBody TreeDTO request) {
        String reqStr = JSON.toJSONString(request);
        try {
            logger.info("查询规则树信息{}Begin req：{}", request.getTreeId(), reqStr);
            TreeCollect treeCollect = mallTreeService.queryTreeSummaryInfo(request.getTreeId());
            logger.info("查询规则树信息{}End res：{}", request.getTreeId(), JSON.toJSON(treeCollect));
            return new ResponseEntity<>(treeCollect, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("查询规则树信息{}Error req：{}", request.getTreeId(), reqStr, e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    /**
     * 测试接口：http://localhost:8080/api/tree/decisionRuleTree
     * 请求参数：{"treeId":10001,"userId":"xiaofuge","valMap":{"gender":"man","age":"25"}}
     */
    @RequestMapping(path = "/api/tree/decisionRuleTree", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity decisionRuleTree(@RequestBody DecisionMatterDTO request) {
        String reqStr = JSON.toJSONString(request);
        try {
            logger.info("规则树行为信息决策{}Begin req：{}", request.getTreeId(), reqStr);
            DecisionMatter decisionMatter = new DecisionMatter();
            decisionMatter.setTreeId(request.getTreeId());
            decisionMatter.setUserId(request.getUserId());
            decisionMatter.setValMap(request.getValMap());
            EngineResult engineResult = mallRuleService.process(decisionMatter);
            logger.info("规则树行为信息决策{}End res：{}", request.getTreeId(), JSON.toJSON(engineResult));
            return new ResponseEntity<>(engineResult, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("规则树行为信息决策{}Error req：{}", request.getTreeId(), reqStr, e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

}

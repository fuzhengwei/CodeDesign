package cn.bugstack.design.rpc.provider.web;

import cn.bugstack.design.rpc.export.HelloService;
import cn.bugstack.design.rpc.export.domain.Hi;
import org.springframework.stereotype.Controller;

@Controller("helloService")
public class HelloServiceImpl implements HelloService {

    @Override
    public String hi() {
        return "hi bugstack rpc";
    }

    @Override
    public String say(String str) {
        return str;
    }

    @Override
    public String sayHi(Hi hi) {
        return hi.getUserName() + " say：" + hi.getSayMsg();
    }

}

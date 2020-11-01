package cn.bugstack.design.rpc.export;

import cn.bugstack.design.rpc.export.domain.Hi;

public interface HelloService {

    String hi();

    String say(String str);

    String sayHi(Hi hi);

}

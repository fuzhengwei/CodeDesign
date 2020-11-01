package cn.bugstack.design.rpc.provider.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-config.xml")
public class ProviderTest {

    @Test
    public void init() throws InterruptedException {
         while (true){
             Thread.sleep(5000);
         }
    }

}

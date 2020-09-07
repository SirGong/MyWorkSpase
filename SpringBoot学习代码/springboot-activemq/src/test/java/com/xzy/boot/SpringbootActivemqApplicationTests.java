package com.xzy.boot;

import com.xzy.boot.activemq.Queue_Produce;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class SpringbootActivemqApplicationTests {
    @Autowired
    private Queue_Produce queue_produce;
    @Test
    public void testSend() {
        queue_produce.produceMsg();
    }

}

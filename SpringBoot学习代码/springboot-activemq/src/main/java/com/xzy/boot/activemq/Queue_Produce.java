package com.xzy.boot.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.UUID;

@Component
public class Queue_Produce {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;
    int i = 1;

    public void produceMsg(){
        jmsMessagingTemplate.convertAndSend(queue,"****"+
                UUID.randomUUID().toString().substring(0, 6));

    }

    /**
     * 间隔定投  三秒钟
     */
    @Scheduled(fixedDelay = 3000)
    public void produceMsgScheduled(){
        jmsMessagingTemplate.convertAndSend(queue,"***Scheduled***"+
                UUID.randomUUID().toString().substring(0, 6));

        System.out.println("第"+(i++)+"次投递成功！");
    }
}

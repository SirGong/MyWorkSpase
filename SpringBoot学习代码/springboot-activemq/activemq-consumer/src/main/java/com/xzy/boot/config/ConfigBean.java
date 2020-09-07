package com.xzy.boot.config;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class ConfigBean {
    @JmsListener(destination = "${myqueue}")
    public void receive(TextMessage message) throws JMSException {
        System.out.println("消费者受到消息：" + message.getText());
    }
}

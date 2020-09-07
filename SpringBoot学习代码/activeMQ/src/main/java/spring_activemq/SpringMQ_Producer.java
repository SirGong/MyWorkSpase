package spring_activemq;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import javax.jms.TextMessage;


@Service
public class SpringMQ_Producer {
    @Autowired
    JmsTemplate jmsTemplate;
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringMQ_Producer producer = (SpringMQ_Producer) applicationContext.getBean("springMQ_Producer");
/*        producer.jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage("spring和active MQ 的整合。。。。。。。。。。");
                return textMessage;
            }
        });*/
        producer.jmsTemplate.send((session)->{
            TextMessage textMessage = session.createTextMessage("spring和active MQ 的整合。。。。。。。。。。");
            return textMessage;
        });
        System.out.println("send message over!!");
    }
}

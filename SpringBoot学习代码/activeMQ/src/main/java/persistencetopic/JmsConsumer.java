package persistencetopic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class JmsConsumer {

    public static final String ACTIVEMQ_URL = "tcp://localhost:61616";
    public static final String TOPIC_NAME = "topic01";

    public static void main(String[] args) throws JMSException {
        System.out.println("消费者zs");
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.setClientID("zs");

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(TOPIC_NAME) ;
        TopicSubscriber topicSubscriber = session.createDurableSubscriber(topic, "remark.............");

        connection.start();

        Message message = topicSubscriber.receive();
        while(message!=null){
            TextMessage textMessage = (TextMessage) message;
            System.out.println("收到的持久化topic："+textMessage.getText());
            message = topicSubscriber.receive(3000L);
        }
        session.close();
        connection.close();
    }
}

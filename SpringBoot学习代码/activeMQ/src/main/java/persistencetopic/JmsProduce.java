package persistencetopic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsProduce {
    public static final String ACTIVEMQ_URL = "tcp://localhost:61616";
    public static final String TOPIC_NAME = "topic01";

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(TOPIC_NAME);
        MessageProducer producer = session.createProducer(topic);

        connection.start();

        for (int i = 1; i < 3; i++) {
            TextMessage textMessage = session.createTextMessage("persistence-topicMessage-" + i);
            producer.send(textMessage);
        }

        producer.close();
        session.close();
        connection.close();
        System.out.println("持久化主题发送成功！！");
    }
}

package activemqqueue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class JmsConsumer2 {
    public static final String ACTIVEMQ_URL = "tcp://localhost:61616";
    public static final String QUEUE_NAME = "queue01";
    public static void main(String[] args) throws JMSException, IOException {

        System.out.println("我是消费者2");

        //创建连接工厂，传入URL地址，使用默认用户名和密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //通过连接工厂获得连接并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        //创建会话,第一个参数：事务  第二个参数：签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建目的地：队列
        Destination queue = session.createQueue(QUEUE_NAME);
        //创建消费者
        MessageConsumer messageConsumer = session.createConsumer(queue);

        /*
        同步阻塞的方式，设置时间之后过时不候
        while (true){
            TextMessage textMessage = (TextMessage) messageConsumer.receive();
            if(textMessage != null){
                System.out.println("消费者接受到的消息："+textMessage.getText());
            }else {
                break;
            }
        }*/

        //通过监听的方式
        messageConsumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if(message != null && message instanceof TextMessage){
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println("接受到的消息是："+textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        System.in.read();

        messageConsumer.close();
        session.close();
        connection.close();
    }
}

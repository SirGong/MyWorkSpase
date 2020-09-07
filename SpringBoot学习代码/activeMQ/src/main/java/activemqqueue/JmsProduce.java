package activemqqueue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsProduce {

    public static final String ACTIVEMQ_URL = "tcp://localhost:61616";
    public static final String QUEUE_NAME = "queue01";
    //消息默认持久化
    public static void main(String[] args) throws JMSException {
        //创建连接工厂，传入URL地址，使用默认用户名和密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //通过连接工厂获得连接并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
        //启动连接
        connection.start();

        //创建会话,第一个参数：事务  第二个参数：签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建目的地：队列
        Destination queue = session.createQueue(QUEUE_NAME);
        //创建消息的生产者
        MessageProducer messageProducer = session.createProducer(queue);
        for (int i = 1; i <7 ; i++) {
            //创建消息
            TextMessage textMessage = session.createTextMessage("msg-" + i);//字符串
            //通过生产者messageProducer发送给MQ
            messageProducer.send(textMessage);
        }
        //关闭资源
        messageProducer.close();
        session.close();
        connection.close();

        System.out.println("消息已经顺利发布！");

    }
}

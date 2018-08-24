package bishe.activeMQ;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;


/**
 * 生产者
 * @author Administrator
 *
 */
public class TopicProducer {
	private static final String url = "tcp://127.0.0.1:61616";
	private static final String topicName = "topic-test";
public static void main(String[] args) {
	try {
		// 创建连接工厂
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		
		// 创建连接
		javax.jms.Connection connection = connectionFactory.createConnection();
		
		// 启动连接
		connection.start();
		
		// 创建会话
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		// 创建目的地destination
		Destination destination = session.createTopic(topicName);
		
		// 创建生产者
		MessageProducer messageProducer = session.createProducer(destination);
		
		for(int i = 0;i<100;i++){
			// 创建消息
		    TextMessage textMessage = session.createTextMessage("test"+i);
		    messageProducer.send(textMessage);
		    
		    System.out.println("发送消息"+textMessage.getText());
		}
		
		// 关闭连接
		connection.close();
		
	} catch (JMSException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}

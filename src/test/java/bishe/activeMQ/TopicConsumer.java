package bishe.activeMQ;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;


/**
 * 消费者
 * @author Administrator
 *
 */
public class TopicConsumer {
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
		
		// 创建消费者
		MessageConsumer messageConsumer = session.createConsumer(destination);
		
		// 创建一个监听器
		messageConsumer.setMessageListener(new MessageListener() {
			
			public void onMessage(Message message) {
					TextMessage textMessage = (TextMessage) message;
					try {
						System.out.println("接收消息"+textMessage.getText());
					} catch (JMSException e) {
						e.printStackTrace();
					}
			}
		});
		
		// 关闭连接 消息监听是异步过程 onMessage
		//connection.close();
		
	} catch (JMSException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}

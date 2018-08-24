package bishe.activeMQ;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;


/**
 * ������
 * @author Administrator
 *
 */
public class TopicProducer {
	private static final String url = "tcp://127.0.0.1:61616";
	private static final String topicName = "topic-test";
public static void main(String[] args) {
	try {
		// �������ӹ���
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		
		// ��������
		javax.jms.Connection connection = connectionFactory.createConnection();
		
		// ��������
		connection.start();
		
		// �����Ự
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		// ����Ŀ�ĵ�destination
		Destination destination = session.createTopic(topicName);
		
		// ����������
		MessageProducer messageProducer = session.createProducer(destination);
		
		for(int i = 0;i<100;i++){
			// ������Ϣ
		    TextMessage textMessage = session.createTextMessage("test"+i);
		    messageProducer.send(textMessage);
		    
		    System.out.println("������Ϣ"+textMessage.getText());
		}
		
		// �ر�����
		connection.close();
		
	} catch (JMSException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}

package com.pss.utils;

import java.util.UUID;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.pss.controller.DemoController;
import com.pss.domain.JmsMessage;

public class ActiveMqProducer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ActiveMqProducer.class);
	
	private JmsTemplate jmsTemplate;
	
	private static final String MESSAGE_FAILED_COUNT = "JMSXDeliveryCount";
	
	/**
	 * This method is used to create jms message and send it to Queue
	 * 
	 * @throws JMSException the exception of JMS
	 */
	public String sendMessageToQueue() throws JMSException {
		LOGGER.info("=== Start to send to queue-test ===");
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				ObjectMessage objectMessage = session.createObjectMessage();
				JmsMessage jmsMessage = new JmsMessage("headerMessage", "bodyMessage");
				objectMessage.setObject(jmsMessage);
				objectMessage.setStringProperty("correlationId", UUID.randomUUID().toString());
				objectMessage.setStringProperty("uniqueName", "_pengs1");
				return objectMessage;
			}
		});
		LOGGER.info("=== Send to queue-test End ===");
		return "success!";
	}
	
	/**
	 * Set method to jmsTemplate used by spring
	 * 
	 * @param jmsTemplate the instance of JmsTemplate
	 */
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
}

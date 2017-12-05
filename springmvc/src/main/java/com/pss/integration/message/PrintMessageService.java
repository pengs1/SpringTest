package com.pss.integration.message;

import java.util.UUID;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.Header;
import org.springframework.jms.core.MessageCreator;

import com.pss.domain.JmsMessage;

/**
 * Test for spring integration to print all message information 
 * 
 * @author songsong.peng
 *
 */
public class PrintMessageService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PrintMessageService.class);
	
	public JmsMessage printAll(final JmsMessage jmsMessage,@Header("uniqueName") String uniqueName, @Header("correlationId") String correlationId) {
		LOGGER.debug("print start, uniqueName:{}, correlationId:{}", uniqueName, correlationId);
		System.out.println("==============================");
		System.out.println("uniqueName:"+uniqueName);
		System.out.println("correlationId:"+correlationId);
		System.out.println("jmsMessageHeader:"+jmsMessage.getMsgHeader());
		System.out.println("jmsMessageBody:"+jmsMessage.getMsgBody());
		System.out.println("==============================");
		
		
		
		return jmsMessage;
	}
}



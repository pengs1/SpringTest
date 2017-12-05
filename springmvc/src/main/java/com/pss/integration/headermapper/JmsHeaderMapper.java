package com.pss.integration.headermapper;

import java.util.Map;
import java.util.UUID;

import javax.jms.JMSException;
import javax.jms.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.jms.DefaultJmsHeaderMapper;

import com.pss.controller.DemoController;

public class JmsHeaderMapper extends DefaultJmsHeaderMapper {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JmsHeaderMapper.class);

	public Map<String, Object> toHeaders(Message jmsMessage) {
		Map<String, Object> headers = super.toHeaders(jmsMessage);
		if (headers.get("correlationId") == null) {
			try {
				if (jmsMessage.getJMSCorrelationID() == null) {
					if (jmsMessage.getJMSMessageID() == null) {
						headers.put("correlationId", UUID.randomUUID().toString());
					} else {
						headers.put("correlationId", jmsMessage.getJMSMessageID());
					}
				}
				else {
					headers.put("correlationId", jmsMessage.getJMSCorrelationID());
				}
				headers.put("orig_jms_timstamp", Long.valueOf(jmsMessage.getJMSTimestamp()));
			}
			catch (JMSException e)
			{
				LOGGER.error(e.getMessage(), e);
			}
		}
		return headers;
	}
}
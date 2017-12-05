package com.pss.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pss.domain.JmsMessage;
import com.pss.gateway.MessageUploadGateway;

/**
 * Send message to remote test queue by spring integration gateway
 * 
 * @author songsong.peng
 */
@Service
public class SendMessageByGateWayService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SendMessageByGateWayService.class);
	
	@Autowired
	private MessageUploadGateway messageUploadGateway;
	
	/**
	 * Propagation REQUIRES_NEW 创建新的transaction并执行；如果当前已有transaction，则将当前transaction挂起；
	 * 
	 * @param jmsMessage body
	 * @param correlationId id
	 * @param uniqueName name
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void sendMessageThroughGateway(JmsMessage jmsMessage, String correlationId, String uniqueName) {
		LOGGER.info("=== Start to send message ===");
		messageUploadGateway.stage(jmsMessage, correlationId, uniqueName);
		LOGGER.info("=== Send message End ===");
	}
}

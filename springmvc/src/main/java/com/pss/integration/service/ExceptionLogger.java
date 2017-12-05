package com.pss.integration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ErrorHandler;

/**
 * This exception logger is used to log the exception which occurs in the integration as the error and put the user id
 * in the message.
 * 
 * @author songsong.peng
 */
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ExceptionLogger implements ErrorHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionLogger.class);
	
	private String userId;
	
	public void handleError(Throwable ex) {
		LOGGER.error("Exception in integration flow. Account ID: {}", this.userId, ex);
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}

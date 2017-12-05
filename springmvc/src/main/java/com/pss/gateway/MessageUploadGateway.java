package com.pss.gateway;

import org.springframework.integration.annotation.Header;

import com.pss.domain.JmsMessage;

/**
 * The gateway used by spring integration for the  message upload request.
 * 
 * @author songsong.peng
 */
public interface MessageUploadGateway {
	void stage(JmsMessage jmsMessage,
				@Header("correlationId") String correlationId,
				@Header("uniqueName") String uniqueName);
}

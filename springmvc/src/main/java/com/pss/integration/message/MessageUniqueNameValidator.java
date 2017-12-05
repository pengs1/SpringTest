package com.pss.integration.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.Header;

/**
 * This class is used to validate the message unique name
 * 
 * @author songsong.peng
 */
public class MessageUniqueNameValidator {
	
	private static final String PENGS1 = "_pengs1";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageUniqueNameValidator.class);
	
	/**
	 * Just for spring integration test
	 * 
	 * @param uniqueName
	 * @return booealn value
	 */
	public boolean validateName(@Header("uniqueName") String uniqueName) {
		LOGGER.info("Start to validate unique Name {}", uniqueName);
		return uniqueName.equals(PENGS1);
	}

}

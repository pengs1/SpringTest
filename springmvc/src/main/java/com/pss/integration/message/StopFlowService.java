package com.pss.integration.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Used to stop the flow
 * 
 * @author songsong.peng
 */
public class StopFlowService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StopFlowService.class);
	
	public void stopFlow() {
		LOGGER.info("Flow stop, because the unique name is not _pengs1!!");
	}
}

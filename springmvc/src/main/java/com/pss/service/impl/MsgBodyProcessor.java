package com.pss.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pss.service.MessageProcessor;

/**
 * 责任链模式测试（body processor）
 * 
 * @author songsong.peng
 *
 */
public class MsgBodyProcessor implements MessageProcessor {

	private static final String PROCESSOR_NAME = "MsgBodyProcessor";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MsgBodyProcessor.class);

	public String doProcessor(String msg) {
		System.out.println("I'm MsgBodyProcessor:"+msg);
		LOGGER.info("Deal with {}", PROCESSOR_NAME);
		return msg+PROCESSOR_NAME;
	}

}

package com.pss.service;

import com.pss.domain.JmsMessage;

/**
 * 责任链模式测试(Interface)
 * 
 * @author songsong.peng
 *
 */
public interface MessageProcessor {
	
	public String doProcessor(String msg);
	
}

package com.pss.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;

import com.pss.chain.ProcessorChain;
import com.pss.service.MessageProcessor;
import com.pss.service.impl.MsgBodyProcessor;
import com.pss.service.impl.MsgFooterProcessor;
import com.pss.service.impl.MsgHeaderProcessor;

/**
 * Responsibility chain model(责任链模式测试)
 * 
 * @author songsong.peng
 *
 */
public class MsgProcessorChainTest {
	
	public static void main(String[] args) {
		String msg = "Original message from main method:";
		// Set processors to chain
		ProcessorChain processorChain = new ProcessorChain();
		processorChain.addProcessor(new MsgHeaderProcessor())
						.addProcessor(new MsgBodyProcessor())
						.addProcessor(new MsgFooterProcessor());
		processorChain.setMessage(msg);
		String finalString = processorChain.doProcessor();
		//SerializationUtils.clone(object)
		System.out.println("Final:"+finalString);
	}
}

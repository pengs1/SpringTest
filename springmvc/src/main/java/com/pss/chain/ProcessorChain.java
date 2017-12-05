package com.pss.chain;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pss.service.MessageProcessor;

/**
 * 责任链模式测试（chain）
 * 
 * @author songsong.peng
 *
 */
public class ProcessorChain {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessorChain.class);
	
	private String message;
	
	private List<MessageProcessor> processors = new ArrayList<MessageProcessor>();
	
	/**
	 * Add the processor to processors
	 * 
	 * @param messageProcessor
	 * @return the instance it self
	 */
	public ProcessorChain addProcessor(MessageProcessor messageProcessor) {
		processors.add(messageProcessor);
		return this;
	}
	
	/**
	 * This method is to run each processor
	 * 
	 * @param msg
	 * @return string which is processored
	 */
	public String doProcessor() {
		LOGGER.info("Start to processor message {}", this.message);
		String dealMsg = this.message;
		for (MessageProcessor processor : processors) {
			dealMsg = processor.doProcessor(dealMsg);
		}
		LOGGER.info("End to processor message {}", this.message);
		return dealMsg;
	}
	
	public List<MessageProcessor> getProcessors() {
		return processors;
	}

	public void setProcessors(List<MessageProcessor> processors) {
		this.processors = processors;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

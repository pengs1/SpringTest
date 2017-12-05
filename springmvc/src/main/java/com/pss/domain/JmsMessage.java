package com.pss.domain;

import java.io.Serializable;

/**
 * Test for spring jms
 * 
 * @author songsong.peng
 *
 */
public class JmsMessage implements Serializable {
	
	private String msgHeader;
	
	private String msgBody;

	
	
	public JmsMessage() {
		super();
	}

	public JmsMessage(String msgHeader, String msgBody) {
		super();
		this.msgHeader = msgHeader;
		this.msgBody = msgBody;
	}

	public String getMsgHeader() {
		return msgHeader;
	}

	public void setMsgHeader(String msgHeader) {
		this.msgHeader = msgHeader;
	}

	public String getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JmsMessage [msgHeader=");
		builder.append(msgHeader);
		builder.append(", msgBody=");
		builder.append(msgBody);
		builder.append("]");
		return builder.toString();
	}
}

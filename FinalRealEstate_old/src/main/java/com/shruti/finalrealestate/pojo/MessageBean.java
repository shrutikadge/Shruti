package com.shruti.finalrealestate.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="messageBean")
public class MessageBean {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="messageID",unique=true,nullable=false)
	private int messageId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="messagesFromSender")
	private Person sender;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="messagesToReceiver")
    private Person receiver;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="message")
	private String message;
	
	
	
	public MessageBean() {
		super();
	}
	public MessageBean(String rec, Date date, String message) {
		super();
		
	    
		this.date = date;
		this.message = message;
	}
	
	public MessageBean(Person sender,Person receiver, Date date, String message) {
		super();
		this.sender=sender;
		this.receiver=receiver;
	    
		this.date = date;
		this.message = message;
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public Person getSender() {
		return sender;
	}
	public void setSender(Person sender) {
		this.sender = sender;
	}
	public Person getReceiver() {
		return receiver;
	}
	public void setReceiver(Person receiver) {
		this.receiver = receiver;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + messageId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessageBean other = (MessageBean) obj;
		if (messageId != other.messageId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return message;
	}
	
	
	
}

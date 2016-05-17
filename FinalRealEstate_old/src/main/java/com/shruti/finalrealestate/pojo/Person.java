package com.shruti.finalrealestate.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name="person")
@Inheritance(strategy=InheritanceType.JOINED)
@org.hibernate.annotations.Entity(
		dynamicUpdate = true
)
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="personID",unique=true,nullable=false)
	private int id;
	
	@Column(name="first")
	private String name;
	
	@Column(name="last")
	private String lastName;
	
	@Column(name="age")
	private String age;
	
	@Column(name="phone")
	private String phoneNumber;
	
	@Column(name="emailId")
	private String emailId;
	
	@Column(name="ssn")
	private String SSN;
	
	@Column(unique=true)
	private String userName;
	
	@Column(name="password")
	private String password;
	
	private String personTypes;
	
	@OneToMany(mappedBy="receiver", orphanRemoval=true,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<MessageBean> messagesToReceiver;
	
	@OneToMany(mappedBy="sender", orphanRemoval=true,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<MessageBean> messagesFromSender;
	
	public Person() {
		
	}
	public Person(String emailId, String userName, String password, String personTypes) {
		super();
		this.emailId = emailId;
		this.userName = userName;
		this.password = password;
		this.personTypes = personTypes;
	}
	
	
	public Person(String name, String lastName, String age, String phoneNumber, String emailId, String sSN,
			String userName, String password) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		SSN = sSN;
		this.userName = userName;
		this.password = password;
	//	this.personTypes = personTypes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPersonTypes() {
		return personTypes;
	}
	public void setPersonTypes(String personTypes) {
		this.personTypes = personTypes;
	}
	public Set<MessageBean> getMessagesToReceiver() {
		return messagesToReceiver;
	}
	public void setMessagesToReceiver(Set<MessageBean> messagesToReceiver) {
		this.messagesToReceiver = messagesToReceiver;
	}
	public Set<MessageBean> getMessagesFromSender() {
		return messagesFromSender;
	}
	public void setMessagesFromSender(Set<MessageBean> messagesFromSender) {
		this.messagesFromSender = messagesFromSender;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		Person other = (Person) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return String.valueOf(id);
	}
	
	
	
	
}

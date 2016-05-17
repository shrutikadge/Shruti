package com.shruti.finalrealestate.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name="Agent")
@PrimaryKeyJoinColumn(name="agentID")
public class Agent extends Person{

	
	public Agent(){}
	
	public Agent(String emailId, String userName, String password, String personTypes) {
		super(emailId, userName, password, personTypes);
		// TODO Auto-generated constructor stub
	}

	
	
	public Agent(String status, Set<Customer> customers, Set<Renter> renters, Set<Property> props) {
		super();
		this.status = status;
		this.customers = customers;
		this.renters = renters;
		this.props = props;
	}



	@Column(name="status")
	private String status;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="Agent_Customer", joinColumns = {
			@JoinColumn(name="agentID", nullable=false,updatable=false)
	}, inverseJoinColumns = {@JoinColumn(name="customerID", nullable = false,updatable = false)})
	private Set<Customer> customers;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="Agent_Renter", joinColumns = {
			@JoinColumn(name="agentID", nullable=false,updatable=false)
	}, inverseJoinColumns = {@JoinColumn(name="renterID", nullable = false,updatable = false)})
	private Set<Renter> renters;
	
	
	@OneToMany(mappedBy="agent",orphanRemoval=true,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	//@JoinColumn(name="agentID")
	@IndexColumn(name="ida")
	private Set<Property> props;

	
	

	public Set<Renter> getRenters() {
		return renters;
	}

	public void setRenters(Set<Renter> renters) {
		this.renters = renters;
	}

	public Set<Property> getProps() {
		return props;
	}

	public void setProps(Set<Property> props) {
		this.props = props;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
	
	public String toString(){
		return this.getUserName();
	}
	
}

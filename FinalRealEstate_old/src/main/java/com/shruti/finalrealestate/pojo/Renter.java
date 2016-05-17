package com.shruti.finalrealestate.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name="renter")
@PrimaryKeyJoinColumn(name="renterID")
public class Renter extends Person{

	
	
	public Renter(){};
	
	public Renter(String emailId, String userName, String password, String personTypes) {
		super(emailId, userName, password, personTypes);
		// TODO Auto-generated constructor stub
	}

	@ManyToMany(fetch = FetchType.LAZY ,mappedBy = "renters")
	private Set<Agent> agents;
	
	@OneToMany(orphanRemoval=true,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	//@JoinColumn(name="renterID")
	@IndexColumn(name="idr")
	private Set<Property> props;
	
	public Set<Agent> getAgents() {
		return agents;
	}

	public void setAgents(Set<Agent> agents) {
		this.agents = agents;
	}

	public Set<Property> getProps() {
		return props;
	}

	public void setProps(Set<Property> props) {
		this.props = props;
	}

	public String toString(){
		return this.getUserName();
	}
	
	
}

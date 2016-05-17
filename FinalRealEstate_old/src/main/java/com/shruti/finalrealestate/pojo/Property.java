package com.shruti.finalrealestate.pojo;


import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.IndexColumn;
import org.hibernate.type.BlobType;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="property")
public class Property {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="propertyID",unique=true,nullable=false)
	private int id;
	
	@Column(name="location")
	private String location;
	
	
	private String propTypes;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="agentID")
	private Agent agent;
	
	@ManyToOne
	@JoinColumn(name="customerID")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="renterID")
	private Renter renter;
	
	@Column(name="price")
	private double price;
	
   /* @Column(name="image")
	private String image;
	
	@Column(name="content")
	@Lob
	private BlobType content;*/
	
	/*public Property(String location, String propTypes, Renter renter, double price, MultipartFile image) {
		super();
		this.location = location;
		this.propTypes = propTypes;
		this.renter = renter;
		this.price = price;
		this.image = image;
	}*/
/*	public Property(String location, String propTypes, Customer customer, double price, MultipartFile image) {
		super();
		this.location = location;
		this.propTypes = propTypes;
		this.customer = customer;
		this.price = price;
		this.image = image;
	}*/
	public Property(String location, String propTypes, String agent, double price/*,String image*/) {
		super();
		this.location = location;
		this.propTypes = propTypes;
		//this.agent = agent;
		this.price = price;
		//this.image = image;
	}
	public Property(String location, String propTypes, Agent agent, double price/*,String image*/) {
		super();
		this.location = location;
		this.propTypes = propTypes;
		this.agent = agent;
		this.price = price;
		//this.image = image;
	}
/*	public Property(String location, String propTypes,
			double price, MultipartFile image) {
		super();
		this.location = location;
		this.propTypes = propTypes;
		this.price = price;
		this.image = image;
	}*/
	public Property() {
		// TODO Auto-generated constructor stub
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getPropTypes() {
		return propTypes;
	}
	public void setPropTypes(String propTypes) {
		this.propTypes = propTypes;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Renter getRenter() {
		return renter;
	}
	public void setRenter(Renter renter) {
		this.renter = renter;
	}
/*	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	*/
	
	public String toString(){
		return String.valueOf(id);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Property other = (Property) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}

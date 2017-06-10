package com.eframe.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client {
	
	@Id
	@GenericGenerator(name = "client_id", strategy = "com.eframe.model.generator.ClientIdGenerator")
	@GeneratedValue(generator = "client_id")  
	@Column(name="client_id")
	private String clientId;
	private String name;
	private String phone;
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	private Set<Bill> bills;
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Set<Bill> getBills() {
		return bills;
	}
	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}
}

package com.eframe.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client {
	
	@Id
	private Long clientId;
	private String name;
	private Integer phone;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	private Set<Bill> bills;
	
	public Long getClientId() {
		return clientId;
	}
	public Long setClientId(Long clientId) {
		return this.clientId = clientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	
	public Set<Bill> getBills() {
		return bills;
	}
	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}
}

package com.eframe.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Bill {

	@Id
	@GenericGenerator(name = "bill_id", strategy = "com.eframe.model.generator.BillIdGenerator")
	@GeneratedValue(generator = "bill_id")  
	@Column(name="bill_id")
	private String BillId;
	@Column(name = "date")
	LocalDate date;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", nullable = false)
	Client client;
	
	public String getBillId() {
		return BillId;
	}
	public void setBillId(String BillId) {
		this.BillId =BillId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
}

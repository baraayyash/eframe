package com.eframe.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

// طلب شراء خارجي
@Entity
public class OutSideOrder {
	@Id
	@GenericGenerator(name = "out_side_order_id", strategy = "com.eframe.model.generator.OutSideOrderIdGenerator")
	@GeneratedValue(generator = "out_side_order_id")  
	@Column(name="out_side_order_id")
	private String outSideOrderId;
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "outSideOrders")
	private Set<Product> products;
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "outSideOrder")
	private Set<Payment> payments;

	public Set<Payment> getPayments() {
		return payments;
	}
	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}
	public String getOutSideOrderId() {
		return outSideOrderId;
	}
	public void setOutSideOrderId(String outSideOrderId) {
		this.outSideOrderId = outSideOrderId;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
}

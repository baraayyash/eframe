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
public class Payment {
	@Id
	@GenericGenerator(name = "payment_id", strategy = "com.eframe.model.generator.PaymentIdGenerator")
	@GeneratedValue(generator = "payment_id")  
	@Column(name="payment_id")
	private String paymentId;
	private boolean isPaid;
	@Column(name = "date")
	LocalDate date;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "out_side_order_id", nullable = false)
	OutSideOrder outSideOrder;

	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public OutSideOrder getOutSideOrder() {
		return outSideOrder;
	}
	public void setOutSideOrder(OutSideOrder outSideOrder) {
		this.outSideOrder = outSideOrder;
	}

}

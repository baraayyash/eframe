package com.eframe.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("DEBIT")
@Entity
public class Debit extends Invoice {
	
	private String directPayment;

	public Debit(String s) {
		this.directPayment = s;
	}
	
	public String getDirectPayment() {
		return directPayment;
	}

	public void setDirectPayment(String directPayment) {
		this.directPayment = directPayment;
	}
}

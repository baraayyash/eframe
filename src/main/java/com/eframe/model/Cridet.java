package com.eframe.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("CRIDET")
@Entity
public class Cridet extends Invoice {

	private float paiedAmount;
	private float amountToPay;

	public float getPaiedAmount() {
		return paiedAmount;
	}
	public void setPaiedAmount(float paiedAmount) {
		this.paiedAmount = paiedAmount;
	}
	public float getAmountToPay() {
		return amountToPay;
	}
	public void setAmountToPay(float amountToPay) {
		this.amountToPay = amountToPay;
	}
}

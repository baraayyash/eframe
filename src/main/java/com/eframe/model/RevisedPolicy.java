package com.eframe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

// سند مرتجع
@Entity
public class RevisedPolicy {

	@Id
	@GenericGenerator(name = "revised_policy_id", strategy = "com.eframe.model.generator.RevisedPolicyIdGenerator")
	@GeneratedValue(generator = "revised_policy_id")  
	@Column(name="revised_policy_id")
	private String revisedPolicyId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "invoice_id", nullable = false)
	Invoice invoice;

	public String getRevisedPolicyId() {
		return revisedPolicyId;
	}
	public void setRevisedPolicyId(String revisedPolicyId) {
		this.revisedPolicyId = revisedPolicyId;
	}
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
}

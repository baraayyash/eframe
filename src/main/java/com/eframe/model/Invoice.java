package com.eframe.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
	name="invoice_type", 
	discriminatorType=DiscriminatorType.STRING
	)
public abstract class Invoice {

	@Id
	@GenericGenerator(name = "invoice_id", strategy = "com.eframe.model.generator.InvoiceIdGenerator")
	@GeneratedValue(generator = "invoice_id")  
	@Column(name="invoice_id")
	private String invoiceId;
	@Column(name = "date")
	LocalDate date;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", nullable = false)
	Client client;
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "invoice")
	private Set<RevisedPolicy> revisedPolicies;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "invoice")
	private Set<ProductInvoice> productInvoice;

	public String getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(String invoiceId) {
		this.invoiceId =invoiceId;
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

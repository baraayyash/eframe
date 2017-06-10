package com.eframe.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	@Id
	@GenericGenerator(name = "product_id", strategy = "com.eframe.model.generator.ProductIdGenerator")
	@GeneratedValue(generator = "product_id")  
	@Column(name="product_id")
	private String productId;
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "product_out_side_order", joinColumns = {
			@JoinColumn(name = "product_id", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "out_side_order_id",
					nullable = false, updatable = false) })
	private Set<OutSideOrder> outSideOrders;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private Set<ZoneProduct> zoneproducts;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private Set<ProductInvoice> productInvoice;

	public Set<ZoneProduct> getZoneproducts() {
		return zoneproducts;
	}
	public void setZoneproducts(Set<ZoneProduct> zoneproducts) {
		this.zoneproducts = zoneproducts;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Set<OutSideOrder> getOutSideOrders() {
		return outSideOrders;
	}
	public void setOutSideOrders(Set<OutSideOrder> outSideOrders) {
		this.outSideOrders = outSideOrders;
	}

}

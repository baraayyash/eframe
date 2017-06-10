package com.eframe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class ZoneProduct {
	@Id
	@GenericGenerator(name = "zone_product_id", strategy = "com.eframe.model.generator.ZoneProductIdGenerator")
	@GeneratedValue(generator = "zone_product_id")  
	@Column(name="zone_product_id")
	private String zoneProductId;
	private int ProductQty;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "zone_id")
	private Zone zone;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;

	public Zone getZone() {
		return zone;
	}
	public void setZone(Zone zone) {
		this.zone = zone;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getZoneProductId() {
		return zoneProductId;
	}
	public void setZoneProductId(String zoneProductId) {
		this.zoneProductId = zoneProductId;
	}
	public int getProductQty() {
		return ProductQty;
	}
	public void setProductQty(int productQty) {
		ProductQty = productQty;
	}
}

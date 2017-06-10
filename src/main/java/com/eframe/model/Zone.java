package com.eframe.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Zone {
	@Id
	@GenericGenerator(name = "zoneـid", strategy = "com.eframe.model.generator.ZoneIdGenerator")
	@GeneratedValue(generator = "zoneـid")  
	@Column(name="zoneـid")
	private String productId;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "zone")
	private Set<ZoneProduct> zoneproducts;

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Set<ZoneProduct> getZoneproducts() {
		return zoneproducts;
	}
	public void setZoneproducts(Set<ZoneProduct> zoneproducts) {
		this.zoneproducts = zoneproducts;
	}
}

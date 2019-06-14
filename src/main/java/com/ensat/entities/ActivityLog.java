package com.ensat.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ActivityLog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer logId;
	
	private Tenant tenant;
	private Booth booth;
	private Event event;
	private BigDecimal harga;


	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}
	
	public Booth getBooth() {
		return booth;
	}

	public void setBooth(Booth booth) {
		this.booth = booth;
	}
	public Event getEvent() {
		return event;
	}

	public void setEventId(Event event) {
		this.event = event;
	}
	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
	
	public BigDecimal getHarga() {
		return harga;
	}

	public void setHarga(BigDecimal harga) {
		this.harga = harga;
	}
	
}

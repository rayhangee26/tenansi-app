package com.ensat.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tenant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tenantId;

	private String nama;
	private String owner;
	private String alamat;
	private String no_identitas;

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}
	
	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	
	public String getNoIdentitas() {
		return no_identitas;
	}

	public void setNoIdentitas(String no_identitas) {
		this.no_identitas = no_identitas;
	}
}

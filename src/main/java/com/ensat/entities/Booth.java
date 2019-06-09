package com.ensat.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booth {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer boothId;

	private String ukuran;
	private BigDecimal harga;
	private String area;

	public Integer getBoothId() {
		return boothId;
	}

	public void setBoothId(Integer boothId) {
		this.boothId = boothId;
	}
	
	public String getUkuran() {
		return ukuran;
	}

	public void setUkuran(String ukuran) {
		this.ukuran = ukuran;
	}
	
	public BigDecimal getHarga() {
		return harga;
	}

	public void setHarga(BigDecimal harga) {
		this.harga = harga;
	}
	
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
}

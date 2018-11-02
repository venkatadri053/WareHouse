package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ventab")
public class Vendor {
	@Id
	@Column(name="v_id")
	@GeneratedValue
	private Integer venId;
	@Column(name="v_name")
	private String venName;
	@Column(name="v_code")
	private String venCode;
	@Column(name="v_desg")
	private String venDesg;
	@Column(name="v_preserve")
	private String venPreserve;
	public Vendor() {
		super();
	}

	public Vendor(Integer venId) {
		super();
		this.venId = venId;
	}

	public Vendor(Integer venId, String venName, String venCode, String venDesg, String venPreserve) {
		super();
		this.venId = venId;
		this.venName = venName;
		this.venCode = venCode;
		this.venDesg = venDesg;
		this.venPreserve = venPreserve;
	}

	public Integer getVenId() {
		return venId;
	}

	public void setVenId(Integer venId) {
		this.venId = venId;
	}

	public String getVenName() {
		return venName;
	}

	public void setVenName(String venName) {
		this.venName = venName;
	}

	public String getVenCode() {
		return venCode;
	}

	public void setVenCode(String venCode) {
		this.venCode = venCode;
	}

	public String getVenDesg() {
		return venDesg;
	}

	public void setVenDesg(String venDesg) {
		this.venDesg = venDesg;
	}

	public String getVenPreserve() {
		return venPreserve;
	}

	public void setVenPreserve(String venPreserve) {
		this.venPreserve = venPreserve;
	}

	@Override
	public String toString() {
		return "Vendor [venId=" + venId + ", venName=" + venName + ", venCode=" + venCode + ", venDesg=" + venDesg
				+ ", venPreserve=" + venPreserve + "]";
	}


}

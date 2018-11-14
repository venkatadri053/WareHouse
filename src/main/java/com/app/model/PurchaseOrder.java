package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="purchase_tab")
public class PurchaseOrder {
	@Id
	@GeneratedValue(generator="purgen")
	@GenericGenerator(name="purgen",strategy="increment")
	@Column(name="pur_id")
	private Integer id;
	@Column(name="pur_code")
	private String orderCode;
	@Column(name="pur_ref_num")
	private String referenceNumber;
	@Column(name="pur_qua_check")
	private String qualityCheck;
	@Column(name="pur_def_status")
	private String defaultStatus;
	@Column(name="")
	private String dsc;

	public PurchaseOrder() {
		super();
	}

	public PurchaseOrder(Integer id) {
		super();
		this.id = id;
	}

	public PurchaseOrder(Integer id, String orderCode, String referenceNumber, String qualityCheck,
			String defaultStatus, String dsc) {
		super();
		this.id = id;
		this.orderCode = orderCode;
		this.referenceNumber = referenceNumber;
		this.qualityCheck = qualityCheck;
		this.defaultStatus = defaultStatus;
		this.dsc = dsc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getQualityCheck() {
		return qualityCheck;
	}

	public void setQualityCheck(String qualityCheck) {
		this.qualityCheck = qualityCheck;
	}

	public String getDefaultStatus() {
		return defaultStatus;
	}

	public void setDefaultStatus(String defaultStatus) {
		this.defaultStatus = defaultStatus;
	}

	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [id=" + id + ", orderCode=" + orderCode + ", referenceNumber=" + referenceNumber
				+ ", qualityCheck=" + qualityCheck + ", defaultStatus=" + defaultStatus + ", dsc=" + dsc + "]";
	}


}

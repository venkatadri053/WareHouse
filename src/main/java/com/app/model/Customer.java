package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="cust_tab")
public class Customer {
	@Id
	@Column(name="c_id")
	@GeneratedValue(generator="custgen")
	@GenericGenerator(name="custgen",strategy="increment")
	private Integer custId;
	@Column(name="c_code")
	private String custCode;
	@Column(name="c_addr")
	private String custAddr;
	@Column(name="c_locs_data")
	private String custLocs;
	@Column(name="c_enabled")
	private String custEnabled;
	@Column(name="c_mail")
	private String custEmail;
	@Column(name="c_contact")
	private String custContact;
	
	public Customer() {
		super();
	}
	public Customer(Integer custId) {
		super();
		this.custId = custId;
	}
	public Customer(Integer custId, String custCode, String custAddr, String custLocs, String custEnabled,
			String custEmail, String custContact) {
		super();
		this.custId = custId;
		this.custCode = custCode;
		this.custAddr = custAddr;
		this.custLocs = custLocs;
		this.custEnabled = custEnabled;
		this.custEmail = custEmail;
		this.custContact = custContact;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getCustCode() {
		return custCode;
	}
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	public String getCustAddr() {
		return custAddr;
	}
	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}
	public String getCustLocs() {
		return custLocs;
	}
	public void setCustLocs(String custLocs) {
		this.custLocs = custLocs;
	}
	public String getCustEnabled() {
		return custEnabled;
	}
	public void setCustEnabled(String custEnabled) {
		this.custEnabled = custEnabled;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getCustContact() {
		return custContact;
	}
	public void setCustContact(String custContact) {
		this.custContact = custContact;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custCode=" + custCode + ", custAddr=" + custAddr + ", custLocs="
				+ custLocs + ", custEnabled=" + custEnabled + ", custEmail=" + custEmail + ", custContact="
				+ custContact + "]";
	}

}

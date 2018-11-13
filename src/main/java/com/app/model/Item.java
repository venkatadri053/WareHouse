
package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="item_tab")
public class Item {
	@Id
	@Column(name="i_id")
	@GeneratedValue(generator="itemgen")
	@GenericGenerator(name="itemgen",strategy="increment")
	private Integer id;
	@Column(name="i_code")
	private String code;
	@Column(name="i_width")
	private Double width;
	@Column(name="i_length")
	private Double length;
	@Column(name="i_height")
	private Double height;
	@Column(name="i_cost")
	private String cost;
	@Column(name="i_curre")
	private String currency;
	@Column(name="i_dsc")
	private String dsc;


	@ManyToOne
	@JoinColumn(name="uidFk")
	private Uom uom;


	@ManyToOne
	@JoinColumn(name="omSaleId")
	private OrderMethod saleType;


	@ManyToOne
	@JoinColumn(name="omPuchaseId")
	private OrderMethod purchaseType;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="itm_venusr_tab",
	joinColumns=@JoinColumn(name="itmaIdFk"),
	inverseJoinColumns=@JoinColumn(name="venIdFk"))
	@Fetch(value = FetchMode.SUBSELECT)

	private List<WhUserType> venUsers=new ArrayList<WhUserType>(0);

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="itm_custs_tab",
	joinColumns=@JoinColumn(name="itmbIdFk"),
	inverseJoinColumns=@JoinColumn(name="custIdFk"))
	@Fetch(value = FetchMode.SUBSELECT)

	private List<WhUserType> custUsers=new ArrayList<WhUserType>(0);

	public Item() {
		super();
	}

	public Item(Integer id) {
		super();
		this.id = id;
	}

	public Item(Integer id, String code, Double width, Double length, Double height, String cost, String currency,
			String dsc, Uom uom, OrderMethod saleType, OrderMethod purchaseType, List<WhUserType> venUsers,
			List<WhUserType> custUsers) {
		super();
		this.id = id;
		this.code = code;
		this.width = width;
		this.length = length;
		this.height = height;
		this.cost = cost;
		this.currency = currency;
		this.dsc = dsc;
		this.uom = uom;
		this.saleType = saleType;
		this.purchaseType = purchaseType;
		this.venUsers = venUsers;
		this.custUsers = custUsers;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	public Uom getUom() {
		return uom;
	}

	public void setUom(Uom uom) {
		this.uom = uom;
	}

	public OrderMethod getSaleType() {
		return saleType;
	}

	public void setSaleType(OrderMethod saleType) {
		this.saleType = saleType;
	}

	public OrderMethod getPurchaseType() {
		return purchaseType;
	}

	public void setPurchaseType(OrderMethod purchaseType) {
		this.purchaseType = purchaseType;
	}

	public List<WhUserType> getVenUsers() {
		return venUsers;
	}

	public void setVenUsers(List<WhUserType> venUsers) {
		this.venUsers = venUsers;
	}

	public List<WhUserType> getCustUsers() {
		return custUsers;
	}

	public void setCustUsers(List<WhUserType> custUsers) {
		this.custUsers = custUsers;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", code=" + code + ", width=" + width + ", length=" + length + ", height=" + height
				+ ", cost=" + cost + ", currency=" + currency + ", dsc=" + dsc + ", uom=" + uom + ", saleType="
				+ saleType + ", purchaseType=" + purchaseType + ", venUsers=" + venUsers + ", custUsers=" + custUsers
				+ "]";
	}


}

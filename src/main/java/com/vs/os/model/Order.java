package com.vs.os.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;

/**
 * Order
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-17T10:01:03.258Z")
@Entity
@Table(name = "VS_ORDER")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer orderId = null;

	private Integer productId = null;

	private BigDecimal price = null;

	private Integer quantity = null;

	private String email = null;

	private String address = null;

	private String orderstatus = null;

	private String orderdate = null;

	private String phone;

	private String creditcardnumber;

	public String getCreditcardnumber() {
		return creditcardnumber;
	}

	public void setCreditcardnumber(String creditcardnumber) {
		this.creditcardnumber = creditcardnumber;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	private Integer cvv = null;

	public Order productId(Integer productId) {
		this.productId = productId;
		return this;
	}

	/**
	 * Get productId
	 * 
	 * @return productId
	 **/
	@ApiModelProperty(value = "")
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Order price(BigDecimal price) {
		this.price = price;
		return this;
	}

	/**
	 * Proce of product
	 * 
	 * @return price
	 **/
	@ApiModelProperty(value = "Proce of product")
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Order quantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	/**
	 * Ordered Quantity
	 * 
	 * @return quantity
	 **/
	@ApiModelProperty(value = "Ordered Quantity")
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Order email(String email) {
		this.email = email;
		return this;
	}

	/**
	 * Email
	 * 
	 * @return email
	 **/
	@ApiModelProperty(value = "Email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Order address(String address) {
		this.address = address;
		return this;
	}

	/**
	 * Address
	 * 
	 * @return address
	 **/
	@ApiModelProperty(value = "Address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Order orderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
		return this;
	}

	/**
	 * Order Status
	 * 
	 * @return orderstatus
	 **/
	@ApiModelProperty(value = "Order Status")
	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public Order orderdate(String orderdate) {
		this.orderdate = orderdate;
		return this;
	}

	/**
	 * Order Placed on
	 * 
	 * @return orderdate
	 **/
	@ApiModelProperty(value = "Order Placed on")
	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getJson() {
		return new Gson().toJson(this);
	}

	public Order getObject(String json) {
		return new Gson().fromJson(json, Order.class);
	}
}

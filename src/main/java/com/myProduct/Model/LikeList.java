package com.myProduct.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "LikeList")
public class LikeList {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "listid")
	private Integer listid;
	
	@Column(name = "order_quantity")
	private Integer orderQuantity;
	
	@Column(name = "total_fee")
	private double totalFee;
	
	@Column(name = "total_amount")
	private Integer totalAmount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productid")
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account")
	private UserAccount userAccount;

	public Integer getListid() {
		return listid;
	}

	public void setListid(Integer listid) {
		this.listid = listid;
	}

	public Integer getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public double getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	
	

}

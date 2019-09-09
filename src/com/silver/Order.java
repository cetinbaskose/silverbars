package com.silver;

public class Order {

	private long userId;
	private Double orderQuantity;
	private long pricePerKg;
	private OrderTypeEnum orderType;

	public Order(long userId, Double orderQuantity, long pricePerKg, OrderTypeEnum orderType) {
		super();
		this.userId = userId;
		this.orderQuantity = orderQuantity;
		this.pricePerKg = pricePerKg;
		this.orderType = orderType;

	}

	@Override
	public String toString() {
		return "Order [userId=" + userId + ", orderQuantity=" + orderQuantity + ", pricePerKg=" + pricePerKg
				+ ", orderType=" + orderType + "]";
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Double getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Double orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public long getPricePerKg() {
		return pricePerKg;
	}

	public void setPricePerKg(long pricePerKg) {
		this.pricePerKg = pricePerKg;
	}

	public OrderTypeEnum getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderTypeEnum orderType) {
		this.orderType = orderType;
	}

}

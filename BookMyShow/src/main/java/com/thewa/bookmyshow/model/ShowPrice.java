package com.thewa.bookmyshow.model;
public class ShowPrice {
	private final double price;
	private final String currency;
	
	public ShowPrice(double price, String currency) {
		this.price = price;
		this.currency = currency;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getCurrency() {
		return this.currency;
	}
}
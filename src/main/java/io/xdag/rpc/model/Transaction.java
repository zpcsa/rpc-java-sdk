package io.xdag.rpc.model;

import java.io.Serializable;



public class Transaction  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String direction;
	
	private String address;
	
	private String amount;
	
	private String timestamp;

	

	public String getDirection() {
		return direction;
	}



	public void setDirection(String direction) {
		this.direction = direction;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getAmount() {
		return amount;
	}



	public void setAmount(String amount) {
		this.amount = amount;
	}



	public String getTimestamp() {
		return timestamp;
	}



	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}



	@Override
	public String toString() {
		return "Transaction [direction=" + direction + ", address=" + address + ", amount=" + amount + ", timestamp="
				+ timestamp + "]";
	}
	
}

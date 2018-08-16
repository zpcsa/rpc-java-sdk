package io.xdag.rpc.model;

import java.io.Serializable;

/**
 * 账户信息model
 * @author jerry
 *
 */
public class Account  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 账号地址
	 */
	private String address;

	/**
	 * 账户金额
	 */
	private String balance;
	
	private String key;

	/**
	 * 账号地址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 账号地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 账户金额
	 */
	public String getBalance() {
		return balance;
	}

	/**
	 * 账户金额
	 */
	public void setBalance(String balance) {
		this.balance = balance;
	}


	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	@Override
	public String toString() {
		return "Account [address=" + address + ", balance=" + balance + ", key=" + key + "]";
	}
	
}

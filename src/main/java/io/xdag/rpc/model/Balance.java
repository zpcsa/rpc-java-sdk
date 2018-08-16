package io.xdag.rpc.model;

import java.io.Serializable;


public class Balance  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 账户金额
	 */
	private String balance;

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

	@Override
	public String toString() {
		return "Balance [balance=" + balance + "]";
	}
	
}

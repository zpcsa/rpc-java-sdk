package io.xdag.rpc.model;

import java.io.Serializable;

/**
 * 区块信息
 * @author jerry
 *
 */
public class BlockInfo  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 块地址
	 */
	private String address;

	/**
	 * 账户金额
	 */
	private String amount;
	
	private String flags;
	
	private String state;
	
	/**
	 * 时间戳
	 */
	private String timestamp;


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


	public String getFlags() {
		return flags;
	}


	public void setFlags(String flags) {
		this.flags = flags;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}


	@Override
	public String toString() {
		return "BlockInfo [address=" + address + ", amount=" + amount + ", flags=" + flags + ", state=" + state
				+ ", timestamp=" + timestamp + "]";
	}
	
}

package io.xdag.rpc.model;

import java.io.Serializable;


public class Xfer  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 区块地址
	 */
	private String block;



	public String getBlock() {
		return block;
	}



	public void setBlock(String block) {
		this.block = block;
	}



	@Override
	public String toString() {
		return "Xfer [block=" + block + "]";
	}
	
}

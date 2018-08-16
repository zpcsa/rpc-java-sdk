package io.xdag.rpc.model;

import java.io.Serializable;


public class RpcError  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * codeNo
	 */
	private Integer code;

	/**
	 * 错误信息
	 */
	private String message;


	public Integer getCode() {
		return code;
	}




	public void setCode(Integer code) {
		this.code = code;
	}




	public String getMessage() {
		return message;
	}




	public void setMessage(String message) {
		this.message = message;
	}




	@Override
	public String toString() {
		return "RpcError [code=" + code + ", message=" + message + "]";
	}
	
}

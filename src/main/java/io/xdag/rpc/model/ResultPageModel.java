package io.xdag.rpc.model;

import java.io.Serializable;

public class ResultPageModel<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private RpcError error;
	
	private ResultObject<T> result;
	
	private String id;

	public RpcError getError() {
		return error;
	}

	public void setError(RpcError error) {
		this.error = error;
	}



	public ResultObject<T> getResult() {
		return result;
	}

	public void setResult(ResultObject<T> result) {
		this.result = result;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ResultPageModel [error=" + error + ", result=" + result + ", id=" + id + "]";
	}

	
	
}

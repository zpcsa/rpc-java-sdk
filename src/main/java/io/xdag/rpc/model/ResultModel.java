package io.xdag.rpc.model;

import java.io.Serializable;
import java.util.List;

public class ResultModel<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private RpcError error;
	
	private List<T> result;
	
	private String id;
	

	
	public RpcError getError() {
		return error;
	}

	public void setError(RpcError error) {
		this.error = error;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ResultModel [error=" + error + ", result=" + result + ", id=" + id + "]";
	}

	
	
}

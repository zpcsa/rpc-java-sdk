package io.xdag.rpc.model;

import java.io.Serializable;
import java.util.List;


public class ResultObject<T>  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 账户金额
	 */
	private Integer total;
	
	private List<T> object;


	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}



	public List<T> getObject() {
		return object;
	}
	public void setObject(List<T> object) {
		this.object = object;
	}
	@Override
	public String toString() {
		return "ResultObject [total=" + total + ", object=" + object + "]";
	}
	
}

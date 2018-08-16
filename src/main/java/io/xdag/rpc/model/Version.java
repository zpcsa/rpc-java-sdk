package io.xdag.rpc.model;

import java.io.Serializable;

public class Version  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * xdag版本信息
	 */
	private String version;

	/**
	 * xdag版本信息
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * xdag版本信息
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Version [version=" + version + "]";
	}
	
}

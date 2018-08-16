package io.xdag.rpc.storage;

import io.xdag.rpc.common.Constants;
import io.xdag.rpc.http.ProxyConfiguration;

/**
 * 该类封装了SDK相关配置参数
 */
public final class Configuration implements Cloneable {

 
    /**
     * 操作是否使用 https , 默认否
     */
    public boolean useHttpsDomains = false;

    /**
     * 连接超时时间 单位秒(默认10s)
     */
    public int connectTimeout = Constants.CONNECT_TIMEOUT;
    /**
     * 写超时时间 单位秒(默认 0 , 不超时)
     */
    public int writeTimeout = Constants.WRITE_TIMEOUT;
    /**
     * 回复超时时间 单位秒(默认30s)
     */
    public int readTimeout = Constants.READ_TIMEOUT;
    /**
     * 底层HTTP库所有的并发执行的请求数量
     */
    public int dispatcherMaxRequests = Constants.DISPATCHER_MAX_REQUESTS;
    /**
     * 底层HTTP库对每个独立的Host进行并发请求的数量
     */
    public int dispatcherMaxRequestsPerHost = Constants.DISPATCHER_MAX_REQUESTS_PER_HOST;
    /**
     * 底层HTTP库中复用连接对象的最大空闲数量
     */
    public int connectionPoolMaxIdleCount = Constants.CONNECTION_POOL_MAX_IDLE_COUNT;
    /**
     * 底层HTTP库中复用连接对象的回收周期（单位分钟）
     */
    public int connectionPoolMaxIdleMinutes = Constants.CONNECTION_POOL_MAX_IDLE_MINUTES;

    /*
     * 解析域名时,优先使用host配置,主要针对内部局域网配置
     */
    public boolean useDnsHostFirst;
    /**
     * 代理对象
     */
    public ProxyConfiguration proxy;

    public static String defaultApiHost = "192.168.199.99:8888";

    
    public Configuration() {
    }
  
	public Configuration clone() {
        try {
            return (Configuration) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String apiHost() {
        String scheme = "http://";
        if (useHttpsDomains) {
            scheme = "https://";
        }
        return scheme + defaultApiHost;
    }

	public ProxyConfiguration getProxy() {
		return proxy;
	}

	public void setProxy(ProxyConfiguration proxy) {
		this.proxy = proxy;
	}


}

package io.xdag.rpc.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.xdag.rpc.common.HttpException;
import io.xdag.rpc.config.Configuration;
import io.xdag.rpc.http.Client;
import io.xdag.rpc.http.Response;
import io.xdag.rpc.model.Account;
import io.xdag.rpc.model.Balance;
import io.xdag.rpc.model.BlockInfo;
import io.xdag.rpc.model.ResultModel;
import io.xdag.rpc.model.ResultObject;
import io.xdag.rpc.model.ResultPageModel;
import io.xdag.rpc.model.RpcError;
import io.xdag.rpc.model.Stats;
import io.xdag.rpc.model.Transaction;
import io.xdag.rpc.model.Version;
import io.xdag.rpc.model.Xfer;
import io.xdag.rpc.util.Json;
import io.xdag.rpc.util.ObjectUtils;
import io.xdag.rpc.util.StringMap;

public class JsonRPCApi {
	
	private  static final Configuration configuration = new Configuration();
	
	private  static final JsonRPCApi INSTANCE = new JsonRPCApi();
	
	private  static final Client client = new Client();
	
	private  static final String RPC_VERSION = "1.1";
	private  static final String XDAG_VERSION = "xdag_version";
	private  static final String XDAG_GET_ACCOUNT = "xdag_get_account";
	private  static final String XDAG_GET_BALANCE = "xdag_get_balance";
	private  static final String XDAG_STATE = "xdag_state";
	private  static final String XDAG_STATS = "xdag_stats";
	private  static final String XDAG_GET_BLOCK_INFO = "xdag_get_block_info";
	private  static final String XDAG_GET_TRANSACTIONS  = "xdag_get_transactions";
	private  static final String XDAG_DO_XFER = "xdag_do_xfer";
	private  static final String XDAG_NEW_ADDRESS = "xdag_new_address";
	
	private static final String CONTENT_TYPE = "application/json; charset=utf-8";
	
	private JsonRPCApi() {}

	
    public static JsonRPCApi getInstance() {
        return INSTANCE;
    }
	
    /**
	 * 返回xdag节点版本
	 * @return
	 */
	public ResultModel<Version> version() {
		StringMap map = new StringMap();
		List<String> params = new ArrayList<String>();
		map.put("params", params);
		map.put("method", XDAG_VERSION);
		return doRequest(map,Version.class);
	}
	/**
	 * 返回xdag账号数量
	 * @param count 需要返回xdag的账号数量
	 * @return
	 */
	public ResultModel<Account> getAccount(int count) {
		StringMap map = new StringMap();
		List<String> params = new ArrayList<String>();
		params.add(String.valueOf(count));
		map.put("params", params);
		map.put("method", XDAG_GET_ACCOUNT);
		return doRequest(map,Account.class);
	}
	
	/**
	 * 返回账号余额
	 * @param address 需要查询的账号地址
	 * @return
	 */
	public ResultModel<Balance> getBalance(String address) {		
		StringMap map = new StringMap();
		List<String> params = new ArrayList<String>();
		params.add(address);
		map.put("params", params);
		map.put("method", XDAG_GET_BALANCE);
		return doRequest(map,Balance.class);
	}
	
	/**
	 * 获取节点当前状态
	 * @return 
	 */
	public ResultModel<String> getState() {		
		StringMap map = new StringMap();
		List<String> params = new ArrayList<String>();
		map.put("params", params);
		map.put("method", XDAG_STATE);
		return doRequest(map,String.class);
	}
	
	
	/**
	 * 获取已连接节点的当前统计信息
	 * @return
	 */
	public ResultModel<Stats> getStats() {	
		StringMap map = new StringMap();
		List<String> params = new ArrayList<String>();
		map.put("params", params);
		map.put("method", XDAG_STATS);
		map.put("method", XDAG_GET_BLOCK_INFO);
		return doRequest(map,Stats.class);
	}
	
	/**
	 * 返回块信息
	 * @param hashrate 地址或 hashrate
	 * @return
	 */
	public ResultModel<BlockInfo> getBlockInfo(String hashrate) {
		StringMap map = new StringMap();
		List<String> params = new ArrayList<String>();
		params.add(hashrate);
		map.put("params", params);
		map.put("method", XDAG_GET_BLOCK_INFO);
		return doRequest(map,BlockInfo.class);
	}

	/**
	 * 获取指定地址的交易信息
	 * @param address 交易地址
	 * @param page 页码
	 * @param pageSize 每页大小
	 * @return
	 */
	public ResultPageModel<Transaction> getTransactions(String address,int page,int pageSize) {	
		StringMap map = new StringMap();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("address", address);
		params.put("page", page);
		params.put("pagesize", pageSize);
		list.add(params);
		map.put("params", list);
		map.put("method", XDAG_GET_TRANSACTIONS);
		return doRequestPage(map,Transaction.class,"transactions");
	}
	
	/**
	 * 转账到指定交易地址
	 * @param amount 金额
	 * @param address 地址
	 * @return
	 */
	public ResultModel<Xfer> doXfer(String amount,String address) {
		StringMap map = new StringMap();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("address", address);
		params.put("amount", amount);
		list.add(params);
		map.put("params", list);
		map.put("method", XDAG_DO_XFER);
		return doRequest(map,Xfer.class);
	}
	
	/**
	 * 生成指定数量的新地址，默认为1
	 * @param count 地址数量
	 * @return 生成的账户地址数组
	 */
	public ResultModel<String> createNewAddress(int count) {
		StringMap map = new StringMap();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("count", count);
		list.add(params);
		map.put("params", list);
		map.put("method", XDAG_NEW_ADDRESS);
		return doRequest(map,String.class);
	}
	
	/**
	 * 请求接口
	 * @param <T>
	 * @param <T>
	 * @param map 参数
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private <T> ResultModel<T> doRequest(StringMap map,Class<T> cls){
		String url = configuration.apiHost();
		try {		
			map.put("id", RPC_VERSION);
			Response response = client.post(url, Json.toJson(map.map()), null,CONTENT_TYPE);
			HashMap<String,Object> retMap = Json.jsonToHashMap(response.bodyString());
			ResultModel<T> obj = new ResultModel<T>();	
			obj.setId((String)retMap.get("id"));
			
			if(retMap.containsKey("result")) {
				List<T> list = Json.jsonToList(Json.toJson(retMap.get("result")), cls);
				obj.setResult(list);
			}else if(retMap.containsKey("error")) {
				RpcError error = new RpcError();
				if(((HashMap)retMap.get("error")).containsKey("code")) {
					error.setCode((Integer)((HashMap)retMap.get("error")).get("code"));
				}
				if(((HashMap)retMap.get("error")).containsKey("message")) {
					error.setMessage((String)((HashMap)retMap.get("error")).get("message")); 
				}
				obj.setError(error);
			}
			return obj;
		} catch (HttpException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 请求接口
	 * @param map 参数
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private <T> ResultPageModel<T> doRequestPage(StringMap map,Class<T> cls,String key){
		String url = configuration.apiHost();
		try {		
			map.put("id", RPC_VERSION);
			System.out.println(Json.toJson(map.map()));
			Response response = client.post(url, Json.toJson(map.map()), null,CONTENT_TYPE);
			HashMap<String,Object> retMap = Json.jsonToHashMap(response.bodyString());
			ResultPageModel<T> obj = new ResultPageModel<T>();	
			ResultObject<T> resultObject = new ResultObject<T>();
			obj.setId((String)retMap.get("id"));
			
			if(ObjectUtils.isNotEmpty(retMap.containsKey("result"))) {	
				if(((HashMap)retMap.get("result")).containsKey("total")) {
					resultObject.setTotal((Integer)((HashMap)retMap.get("result")).get("total"));
				}
				if(((HashMap)retMap.get("result")).containsKey(key)) {
					List<T> list = Json.jsonToList(Json.toJson(((HashMap)retMap.get("result")).get(key)), cls);
					resultObject.setObject(list);
				}
				
				obj.setResult(resultObject);
			}else if(retMap.containsKey("error")) {
				RpcError error = new RpcError();
				if(((HashMap)retMap.get("error")).containsKey("code")) {
					error.setCode((Integer)((HashMap)retMap.get("error")).get("code"));
				}
				if(((HashMap)retMap.get("error")).containsKey("message")) {
					error.setMessage((String)((HashMap)retMap.get("error")).get("message")); 
				}
				obj.setError(error);
			}
			return obj;
		} catch (HttpException e) {
			e.printStackTrace();
		}
		return null;
	}
}

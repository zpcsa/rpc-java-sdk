package io.xdag.rpc;

import org.junit.Test;

import io.xdag.rpc.api.JsonRPCApi;
import io.xdag.rpc.model.Account;
import io.xdag.rpc.model.Balance;
import io.xdag.rpc.model.Result;
import io.xdag.rpc.model.Version;
import io.xdag.rpc.util.Json;

public class RPCTest
{

	@Test
	public void version() {
		Result<Version> result = JsonRPCApi.getInstance().version();
		System.out.println(Json.toJson(result));
		System.out.println(Json.toJson(result.getResult()));
	}
	
	@Test
	public void getAccount() {
		Result<Account> result = JsonRPCApi.getInstance().getAccount(5);
		System.out.println(Json.toJson(result));
	}
	
	@Test
	public void getBalance() {
		Result<Balance> result = JsonRPCApi.getInstance().getBalance("cosuYGn+Vjp1rxD0rnq7OI9xyBKETaCm");
		System.out.println(Json.toJson(result));
	}
	
}

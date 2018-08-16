package io.xdag.rpc;

import io.xdag.rpc.api.JsonRPCApi;
import io.xdag.rpc.model.ResultModel;
import io.xdag.rpc.model.ResultPageModel;
import io.xdag.rpc.model.Transaction;
import io.xdag.rpc.model.Version;
import io.xdag.rpc.util.Json;



public class App {
	public static void main(String[] args) {
//		ResultModel<Version> result = JsonRPCApi.getInstance().version();
		ResultPageModel<Transaction> result1 = JsonRPCApi.getInstance().getTransactions("cosuYGn+Vjp1rxD0rnq7OI9xyBKETaCm",0,15);
		System.out.println(Json.toJson(result1));
	}
}

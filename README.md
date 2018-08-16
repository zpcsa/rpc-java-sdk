

# Xdag RPC SDK for Java

The Xdag RPC SDK is based on xdag rpc api v1.0, sdk only supports APIs that call local nodes, more features to synchronize xdag rpc api updates

#### Install Instructions

##### Build From Source



#### Execution Environment

1.Running the xdag node,ip does not support modification, only supports local calls. To change the port, add "-rpc-port xxxx" to the xdag startup command and modify "defaultApiPort" in "io.xdag.rpc.config.Configuration" in the sdk source. "Attributes.
2.Compile with maven command.

    $ ./mvn install -Dmaven.test.skip=true
  
3.Run the project on the server of the xdag node.

#### 使用说明

Call rpc's version API

    ResultModel<Version> result = JsonRPCApi.getInstance().version();





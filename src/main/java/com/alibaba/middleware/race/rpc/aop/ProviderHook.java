package com.alibaba.middleware.race.rpc.aop;

import com.alibaba.middleware.race.rpc.model.RpcRequest;

/** 
 * @author mengchenfei
 * @time   2015��7��26�� ����3:50:41 
 */
public interface ProviderHook {
	 public void before(RpcRequest request);
	    public void after(RpcRequest request);
}

package com.alibaba.middleware.race.rpc.model;

import java.io.Serializable;
import java.lang.reflect.Method;

import com.alibaba.middleware.race.rpc.context.RpcContext;

/** 
 * @author mengchenfei
 * @time   2015年7月26日 下午3:40:10 
 */
public class RpcRequest implements Serializable{
	private Object proxy;
	private Method method;
	private Object[] args;
	private RpcContext rpcContext;
	public Object getProxy() {
		return proxy;
	}
	public void setProxy(Object proxy) {
		this.proxy = proxy;
	}
	public Method getMethod() {
		return method;
	}
	public void setMethod(Method method) {
		this.method = method;
	}
	public Object[] getArgs() {
		return args;
	}
	public void setArgs(Object[] args) {
		this.args = args;
	}
	public RpcContext getRpcContext() {
		return rpcContext;
	}
	public void setRpcContext(RpcContext rpcContext) {
		this.rpcContext = rpcContext;
	}
	
}

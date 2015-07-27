package com.alibaba.middleware.race.rpc.model;
/** 
 * @author mengchenfei
 * @time   2015年7月26日 下午3:40:23 
 */
public class RpcResponse {
		static private final long serialVersionUID = -4364536436151723421L;

	    private String errorMsg;

	    private Object appResponse;

	    public Object getAppResponse() {
	        return appResponse;
	    }

	    public String getErrorMsg() {
	        return errorMsg;
	    }

	    public boolean isError(){
	        return errorMsg == null ? false:true;
	    }
}

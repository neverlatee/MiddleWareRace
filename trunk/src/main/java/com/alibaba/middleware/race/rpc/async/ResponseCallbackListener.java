package com.alibaba.middleware.race.rpc.async;
/** 
 * @author mengchenfei
 * @time   2015年7月26日 下午3:52:19 
 */
public interface ResponseCallbackListener {
	void onResponse(Object response);
    void onTimeout();
    void onException(Exception e);
}

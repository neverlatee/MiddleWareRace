package com.alibaba.middleware.race.rpc.async;
/** 
 * @author mengchenfei
 * @time   2015��7��26�� ����3:52:19 
 */
public interface ResponseCallbackListener {
	void onResponse(Object response);
    void onTimeout();
    void onException(Exception e);
}

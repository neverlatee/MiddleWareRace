package com.alibaba.middleware.race.rpc.context;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/** 
 * @author mengchenfei
 * @time   2015年7月26日 下午1:15:28 
 */
public class RpcContext {
	 public static Map<String,Object> props = new HashMap<String, Object>();

	    public static void addProp(String key ,Object value){
	        props.put(key,value);
	    }

	    public static Object getProp(String key){
	        return props.get(key);
	    }

	    public static Map<String,Object> getProps(){
	       return Collections.unmodifiableMap(props);
	    }
}

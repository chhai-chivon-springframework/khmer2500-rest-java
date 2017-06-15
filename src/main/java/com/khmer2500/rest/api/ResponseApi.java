package com.khmer2500.rest.api;

import java.util.List;
import java.util.Map;

import com.khmer2500.rest.entities.Category;

public abstract class ResponseApi {
	
	public Map<String,Object> ResponseSuccess(Map<String, Object> map, List<Category> categories ){
		map.put("DATA", categories);
		map.put("STATUS", true);
		map.put("MESSAGE", "SUCCESS");
		return map;
	}
	
	public Map<String,Object> ResponseError(Map<String, Object> map, List<?> list){
		map.put("STATUS", false);
		map.put("MESSAGE", "FAIL");
		return map;
	}
}

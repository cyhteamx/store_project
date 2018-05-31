package com.store.utils;


import lombok.Data;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 查询参数
 */
@Data
public class Querybak extends LinkedHashMap<String, Object> {

	private static final long serialVersionUID = 1L;

	//当前页码
    private int page = 1;
    
    //每页条数
    private int limit = 10;

    public Querybak(int page, int limit) {
        HashMap params = new HashMap<String, Object>();
        params.put("page", page);
        params.put("limit", limit);
        this.putAll(params);
        this.page = page;
        this.limit = limit;
        this.remove("page");
        this.remove("limit");
    }

    public Querybak(Map<String, Object> params){
        this.putAll(params);
        //分页参数
        if(params.get("page")!=null) {
            this.page = Integer.parseInt(params.get("page").toString());
        }
        if(params.get("limit")!=null) {
            this.limit = Integer.parseInt(params.get("limit").toString());
        }
        this.remove("page");
        this.remove("limit");
    }

}

package com.scarfilun.domain.dao.impl;

import java.io.Serializable;

class QueryParam implements Serializable {
	
	private static final long serialVersionUID = 1L;
    String name;
    Object value;

    public QueryParam(String name, Object value){
        this.name = name;
        this.value = value;
    }
}

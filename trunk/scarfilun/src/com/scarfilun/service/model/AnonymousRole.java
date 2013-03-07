package com.scarfilun.service.model;

import org.springframework.stereotype.Component;

@Component("anonymousRole")
public class AnonymousRole extends Role{

	private static final long serialVersionUID = 1L;
	
    public AnonymousRole() {
        super("ANONYMOUS");
    }
}

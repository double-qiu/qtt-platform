package com.ufdouble.baseModule.service;

import com.kcfy.platform.server.kernal.service.ServiceContext;
import com.ufdouble.baseModule.model.BaseUser;

public interface BaseUserService {
	
	
	public void saveBaseUser(ServiceContext serviceContext, BaseUser baseUser);
	
	public void deleteBaseUserById(ServiceContext serviceContext,  String id);
	
	public void updateBaseUser(ServiceContext serviceContext, BaseUser baseUser);
	
	public BaseUser getBaseUserById(ServiceContext serviceContext, String id);
	
}

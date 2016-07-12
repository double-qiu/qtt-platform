package com.ufdouble.baseModule.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.kcfy.platform.server.kernal.service.ServiceContext;
import com.ufdouble.baseModule.model.BaseUser;
import com.ufdouble.baseModule.service.BaseUserService;

public class BaseUserServiceImpl implements BaseUserService {

	@Autowired
	private InternalBaseUserServiceImpl internalBaseUserServiceImpl;
	@Override
	public void saveBaseUser(ServiceContext serviceContext, BaseUser baseUser) {
		
		internalBaseUserServiceImpl.saveOnly(serviceContext, baseUser);
	}

	@Override
	public void deleteBaseUserById(ServiceContext serviceContext, String id) {
		internalBaseUserServiceImpl.delete(serviceContext, id);
	}

	@Override
	public void updateBaseUser(ServiceContext serviceContext, BaseUser baseUser) {
		internalBaseUserServiceImpl.updateOnly(serviceContext, baseUser);
	}

	@Override
	public BaseUser getBaseUserById(ServiceContext serviceContext, String id) {
		BaseUser baseUser=internalBaseUserServiceImpl.getById(serviceContext, id, BaseUser.class);
		return baseUser;
	}

}

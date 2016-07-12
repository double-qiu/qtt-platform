package com.ufdouble.baseModule.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kcfy.platform.server.kernal.repo.SingleEntityRepo;
import com.kcfy.platform.server.kernal.service.InternalServiceSupport;
import com.ufdouble.baseModule.model.BaseUser;
import com.ufdouble.baseModule.repo.BaseUserRepo;

@Service
public class InternalBaseUserServiceImpl extends InternalServiceSupport<BaseUser> {
	@Autowired
	private BaseUserRepo baseUserRepo;

	@Override
	public SingleEntityRepo<BaseUser, String> getRepo() {
		return baseUserRepo;
	}
}

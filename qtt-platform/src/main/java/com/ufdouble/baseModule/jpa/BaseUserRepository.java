package com.ufdouble.baseModule.jpa;

import com.kcfy.platform.server.kernal.springjpa.JSpringJpaRepository;
import com.ufdouble.baseModule.model.BaseUser;
import com.ufdouble.baseModule.repo.BaseUserRepo;

public interface BaseUserRepository extends  JSpringJpaRepository<BaseUser, String>, BaseUserRepo {

}

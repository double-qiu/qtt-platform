package com.ufdouble;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcfy.platform.server.kernal.model.SessionUser;
import com.kcfy.platform.server.kernal.service.ServiceContext;
import com.ufdouble.application.PlatformApplication;
import com.ufdouble.baseModule.controller.BaseUserController;
import com.ufdouble.baseModule.dto.BaseUserInVO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PlatformApplication.class)
public class BaseUserTest {

	@Autowired
	private BaseUserController baseUserController ;
	
	ServiceContext serviceContext=null;
    @Before
    public void before(){
        serviceContext=new ServiceContext();
        SessionUser sessionUser=new SessionUser();
        sessionUser.setId("SYS-TEST");
        sessionUser.setUserName("SYS-TEST");
        serviceContext.setUser(sessionUser);
    }
	@Test
	public void testJunit() {
		System.out.println("Junit Test......");
	}
	
	@Test
	public void saveBaseUser() {
		BaseUserInVO baseUser = new BaseUserInVO();
		baseUser.setName("double");
		baseUser.setAge(26);
		baseUser.setEmail("934590736@qq.com");
		baseUser.setPhone("13816117471");
		baseUser.setPassword("123456");
		baseUser.setSex("man");
		
		baseUserController.saveBaseUser(serviceContext, baseUser);
	}
	
}

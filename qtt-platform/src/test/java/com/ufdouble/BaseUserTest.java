package com.ufdouble;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcfy.platform.server.kernal.Copy;
import com.kcfy.platform.server.kernal.model.InvokeResult;
import com.kcfy.platform.server.kernal.model.SessionUser;
import com.kcfy.platform.server.kernal.service.ServiceContext;
import com.ufdouble.application.PlatformApplication;
import com.ufdouble.baseModule.controller.BaseUserController;
import com.ufdouble.baseModule.dto.BaseUserInVO;
import com.ufdouble.baseModule.dto.BaseUserUpdateVO;
import com.ufdouble.baseModule.model.BaseUser;
import com.ufdouble.baseModule.service.BaseUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PlatformApplication.class)
public class BaseUserTest {

	
	@Autowired
	private BaseUserController baseUserController ;
	@Autowired
	private BaseUserService baseUserService;
	
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
		BaseUserInVO baseUserInVO = new BaseUserInVO();
		baseUserInVO.setName("double");
		baseUserInVO.setAge(26);
		baseUserInVO.setEmail("934590736@qq.com");
		baseUserInVO.setPhone("13816117471");
		baseUserInVO.setPassword("123456");
		baseUserInVO.setSex("man");
		
		baseUserController.saveBaseUser(serviceContext, baseUserInVO);
	}
	
	@Test
	public void updateBaseUser() {
		BaseUser baseUser = baseUserService.getBaseUserById(serviceContext, "92f2f6da-a9f2-418a-8e43-905a9816fbdd");
		BaseUserUpdateVO baseUserUpdateVO = new BaseUserUpdateVO();
		baseUserUpdateVO = Copy.simpleCopy(baseUser, BaseUserUpdateVO.class);
		
		baseUserUpdateVO.setName("ufdouble");
		baseUserUpdateVO.setAge(29);
		baseUserUpdateVO.setEmail("934590736@qq.com");
		baseUserUpdateVO.setPhone("13816117471");
		baseUserUpdateVO.setPassword("123321");
		baseUserUpdateVO.setSex("man");
		
		baseUserController.updateBaseUser(serviceContext, baseUserUpdateVO);
	}
	
	@Test
	public void deleteBaseUser() {
		baseUserController.deleteBaseUserById(serviceContext, "92f2f6da-a9f2-418a-8e43-905a9816fbdd");
	}
	@Test
	public void getBaseUserById() {
		
		InvokeResult	result =baseUserController.getBaseUserById(serviceContext, "92f2f6da-a9f2-418a-8e43-905a9816fbdd");
		
		System.out.println(result.getData());
	}
	
}

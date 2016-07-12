package com.ufdouble.baseModule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kcfy.platform.server.kernal.Copy;
import com.kcfy.platform.server.kernal.mapping.ControllerSupport;
import com.kcfy.platform.server.kernal.model.InvokeResult;
import com.kcfy.platform.server.kernal.service.ServiceContext;
import com.ufdouble.baseModule.dto.BaseUserInVO;
import com.ufdouble.baseModule.dto.BaseUserOutVO;
import com.ufdouble.baseModule.dto.BaseUserUpdateVO;
import com.ufdouble.baseModule.model.BaseUser;
import com.ufdouble.baseModule.service.BaseUserService;

@Controller
@RequestMapping("/baseUser")
public class BaseUserController extends ControllerSupport {
	
	
	@Autowired
	private  BaseUserService baseUserService;
	
	@ResponseBody
	@RequestMapping("/saveBaseUser")
	public InvokeResult saveBaseUser(ServiceContext serviceContext, BaseUserInVO baseUserInVO) {
		try {
			BaseUser baseUser = Copy.simpleCopy(baseUserInVO, BaseUser.class);
			baseUserService.saveBaseUser(serviceContext, baseUser);
			return InvokeResult.success(baseUser.getId());
		} catch (Exception e) {
			return InvokeResult.failure("保存失败");
		}
	}
	
	@ResponseBody
	@RequestMapping("/updateBaseUser")
	public InvokeResult updateBaseUser(ServiceContext serviceContext, BaseUserUpdateVO baseUserUpdateVO) {
		try {
			BaseUser baseUser = baseUserService.getBaseUserById(serviceContext, baseUserUpdateVO.getId());
			Copy.simpleCopyExcludeNull(baseUserUpdateVO, baseUser);
			baseUserService.updateBaseUser(serviceContext, baseUser);
			return InvokeResult.success(baseUser.getId());
		} catch (Exception e) {
			return InvokeResult.failure("更新失败");
		}

	}
	
	@ResponseBody
	@RequestMapping("/deleteBaseUserById")
	public InvokeResult deleteBaseUserById(ServiceContext serviceContext, String id) {
		try {
			baseUserService.deleteBaseUserById(serviceContext, id);
			return InvokeResult.success(true);
		} catch (Exception e) {
			return InvokeResult.failure("删除失败");
		}
	}
	@ResponseBody
	@RequestMapping("/getBaseUserById")
	public InvokeResult getBaseUserById(ServiceContext serviceContext, String id) {
		try {
			BaseUser baseUser = baseUserService.getBaseUserById(serviceContext, id);
			BaseUserOutVO baseUserOutVO = null;
			if (baseUser != null) {
				baseUserOutVO = Copy.simpleCopy(baseUser, BaseUserOutVO.class);
			}
			return InvokeResult.success(baseUserOutVO);
		} catch (Exception e) {
			return InvokeResult.failure("查询失败");
		}
	}
}

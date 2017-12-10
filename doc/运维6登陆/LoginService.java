package com.founder.service.login;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.easymap.cops.tools.EzManagerTool;
import com.easymap.management.entity.Function;
import com.easymap.management.newapi.FunctionManager;
import com.easymap.management.user.User;
import com.easymap.management.user.UserManager;
import com.founder.service.config.ConfigService;
import com.founder.service.log.LogDao;
import com.founder.util.PropertyUtil;

@SuppressWarnings("unchecked")
@Service
public class LoginService {
	//log4j日志
	Logger logger = Logger.getLogger(LoginService.class.getName());
	
	/*数据库连接类*/
	@Resource
	private LoginDao loginDao;

	/**
	 * 用户登陆
	 */
	@SuppressWarnings("deprecation")
	public Map UserLogin(Map param) {
		Map remap = new HashMap();
		//参数
		String userId = (String)param.get("userId");
		String password = (String)param.get("password");
		//运维地址
		String EzManagerUrl = PropertyUtil.getPropertyValue("ezManagerLocation");
		//系统名称
		String systemname = PropertyUtil.getPropertyValue("systemname");
		
		try {
			UserManager userManager = new UserManager(EzManagerUrl);
			boolean flag = userManager.validUser(userId, password);
			if(flag){
				//登陆成功
				//获取用户权限和基本信息
				remap = getUserAuth(userManager,userId,systemname,EzManagerUrl);
				
			}else{
				remap.put("code", "EC01");
				remap.put("msg" , "用户名或密码错误!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			remap.put("code", "EC02");
			remap.put("msg" , "网络存在异常!");
		}
		
		return remap;
	}
	/**
	 * 查询授权 运维V6
	 * @param userManager
	 * @param userId
	 * @param cj_systemname
	 * @param gl_systemname
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private Map getUserAuth(UserManager userManager,String userId,String systemname,String EzManagerUrl){
		Map remap = new HashMap();
		try{
			Map auth = new HashMap();
			//系统授权
			boolean xt_auth = userManager.hasFunctionPrivilege(userId, systemname);
			auth.put("system_auth", xt_auth);
			if(!xt_auth){
				remap.put("code", "EC03");
				remap.put("msg", "登录失败，您没有权限登录本系统！");
				return remap;
			}
			//获取模块权限
			FunctionManager functionManager = new FunctionManager(EzManagerUrl);
			List<Function> functionList = functionManager.getFunctionByUserId(userId);
			
			//获取用户信息
			User user = userManager.getUser(userId);
			remap.put("code", "EC00");
			remap.put("msg", "登录成功！");
			remap.put("user", user);
			remap.put("function_auth", functionList);
			return remap;
		}catch(Exception e){
			e.printStackTrace();
			remap.put("code", "EC03");
			remap.put("msg", "登录失败，您没有权限登录本系统！");
			return remap;
		}
	}

	/**
	 * 用户登陆
	 */
	@SuppressWarnings("deprecation")
	public Map UserLoginDb(Map param) {		
		Map remap = new HashMap();
		//验证用户
		Map info = this.loginDao.UserLoginDb(param);

		if(info==null || "".equals(info.get("USERNAME"))){
			remap.put("code", "EC04");
			remap.put("msg", "登录失败，用户名/密码错误！");
		}else{
			remap.put("code", "EC00");
			remap.put("msg", "登陆成功！");
			remap.put("user", param.get("userId"));
			remap.put("auth", param.get("password"));
		}
		
		return remap;
	}
	
	

}

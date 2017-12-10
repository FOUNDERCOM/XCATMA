package com.founder.service.login;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.easymap.management.user.User;
import com.founder.service.BaseAction;
import com.founder.service.config.ConfigService;
import com.founder.util.PropertyUtil;

/**
 * 登录模块
 * @author Administrator
 *
 */
@SuppressWarnings("unchecked")
@Controller("LoginAction")
//@RequestMapping("/login.do")
public class LoginAction extends BaseAction{
	/*服务实现类*/
	@Resource
	private LoginService loginService;

	/**
	 * 用户登陆
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(params = "method=UserLogin")
	public ModelAndView UserLogin(HttpServletRequest req, HttpServletResponse res) {
		//页面参数
		Map<String, String> param  = this.getParameterMap(req);
		//设置登陆超时时间30分钟
		Long sessionTimeout = 1000*60*30L;
		//获取数据
		Map dataMap = this.loginService.UserLogin(param);
		if("EC00".equals(dataMap.get("code"))){
			HttpSession session = req.getSession(true);
			//设置用户未活动超时时间为30分钟
			session.setMaxInactiveInterval(sessionTimeout.intValue());
			//将用户基本信息和权限写入session
			session.setAttribute("user", dataMap.get("user"));
			session.setAttribute("auth", dataMap.get("auth"));
			//dataMap.remove("user");
		}

		// 写回客户端
		this.WriteJsonObjToPage(dataMap, res);

		// 返回
		return null;
	}
	
	//用户登陆
	@RequestMapping(params = "method=UserLoginDb")
	public ModelAndView UserLoginDb(HttpServletRequest req, HttpServletResponse res) {
		//页面参数
		Map<String, String> param  = this.getParameterMap(req);
		//添加日志参数，aop自动记录日志
		param.put("log_userid", param.get("userId"));
		param.put("log_usemoudle", "登录");
		param.put("log_remark", "登录系统");
		
		Long sessionTimeout = 0L;
		//是否验证用户登录
		/*String sessionTimeoutS = ConfigService.GetConfigInfo("sessionTimeout");
		String isCheckUser = ConfigService.GetConfigInfo("isCheckUser");
		if(sessionTimeout!=null && !"".equals(sessionTimeout)){
			try{
				sessionTimeout = Long.parseLong(sessionTimeoutS);
				if(sessionTimeout<1000*60*5 || sessionTimeout>1000*60*60){
					sessionTimeout = 1000*60*30L;
				}
			}catch(Exception e){}
		}*/
		//获取数据
		Map dataMap = this.loginService.UserLoginDb(param);
		if("EC00".equals(dataMap.get("code"))){
			HttpSession session = req.getSession(true);
			session.setAttribute("user", dataMap.get("user"));
			session.setAttribute("auth", dataMap.get("auth"));
			System.out.println("登陆dataMap:"+dataMap+"登陆session:"+session.getAttribute("user"));
			dataMap.remove("user");
			
		}

		// 写回客户端
		this.WriteJsonObjToPage(dataMap, res);

		// 返回
		return null;
	}
	
	/**
	 * 用户退出
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(params = "method=UserLogout")
	public ModelAndView UserLogout(HttpServletRequest req, HttpServletResponse res) {
		//获取数据
		HttpSession session = req.getSession(true);
		if(session.getAttribute("user")!=null){
			session.setAttribute("user",null);
		}
		
		//返回登录界面
		ModelAndView view = new ModelAndView("");

		// 返回
		return view;
	}
	
	/**
	 * 获取登录用户
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(params = "method=GetLoginUser")
	public ModelAndView GetLoginUser(HttpServletRequest req, HttpServletResponse res) {
		//获取用户信息
		HttpSession session = req.getSession(true);
		Map dataMap = new HashMap();
		if(session.getAttribute("user")!=null){
			dataMap.put("user", session.getAttribute("user"));
			dataMap.put("auth", session.getAttribute("auth"));
			dataMap.put("code", "EC00");
			dataMap.put("msg", "操作成功！");
		}else{
			dataMap.put("code", "EC01");
			dataMap.put("msg", "登录用户超时，请重新登录！");
		}
		
		// 写回客户端
		this.WriteJsonObjToPage(dataMap, res);

		// 返回
		return null;
	}
	
}

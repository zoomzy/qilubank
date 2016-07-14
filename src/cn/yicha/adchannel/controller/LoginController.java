package cn.yicha.adchannel.controller;

import cn.yicha.adchannel.service.LoginService;

import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;

/** 
 * @TODO   登录相关controller
 * @author yicha
 * @date   2015年10月20日 
 */
public class LoginController extends Controller {

	private LoginService loginService = LoginService.getInstance();
	/**
	 * 登陆页
	 */
	@Clear
	public void index(){
		render("/html/login.html");
	}
	/**
	 * 登录验证
	 */
	@Clear
	public void loginValidate(){
		String userName = getPara("username");
		String password = getPara("userpass");
		
		boolean result = loginService.loginValidate(userName, password);
		
		if(result){
			setSessionAttr("ad_channel_user", userName);
			renderText("success");
		}else{
			renderText("fail");
		}
	}
}

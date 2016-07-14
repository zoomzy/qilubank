package cn.yicha.adchannel.service;

import cn.yicha.adchannel.dao.SysUserDao;

/** 
 * @TODO
 * @author yicha
 * @date   2015年10月20日 
 */
public class LoginService {

	private SysUserDao sysUserDao = SysUserDao.getInstance();
	
	private static LoginService instance = null;
	
	private LoginService(){}
	
	/**
	 * 实现单例模式
	 * @return
	 */
	public static LoginService getInstance(){
		if(instance == null){
			return new LoginService();
		}
		return instance;
	}
	
	/**
	 * 判断是否为合法用户
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean loginValidate(String userName, String password){
		return sysUserDao.loginValidate(userName, password);
	}
}

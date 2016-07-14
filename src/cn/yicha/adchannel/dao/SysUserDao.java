package cn.yicha.adchannel.dao;

import cn.yicha.adchannel.model.SysUser;

/**
 * @TODO
 * @author yicha
 * @date 2015年10月21日
 */
public class SysUserDao {
	
	private static final String TABLE_NAME = "sys_user"; 

	private static final SysUserDao instance = null;

	private SysUserDao() {
	}

	public static SysUserDao getInstance() {
		if (instance == null) {
			return new SysUserDao();
		}
		return instance;
	}
	
	/**
	 * 判断用户是否为合法用户
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean loginValidate(String userName, String password){
		SysUser sysUser = SysUser.dao.findFirst("select * from " + TABLE_NAME + " where user_name=? and user_pass=?", userName, password);
		if(sysUser != null){
			return true;
		}else{
			return false;
		}
	}
}

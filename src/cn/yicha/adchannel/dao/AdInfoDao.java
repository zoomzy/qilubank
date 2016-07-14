package cn.yicha.adchannel.dao;

import java.util.List;

import cn.yicha.adchannel.model.AdInfo;

/**
 * @TODO
 * @author yicha
 * @date 2015年10月21日
 */
public class AdInfoDao {

	private static final String TABLE_NAME = "ad_info";
	
	private static AdInfoDao instance = null;

	private AdInfoDao() {

	}

	public static AdInfoDao getInstance() {
		if (instance == null) {
			return new AdInfoDao();
		}
		return instance;
	}
	
	/**
	 * 所有的第三方广告信息
	 * @return
	 */
	public List<AdInfo> getAllAdInfo(){
		return AdInfo.dao.find("select * from " + TABLE_NAME);
	}
}

package cn.yicha.adchannel.service;

import java.util.List;

import cn.yicha.adchannel.dao.AdInfoDao;
import cn.yicha.adchannel.model.AdInfo;

/**
 * @TODO
 * @author yicha
 * @date 2015年10月21日
 */
public class AdInfoService {

	private AdInfoDao adInfoDao = AdInfoDao.getInstance();
	
	private static AdInfoService instance = null;

	private AdInfoService() {

	}

	public static AdInfoService getInstance() {
		if (instance == null) {
			return new AdInfoService();
		}
		return instance;
	}
	
	/**
	 * 获取所有广告信息
	 * @return
	 */
	public List<AdInfo> getAllAdInfos(){
		
		return adInfoDao.getAllAdInfo();
	}
	
}

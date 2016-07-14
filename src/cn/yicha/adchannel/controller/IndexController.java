package cn.yicha.adchannel.controller;

import java.util.List;
import cn.yicha.adchannel.model.AdInfo;
import cn.yicha.adchannel.service.AdInfoService;
import com.jfinal.core.Controller;

/**
 * @TODO
 * @author yicha
 * @date 2015年10月20日
 */
public class IndexController extends Controller {

	private AdInfoService adInfoService = AdInfoService.getInstance();

	public void index() {
		List<AdInfo> adInfos = adInfoService.getAllAdInfos();
		setAttr("adinfos", adInfos);
		render("/html/index.html");
	}
}

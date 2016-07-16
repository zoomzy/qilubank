package cn.yicha.adchannel.controller;

import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;

import cn.yicha.adchannel.service.OperateService;
/**
 * @TODO   增删查改相关的功能
 * @author lixiaowen
 * 
 */
public class OperateController extends Controller {
	
	private OperateService operateService = OperateService.getInstance();
	/**
	 * 接收查询5张表的请求
	 * tableId=>1:module,2:program,3:item,4:document,5:picture
	 */
	public void select(){
		Integer tableId = Integer.parseInt(getPara("tableId"));
		renderJson(operateService.select(tableId));
	}
	/**
	 * 搜索框的模糊查询
	 */
	@Clear
	public void selectDoc(){
		String key = getPara("key");
		renderJson(operateService.selectDoc(key));
	}
}

package cn.yicha.adchannel.controller;

import com.jfinal.core.Controller;

/**
 * 
 * @author zhangcc
 *
 */
public class IndexController extends Controller {


	public void index() {
		render("/html/index.html");
	}
}

package com.zyf.springMVC.mvcdevflow;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * spring mvc 开发流程简单例子
 */
@Controller
@RequestMapping("/mvcdevflow") // 1.定义请求分发-1
public class MvcDevFlowController {

	@RequestMapping("/mdf1") // 1.定义请求分发-2
	public ModelAndView mvc1(
			@RequestParam int id, // 2.接受请求参数
			@RequestParam(value = "name", required = false) String userName) {
		
		ModelAndView modelAndView = new ModelAndView();

		// 3.处理业务数据
		User user = new User();
		user.setId(id);
		user.setName(userName == null ? "无名氏" : userName);
		
		// 4.绑定数据模型和视图
		modelAndView.addObject("userModel", user);
		modelAndView.setViewName("mvcdevflow/mdf1");
		return modelAndView;
	}
}
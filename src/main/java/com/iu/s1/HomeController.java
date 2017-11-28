package com.iu.s1;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */

/*
 *controller
 *순수한 자바 클래스를 생성
 *class 선언부에 @Controller annotation추가
 *class 선언부에 @RequestMapping annotation 추가(옵션)
 *일반 멤버 메서드 선언
 *메서드 선언부 위에 @RequestMapping annotation 추가
 *value: 요청 URI
 *method: get방식과 post방식 둘다 일때는 {,}로 이은다.
 *
 *메석드의 리턴타입
 *String : view의 경로
 *void : 요청 URI 자체가 view의 경로
 * */

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

}

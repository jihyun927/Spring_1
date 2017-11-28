package com.iu.s1;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
		
		/*-----value값의 주소가 들어올 시 해당 메소드 실행-----*/
		@RequestMapping(value="/notice/noticeList")
		public String go(HttpServletRequest request){
			String name=request.getParameter("name");
			System.out.println("name : "+name);
			return "notice/noticeList";
		}
		
		@RequestMapping(value="/notice/noticeView")
		public String view(){
			return "notice/noticeView";
		}
	
}

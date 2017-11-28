package com.iu.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iu.qna.QnaDTO;

@Controller
@RequestMapping(value="/qna/*")
public class QnaController {
	
	@RequestMapping(value="qnaList", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView list(ModelAndView modelAndView,  @RequestParam(defaultValue="0", required=false)int curPage){
		QnaDTO qnaDTO=new QnaDTO();
		
		qnaDTO.setTitle("test");
		qnaDTO.setWriter("jihyun");
		qnaDTO.setAge(23);
		modelAndView.addObject("list", qnaDTO);
		modelAndView.setViewName("qna/qnaList");
		
		System.out.println("curPage"+curPage);
		
		return modelAndView;
	}
	
	@RequestMapping(value="qnaView")
	public String view(Model model){
		QnaDTO qnaDTO=new QnaDTO();
		
		qnaDTO.setTitle("test");
		qnaDTO.setWriter("choa");
		qnaDTO.setAge(29);
		model.addAttribute("view", qnaDTO).addAttribute("baord", "QnA");
		
		return "qna/qnaView";
	}
	
	/*리턴 타입이 void일 경우 value값이 요청 URI가 된다.*/
	@RequestMapping(value="qnaWrite", method=RequestMethod.GET)
	public void write(){}
	
	/*리턴 타입이 void일 경우 value값이 요청 URI가 된다.*/
	@RequestMapping(value="qnaWrite", method=RequestMethod.POST)
	public String write(QnaDTO qnaDTO, String title){
		
		System.out.println(qnaDTO.getTitle());
		System.out.println("title:"+title);
		System.out.println(qnaDTO.getWriter());
		System.out.println(qnaDTO.getAge());
		
		for(String s : qnaDTO.getName()){
			System.out.println(s);
		}
		
		return "redirect:./qnaList";
	}
	
/*	
 * <파라미터 처리>
 * 1번째 방식) 매서드의 매개변수로 HttpServletRequest선언(내장객체 사용)
 * @RequestMapping(value="qnaWrite", method=RequestMethod.POST)
	public String write(HttpServletRequest request){
		String title=request.getParameter("title");
		String writer=request.getParameter("writer");
		int age=Integer.parseInt(request.getParameter("age"));
		
		System.out.println("TITLE : "+title);
		System.out.println("WRITER : "+writer);
		System.out.println("AGE : "+age);
		
		return "qna/qnaList";
	}
	*
	*
	*2번째 방식)파라미터랑 동일한 타입과 변수명 선언
	*@RequestMapping(value="qnaWrite", method=RequestMethod.POST)
		public String write(String title, String writer, int age){
		System.out.println(title);
		System.out.println(writer);
		System.out.println(age);
		return "qna/qnaList";
	}
	
	@RequestMapping(value="qnaWrite", method=RequestMethod.POST)
	public String write(String title, String writer, int age, String[] name){
		for(String s : name){
			System.out.println(s);
		}
		System.out.println(title);
		System.out.println(writer);
		System.out.println(age);
		return "qna/qnaList";
	}
	*
	*파라미터의 이름이 다를때는 
	*@RequestParam(value="파라미터 이름") 데이터 티입 매핑할 변수명 으로 작성한다.
	*
	*3번째 방식)DTO선언(단, 파라미터의 name과 DTO의 멤버변수의 name이 같아야 함)
	*
	*
	*<서버에서 클라이언트로 데이터 전송>
	*1.매개변수로 HttpServletRequest 선언 request.setAttribute
	*@RequestMapping(value="qnaView")
		public String view(HttpServletRequest request){
		QnaDTO qnaDTO=new QnaDTO();
		qnaDTO.setTitle("test");
		qnaDTO.setWriter("iu");
		qnaDTO.setAge(25);
		
		request.setAttribute("view", qnaDTO);
		return "qna/qnaView";
	}
	*
	*2.매개변수로 Model 선언
	*model.addAttribute("key","value")값으로 넣어 보낸다.
	*--model의 생명주기는 request와 거의 같음.
	*Model의 메서드 체이닝
	*@RequestMapping(value="qnaView")
		public String view(Model model){
		QnaDTO qnaDTO=new QnaDTO();
		qnaDTO.setTitle("test");
		qnaDTO.setWriter("choa");
		qnaDTO.setAge(29);
		--체이닝
		model.addAttribute("view", qnaDTO).addAttribute("baord", "QnA");
		
		return "qna/qnaView";
	}
	*
	*3.매개변수로 ModelandView 선언
	*Model+View 
	*매서드에서 리턴을 ModelandView로 리턴
	*@RequestMapping(value="qnaList", method={RequestMethod.GET, RequestMethod.POST})
		public ModelAndView list(ModelAndView modelAndView){
		QnaDTO qnaDTO=new QnaDTO();
		
		qnaDTO.setTitle("test");
		qnaDTO.setWriter("jihyun");
		qnaDTO.setAge(23);
		modelAndView.addObject("list", qnaDTO);
		modelAndView.setViewName("qna/qnaList");
		
		return modelAndView;
	}
	--view page로 redirect
	
	--파라미터가 넘어 오지 않을 경우 처리
	@RequestParam(defaultValue="기본값", required=false)
	false는 필수가 아님을 뜻함, true는 필수
	
	**/
	
}

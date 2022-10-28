package com.care.quiz.membership;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.quiz.membership.dto.LoginDTO;
import com.care.quiz.membership.dto.MemberDTO;
import com.care.quiz.membership.dto.PostcodeDTO;
import com.care.quiz.membership.service.IMemberService;
import com.care.quiz.membership.service.MailService;

@Controller
public class MemberController {
	@Autowired IMemberService service;
	@Autowired HttpSession session;
	
	@RequestMapping("index")
	public String index(Model model, String formpath) {
		if(formpath == null)
			return "index";
		else if(formpath.equals("memberList")) {
			model.addAttribute("members", service.memberList());
			return "index";
		}
		return "index";
	}
	
	@ResponseBody
	@PostMapping(value = "isExistId", produces = "text/html; charset=UTF-8")
	public String isExistId(@RequestBody(required = false) String id) {
		return service.isExistId(id);
	}
	
	@RequestMapping(value = "memberProc", produces = "text/html; charset=UTF-8")
	public String memberProc(MemberDTO member, PostcodeDTO post, RedirectAttributes ra) {
		
		// 입력한 데이터를 안 지워주기 위함
		session.setAttribute("member", member);
		session.setAttribute("post", post);
		
		// service의 memberProc 메서드 호출해서 문자열 반환
		String result = service.memberProc(member, post);
		// result가 가입 완료가 아니라면
		if(result.equals("가입 완료") == false) {
			ra.addFlashAttribute("Msg", result);
			return "redirect:index?formpath=member";
		} 
		else {
			ra.addFlashAttribute("Msg", result);
			// 가입 완료하면 회원가입 관련 session을 지워주기 위한 invalidate
			session.invalidate();
			return "redirect:index?formpath=member";
		}
	}
	
	@RequestMapping(value = "loginProc", produces = "text/html; charset=UTF-8")
	public String loginProc(LoginDTO login, RedirectAttributes ra) {
		// service의 login 메서드를 호출하고 반환받은 문자열을 result 변수에 저장
		String result = service.loginProc(login);
		
		// 로그인 실패 시 반환받은 문자열을 반환
		if(result.equals("로그인 완료")) {
			ra.addFlashAttribute("Msg", result);
			return "redirect:index";
		}
		ra.addFlashAttribute("Msg", result);
		ra.addFlashAttribute("id", login.getId());
		return "redirect:index?formpath=login";
	}
	
	@GetMapping("logout")
	public String logout(RedirectAttributes ra) {
		// session 제거
		session.invalidate();
		ra.addFlashAttribute("Msg", "로그아웃");
		return "redirect:index";
	}
	
	@Autowired private MailService mailService;
	@ResponseBody
	@PostMapping(value="sendAuth", produces="text/html; charset=UTF-8")
	public String sendAuth(@RequestBody(required = false) String email) {
		if(email == null) {
			return "이메일을 입력해주세요.";
		}
		// Math.random() : 0~1사이의 실수를 생성(대략 소숫점 16자리까지)
		double n = Math.random();
		// 생성된 랜덤 실수를 substring으로 2번째 인덱스부터 8번째 인덱스 전까지 추출해서 문자열로 형변환
		String randomNum = Double.toString(n).substring(2,8);
		// 인증번호는 사용자별 정보이기에 session에 꼭 저장해야함.
		session.setAttribute("randomNum", randomNum);
		System.out.println("randomNum : " + randomNum);
		mailService.sendMail(email, "[인증번호]", randomNum);
		return "인증번호를 이메일로 전송했습니다.";
	}
	
	@ResponseBody
	@PostMapping(value="checkAuth", produces="text/html; charset=UTF-8")
	public String checkAuth(@RequestBody(required = false) String inputNum) {
		String sessionNum = (String)session.getAttribute("randomNum");
		
		session.setAttribute("authStatus", false);
		if(sessionNum == null)
			return "인증번호를 생성하세요.";
		if(inputNum == null)
			return "인증번호를 입력하세요 ";
		if(inputNum.equals(sessionNum)) {
			session.setAttribute("authStatus", true); // 인증 체크용 session
			return "인증 성공";
		}
		
		return "인증 실패";
	}
	
	
	
	
	
	
	
}

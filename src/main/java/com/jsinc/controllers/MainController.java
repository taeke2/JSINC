package com.jsinc.controllers;

import java.io.File;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jsinc.jsincDTO.MemberDTO;
import com.jsinc.services.main.ComponentService;
import com.jsinc.services.main.LoginService;
import com.jsinc.services.main.MailService;
import com.jsinc.services.main.MemberServiceImpl;
import com.jsinc.services.main.RecentServiceImpl;
import com.jsinc.services.main.ResentSurveyService;
import com.jsinc.services.main.ServiceIf;
import com.jsinc.services.message.MsgAlarmServiceImpl;
import com.jsinc.services.message.ServiceMes;
import com.jsinc.services.profile.PasswordChangeService;
import com.jsinc.services.profile.ProfileEditServiceImpl;
import com.jsinc.services.profile.ProfileService;
import com.jsinc.services.profile.ProfileValueServiceImpl;

// 메인 페이지 Controller
@Controller
public class MainController {
	ApplicationContext ac = App.ac;
	static String vali;
	private ServiceIf service;

	@Autowired
	MailService mailService;
	ServiceMes msgService;
	ComponentService comService;
	// by재만_파일 업로드 경로 설정_20200525
	@Resource(name = "uploadPath") // 업로드 경로 (출처 : servlet-context)
	private String uploadPath;

	// by성택_사원 로그인 ID,PW 확인_20200520
	@RequestMapping("loginChk")
	public String loginChk(Model model, HttpServletRequest request) throws Exception {
		model.addAttribute("request", request);
		service = ac.getBean("loginService", LoginService.class);
		int result = service.execute(model);
		// 메세지 알람 수 표시
		if (result == 0) {
			msgService = ac.getBean("msgAlarmServiceImpl", MsgAlarmServiceImpl.class);
			model.addAttribute("request", request);
			msgService.execute(model);
			return "redirect:index";
		}
		return "home";
	}

	// by성택_메인 페이지 나타내기_20200520
	@RequestMapping("index")
	public String index(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		// by성택_최근 등록된 설문 리스트_20200616 추가
		comService = ac.getBean("resentSurveyService", ResentSurveyService.class);
		comService.execute(model);

		// by해준_안읽은 메세지 리스트_20200616 추가
		msgService = ac.getBean("recentServiceImpl", RecentServiceImpl.class);
		msgService.execute(model);

		return "index";
	}

	// by성택_로그아웃_20200522
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		ServletContext application = session.getServletContext();
		application.removeAttribute("user"); // 로그인 유저 정보 삭제
		application.removeAttribute("start"); // 출근 시간 삭제
		application.removeAttribute("end"); // 퇴근 시간 삭제
		return "home";	// 로그인 페이지로 이동
	}

	// by해준_회원가입 페이지_20200520
	@RequestMapping("join")
	public String view() {
		return "join";
	}
	
	// by해준_회원가입시 이메일 인증번호 전송_20200529
	@RequestMapping("doSend")
	@ResponseBody
	public String doSend(String email, String title, String body, HttpServletRequest req) {
		title = "JSInc. 회원가입 인증 코드 발급 안내 입니다.";
		email = req.getParameter("userEmail");
		body = "귀하의 인증 코드는" + vali + " 입니다.";
		
		char[] charSet = { '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'e', 'F', 'G', 'h', 'I',
				'j', 'K', 'L', 'm', 'O', 'p', 'Q', 'r', 'S', 't' };
		
		// 랜덤 인증번호 생성
		StringBuffer newKey = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			int idx = (int) (charSet.length * Math.random());
			newKey.append(charSet[idx]);
		}
		this.vali = newKey.toString();
		System.out.println("사용자 이메일:" + email);
		System.out.println("인증코드:" + vali);
		title = "JSInc. 회원가입 인증 코드 발급 안내 입니다.";
		body = "";
		body += "<div align='center' style='border:1px solid black;' font-family:verdana'>";
		body += "<h3 style='color:blue;'>귀하의 인증코드 입니다. </h3>";
		body += "<p>인증코드: <strong>" + vali + "</strong></p></div>";
		
		Map<String, Object> sendRs = mailService.send(email, title, body);
		return (String) sendRs.get("msg");
	}

	// by해준_인증번호 일치여부 확인_20200530
	@RequestMapping(value = "chkEmail", produces = "application/text;charset=utf8")
	@ResponseBody
	public String chkEmail(HttpServletRequest req) {
		String chkNum = (String) req.getParameter("chkNum");
		System.out.println("입력한 인증번호" + chkNum);
		System.out.println("인증번호=======" + vali);
		if (vali.equals(chkNum)) {
			return 0 + "";
		} else if (chkNum.equals("")) {
			return 1 + "";
		} else {
			return 2 + "";
		}
	}
	
	// by해준_사원번호 중복확인_20200601
	@RequestMapping(value = "empNoChk", produces = "application/text;charset=utf8")
	@ResponseBody
	public String empNoChk(MemberDTO dto) throws Exception {
		service = ac.getBean("memberServiceImpl", MemberServiceImpl.class);
		System.out.println(dto.getEmpNo());
		int result = service.empNoChk(dto);
		System.out.println("result: " + result);
		return result + "";
	}
	
	// by해준_이메일 중복확인_20200601
	@RequestMapping(value = "userEmailChk", produces = "application/text;charset=utf8")
	@ResponseBody
	public String userEmailChk(HttpServletRequest req) throws Exception {
		String userEmail = (String) req.getParameter("userEmail");
		System.out.println("controller:" + userEmail);
		service = ac.getBean("memberServiceImpl", MemberServiceImpl.class);
		int result = service.userEmailChk(userEmail);
		System.out.println("result:" + result);
		return result + "";
	}
	
	// by재만_사진 업로드_20200608
	@RequestMapping("registerMem")
	public String registerMem(MemberDTO dto, Model model, MultipartFile profile) throws Exception {
		// 업로드
		UUID uuid = UUID.randomUUID(); // 파일 이름 중복 방지
		String saveName = uuid + "_" + profile.getOriginalFilename(); // UUID가 붙은 파일이름을 객체에 저장
		File saveFile = new File(uploadPath + File.separator + "img" + File.separator + "profile", saveName);// 저장할 폴더 , 이름, 저장할 파일 이름
		try {
			profile.transferTo(saveFile); // 업로드 파일에 saveFile이라는 껍데기 입히기
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		dto.setImg(File.separator + "profile" + File.separator + saveName);

		service = ac.getBean("memberServiceImpl", MemberServiceImpl.class);
		model.addAttribute("dto", dto);
		service.execute(model);

		return "home";
	}
	
	// by해준_비밀번호 초기화_20200604
	@RequestMapping("lostPw")
	@ResponseBody
	public String lostPw(MemberDTO dto) throws Exception {
		int result = 0;
		char[] charSet = { '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'e', 'F', 'G', 'h', 'I',
				'j', 'K', 'L', 'm', 'O', 'p', 'Q', 'r', 'S', 't' };
		
		// 임시 비밀번호 생성
		StringBuffer newKey = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			int idx = (int) (charSet.length * Math.random());
			newKey.append(charSet[idx]);
		}
		String sentpw = newKey.toString();
		dto.setPassword(sentpw);
		System.out.println("사용자 이메일:" + dto.getUserEmail());
		System.out.println("임시 비밀번호:" + dto.getPassword());
		String title = "JSInc. 임시 비밀번호 발급 안내 입니다.";
		String body = "";
		body += "<div align='center' style='border:1px solid black;' font-family:verdana'>";
		body += "<h3 style='color:blue;'>귀하의 임시 비밀번호 입니다. 로그인 후 비밀번호를 변경하세요.</h3>";
		body += "<p>임시 비밀번호: <strong>" + sentpw + "</strong></p></div>";
		Map<String, Object> sendRs = mailService.send(dto.getUserEmail(), title, body);
		
		// 임시 비밀번호 초기화
		service = ac.getBean("memberServiceImpl", MemberServiceImpl.class);
		service.sentPw(dto);

		return (String) sendRs.get("msg");

	}
	
	// by성택_화면 잠금 설정_20200530
	@RequestMapping("lockScreen")
	public String lockScreen() {
		return "lockScreen";
	}
	
	// by성택_화면 잠금 해체_20200530
	@RequestMapping("lock")
	public String lock(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		MemberDTO dto = (MemberDTO) application.getAttribute("user");
		// 입력한 비밀번호가 일치하면 메인화면 사용가능
		if (dto.getPassword().equals(request.getParameter("password"))) {
			return "redirect:index";
		}
		// 불일치시 그대로 화면잠금 페이지
		return "redirect:lockScreen";
	}

}

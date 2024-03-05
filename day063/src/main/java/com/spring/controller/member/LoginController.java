package com.spring.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.member.MemberDAO;
import com.spring.biz.member.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller("login")
public class LoginController {

	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		
		MemberDAO mDAO=new MemberDAO();
		MemberDTO mDTO=new MemberDTO();
		mDTO.setMid(request.getParameter("mid"));
		mDTO.setPassword(request.getParameter("password"));
		mDTO=mDAO.selectOne(mDTO);
		if(mDTO != null) {
			HttpSession session=request.getSession();
			session.setAttribute("member", mDTO.getMid());

			mav.setViewName("redirect:main.do");
		}
		else {
			mav.addObject("msg", "로그인에 실패했습니다...");

			mav.setViewName("goback.do");
		}
		
		return mav;
	}
	
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", "로그아웃이 완료되었습니다! :D");
		mav.setViewName("alert.do");
		
		HttpSession session=request.getSession();
		session.removeAttribute("member");
		
		return mav;
	}

}

package kr.basic.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberLogoutController implements Controller {
	

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ctx = req.getContextPath();
		HttpSession session = req.getSession();
		session.removeAttribute("log");
		System.out.println("로그아웃 완료");
		return "redirect:" + ctx + "/header.jsp";
	}
		
}

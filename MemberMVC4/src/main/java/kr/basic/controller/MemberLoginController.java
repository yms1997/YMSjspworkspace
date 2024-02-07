package kr.basic.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.basic.model.MemberDAO;

public class MemberLoginController implements Controller {
	
	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ctx = req.getContextPath();
		String id = req.getParameter("id");
		if(req.getParameter("id") == null) {
			return "memberLogin";
		}
		String pw = req.getParameter("pw");
		int check = MemberDAO.getInstance().checkLogin(id, pw);
		if(check != 0) {
			HttpSession session = req.getSession();
			session.setAttribute("log", check);
			System.out.println("로그인 성공");
			System.out.println(check);
			return "redirect:" + ctx + "/header.jsp";
		}
		else {
			System.out.println("로그인 실패");
			return "redirect:" + ctx + "/memberLogin.do";
		}
	}
}

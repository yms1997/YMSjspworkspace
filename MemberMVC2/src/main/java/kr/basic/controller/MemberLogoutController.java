package kr.basic.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/memberLogout.do")
public class MemberLogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("log");
		System.out.println("로그아웃 완료");
		String ctx = req.getContextPath();
		res.sendRedirect(ctx + "/member/header.jsp");
	}
}

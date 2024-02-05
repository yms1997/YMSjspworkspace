package kr.basic.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;

import kr.basic.model.MemberDAO;


@WebServlet("/MemberLogin.do")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ctx = req.getContextPath();
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		int check = MemberDAO.getInstance().checkLogin(id, pw);
		if(check != 0) {
			req.setAttribute("log", check);
			res.sendRedirect(ctx + "/member/header.jsp");
		}
		else {
			res.sendRedirect(ctx + "/member/memberLogin.jsp");
		}
	}
}

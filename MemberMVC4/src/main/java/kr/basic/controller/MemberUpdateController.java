package kr.basic.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.model.MemberDAO;

public class MemberUpdateController implements Controller {
	
	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ctx = req.getContextPath();
		
		int num = Integer.parseInt(req.getParameter("num"));
		int age = Integer.parseInt(req.getParameter("age"));
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		
		int cnt = MemberDAO.getInstance().updateOneMember(num, age, email, phone);
		if(cnt > 0) {
			return "redirect:" + ctx + "/memberList.do";
		}else {
			throw new ServletException("not Update");
		}
	}
}

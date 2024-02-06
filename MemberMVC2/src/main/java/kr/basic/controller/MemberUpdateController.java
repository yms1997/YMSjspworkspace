package kr.basic.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.model.MemberDAO;

/**
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/memberUpdate.do")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ctx = req.getContextPath();
		
		int num = Integer.parseInt(req.getParameter("num"));
		int age = Integer.parseInt(req.getParameter("age"));
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");

		int cnt = MemberDAO.getInstance().updateOneMember(num, age, email, phone);
		
		if(cnt > 0) {
			res.sendRedirect(ctx + "/memberList.do");
		}
	}
}

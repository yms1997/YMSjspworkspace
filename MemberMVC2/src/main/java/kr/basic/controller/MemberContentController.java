package kr.basic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.model.Member;
import kr.basic.model.MemberDAO;

/**
 * Servlet implementation class MemberContentController
 */
@WebServlet("/memberContent.do")
public class MemberContentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ctx = req.getContextPath();
		
		int num = -1;
		if(req.getParameter("num") == null) {
			res.sendRedirect(ctx + "/member/memberList.jsp");
		}
		else {
			num = Integer.parseInt(req.getParameter("num"));
		}
		Member vo = MemberDAO.getInstance().getMemberByNum(num);
		RequestDispatcher rd = req.getRequestDispatcher("member/memberContent.jsp");
		req.setAttribute("vo", vo);
		rd.forward(req, res);
	}

}

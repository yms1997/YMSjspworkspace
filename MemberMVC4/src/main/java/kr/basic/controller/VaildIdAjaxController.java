package kr.basic.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.model.MemberDAO;

public class VaildIdAjaxController implements Controller{
	
	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		String passData = MemberDAO.getInstance().isValidById(id) ? "notValid" : "valid";
		
		res.getWriter().print(passData);
		
		return null;
		
	}
}

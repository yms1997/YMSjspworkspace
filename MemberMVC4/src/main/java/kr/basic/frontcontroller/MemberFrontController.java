package kr.basic.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.controller.Controller;


@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); // 한글깨짐방지
		
		String url = req.getRequestURI();
		System.out.println("url = " + url);
		String ctx = req.getContextPath();
		System.out.println("ctx = " + ctx);
		// 실제로 요청한 명령이 무엇인지 파악
		String command = url.substring(ctx.length());
		System.out.println("command = " + command); // /memberInsert.do
		Controller controller = null; // Controller interface 연결
		String nextPage = null;
		// 핸들러매핑 -> HandlerMapping : 우리가 가지고있는 url을 맵핑한 클래스
		HandlerMapping mapping = new HandlerMapping();
		controller = mapping.getController(command); // new~ Controller() : 주소값 받아서
		System.out.println("controller = " + controller);
		nextPage = controller.requestHandler(req, res); // memberList
		System.out.println("nextPage = " + nextPage);
		
		if(nextPage != null) {
			if(nextPage.indexOf("redirect:") != -1) {
				// redirect:/MemberMVC3/memberList.do
				res.sendRedirect(nextPage.split(":")[1]); // redirect
			}
			else {
				RequestDispatcher rd = req.getRequestDispatcher(ViewResolver.makeView(nextPage)); // forward
				rd.forward(req, res);
			}
		}
	}
	
}

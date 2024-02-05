package _01_el;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginProAction2
 */
@WebServlet("/loginPro2.do")
public class LoginProAction2 extends HttpServlet {
	
	// 클래스의 식별자 
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//super.service(req, resp);
		
		String dbId ="qwer";
		String dbPw ="1234";
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		System.out.println(id);
		System.out.println(pw);
		
		if(dbId.equals(id)&& dbPw.equals(pw)) {
			System.out.println("로그인 성공 ");
			HttpSession session = req.getSession();
			session.setAttribute("log", id);
			
			System.out.println(session.getAttribute("log"));
			
		}
		// 디폴트 경로 webapp 
		resp.sendRedirect("01_el/index.jsp");
		
	}

	
	

}

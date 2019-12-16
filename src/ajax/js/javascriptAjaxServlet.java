package ajax.js;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/js/test")
public class javascriptAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public javascriptAjaxServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1.인코딩처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
//		2.파라미터 핸들링
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println("요청메소드"+request.getMethod());
		System.out.println(name);
		System.out.println(age);
		
		
//		3.응답객체 출력
		PrintWriter out = response.getWriter();
		out.append("서버측 메세지<br/>")
		   .append("이름: "+name+"<br/>")
		   .append("나이: "+age+"<br/>")
		   .append("===========================</br>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

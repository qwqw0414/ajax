package ajax.jquery.xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;

@WebServlet("/jquery/xml/member")
public class JqueryAjaxXMLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JqueryAjaxXMLServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.업무로직
		List<Member> list = new ArrayList<>();
		list.add(new Member("박보검", "01012341234", "parkBogum.jpg"));
		list.add(new Member("쥴리아 로버츠", "01012341234", "juliaRoberts.jpg"));
		list.add(new Member("맷 데이먼", "01012341234", "mattDamon.jpg"));
		
		//2.view단처리
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jquery/xml/memberXml.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

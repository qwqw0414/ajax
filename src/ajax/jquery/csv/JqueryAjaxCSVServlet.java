package ajax.jquery.csv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;

@WebServlet("/jquery/csv")
public class JqueryAjaxCSVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JqueryAjaxCSVServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.업무로직
		List<Member> list = new ArrayList<>();
		list.add(new Member("박보검", "01012341234", "parkBogum.jpg"));
		list.add(new Member("쥴리아 로버츠", "01012341234", "juliaRoberts.jpg"));
		list.add(new Member("맷 데이먼", "01012341234", "mattDamon.jpg"));
		
		//csv작업
		StringBuilder csv = new StringBuilder();
		for(int i = 0; i < list.size(); i++) {
			if(i!=0) csv.append("\n");
			
			csv.append(list.get(i));
		}
		
		System.out.println("csv"+csv);
		//2.view단 처리
		response.setContentType("text/csv; charset=utf-8");
		response.getWriter().append(csv);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

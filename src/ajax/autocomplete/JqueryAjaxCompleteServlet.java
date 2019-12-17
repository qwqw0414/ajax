package ajax.autocomplete;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ajax.model.dao.AjaxDAO;

@WebServlet("/jquery/autoComplete")
public class JqueryAjaxCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JqueryAjaxCompleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/csv; charset=utf-8"); 
		
		//2.파라미터핸들링
		String srchName = request.getParameter("srchName");
		
		//유효성 검사
		if(srchName.trim().isEmpty()) return;
		
		//3.업무로직
		List<String> nameList = new AjaxDAO().selectByName(srchName);
		
		//csv 작업
		StringBuilder csv = new StringBuilder();
		if(nameList!=null && !nameList.isEmpty()){
			for(int i=0; i< nameList.size(); i++){
				if(i!=0) csv.append(",");
				csv.append(nameList.get(i));
			}
		}
		
		//4.view단 처리: csv형태로 전송
//		response.setContentType("text/csv; charset=utf-8");
		response.getWriter().append(csv);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

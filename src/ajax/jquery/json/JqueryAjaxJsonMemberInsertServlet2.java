package ajax.jquery.json;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import common.MemberSingletone;
import member.model.vo.Member;

@WebServlet("/jquery/json/member/insertMember2")
public class JqueryAjaxJsonMemberInsertServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JqueryAjaxJsonMemberInsertServlet2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.encoding
		request.setCharacterEncoding("utf-8");
		
		//2.parameter handling
		String jsonMember = request.getParameter("jsonMember");
		System.out.println(jsonMember);
		
		JSONParser jsonParser = new JSONParser();
		JSONObject obj = null;
		try {
			obj = (JSONObject)jsonParser.parse(jsonMember);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String name = (String)obj.get("name");
		String phone = (String)obj.get("phone");
		String profile = (String)obj.get("profile");

		//3.business logic
		List<Member> list = MemberSingletone.getInstance().getList();
		boolean result = list.add(new Member(name, phone, profile));
		JSONObject resultObj = new JSONObject();
		resultObj.put("result", result);
		
		//4.view단 처리
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(resultObj);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

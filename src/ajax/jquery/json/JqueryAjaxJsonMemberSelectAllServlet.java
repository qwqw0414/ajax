package ajax.jquery.json;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import common.MemberSingletone;
import member.model.vo.Member;

@WebServlet("/jquery/json/member/selectAll")
public class JqueryAjaxJsonMemberSelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JqueryAjaxJsonMemberSelectAllServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.업무로직
		List<Member> list = MemberSingletone.getInstance().getList();
		
		
		//JSONbject : HashMap을 상속
		//JSONArray : ArrayList를 상속
		JSONArray jsonArray = new JSONArray();
		
		for(Member m : list) {
			
			JSONObject jsonMember = new JSONObject();
			jsonMember.put("name", m.getName());
			jsonMember.put("phone", m.getPhone());
			jsonMember.put("profile", m.getProfile());
			jsonArray.add(jsonMember);
		}
		
		//2.view단처리: json문자열을 출력하기
		//인코딩과 mime타입 설정 필수
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().append(jsonArray.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

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

@WebServlet("/jquery/json/member/insertMember")
public class InsertMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertMemberServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String profile = request.getParameter("profile");
		
		List<Member> list = MemberSingletone.getInstance().getList();
		
		list.add(new Member(name,phone,profile));
		
		JSONArray jsonArray = new JSONArray();
		
		for(Member m : list) {
			
			JSONObject jsonMember = new JSONObject();
			jsonMember.put("name", m.getName());
			jsonMember.put("phone", m.getPhone());
			jsonMember.put("profile", m.getProfile());
			jsonArray.add(jsonMember);
		}
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().append(jsonArray.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

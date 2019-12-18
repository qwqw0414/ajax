package smart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import smart.vo.model.SmartPhone;
import smart.vo.service.SmartService;

@WebServlet("/smart/insertPhone")
public class insertPhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public insertPhoneServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1.인코딩
		request.setCharacterEncoding("utf-8");
		
//		2.파라미터 핸들링
		String jsonPhone = request.getParameter("jsonPhone");
		
		JSONParser jsonParser = new JSONParser();
		JSONObject obj = null;
		
		try {
			obj = (JSONObject)jsonParser.parse(jsonPhone);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String pname = (String)obj.get("pname");
		String amount = (String)obj.get("amount");
		
//		3.비즈니스 로직
		SmartPhone s = new SmartPhone(pname, Integer.parseInt(amount), null);
		
		int result = new SmartService().insertPhone(s);
		
		JSONArray jsonArray = new JSONArray();
		List<SmartPhone> phoneList = new ArrayList<>();
		phoneList = new SmartService().selectRecen5();
		String preDate;
		
		for(SmartPhone index : phoneList) {
			JSONObject jsonOutput = new JSONObject();
			jsonOutput.put("pname", index.getPname());
			jsonOutput.put("amount", index.getAmount());
			jsonOutput.put("pdate", index.getPdate().toString());
			jsonArray.add(jsonOutput);
		}
		System.out.println(jsonArray);
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jsonArray.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

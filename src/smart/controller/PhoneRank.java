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

import smart.vo.model.SmartPhone;
import smart.vo.service.SmartService;

@WebServlet("/smart/selectRank")
public class PhoneRank extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PhoneRank() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SmartPhone> phoneList = new ArrayList<>();
		phoneList = new SmartService().selectRank();
		
		JSONArray jsonArray = new JSONArray();
		
		for(SmartPhone index : phoneList) {
			JSONObject jsonOutput = new JSONObject();
			jsonOutput.put("pname", index.getPname());
			jsonOutput.put("amount", index.getAmount());
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

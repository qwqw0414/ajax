package ajax.model.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class AjaxDAO {

	public List<String> selectByName(String srchName) {
		PreparedStatement pstmt = null;
		String query = "select * from classmate where name like ?";
		List<String> list = new ArrayList<>();
		
		return null;
	}
	
}

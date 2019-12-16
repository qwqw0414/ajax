package ajax.model.dao;

import static common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AjaxDAO {

	public List<String> selectByName(String srchName) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<String> list = new ArrayList<>();
		String query = "select * from classmate where name like ?";

		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+srchName+"%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(rset.getString("name"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
			close(conn);
		}

		return list;
	}

}

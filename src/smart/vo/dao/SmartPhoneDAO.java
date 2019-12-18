package smart.vo.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static common.JDBCTemplate.*;
import smart.vo.model.SmartPhone;

public class SmartPhoneDAO {

	private Properties prop = new Properties();

	public SmartPhoneDAO() {
		try {
			String fileName = SmartPhoneDAO.class.getResource("/smart/smart.properties").getPath();
			prop.load(new FileReader(fileName));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertPhone(Connection conn, SmartPhone s) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertPhone");
		System.out.println(s);
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, s.getPname());
			pstmt.setInt(2, s.getAmount());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public List<SmartPhone> selectRecen5(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<SmartPhone> smartList = new ArrayList<>();
		String query = prop.getProperty("selectRecen5");
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				SmartPhone s = new SmartPhone();
				s.setPname(rset.getString("pname"));
				s.setAmount(rset.getInt("amount"));
				s.setPdate(rset.getDate("pdate"));

				smartList.add(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return smartList;
	}

	public List<SmartPhone> selectRank(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<SmartPhone> smartList = new ArrayList<>();
		String query = prop.getProperty("selectRank");
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				SmartPhone s = new SmartPhone();
				s.setPname(rset.getString("pname"));
				s.setAmount(rset.getInt("sum"));

				smartList.add(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return smartList;
	}

}

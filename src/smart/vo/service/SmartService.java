package smart.vo.service;

import smart.vo.dao.SmartPhoneDAO;
import smart.vo.model.SmartPhone;
import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

public class SmartService {

	public int insertPhone(SmartPhone s) {
		Connection conn = getConnection();
		int result = new SmartPhoneDAO().insertPhone(conn, s);
		
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
		return result;
	}

	public List<SmartPhone> selectRecen5() {
		Connection conn = getConnection();
		List<SmartPhone> list = null;
		
		list = new SmartPhoneDAO().selectRecen5(conn);
		
		close(conn);
		
		return list;
	}

	public List<SmartPhone> selectRank() {
		Connection conn = getConnection();
		List<SmartPhone> list = null;
		
		list = new SmartPhoneDAO().selectRank(conn);
		
		close(conn);
		
		return list;
	}

}

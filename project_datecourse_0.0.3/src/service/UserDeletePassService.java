package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;


import dao.DAO;

public class UserDeletePassService {

	public boolean userPass(String id, String inputPassword) {
		DAO userdeleteDAO = DAO.getInstance();
		Connection con = getConnection();
		userdeleteDAO.setConnection(con);
		boolean deleteResult = false;
		int deleteCount =userdeleteDAO.userPass(id, inputPassword);
		
		//deleteCount 가 1이면 트루
		if(deleteCount>0) {
			System.out.println("서비스에서 삭제완료");
			deleteResult =true;
			commit(con);
		}else {
			System.out.println("서비스에서 삭제실패");
			deleteResult=false;
			rollback(con);
		}
		close(con);
		
		
		return deleteResult;
	}

}
/*package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import bean.MemberBean;
import dao.DAO;

public class SuspendedMemberListService {

	public ArrayList<MemberBean> returningToAction2(){
		DAO suspendedMemberListDAO = DAO.getInstance();
		Connection con = getConnection();
		suspendedMemberListDAO.setConnection(con);
		ArrayList<MemberBean> list = suspendedMemberListDAO.suspendedmemberList();
		close(con);
		
		return list;
	}
	
}



*/
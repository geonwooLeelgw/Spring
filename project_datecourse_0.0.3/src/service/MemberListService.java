package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import bean.MemberBean;
import dao.DAO;

public class MemberListService {

	public ArrayList<MemberBean> returningToAction(){
		
		//일반회원 로그인
		
		DAO memberDAO = DAO.getInstance();
		Connection con = getConnection();
		memberDAO.setConnection(con);
		ArrayList<MemberBean> list = memberDAO.memberList();
		close(con);
		
		return list;
	}
	
	
	

	
	public ArrayList<MemberBean> returningToAction2(){
		
		//정지회원 리스트
		
		DAO suspendedMemberListDAO = DAO.getInstance();
		Connection con = getConnection();
		suspendedMemberListDAO.setConnection(con);
		ArrayList<MemberBean> list = suspendedMemberListDAO.suspendedmemberList();
		close(con);
		
		return list;
	}
	
}




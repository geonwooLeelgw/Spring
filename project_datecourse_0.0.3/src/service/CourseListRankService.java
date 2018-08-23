package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import bean.CourseBean;
import dao.DAO;

public class CourseListRankService {

	public ArrayList<CourseBean> returningToAction() {
		DAO listDAO = DAO.getInstance();
		Connection con = getConnection();
		listDAO.setConnection(con);
		
		
		
		ArrayList<CourseBean> list = listDAO.courseRankList();
		close(con);

		return list;
	}

}

package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import bean.CourseBean;
import dao.DAO;

public class UserLikeListService {

	public ArrayList<CourseBean> likeList(String id) {
		DAO listDAO = DAO.getInstance();
		Connection con = getConnection();
		listDAO.setConnection(con);
		
		
		
		ArrayList<CourseBean> list = listDAO.courseLikeList(id);
		close(con);
		
		return list;

}
}
package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;


import bean.LikeBean;

import dao.DAO;

public class LikeViewService {

	public LikeBean like(int course_num, String id) {
		DAO viewDAO = DAO.getInstance();
		Connection con = getConnection();
		viewDAO.setConnection(con);

		LikeBean detailReple = viewDAO.viewLike(course_num, id);
		close(con);
		return detailReple;
	}

}

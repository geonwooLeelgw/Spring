package service;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;
import bean.RepleBean;
import dao.DAO;

public class RepleViewService {

	public static ArrayList<RepleBean> Reple(int course_num) {
		DAO viewDAO = DAO.getInstance();
		Connection con = getConnection();
		viewDAO.setConnection(con);

		ArrayList<RepleBean> detailReple = viewDAO.viewReple(course_num);
		close(con);
		return detailReple;
	}

}

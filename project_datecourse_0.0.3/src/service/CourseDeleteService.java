package service;

import static db.JdbcUtil.*;


import java.sql.Connection;

import dao.DAO;

public class CourseDeleteService {

	public boolean returningToAction(int course_num) {
		
		DAO delDAO = DAO.getInstance();
		Connection con = getConnection();
		delDAO.setConnection(con);
		
		boolean delResult = false;
		int result = delDAO.deleteCourse(course_num);
		System.out.println(result);
		if (result > 0) {
			delResult = true;
			commit(con);
		} else {
			delResult = false;
			rollback(con);
		}
		close(con);

		return delResult;
	}
}

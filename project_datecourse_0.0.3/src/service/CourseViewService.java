package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import bean.CourseBean;
import dao.DAO;

public class CourseViewService {

	public CourseBean returningToAction(int course_num) {
		DAO viewDAO = DAO.getInstance();
		Connection con = getConnection();
		viewDAO.setConnection(con);

		CourseBean detailCourse = viewDAO.viewCourse(course_num);
		close(con);
		return detailCourse;

	}
}

package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import bean.CourseBean;
import dao.DAO;

public class CourseInsertService {

	
	public boolean insertCourse(CourseBean course) {
		DAO insertDAO = DAO.getInstance();
		Connection con = getConnection();
		insertDAO.setConnection(con);
		
		boolean LoginMember = false;
		
		int insertResult = insertDAO.insertCourse(course);
		
		if(insertResult > 0 ) {
			LoginMember = true;
			commit(con);
		} else {
			LoginMember = false;
			rollback(con);
		}
		
		close(con);
		return LoginMember;
	}
	
}

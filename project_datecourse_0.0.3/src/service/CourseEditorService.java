package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import bean.EditorBean;
import dao.DAO;

public class CourseEditorService {

	public boolean insertEditor(EditorBean ed) {
		DAO insertDAO = DAO.getInstance();
		Connection con = getConnection();
		insertDAO.setConnection(con);
		
		boolean edirtor = false;
		
		int insertResult = insertDAO.insertEditor(ed);
		
		if(insertResult > 0 ) {
			edirtor = true;
			commit(con);
		} else {
			edirtor = false;
			rollback(con);
		}
		
		close(con);
		return edirtor;
	}

}

package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import bean.EditorBean;

import dao.DAO;

public class editorViewService {

	public static EditorBean editor(int course_num) {
		DAO viewDAO = DAO.getInstance();
		Connection con = getConnection();
		viewDAO.setConnection(con);

		EditorBean detailReple = viewDAO.viewEditor(course_num);
		close(con);
		return detailReple;
	}

}

package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.DAO;

public class CourseLikeService {

	public boolean LikeNo(int course_num, String id) {
		
		//좋아요 취소
		
		DAO likeDAO = DAO.getInstance();
		Connection con = getConnection();
		likeDAO.setConnection(con);
		boolean likeResult = false;
		
		int result = likeDAO.CourseLikeNo(course_num, id);
		if(result>0) {
			likeResult = true;
			commit(con);
		}else {
			likeResult = false;
			rollback(con);
		}
		close(con);
		return likeResult;
	}

	public boolean LikeUp(int course_num, String id) {
		
		//좋아요 선택
		
		DAO likeDAO = DAO.getInstance();
		Connection con = getConnection();
		likeDAO.setConnection(con);
		boolean likeResult = false;
		
		int result = likeDAO.CourseLikeUpDown(course_num, id);
		if(result>0) {
			likeResult = true;
			commit(con);
		}else {
			likeResult = false;
			rollback(con);
		}
		close(con);
		return likeResult;
	}

}

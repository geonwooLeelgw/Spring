package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.AdvertisementBean;
import bean.CalenderBean;
import bean.CourseBean;
import bean.CourseLikeBean;
import bean.EditorBean;
import bean.LikeBean;
import bean.MemberBean;
import bean.PlaceBean;
import bean.RepleBean;

public class DAO {
	/*
	 * 회원가입 쿼리문 전송을 위한 insertMember 메소드 정의
	 */
	private static DAO DAO;
	private Connection con;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int insertResult = 0;
	int deleteResult = 0;
	boolean go = false;

	public static DAO getInstance() {
		if (DAO == null) {
			DAO = new DAO();
		}
		return DAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	// 회원정보 삽입
	public int insertMember(MemberBean member) {
		String sql = "insert into member values(?,?,?,?,?,?)";

		try {

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getNickname());
			pstmt.setString(5, member.getEmail());
			pstmt.setInt(6, 1);
			// 쿼리문 실행
			insertResult = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("joinMember 오류!!:" + e);
		} finally {
			try {
				close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return insertResult;
	}

	public int insertFes(CalenderBean cb) {
		int num = 0;
		int insertCount = 0;

		String sql1 = "SELECT MAX(FES_NUM) FROM CALENDER";
		String sql2 = "INSERT INTO CALENDER VALUES(?, ?, ?, ?, ?, ?, ?)";

		try {
			pstmt = con.prepareStatement(sql1);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				num = rs.getInt(1) + 1;
			} else {
				num = 1;
			}

			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, num);
			pstmt.setString(2, cb.getNAME());
			pstmt.setString(3, cb.getPLACE());
			pstmt.setInt(4, cb.getTEL());
			pstmt.setString(5, cb.getPERIOD());
			pstmt.setString(6, cb.getSEARCHKEYWORD());
			pstmt.setString(7, cb.getFES_MONTH());

			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("insertFes" + e);
		} finally {
			try {
				close(rs);
				close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return insertCount;
	}

	public int DeleteArticle(int FES_NUM) {
		String sql = "delete calender where FES_NUM=?";
		int deleteCount = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, FES_NUM);
			deleteCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("DeleteArticle" + e);
		} finally {
			close(pstmt);
		}
		return deleteCount;
	}

	public ArrayList<CalenderBean> CalenderList() {
		ArrayList<CalenderBean> calender = new ArrayList<CalenderBean>();
		String sql = "select * from calender";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					CalenderBean cb = new CalenderBean();
					cb.setFES_NUM(rs.getInt(1));
					cb.setNAME(rs.getString(2));
					cb.setPLACE(rs.getString(3));
					cb.setTEL(rs.getInt(4));
					cb.setPERIOD(rs.getString(5));
					cb.setSEARCHKEYWORD(rs.getString(6));
					cb.setFES_MONTH(rs.getString(7));
					calender.add(cb);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("CalenderList" + e);
		} finally {
			try {
				close(pstmt);
				close(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return calender;
	}
	
	//입력받은 정보 삽입
	public int insertCourse(CourseBean course) {
		int num = 0;
		int result = 0;
		String sql1 = "select max(course_num) from course_detail";
		String sql2 = "insert into course_detail values (?, ?, ?, ?, ?, sysdate, ?, ?,?,?)";

		try {

			pstmt = con.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt(1) + 1;
			} else {
				num = 1;
			}

			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, num);
			pstmt.setString(2, course.getCourse_name());
			pstmt.setString(3, course.getCourse_location());
			pstmt.setString(4, course.getCourse_place_name());
			pstmt.setInt(5, course.getCourse_place_tel());
			pstmt.setInt(6, 0);
			pstmt.setString(7, course.getCourse_search_keyword());
			pstmt.setString(8, course.getPhoto());
			pstmt.setString(9, null);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("insertCourse" + e);
		} finally {
			try {
				close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public ArrayList<CourseBean> courseList() {
		ArrayList<CourseBean> list = new ArrayList<CourseBean>();
		String sql = "select * from course_detail";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					CourseBean cb = new CourseBean();
					cb.setCourse_num(rs.getInt(1));
					cb.setCourse_name(rs.getString(2));
					cb.setCourse_location(rs.getString(3));
					cb.setCourse_place_name(rs.getString(4));
					cb.setCourse_place_tel(rs.getInt(5));
					cb.setCourse_post_date(rs.getDate(6));
					cb.setCourse_like(rs.getInt(7));
					cb.setCourse_search_keyword(rs.getString(8));

					list.add(cb);

				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("courseList" + e);

		} finally {
			try {

				close(pstmt);
				close(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	//코스 가져오기
	public CourseBean viewCourse(int course_num) {
		CourseBean cb = null;
		String sql = "select * from course_detail where course_num='" + course_num + "'";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				cb = new CourseBean();
				cb.setCourse_num(rs.getInt(1));
				cb.setCourse_name(rs.getString(2));
				cb.setCourse_location(rs.getString(3));
				cb.setCourse_place_name(rs.getString(4));
				cb.setCourse_place_tel(rs.getInt(5));
				cb.setCourse_post_date(rs.getDate(6));
				cb.setCourse_like(rs.getInt(7));
				cb.setCourse_search_keyword(rs.getString(8));
			}
		} catch (Exception e) {
			System.out.println("viewCourse" + e);
		} finally {
			try {
				close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return cb;
	}

	public int deleteCourse(int course_num) {
		String sql = "delete course_detail where course_num=?";
		String sql2 = "delete editor where course_num=?";
		String sql3 = "delete reple where course_num=?";
		int deleteResult = 0;

		try {
			//해당 코스 삭제
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, course_num);
			deleteResult = pstmt.executeUpdate();
			System.out.println("1");
			
			//코스에 작성된 내용 삭제
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, course_num);
			pstmt.executeUpdate();
			System.out.println("2");
			
			//코스 댓글 삭제
			pstmt = con.prepareStatement(sql3);
			pstmt.setInt(1, course_num);
			pstmt.executeUpdate();
			System.out.println("3");
			
		} catch (Exception e) {
			System.out.println("deleteCourse" + e);
		} finally {
			close(pstmt);
		}

		return deleteResult;
	}

	public ArrayList<CourseBean> FoodList(String key) {
		ArrayList<CourseBean> flist = new ArrayList<CourseBean>();
		String sql = "select * from course_detail where COURSE_SEARCH_KEYWORD = ?";
		String sql2 = "select * from course_detail";
		System.out.println("dao에서 키값 : " + key);
		try {
			System.out.println("try문 처음 key값 : "+key);
			
			if (key.equals("ViewAll")) {
				//전체보기
				pstmt = con.prepareStatement(sql2);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					System.out.println("와일문");
					CourseBean cb = new CourseBean();
					cb.setCourse_num(rs.getInt(1));
					cb.setCourse_name(rs.getString(2));
					cb.setCourse_location(rs.getString(3));
					cb.setCourse_place_name(rs.getString(4));
					cb.setCourse_place_tel(rs.getInt(5));
					cb.setCourse_post_date(rs.getDate(6));
					cb.setCourse_like(rs.getInt(7));
					cb.setCourse_search_keyword(rs.getString(8));
					cb.setPhoto(rs.getString(9));
					cb.setContent(rs.getString(10));
					System.out.println("리스트 담기전");
					flist.add(cb);
				}
				System.out.println("뷰올" + key);
			} else {
				//전체보기를 제외한 나머지
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, key);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					System.out.println("와일문");
					CourseBean cb = new CourseBean();
					cb.setCourse_num(rs.getInt(1));
					cb.setCourse_name(rs.getString(2));
					cb.setCourse_location(rs.getString(3));
					cb.setCourse_place_name(rs.getString(4));
					cb.setCourse_place_tel(rs.getInt(5));
					cb.setCourse_post_date(rs.getDate(6));
					cb.setCourse_like(rs.getInt(7));
					cb.setCourse_search_keyword(rs.getString(8));
					cb.setPhoto(rs.getString(9));
					cb.setContent(rs.getString(10));
					System.out.println("리스트 담기전");
					flist.add(cb);
				}
				System.out.println("나머지 : " + key);
			}
		} catch (Exception e) {
			System.out.println("FoodList" + e);
		} finally {
			try {
				close(pstmt);
				close(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flist;
	}

	public CalenderBean ViewCalender(int FES_NUM) {
		CalenderBean cb = null;
		String sql = "select * from calender where FES_NUM='" + FES_NUM + "'";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cb = new CalenderBean();
				cb.setFES_NUM(rs.getInt(1));
				cb.setNAME(rs.getString(2));
				cb.setPLACE(rs.getString(3));
				cb.setTEL(rs.getInt(4));
				cb.setPERIOD(rs.getString(5));
				cb.setSEARCHKEYWORD(rs.getString(6));
				cb.setFES_MONTH(rs.getString(7));
			}
		} catch (Exception e) {
			System.out.println("ViewCalender" + e);
		} finally {
			try {
				close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cb;
	}

	//해당 아이디와 비밀번호 확인
	public MemberBean SelectLoginMember(MemberBean member) {
		System.out.println("dao에서 로그인전");

		MemberBean MB = new MemberBean();

		String sql = "select id from member where id=? and password=?";
		String sql2 = "select suspendedNum, password from member where id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			rs = pstmt.executeQuery();

			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1, member.getId());
			rs = pstmt.executeQuery();

			if (rs.next()) {

				MB.setSuspendedNum(rs.getInt(1));
				MB.setPassword(rs.getString(2));
				System.out.println("DAO에서 정지번호 : " + MB.getSuspendedNum());
			}

		} catch (Exception e) {
			System.out.println("LoginMember 오류!! " + e);
			e.printStackTrace();
		}
		return MB;
	}

	public MemberBean selectMember(String viewId) {
		String sql = "select * from member where id=?";
		MemberBean member = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, viewId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new MemberBean();
				member.setId(rs.getString("id"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setNickname(rs.getString("nickname"));
				member.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			System.out.println("selectMember 오류!!! :" + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return member;
	}

	public ArrayList<CourseBean> userCourseList() {
		ArrayList<CourseBean> list = new ArrayList<CourseBean>();
		String sql = "select * from course_detail";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					CourseBean courseBean = new CourseBean();
					courseBean.setCourse_num(rs.getInt(1));
					courseBean.setCourse_name(rs.getString(2));
					courseBean.setCourse_location(rs.getString(3));
					courseBean.setCourse_place_name(rs.getString(4));
					courseBean.setCourse_place_tel(rs.getInt(5));
					courseBean.setCourse_post_date(rs.getDate(6));
					courseBean.setCourse_like(rs.getInt(7));
					courseBean.setCourse_search_keyword(rs.getString(8));
					list.add(courseBean);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("userCourseList" + e);
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	public String isArticlePass(int course_num, String password) {
		String sql = "select * from course_detail where course_num=?";
		String isRight = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, course_num);
			rs = pstmt.executeQuery();
			rs.next();
			if (password.equals(rs.getString("password")))
				isRight = null;
		} catch (Exception e) {
			System.out.println("isArticlePass" + e);
		} finally {
			close(pstmt);
			close(rs);
		}
		return isRight;
	}

	public int deleteArticle(int course_num) {
		String sql = "delete from course_detail where course_num=?";
		int deleteCount = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, course_num);
			deleteCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("deleteArticle" + e);
		} finally {
			close(pstmt);
		}
		return deleteCount;
	}

	public AdvertisementBean adInfo(int advertisement_num) {
		AdvertisementBean AB = null;
		String sql = "select * from advertisement where advertisement_num=?";
		//랜덤으로 나온 숫자를 대입하여 광고를 가져옴
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, advertisement_num);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				AB = new AdvertisementBean();
				AB.setAdvertisement_num(rs.getInt(1));
				AB.setCompany_name(rs.getString(2));
				AB.setCompany_tel(rs.getInt(3));
				AB.setCompany_address(rs.getString(4));

			}

		} catch (Exception e) {
			System.out.println("adInfo" + e);
		} finally {
			try {
				close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return AB;
	}
	
	//댓글 삽입
	public int insertReple(int course_num, String reple, String id) {
		int num = 0;
		int Result = 0;
		String sql = "insert into reple values (?,?,?,?)";
		String sql1 = "select max(reple_num) from reple";

		try {

			pstmt = con.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt(1) + 1;
			} else {
				num = 1;
			}

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, course_num);
			pstmt.setInt(2, num);
			pstmt.setString(3, reple);
			pstmt.setString(4, id);

			Result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				close(pstmt);
			} catch (Exception e) {
				System.out.println("insertReple" + e);
			}
		}
		return Result;
	}

	public ArrayList<RepleBean> viewReple(int course_num) {
		ArrayList<RepleBean> list = new ArrayList<RepleBean>();
		RepleBean rb = null;
		String sql = "select * from reple where course_num=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, course_num);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				rb = new RepleBean();
				rb.setCourse_num(rs.getInt(1));
				rb.setReple_num(rs.getInt(2));
				rb.setReple_content(rs.getString(3));
				rb.setId(rs.getString(4));
				list.add(rb);
			}
		} catch (Exception e) {
			System.out.println("viewReple" + e);
		} finally {
			try {
				close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	//댓글 삭제
	public int deleteReple(int reple_num) {
		String sql = "delete reple where reple_num=?";
		int deleteResult = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reple_num);

			deleteResult = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("deleteReple" + e);
		} finally {
			close(pstmt);
		}

		return deleteResult;
	}

	//좋아요
	public int CourseLikeUpDown(int course_num, String id) {
		int UpdateResult = 0;
		String sql = "update course_detail set course_like=course_like+1 where course_num=?";
		String sql1 = "insert into course_like values (?,?)";
		String sql2 = "select * from course_like where course_num=? and id=?";

		try {
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, course_num);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				UpdateResult = 0;
			} else {

				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, course_num);
				UpdateResult = pstmt.executeUpdate();

				pstmt = con.prepareStatement(sql1);
				pstmt.setInt(1, course_num);
				System.out.println(id);
				pstmt.setString(2, id);
				UpdateResult = pstmt.executeUpdate();

			}
		} catch (Exception e) {
			System.out.println("CourseLikeUpDown" + e);
		}
		return UpdateResult;
	}

	//좋아요 취소
	public int CourseLikeNo(int course_num, String id) {
		int UpdateResult = 0;
		String sql = "update course_detail set course_like=course_like-1 where course_num=?";
		String sql1 = "delete from course_like where COURSE_NUM=? and id=?";
		String sql2 = "select * from course_like where course_num=? and id=?";

		try {
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, course_num);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, course_num);
				UpdateResult = pstmt.executeUpdate();

				pstmt = con.prepareStatement(sql1);
				pstmt.setInt(1, course_num);
				pstmt.setString(2, id);
				UpdateResult = pstmt.executeUpdate();

			} else {
				UpdateResult = 0;
			}
		} catch (Exception e) {
			System.out.println("CourseLikeUpDown" + e);
		}
		return UpdateResult;
	}

	int i = 0;

	// 내가 좋아요 누른 게시물
	public ArrayList<CourseBean> courseLikeList(String id) {
		ArrayList<CourseBean> list = new ArrayList<CourseBean>();
		ArrayList<CourseLikeBean> list2 = new ArrayList<CourseLikeBean>();
		String sql0 = "select course_num from course_like where id=?";
		String sql = "select * from course_detail where course_num=?";

		try {
			pstmt = con.prepareStatement(sql0);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			System.out.println("1");
			while (rs.next()) {
				//쿼리문 전송결과를 list2에 담는다.
				CourseLikeBean cl = new CourseLikeBean();
				cl.setCourse_num(rs.getInt(1));
				System.out.println("2");
				list2.add(cl);
				i++;
			}

			System.out.println("2-2");
			for (int s = 0; s < i; s++) {

				System.out.println(list2.get(s).getCourse_num());
				//list2에 담긴 값으로 쿼리문을 전송한다.
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, list2.get(s).getCourse_num());
				rs = pstmt.executeQuery();

				System.out.println("3");

				if (rs.next()) {
					CourseBean cb = new CourseBean();
					cb.setCourse_num(rs.getInt(1));
					cb.setCourse_name(rs.getString(2));
					cb.setCourse_location(rs.getString(3));
					cb.setCourse_place_name(rs.getString(4));
					cb.setCourse_place_tel(rs.getInt(5));
					cb.setCourse_post_date(rs.getDate(6));
					cb.setCourse_like(rs.getInt(7));
					cb.setCourse_search_keyword(rs.getString(8));

					list.add(cb);
					System.out.println("4");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("courseLikeList" + e);
		} finally {
			try {

				close(pstmt);
				close(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return list;

	}

	public ArrayList<CalenderBean> viewKeyword(String calenderKeyword) {
		ArrayList<CalenderBean> list = new ArrayList<CalenderBean>();
		String sql = "select * from calender where searchKeyword='" + calenderKeyword + "'";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					CalenderBean CB = new CalenderBean();
					CB.setFES_NUM(rs.getInt(1));
					CB.setNAME(rs.getString(2));
					CB.setPLACE(rs.getString(3));
					CB.setTEL(rs.getInt(4));
					CB.setPERIOD(rs.getString(5));
					CB.setSEARCHKEYWORD(rs.getString(6));
					CB.setFES_MONTH(rs.getString(7));

					list.add(CB);

				} while (rs.next());
			}

		} catch (Exception e) {
			System.out.println("viewKeyword" + e);

		} finally {
			try {

				close(pstmt);
				close(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	//5개 이하로 좋아요 높은순으로 가져오기
	public ArrayList<CourseBean> courseRankList() {
		ArrayList<CourseBean> list = new ArrayList<CourseBean>();
		String sql = "select * from (select * from course_detail order by course_like desc) where rownum <= 5";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					CourseBean cb = new CourseBean();
					cb.setCourse_num(rs.getInt(1));
					cb.setCourse_name(rs.getString(2));
					cb.setCourse_location(rs.getString(3));
					cb.setCourse_place_name(rs.getString(4));
					cb.setCourse_place_tel(rs.getInt(5));
					cb.setCourse_post_date(rs.getDate(6));
					cb.setCourse_like(rs.getInt(7));
					cb.setCourse_search_keyword(rs.getString(8));
					cb.setPhoto(rs.getString(9));
					cb.setContent(rs.getString(10));

					list.add(cb);

				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("courseRankList" + e);

		} finally {
			try {

				close(pstmt);
				close(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	public ArrayList<PlaceBean> PlaceSelect() {
		ArrayList<PlaceBean> list = new ArrayList<PlaceBean>();
		String sql = "SELECT * FROM PLACE_DETAIL WHERE PLACE_NAME = ? OR PLACE_NAME = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "아오리라멘");
			pstmt.setString(2, "쿠우쿠우");
			rs = pstmt.executeQuery();
			System.out.println("1");
			if (rs.next()) {
				do {
					PlaceBean plb = new PlaceBean();
					plb.setPlace_num(rs.getInt(1));
					plb.setPlace_name(rs.getString(2));
					plb.setPlace_location(rs.getString(3));
					plb.setPlace_tel(rs.getString(4));
					plb.setPlace_content(rs.getString(5));
					list.add(plb);
					System.out.println(plb.getPlace_name());

				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("PlaceSelect" + e);
		} finally {
			try {
				close(pstmt);
				close(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public LikeBean viewLike(int course_num, String id) {

		LikeBean lb = null;
		String sql = "select * from COURSE_LIKE where course_num=? and id=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, course_num);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				lb = new LikeBean();
				lb.setCourse_num(rs.getInt(1));
				lb.setId(rs.getString(2));

			}
		} catch (Exception e) {
			System.out.println("viewLike" + e);
		} finally {
			try {
				close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return lb;
	}

	// 개인정보 값 가져오기
	public MemberBean memmodify(String id) {
		MemberBean mem = null;
		//sql = member테이블에 있는 id
		String sql = "select * from member where id=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) { //유저 id에 저장된 값을 가져온다
				mem = new MemberBean();
				mem.setId(rs.getString("id"));
				mem.setPassword(rs.getString("password"));
				mem.setName(rs.getString("name"));
				mem.setNickname(rs.getString("nickname"));
				mem.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			System.out.println("개인정보 값 가져오기 실패" + e);
		} finally {
			close(rs);
			close(pstmt);
		}

		return mem;
	}

	// 개인정보 비밀번호 및 수정
	public int modiPassword(MemberBean memberBean) {
		//sql1 = member테이블에 있는 id에 password 입력
		//sql2 = member테이블에 id를 이름,닉네임,이메일을 업데이트 한다
		String sql1 = "select password from member where id = ?";
		String sql2 = "update member set name=?,nickname=?,email=? where id=?";

		String id = memberBean.getId();
		System.out.println(" : " + id);
		String password = memberBean.getPassword(); //비밀번호 비교하기위해
		System.out.println(": " + password);
		int UpdateCount = 0; //리턴을 해주기 위해
		String pass = null;

		try {

			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				pass = rs.getString(1);
				System.out.println("" + pass);
				/*
				 * System.out.println("1:"+pass); System.out.println("2:"+password);
				 */
			}

			if (pass.equals(password)) {//입력한 비밀번호가 일치하면 정보를 수정할 수 있다.
				pstmt = con.prepareStatement(sql2);
				pstmt.setString(1, memberBean.getName()); //변경하는 이름
				pstmt.setString(2, memberBean.getNickname());// ``
				pstmt.setString(3, memberBean.getEmail()); // ``
				pstmt.setString(4, id);//유저 아이디 값
				UpdateCount = pstmt.executeUpdate();//UpdateCount에 실행을 담는다

			}

		} catch (Exception e) {
			System.out.println(" :" + e);
		} finally {
			close(pstmt);
			close(rs);
		}

		return UpdateCount;

	}

	// 회원탈퇴 및 비밀번호 일치
	public int userPass(String id, String inputPassword) {
		String sql1 = "select password from member where id = ?";
		String sql2 = "delete member where id = ? ";
		MemberBean MB = new MemberBean();
		String confirmedPassword = null;
		int result = 0;
		try {
			/*
			 * pstmt = con.prepareStatement(sql); pstmt.setString(1, usermember.getId());
			 * pstmt.setString(2, usermember.getPassword());
			 */

			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				MB.setPassword(rs.getString(1));
				confirmedPassword = MB.getPassword();
				System.out.println("id : " + id);
				System.out.println("confirmedPassword : " + confirmedPassword);
				System.out.println("inputPassword : " + inputPassword);

				if (confirmedPassword.equals(inputPassword)) {
					System.out.println("ㅇㄹ");
					pstmt = con.prepareStatement(sql2);
					pstmt.setString(1, id);
					result = pstmt.executeUpdate();
				}

			}
			if (result > 0) {
				result = 1;
			} else {
				System.out.println("ㅗㅎ");
				result = 0;
			}
		} catch (Exception e) {
			System.out.println(" :" + e);
		} finally {
			close(pstmt);
			close(rs);
		}

		return result;

	}
	//관리자를 제외한 모든 회원 조회
	public ArrayList<MemberBean> memberList() {

		ArrayList<MemberBean> list = new ArrayList<MemberBean>();
		MemberBean MB = null;
		String sql = "select * from member where not id='admin'";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					MB = new MemberBean();
					MB.setId(rs.getString(1));
					MB.setPassword(rs.getString(2));
					MB.setName(rs.getString(3));
					MB.setNickname(rs.getString(4));
					MB.setEmail(rs.getString(5));

					list.add(MB);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("FoodList" + e);
		} finally {
			try {
				close(pstmt);
				close(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int SuspendedMember(String thatId) {
		int result = 0;
		//suspendedNum을 -1로 바꾸어 로그인 정지
		String sql = "update member set suspendedNum=-1  where id=?";
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, thatId);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("SuspendedMember method 오류 : " + e);
		}

		return result;
	}

	public ArrayList<MemberBean> suspendedmemberList() {
		
		//일반회원을 제외한 나머지 조회 --정지회원
		ArrayList<MemberBean> list = new ArrayList<MemberBean>();
		MemberBean MB = null;
		String sql = "select * from member where not suspendedNum = 1";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					MB = new MemberBean();
					MB.setId(rs.getString(1));
					MB.setPassword(rs.getString(2));
					MB.setName(rs.getString(3));
					MB.setNickname(rs.getString(4));
					MB.setEmail(rs.getString(5));

					list.add(MB);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("FoodList" + e);
		} finally {
			try {
				close(pstmt);
				close(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int CancelSuspension(String forCancel) {
		//정지당한 회원 정지 풀어주기
		int result = 0;
		String sql = "update member set suspendedNum=1 where id=?";
		
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, forCancel);
			result = pstmt.executeUpdate();

			if (result > 0) {
				result = 1;
			} else {
				result = 0;
			}

		} catch (Exception e) {
			System.out.println("CancelSuspension 메소드 오류 : " + e);
		} finally {
			try {
				close(pstmt);
				close(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// place테이블의 컬림인 course_num에 해당하는 코스 출력
	public ArrayList<CourseBean> SearchList(String key) {
		ArrayList<CourseBean> flist = new ArrayList<CourseBean>();
		ArrayList<CourseBean> nlist = new ArrayList<CourseBean>();
		String sql = "select course_num from editor where content like ?";
		String sql1 = "select * from course_detail where course_num=?";
		System.out.println("검색어 dao 메소드");
		try {	//검색
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + key + "%");

			rs = pstmt.executeQuery();
			System.out.println("검색어 dao 메소드 while문 전");
			while (rs.next()) {
				System.out.println("검색어 dao 메소드 while문 안");
				CourseBean pb = new CourseBean();

				pb.setCourse_num(rs.getInt(1));

				nlist.add(pb);
			}
			System.out.println("검색어 dao 메소드 for문 전");
			for (int i = 0; i < nlist.size(); i++) {
				System.out.println("검색어 dao 메소드 for문 안");
				pstmt = con.prepareStatement(sql1);

				pstmt.setInt(1, nlist.get(i).getCourse_num());
				rs = pstmt.executeQuery();
				if (rs.next()) {		//해당 된 정보를 담음
					CourseBean cb = new CourseBean();

					cb.setCourse_num(rs.getInt(1));
					cb.setCourse_name(rs.getString(2));
					cb.setCourse_location(rs.getString(3));
					cb.setCourse_place_name(rs.getString(4));
					cb.setCourse_place_tel(rs.getInt(5));
					cb.setCourse_post_date(rs.getDate(6));
					cb.setCourse_like(rs.getInt(7));
					cb.setCourse_search_keyword(rs.getString(8));
					cb.setPhoto(rs.getString(9));
					cb.setContent(rs.getString(10));

					flist.add(cb);
				}
			}

			System.out.println("2");
		} catch (Exception e) {
			System.out.println("SearchList" + e);
		} finally {
			try {
				close(pstmt);
				close(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flist;
	}

	//코스 정보 삽입
	public int insertEditor(EditorBean ed) {
		int num = 0;
		int result = 0;
		String sql1 = "select max(course_num) from course_detail";
		String sql2 = "insert into editor values (?, ?, ?, ?, ?, ?, ?)";
		String sql3 = "update course_detail set photo=? where course_num = (select max(course_num) from course_detail)";
		//리스트 썸네일

		try {

			pstmt = con.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt(1);
			}

			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, num);
			pstmt.setString(2, "se2/Insert/" + ed.getImage1());
			pstmt.setString(3, "se2/Insert/" + ed.getImage2());
			pstmt.setString(4, "se2/Insert/" + ed.getImage3());
			pstmt.setString(5, "se2/Insert/" + ed.getImage4());
			pstmt.setString(6, "se2/Insert/" + ed.getImage5());
			pstmt.setString(7, ed.getContent());

			result = pstmt.executeUpdate();

			pstmt = con.prepareStatement(sql3);
			pstmt.setString(1, "se2/Insert/" + ed.getImage1());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("insertEditor" + e);
		} finally {
			try {
				close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public EditorBean viewEditor(int course_num) {
		EditorBean eb = null;
		String sql = "select * from editor where course_num=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, course_num);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				eb = new EditorBean();
				eb.setCourse_num(rs.getInt(1));
				eb.setImage1(rs.getString(2));
				eb.setImage2(rs.getString(3));
				eb.setImage3(rs.getString(4));
				eb.setImage4(rs.getString(5));
				eb.setImage5(rs.getString(6));
				eb.setContent(rs.getString(7));

			}
		} catch (Exception e) {
			System.out.println("viewEditor" + e);
		} finally {
			try {
				close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return eb;
	}

}

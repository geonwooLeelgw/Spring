package bean;

import java.sql.Date;

public class CourseBean {

	private int course_num = 1;
	private String course_name;
	private String course_location;
	private String course_place_name;
	private int course_place_tel;
	private Date course_post_date;
	private int course_like = 0;
	private String course_search_keyword;
	private String photo;
	private String content;
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getCourse_num() {
		return course_num;
	}
	public void setCourse_num(int course_num) {
		this.course_num = course_num;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCourse_location() {
		return course_location;
	}
	public void setCourse_location(String course_location) {
		this.course_location = course_location;
	}
	public String getCourse_place_name() {
		return course_place_name;
	}
	public void setCourse_place_name(String course_place_name) {
		this.course_place_name = course_place_name;
	}
	public int getCourse_place_tel() {
		return course_place_tel;
	}
	public void setCourse_place_tel(int course_place_tel) {
		this.course_place_tel = course_place_tel;
	}
	public Date getCourse_post_date() {
		return course_post_date;
	}
	public void setCourse_post_date(Date course_post_date) {
		this.course_post_date = course_post_date;
	}
	public int getCourse_like() {
		return course_like;
	}
	public void setCourse_like(int course_like) {
		this.course_like = course_like;
	}
	public String getCourse_search_keyword() {
		return course_search_keyword;
	}
	public void setCourse_search_keyword(String course_search_keyword) {
		this.course_search_keyword = course_search_keyword;
	}
	
	
	
	
	
}

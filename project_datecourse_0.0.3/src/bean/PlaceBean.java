package bean;

public class PlaceBean {
	 private int place_num;
	 private String place_name;
	 private String place_location;
	 private String place_tel;
	 private String place_content;
	 private int course_num;
	 
	 public int getCourse_num() {
		return course_num;
	}
	public void setCourse_num(int course_num) {
		this.course_num = course_num;
	}
	public int getPlace_num() {
		return place_num;
	}
	public void setPlace_num(int place_num) {
		this.place_num = place_num;
	}
	public String getPlace_name() {
		return place_name;
	}
	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
	public String getPlace_location() {
		return place_location;
	}
	public void setPlace_location(String place_location) {
		this.place_location = place_location;
	}
	public String getPlace_content() {
		return place_content;
	}
	public void setPlace_content(String place_content) {
		this.place_content = place_content;
	}
	public String getPlace_tel() {
		return place_tel;
	}
	public void setPlace_tel(String place_tel) {
		this.place_tel = place_tel;
	}
}

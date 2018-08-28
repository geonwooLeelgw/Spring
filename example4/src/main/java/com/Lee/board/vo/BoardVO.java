package com.Lee.board.vo;

import java.sql.Date;

public class BoardVO {

	private int board_num;//글 번호1
	private String board_name;//글쓴이2
	private String board_pass;//글 비밀번호3
	private String board_subject;//글 제목4
	private String board_content;//글 내용5
	private String board_file;//처부파일 명6
	private int board_re_ref;//답글(원글 번호)7
	private int board_re_lev;//답글 레벨8
	private int board_re_seq;//답글의 출력순서9
	private int board_readcount;//조회수10
	private Date date;//작성일자11
	
	
	@Override
	public String toString() {
		return "BoardVO [board_num=" + board_num + ", board_name=" + board_name + ", board_pass=" + board_pass
				+ ", board_subject=" + board_subject + ", board_content=" + board_content + ", board_file=" + board_file
				+ ", board_re_ref=" + board_re_ref + ", board_re_lev=" + board_re_lev + ", board_re_seq=" + board_re_seq
				+ ", board_readcount=" + board_readcount + ", date=" + date + "]";
	}
	
	public BoardVO(int board_num, String board_name, String board_pass, String board_subject, String board_content, String board_file
			,int board_re_ref,int board_re_lev,int board_re_seq,int board_readcount,Date date) {
		this.board_num = board_num;
		this.board_name = board_name;
		this.board_pass = board_pass;
		this.board_subject = board_subject;
		this.board_content = board_content;
		this.board_file = board_file;
		this.board_re_ref = board_re_ref;
		this.board_re_lev = board_re_lev;
		this.board_re_seq = board_re_seq;
		this.board_readcount = board_readcount;
		this.date = date;
	}
	
	
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getBoard_pass() {
		return board_pass;
	}
	public void setBoard_pass(String board_pass) {
		this.board_pass = board_pass;
	}
	public String getBoard_subject() {
		return board_subject;
	}
	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_file() {
		return board_file;
	}
	public void setBoard_file(String board_file) {
		this.board_file = board_file;
	}
	public int getBoard_re_ref() {
		return board_re_ref;
	}
	public void setBoard_re_ref(int board_re_ref) {
		this.board_re_ref = board_re_ref;
	}
	public int getBoard_re_lev() {
		return board_re_lev;
	}
	public void setBoard_re_lev(int board_re_lev) {
		this.board_re_lev = board_re_lev;
	}
	public int getBoard_re_seq() {
		return board_re_seq;
	}
	public void setBoard_re_seq(int board_re_seq) {
		this.board_re_seq = board_re_seq;
	}
	public int getBoard_readcount() {
		return board_readcount;
	}
	public void setBoard_readcount(int board_readcount) {
		this.board_readcount = board_readcount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}

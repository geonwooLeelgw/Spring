package com.Lee.board.vo;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {

	private int bId;//글 번호
	private String bName;//글쓴이
	private String bTitle;//글제목
	private String bContent;//글내용
	private Date bDate;
	private int bHit;
	
	private MultipartFile bFile;
	private String bFileName;
	
	
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	public int getbHit() {
		return bHit;
	}
	public void setbHit(int bHit) {
		this.bHit = bHit;
	}
	public MultipartFile getbFile() {
		return bFile;
	}
	public void setbFile(MultipartFile bFile) {
		this.bFile = bFile;
	}
	public String getbFileName() {
		return bFileName;
	}
	public void setbFileName(String bFileName) {
		this.bFileName = bFileName;
	}
	
	
	
	/*public BoardVO(int bid, String bname, String btitle, String bcontent, Date bdate, int bhit, String bfile) {
		this.bid = bid;
		this.bname = bname;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bdate = bdate;
		this.bhit = bhit;
		
	}*/

	
	
}

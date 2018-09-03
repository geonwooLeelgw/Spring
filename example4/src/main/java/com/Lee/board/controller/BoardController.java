package com.Lee.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

//import java.io.IOException;
//import java.text.DateFormat;

//import java.util.Date;
/*import java.util.List;*/
//import java.util.Locale;

//import javax.security.auth.message.callback.PrivateKeyCallback.Request;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletResponse;

//import javax.xml.ws.Response;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.Lee.board.service.BoardService;
import com.Lee.board.vo.BoardVO;


@Controller
public class BoardController {
	
	/*
	 * 별도의 객체를 생성하지 않고도 자동으로 객체를 주입하여 사용할 수 있도록 하는 어노테이션
	 * 스프링의 특징 중 하나인 의존성 주입(Dependency Injection)을 구현하는 개념
	 * @Autowired를 붙이면 스프링 컨테이너가 자동으로 관리 함.
	 */
	@Autowired
	private BoardService bs;
	private ModelAndView mav;
	
	//첫페이지
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "redirect:/boardList";
	}
	//목록으로!
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public ModelAndView boardList() throws IOException {
		mav = new ModelAndView();
		mav = bs.boardList();
		
		return mav;
	}
	
	//글쓰기 jsp로 가즈아~!
	@RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
	public String boardWrite() {
		
		return "boardWrite";
	}
	//글 쓰기
	@RequestMapping(value = "/boardWritePro", method=RequestMethod.POST)
	public ModelAndView boardWritePro(@ModelAttribute BoardVO boardVO) throws IOException {
		mav = new ModelAndView();
		
		MultipartFile bfile = boardVO.getbFile();
		if(!bfile.isEmpty()) {
			String fileName = bfile.getOriginalFilename(); // 파일 이름 가져오기
			bfile.transferTo(new File("C:\\Users\\user\\git\\Spring\\example4\\src\\main\\webapp\\WEB-INF\\upload\\"+fileName)); // 파일을 관리할 경로
	
		}
		
		boardVO.setbFileName(bfile.getOriginalFilename());
		
		mav = bs.boardWrite(boardVO);
		return mav;
	}	
	//상세 보기
	@RequestMapping(value = "/boardView", method = RequestMethod.GET)
	public ModelAndView boardView(@RequestParam("bId") int bId) {
		mav = new ModelAndView();
		mav = bs.boardView(bId);
		
		return mav;
	}
	//게시물 삭제
	@RequestMapping(value = "/baordDelete", method = RequestMethod.GET)
	public ModelAndView boardDel(@RequestParam("bId") int bId) {
		mav = new ModelAndView();
		mav = bs.boardDel(bId);
		return mav;
	}
	//게시물 수정 값 불러오기
	@RequestMapping(value = "/boardUpdate", method = RequestMethod.GET)
	public ModelAndView boardUpdateView(@RequestParam("bId") int bId) {
		mav = new ModelAndView();
		mav = bs.boardUpdateView(bId);
		return mav;
	}
	//게시물 수정
	@RequestMapping(value = "/boardUpdateWritePro", method = RequestMethod.POST)
	public ModelAndView boardUpdate(@ModelAttribute BoardVO boardVO) {
		mav = new ModelAndView();
		mav = bs.boardUpdate(boardVO);
		return mav;
	}
	@RequestMapping(value = "/boardFileDown", method = RequestMethod.GET)
	public void fileDown(@RequestParam("bFileName") String bFileName, HttpServletResponse response) throws Exception {
		
		//무조건 팝업창 뜨게 하는!
		response.setContentType("application/octet-stream");	
		String Orgname = new String(bFileName.getBytes("UTF-8"), "iso-8859-1");
		
		//파일명 지정(스펠링 중요)
		response.setHeader("Content-Disposition", "attachment;filename=\""+Orgname+"\"");
		
		OutputStream os = response.getOutputStream();
		String path = "C:\\Users\\user\\git\\Spring\\example4\\src\\main\\webapp\\WEB-INF\\upload\\";
		FileInputStream fis = new FileInputStream(path+File.separator+bFileName);
		int n = 0;
		byte[] b = new byte[512];
		while((n = fis.read(b))!=-1) {
			os.write(b, 0, n);
		}
		fis.close();
		os.close();
	/*	String fileName = request.getParameter("downFile");
		
		String savePath = "boardUpload";
		
		ServletContext context = request.getServletContext();
		//서버 상의 실제 경로를 가져오는 부분
		String sDownloadPath = context.getRealPath(savePath);
		//다운로드 할 파일의 전체 경로값을 지정하는 부분
		String sFilePath = sDownloadPath+"\\"+fileName;
		//한번에 읽고 출력할 사이즈를 지정
		byte b[] = new byte[4096];
		FileInputStream in = new FileInputStream(sFilePath);
		String sMimeType = request.getServletContext().getMimeType(sFilePath);
		System.out.println("sMimeType>>"+sMimeType);
		
		
		if(sMimeType == null)
			sMimeType = "applicaton/octet-stream";
		
		response.setContentType(sMimeType);
		String agent = request.getHeader("User-Agent");
		
		boolean ieBrowser = (agent.indexOf("MSIE")>-1)
							|| (agent.indexOf("Trident")>-1);
		
		//브라우저 종류에 따라 파일 명이 깨지지 않도록 처리하는 부분
		if(ieBrowser){
			fileName = URLEncoder.encode(fileName,"UTF-8").replaceAll("\\+","%20");//%20은 공백처리 용도
		} else {
			fileName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
		}
		
		response.setHeader("Content-Disposition", 
							"attachment; filename="+fileName);
		
		ServletOutputStream out2 =response.getOutputStream();
		int numRead;
		
		while((numRead = in.read(b,0,b.length))!=-1){
			out2.write(b,0,numRead);
		}
		out2.flush();
		out2.close();
		in.close();*/
		
		
	}
}

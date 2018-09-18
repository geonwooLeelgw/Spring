package com.with.project.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.with.project.dao.CreateRoomDAO;
import com.with.project.vo.RoomVO;

@Service
public class CreateRoomService {
	
	@Autowired
	private CreateRoomDAO CreateRoomDAO;
	private ModelAndView mav;
	//private RoomVO roomVO;
	
	//방만들기 처음!
	public ModelAndView CreateRoom(RoomVO roomVO) {
		mav = new ModelAndView();
		String RoomId = CreateRoomDAO.MaxId();
		if(RoomId == null) {
			roomVO.setRoomId(1);
		}else {
			int Roomid = Integer.parseInt(RoomId);
			Roomid = Roomid+1;
			roomVO.setRoomId(Roomid);
		}
		//System.out.println(RoomId);
		
		//int InsertRoomId = roomVO.getRoomid(); 
		
		int result = CreateRoomDAO.CreateRoom(roomVO);
		//System.out.println(result);
		if (result == 0) {
			mav.setViewName("home");
		} else {
			//System.out.println(roomVO.getPreDistance());
			//RoomVO RoomV = CreateRoomDAO.RoomList(InsertRoomId);
			mav.addObject("Room", roomVO);
			mav.setViewName("CreateRoom");
		}
		return mav;
	}
	//방만들기 성별, 최대인원 추가하기
	public ModelAndView CreateRealRoom(RoomVO roomVO) {
		mav = new ModelAndView();
		
		int result = CreateRoomDAO.CreateRealRoom(roomVO);
		if(result==0) {
			mav.setViewName("home");
		}else {
			RoomVO roomVO2 = CreateRoomDAO.SelectRoom(roomVO);
			
			//예상 가격을 가져와서 원 의 인덱스 값을 가져온다.
			int idx = roomVO2.getPreMoney().indexOf("원");
			System.out.println("1:"+idx);
			//원 부터 뒤에 글자는 모두 자른다.
			String money = roomVO2.getPreMoney().substring(0, idx);
			System.out.println("2:"+money);
			//int로 형변환
			int money1 = Integer.parseInt(money);
			//int 값이기때문에 나눌수 있다.
			money1 /= Integer.parseInt(roomVO2.getMaximum());
			//다시 setPreMoney에 넣어야하기 때문에 String 으로 형변환
			String money2 = Integer.toString(money1);
			System.out.println("3:"+money2);
			//다시 값을 넣는다.
			//roomVO2.setPreMoney(money2);
			roomVO2.setFinalMoney(money2);
			
			//따로 한번 더 넣어주는 작업
			CreateRoomDAO.CreateRealRoom2(roomVO2);
			
			
			mav.addObject("Room", roomVO2);
			mav.setViewName("room");
		}
		return mav;
	
	}
	public ModelAndView ReservationRoom(RoomVO roomVO) {
		mav = new ModelAndView();
		int result = CreateRoomDAO.ReservationRoom(roomVO);
		if(result==0) {
			mav.setViewName("home");
		}else {
			RoomVO roomVO2 = CreateRoomDAO.SelectRoom(roomVO);
			
			//예상 가격을 가져와서 원 의 인덱스 값을 가져온다.
			int idx = roomVO2.getPreMoney().indexOf("원");
			//System.out.println("1:"+idx);
			//원 부터 뒤에 글자는 모두 자른다.
			String money = roomVO2.getPreMoney().substring(0, idx);
			//System.out.println("2:"+money);
			//int로 형변환
			int money1 = Integer.parseInt(money);
			//int 값이기때문에 나눌수 있다.
			money1 /= Integer.parseInt(roomVO2.getMaximum());
			//다시 setPreMoney에 넣어야하기 때문에 String 으로 형변환
			String money2 = Integer.toString(money1);
			//System.out.println("3:"+money2);
			//다시 값을 넣는다.
			roomVO2.setPreMoney(money2);
			
			mav.addObject("Room", roomVO2);
			mav.setViewName("Reservation");
		}
		return mav;
	}
	public ModelAndView RoomList() {
		mav = new ModelAndView();
		List<RoomVO> RoomList = CreateRoomDAO.RoomList();
		
		mav.addObject("RoomList", RoomList);
		mav.setViewName("RoomList");
				
		return mav;
	}
	public ModelAndView RoomInfo(RoomVO roomVO,HttpSession session,HttpServletResponse response) throws IOException {
		mav = new ModelAndView();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = (String) session.getAttribute("id");
		String max = CreateRoomDAO.selectMax(roomVO);
		//기사 / 유저 :해야 할 것
		
		//성별 :해야할것 
		
		
		if (max.equals("2")) {
			String rId1 = CreateRoomDAO.SelectId1(roomVO);
			if (rId1 == null) {
				roomVO.setrId1(id);
				CreateRoomDAO.UpdateId1(roomVO);
				RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
				mav.addObject("Room", roomVO2);
				mav.setViewName("room");
			} else {
				String rId2 = CreateRoomDAO.SelectId2(roomVO);
				if (rId2 == null) {
					roomVO.setrId2(id);
					CreateRoomDAO.UpdateId2(roomVO);
					RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
					mav.addObject("Room", roomVO2);
					mav.setViewName("room");
				} else {
					out.println("<script>");
					out.println("alert('인원이 꽉 찼습니다. 다른 방을 이용해주세용.');");
					out.println("history.go(-1);");
					out.println("</script>");
					out.close();
					mav.setViewName("redirect:RoomList");
				}
			}
		} else if (max.equals("3")) {
			String rId1 = CreateRoomDAO.SelectId1(roomVO);
			if (rId1 == null) {
				roomVO.setrId1(id);
				CreateRoomDAO.UpdateId1(roomVO);
				RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
				mav.addObject("Room", roomVO2);
				mav.setViewName("room");
			} else {
				String rId2 = CreateRoomDAO.SelectId2(roomVO);
				if (rId2 == null) {
					roomVO.setrId2(id);
					CreateRoomDAO.UpdateId2(roomVO);
					RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
					mav.addObject("Room", roomVO2);
					mav.setViewName("room");
				} else {
					String rId3 = CreateRoomDAO.selectId3(roomVO);
					if (rId3 == null) {
						roomVO.setrId3(id);
						CreateRoomDAO.UpdateId3(roomVO);
						RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
						mav.addObject("Room", roomVO2);
						mav.setViewName("room");
					} else {
						out.println("<script>");
						out.println("alert('인원이 꽉 찼습니다. 다른 방을 이용해주세용.');");
						out.println("history.go(-1);");
						out.println("</script>");
						out.close();
						mav.setViewName("redirect:RoomList");
					}
				}
			}
		} else if (max.equals("4")) {
			String rId1 = CreateRoomDAO.SelectId1(roomVO);
			if (rId1 == null) {
				roomVO.setrId1(id);
				CreateRoomDAO.UpdateId1(roomVO);
				RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
				mav.addObject("Room", roomVO2);
				mav.setViewName("room");
			} else {
				String rId2 = CreateRoomDAO.SelectId2(roomVO);
				if (rId2 == null) {
					roomVO.setrId2(id);
					CreateRoomDAO.UpdateId2(roomVO);
					RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
					mav.addObject("Room", roomVO2);
					mav.setViewName("room");
				} else {
					String rId3 = CreateRoomDAO.selectId3(roomVO);
					if (rId3 == null) {
						roomVO.setrId3(id);
						CreateRoomDAO.UpdateId3(roomVO);
						RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
						mav.addObject("Room", roomVO2);
						mav.setViewName("room");
					} else {
						String rId4 = CreateRoomDAO.selectId4(roomVO);
						if (rId4 == null) {
							roomVO.setrId4(id);
							CreateRoomDAO.UpdateId4(roomVO);
							RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
							mav.addObject("Room", roomVO2);
							mav.setViewName("room");
						} else {
							out.println("<script>");
							out.println("alert('인원이 꽉 찼습니다. 다른 방을 이용해주세용.');");
							out.println("history.go(-1);");
							out.println("</script>");
							out.close();
							mav.setViewName("redirect:RoomList");
						}
					}
				}
			}
		}
		
		return mav;
	}
	public ModelAndView RoomOut(RoomVO roomVO, HttpSession session, HttpServletResponse response) throws IOException {
		mav = new ModelAndView();
		String id = (String) session.getAttribute("id");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//자신의 id 값과 room table db에 있는 값을 비교한 후 db에 있는 값과 같다면 null 값을 만든다.
		//비교 하려면 List 와 반복문을 사용한다.
		
		//DB에 ID 값이 들어있는데 그값을 찾기 위한 리스트!
		RoomVO RoomRid = CreateRoomDAO.RoomOutList(roomVO);
		if(RoomRid.getrId1().equals(id)) {
			CreateRoomDAO.RoomOutListDel(roomVO);
			mav.setViewName("redirect:RoomList");
			out.println("<script>");
			out.println("alert('방장이 방을 나가면 방이 삭제 됩니다.');");
			out.println("location.href='RoomList';");
			out.println("</script>");
			out.close();
		}else if(RoomRid.getrId2().equals(id)) {
			CreateRoomDAO.RoomOutRid2(roomVO);
			mav.setViewName("redirect:RoomList");
		}else if(RoomRid.getrId3().equals(id)) {
			CreateRoomDAO.RoomOutRid3(roomVO);
			mav.setViewName("redirect:RoomList");
		}else if(RoomRid.getrId4().equals(id)) {
			CreateRoomDAO.RoomOutRid4(roomVO);
			mav.setViewName("redirect:RoomList");
		}
		
		return mav;
	}

	
}

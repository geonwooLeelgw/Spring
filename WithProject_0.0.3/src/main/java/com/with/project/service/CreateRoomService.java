package com.with.project.service;

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
		int RoomId = CreateRoomDAO.MaxId();
		//System.out.println(RoomId);
		roomVO.setRoomId(RoomId+1);
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

	
}

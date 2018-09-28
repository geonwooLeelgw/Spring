/*package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.with.project.vo.MemberVO;
import com.with.project.vo.PayVO;
import com.with.project.vo.RoomVO;

public class backup {

	public ModelAndView RoomInfo(RoomVO roomVO,HttpSession session,HttpServletResponse response,PayVO payVO) throws IOException {
		mav = new ModelAndView();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = (String) session.getAttribute("id");
		MemberVO memberVO = CreateRoomDAO.MemberGender(id);
		RoomVO room = CreateRoomDAO.roomS(roomVO);
		String max = CreateRoomDAO.selectMax(roomVO);
		//기사 / 유저
		//1이면 유저 2는 기사
		int UserPass = memberVO.getPassuser();
		System.out.println(id);
		System.out.println("유저패스 값:"+UserPass);
		if(UserPass == 1) {				
				System.out.println("하나라도 다르면");
				//성별
				String memberGender = memberVO.getGender();
				String RoomOpGender = room.getOpGender();
				if(memberGender.equals(RoomOpGender) || RoomOpGender.equals("noProblem")) {
				if (max.equals("2")) {
					System.out.println("1");
					String rId1 = CreateRoomDAO.SelectId1(roomVO);
					//1,2,3,4 컬럼에 null인지 아닌지 확인
					if (rId1 == null) {
						roomVO.setrId1(id);
						CreateRoomDAO.UpdateId1(roomVO);
						RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
						mav.addObject("Room", roomVO2);
						mav.setViewName("room");
						payVO.setId(id);
						payVO.setRoomId(roomVO.getRoomId());
						String OkChash = CreateRoomDAO.SelectOkChash(payVO);
						if(OkChash !=null) {
							PayVO pay =payDAO.SelectPayTable(payVO);
							mav.addObject("pay", pay);
							mav.addObject("Room", roomVO2);
							mav.setViewName("room");	
						}else {
							
							mav.addObject("Room", roomVO2);
							mav.setViewName("room");
						}
					} else {
						String rId2 = CreateRoomDAO.SelectId2(roomVO);
						if(rId1.equals(id)) {
							RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
							payVO.setId(id);
							payVO.setRoomId(roomVO.getRoomId());
							String OkChash = CreateRoomDAO.SelectOkChash(payVO);
							if(OkChash !=null) {
								PayVO pay =payDAO.SelectPayTable(payVO);
								mav.addObject("pay", pay);
								mav.addObject("Room", roomVO2);
								mav.setViewName("room");	
							}else {
								mav.addObject("Room", roomVO2);
								mav.setViewName("room");
							}
						}
						else if (rId2 == null) {
							roomVO.setrId2(id);
							CreateRoomDAO.UpdateId2(roomVO);
							RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
							payVO.setId(id);
							payVO.setRoomId(roomVO.getRoomId());
							String OkChash = CreateRoomDAO.SelectOkChash(payVO);
							if(OkChash !=null) {
								PayVO pay =payDAO.SelectPayTable(payVO);
								mav.addObject("pay", pay);
								mav.addObject("Room", roomVO2);
								mav.setViewName("room");	
							}else {
								mav.addObject("Room", roomVO2);
								mav.setViewName("room");
							}
						}else if(rId2.equals(id)) {
							RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
							payVO.setId(id);
							payVO.setRoomId(roomVO.getRoomId());
							String OkChash = CreateRoomDAO.SelectOkChash(payVO);
							if(OkChash !=null) {
								PayVO pay =payDAO.SelectPayTable(payVO);
								mav.addObject("pay", pay);
								mav.addObject("Room", roomVO2);
								mav.setViewName("room");	
							}else {
								mav.addObject("Room", roomVO2);
								mav.setViewName("room");
							}
						}
						else {
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
						payVO.setId(id);
						payVO.setRoomId(roomVO.getRoomId());
						String OkChash = CreateRoomDAO.SelectOkChash(payVO);
						if(OkChash !=null) {
							PayVO pay =payDAO.SelectPayTable(payVO);
							mav.addObject("pay", pay);
							mav.addObject("Room", roomVO2);
							mav.setViewName("room");	
						}else {
							mav.addObject("Room", roomVO2);
							mav.setViewName("room");
						}
					} else {
						String rId2 = CreateRoomDAO.SelectId2(roomVO);
						if(rId1.equals(id)) {
							RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
							payVO.setId(id);
							payVO.setRoomId(roomVO.getRoomId());
							String OkChash = CreateRoomDAO.SelectOkChash(payVO);
							if(OkChash !=null) {
								PayVO pay =payDAO.SelectPayTable(payVO);
								mav.addObject("pay", pay);
								mav.addObject("Room", roomVO2);
								mav.setViewName("room");	
							}else {
								mav.addObject("Room", roomVO2);
								mav.setViewName("room");
							}
						}
						else if (rId2 == null) {
							roomVO.setrId2(id);
							CreateRoomDAO.UpdateId2(roomVO);
							RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
							payVO.setId(id);
							payVO.setRoomId(roomVO.getRoomId());
							String OkChash = CreateRoomDAO.SelectOkChash(payVO);
							if(OkChash !=null) {
								PayVO pay =payDAO.SelectPayTable(payVO);
								mav.addObject("pay", pay);
								mav.addObject("Room", roomVO2);
								mav.setViewName("room");	
							}else {
								mav.addObject("Room", roomVO2);
								mav.setViewName("room");
							}
						}else if(rId2.equals(id)) {
							RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
							payVO.setId(id);
							payVO.setRoomId(roomVO.getRoomId());
							String OkChash = CreateRoomDAO.SelectOkChash(payVO);
							if(OkChash !=null) {
								PayVO pay =payDAO.SelectPayTable(payVO);
								mav.addObject("pay", pay);
								mav.addObject("Room", roomVO2);
								mav.setViewName("room");	
							}else {
								mav.addObject("Room", roomVO2);
								mav.setViewName("room");
							}
						}
						else {
							String rId3 = CreateRoomDAO.selectId3(roomVO);
							if(rId3 == null) {
								roomVO.setrId3(id);
								CreateRoomDAO.UpdateId3(roomVO);
								RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
								payVO.setId(id);
								payVO.setRoomId(roomVO.getRoomId());
								String OkChash = CreateRoomDAO.SelectOkChash(payVO);
								if(OkChash !=null) {
									PayVO pay =payDAO.SelectPayTable(payVO);
									mav.addObject("pay", pay);
									mav.addObject("Room", roomVO2);
									mav.setViewName("room");	
								}else {
									mav.addObject("Room", roomVO2);
									mav.setViewName("room");
								}
							}else if(rId3.equals(id)) {
								RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
								payVO.setId(id);
								payVO.setRoomId(roomVO.getRoomId());
								String OkChash = CreateRoomDAO.SelectOkChash(payVO);
								if(OkChash !=null) {
									PayVO pay =payDAO.SelectPayTable(payVO);
									mav.addObject("pay", pay);
									mav.addObject("Room", roomVO2);
									mav.setViewName("room");	
								}else {
									mav.addObject("Room", roomVO2);
									mav.setViewName("room");
								}
							}
							else {
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
						payVO.setId(id);
						payVO.setRoomId(roomVO.getRoomId());
						String OkChash = CreateRoomDAO.SelectOkChash(payVO);
						if(OkChash !=null) {
							PayVO pay =payDAO.SelectPayTable(payVO);
							mav.addObject("pay", pay);
							mav.addObject("Room", roomVO2);
							mav.setViewName("room");	
						}else {
							mav.addObject("Room", roomVO2);
							mav.setViewName("room");
						}
					} else {
						String rId2 = CreateRoomDAO.SelectId2(roomVO);
						String rId3 = CreateRoomDAO.selectId3(roomVO);
						String rId4 = CreateRoomDAO.selectId4(roomVO);
						if(rId1.equals(id)){
							RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
							payVO.setId(id);
							payVO.setRoomId(roomVO.getRoomId());
							String OkChash = CreateRoomDAO.SelectOkChash(payVO);
							if(OkChash !=null) {
								PayVO pay =payDAO.SelectPayTable(payVO);
								mav.addObject("pay", pay);
								mav.addObject("Room", roomVO2);
								mav.setViewName("room");	
							}else {
								mav.addObject("Room", roomVO2);
								mav.setViewName("room");
							}
						}else if(rId2.equals(id)) {
							RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
							payVO.setId(id);
							payVO.setRoomId(roomVO.getRoomId());
							String OkChash = CreateRoomDAO.SelectOkChash(payVO);
							if(OkChash !=null) {
								PayVO pay =payDAO.SelectPayTable(payVO);
								mav.addObject("pay", pay);
								mav.addObject("Room", roomVO2);
								mav.setViewName("room");	
							}else {
								mav.addObject("Room", roomVO2);
								mav.setViewName("room");
							}
						}else if(rId3.equals(id)) {
							RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
							payVO.setId(id);
							payVO.setRoomId(roomVO.getRoomId());
							String OkChash = CreateRoomDAO.SelectOkChash(payVO);
							if(OkChash !=null) {
								PayVO pay =payDAO.SelectPayTable(payVO);
								mav.addObject("pay", pay);
								mav.addObject("Room", roomVO2);
								mav.setViewName("room");	
							}else {
								mav.addObject("Room", roomVO2);
								mav.setViewName("room");
							}
						}else if(rId4.equals(id)) {
							RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
							payVO.setId(id);
							payVO.setRoomId(roomVO.getRoomId());
							String OkChash = CreateRoomDAO.SelectOkChash(payVO);
							if(OkChash !=null) {
								PayVO pay =payDAO.SelectPayTable(payVO);
								mav.addObject("pay", pay);
								mav.addObject("Room", roomVO2);
								mav.setViewName("room");	
							}else {
								mav.addObject("Room", roomVO2);
								mav.setViewName("room");
							}
						}
						if (rId2 == null) {
							roomVO.setrId2(id);
							CreateRoomDAO.UpdateId2(roomVO);
							RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
							payVO.setId(id);
						 	payVO.setRoomId(roomVO.getRoomId());
							String OkChash = CreateRoomDAO.SelectOkChash(payVO);
							if(OkChash !=null) {
								PayVO pay =payDAO.SelectPayTable(payVO);
								mav.addObject("pay", pay);
								mav.addObject("Room", roomVO2);
								mav.setViewName("room");	
							}else {
								mav.addObject("Room", roomVO2);
								mav.setViewName("room");
							}
						}
						else {
							//String rId2 = CreateRoomDAO.SelectId2(roomVO);
							//String rId3 = CreateRoomDAO.selectId3(roomVO);
							//String rId4 = CreateRoomDAO.selectId4(roomVO);
							if(rId1.equals(id)){
								RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
								payVO.setId(id);
								payVO.setRoomId(roomVO.getRoomId());
								String OkChash = CreateRoomDAO.SelectOkChash(payVO);
								if(OkChash !=null) {
									PayVO pay =payDAO.SelectPayTable(payVO);
									mav.addObject("pay", pay);
									mav.addObject("Room", roomVO2);
									mav.setViewName("room");	
								}else {
									mav.addObject("Room", roomVO2);
									mav.setViewName("room");
								}
							}else if(rId2.equals(id)) {
								RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
								payVO.setId(id);
								payVO.setRoomId(roomVO.getRoomId());
								String OkChash = CreateRoomDAO.SelectOkChash(payVO);
								if(OkChash !=null) {
									PayVO pay =payDAO.SelectPayTable(payVO);
									mav.addObject("pay", pay);
									mav.addObject("Room", roomVO2);
									mav.setViewName("room");	
								}else {
									mav.addObject("Room", roomVO2);
									mav.setViewName("room");
								}
							}else if(rId3.equals(id)) {
								RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
								payVO.setId(id);
								payVO.setRoomId(roomVO.getRoomId());
								String OkChash = CreateRoomDAO.SelectOkChash(payVO);
								if(OkChash !=null) {
									PayVO pay =payDAO.SelectPayTable(payVO);
									mav.addObject("pay", pay);
									mav.addObject("Room", roomVO2);
									mav.setViewName("room");	
								}else {
									mav.addObject("Room", roomVO2);
									mav.setViewName("room");
								}
							}else if(rId4.equals(id)) {
								RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
								payVO.setId(id);
								payVO.setRoomId(roomVO.getRoomId());
								String OkChash = CreateRoomDAO.SelectOkChash(payVO);
								if(OkChash !=null) {
									PayVO pay =payDAO.SelectPayTable(payVO);
									mav.addObject("pay", pay);
									mav.addObject("Room", roomVO2);
									mav.setViewName("room");	
								}else {
									mav.addObject("Room", roomVO2);
									mav.setViewName("room");
								}
							}
							//String rId3 = CreateRoomDAO.selectId3(roomVO);
								if (rId3 == null) {
								roomVO.setrId3(id);
								CreateRoomDAO.UpdateId3(roomVO);
								RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
								mav.addObject("Room", roomVO2);
								mav.setViewName("room");
								payVO.setId(id);
								payVO.setRoomId(roomVO.getRoomId());
								String OkChash = CreateRoomDAO.SelectOkChash(payVO);
								if(OkChash !=null) {
									PayVO pay =payDAO.SelectPayTable(payVO);
									mav.addObject("pay", pay);
									mav.addObject("Room", roomVO2);
									mav.setViewName("room");	
								}else {
									mav.addObject("Room", roomVO2);
									mav.setViewName("room");
								}
							}
							else {
								if(rId1.equals(id)){
									RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
									payVO.setId(id);
									payVO.setRoomId(roomVO.getRoomId());
									String OkChash = CreateRoomDAO.SelectOkChash(payVO);
									if(OkChash !=null) {
										PayVO pay =payDAO.SelectPayTable(payVO);
										mav.addObject("pay", pay);
										mav.addObject("Room", roomVO2);
										mav.setViewName("room");	
									}else {
										mav.addObject("Room", roomVO2);
										mav.setViewName("room");
									}
								}else if(rId2.equals(id)) {
									RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
									payVO.setId(id);
									payVO.setRoomId(roomVO.getRoomId());
									String OkChash = CreateRoomDAO.SelectOkChash(payVO);
									if(OkChash !=null) {
										PayVO pay =payDAO.SelectPayTable(payVO);
										mav.addObject("pay", pay);
										mav.addObject("Room", roomVO2);
										mav.setViewName("room");	
									}else {
										mav.addObject("Room", roomVO2);
										mav.setViewName("room");
									}
								}else if(rId3.equals(id)) {
									RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
									payVO.setId(id);
									payVO.setRoomId(roomVO.getRoomId());
									String OkChash = CreateRoomDAO.SelectOkChash(payVO);
									if(OkChash !=null) {
										PayVO pay =payDAO.SelectPayTable(payVO);
										mav.addObject("pay", pay);
										mav.addObject("Room", roomVO2);
										mav.setViewName("room");	
									}else {
										mav.addObject("Room", roomVO2);
										mav.setViewName("room");
									}
								}else if(rId4.equals(id)) {
									RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
									payVO.setId(id);
									payVO.setRoomId(roomVO.getRoomId());
									String OkChash = CreateRoomDAO.SelectOkChash(payVO);
									if(OkChash !=null) {
										PayVO pay =payDAO.SelectPayTable(payVO);
										mav.addObject("pay", pay);
										mav.addObject("Room", roomVO2);
										mav.setViewName("room");	
									}else {
										mav.addObject("Room", roomVO2);
										mav.setViewName("room");
									}
								}
								//String rId4 = CreateRoomDAO.selectId4(roomVO);
								if (rId4 == null) {
									roomVO.setrId4(id);
									CreateRoomDAO.UpdateId4(roomVO);
									RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
									mav.addObject("Room", roomVO2);
									mav.setViewName("room");
									payVO.setId(id);
									payVO.setRoomId(roomVO.getRoomId());
									String OkChash = CreateRoomDAO.SelectOkChash(payVO);
									if(OkChash !=null) {
										PayVO pay =payDAO.SelectPayTable(payVO);
										mav.addObject("pay", pay);
										mav.addObject("Room", roomVO2);
										mav.setViewName("room");	
									}else {
										mav.addObject("Room", roomVO2);
										mav.setViewName("room");
									}
								}
								else {
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
				}else {
					out.println("<script>");
					out.println("alert('성별 옵션을 잘 보고 입장해주세요.');");
					out.println("history.go(-1);");
					out.println("</script>");
					out.close();
					mav.setViewName("redirect:RoomList");
				}
				
		}else {
			//여기는 passUser가 2일때 기사일때 입장 여부!
			String DriverId = CreateRoomDAO.SelectDriverId(roomVO);
			if(DriverId == null) {
				roomVO.setDriverId(id);
				CreateRoomDAO.UpdateDriverId(roomVO);
				RoomVO roomVO2 = CreateRoomDAO.RoomInfo(roomVO);
				mav.addObject("Driver", 100);
				//기사가 들어왔을때 표시해주기 위해서.
				mav.addObject("Room", roomVO2);
				mav.setViewName("room");	
			}else {
				out.println("<script>");
				out.println("alert('이미 다른 기사님이 운행을 준비중 입니다.');");
				out.println("history.go(-1);");
				out.println("</script>");
				out.close();
				mav.setViewName("redirect:RoomList");
			}
			
		}
		return mav;
	}
	
}
*/
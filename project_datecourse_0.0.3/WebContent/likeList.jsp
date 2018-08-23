<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>

<html>

<head>
<meta charset="UTF-8">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>


<title>TEST</title>




</head>

<body>




	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">




		<div class="container">
			<ul class="nav">
				<li><a href="index.jsp"><img src="1.jpeg" height=35px; width="35px"></a>&nbsp;&nbsp;&nbsp;</li>
				
			</ul>
		</div>





		<div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
			<ul class="navbar-nav ml-auto">
<%-- 
				<%
					String id = (String) session.getAttribute("id");
					if (id != null && !(id.equals("admin"))) {
				%>
			 --%>	<li class="nav-item">

					<button type="button" class="btn btn-warning dropdown-toggle"
						data-toggle="dropdown">마이페이지</button>

				<%-- 	<div class="dropdown-menu dropdown-menu-right">

						<a class="dropdown-item"
							href="ChangedPersonalInfo.s?id=<%=session.getAttribute("id")%>">개인정보
							수정 및 보기 </a> <a class="dropdown-item" href="userLikeListAction.s">내가
							좋아요 누른 게시물보기</a> <a class="dropdown-item"
							href="AskedPasswordForDelete.jsp">회원 탈퇴</a>
					</div> --%>

				</li>
				<li class="nav-item">
					<button type="button" class="btn btn-danger" data-toggle="modal"
						data-target="#myModal2">로그아웃</button>
				</li>
			<%-- 	<%
					} else if (id == null) {
				%>
 --%>



				<li class="nav-item">
					<button type="button" class="btn btn-primary"
						onclick="location.href='SignUp.jsp'">회원가입</button>
				</li>
				<li class="nav-item">
					<button type="button" class="btn btn-success" data-toggle="modal"
						data-target="#myModal">로그인</button>


				</li>
	<%-- 			<%
					} else if (id.equals("admin")) {
				%>


 --%>













				<li class="nav-item">

					<button type="button" class="btn btn-warning dropdown-toggle"
						data-toggle="dropdown">관리자 전용</button>

					<div class="dropdown-menu dropdown-menu-right">

						<a class="dropdown-item" href="allMembersList.s">회원관리</a> <a
							class="dropdown-item" href="./InsertCourse.jsp">데이트코스 삽입</a>

					</div>

				</li>
				<li class="nav-item">
					<button type="button" class="btn btn-danger" data-toggle="modal"
						data-target="#myModal2">로그아웃</button>
				</li>



			</ul>
		</div>


























	<%-- 	<%
			}
		%>


 --%>

		




	</nav>





	<br>
	<div class="container">
		<br><br>
		<h4 style="text-align: center;">내가 좋아요한 리스트</h4>

		<table class="table" style="width: 1250px;">

			<thead class="thead-dark">
				<tr>
					<th scope="col">코스 번호</th>
					<th scope="col">코스 이름</th>
					<th scope="col">코스 지역</th>
					<th scope="col">장소 이름</th>
					<th scope="col">장소 연락번호</th>
					<th scope="col">작성날짜</th>
					<th scope="col">검색키워드</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="likeList" items="${likeList}">
					<tr>
						<td>${likeList.course_num}</td>
						<td><a href="courseView.s?course_num=${likeList.course_num}">${likeList.course_name}</a></td>
						<td>${likeList.course_location}</td>
						<td>${likeList.course_place_name}</td>
						<td>${likeList.course_place_tel}</td>
						<td>${likeList.course_post_date}</td>
						<td>${likeList.course_search_keyword}</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>











	</div>









		<!-- Modal2 -->
		<div id="myModal2" class="modal fade" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">

					<div class="modal-body" style="text-align: center;">



						<img class="mb-4" src="1.png" alt="" width="72" height="72">
						<p class="h3 mb-3 font-weight-normal">정말 로그아웃 하시겠어요?</p>

						<button type="button" class="btn btn-info"
							onclick="location.href='LogOut.s'">예</button>
						<button type="button" class="btn btn-danger"
							onclick="location.href='index.jsp'">아니요</button>




					</div>

</div>
</div>
</div>





					<!-- Modal2 -->
					<div id="myModal3" class="modal fade" role="dialog">
						<div class="modal-dialog">

							<!-- Modal content-->
							<div class="modal-content">

								<div class="modal-body" style="text-align: center;">



									<img class="mb-4" src="1.png" alt="" width="72" height="72">
									<p class="h3 mb-3 font-weight-normal">정말 로그아웃 하시겠어요?</p>

									<button type="button" class="btn btn-info"
										onclick="location.href='LogOut.s'">예</button>
									<button type="button" class="btn btn-danger"
										onclick="location.href='  <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
				            <ul class="navbar-nav ml-auto">
				            
					        <li class="nav-item">

					                    <button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown">    
					                관리자 전용
					                </button>

					                    <div class="dropdown-menu dropdown-menu-right">

					                        <a class="dropdown-item" href="allMembersList.s">회원관리</a>
					                        <a class="dropdown-item" href="./InsertCourse.jsp">데이트코스 삽입</a>
					                  
					                    </div>

					                </li>
					<li class="nav-item">
					                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal3">로그아웃</button>
					                </li>

					                </li>
					                
							
					            </ul>
					        </div>'">아니요</button>








								</div>






















								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
								</div>
							</div>

						</div>
					</div>
					




</body>
</html>


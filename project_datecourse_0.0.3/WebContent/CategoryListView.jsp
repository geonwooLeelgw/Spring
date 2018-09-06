<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="bean.EditorBean"%>
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
				<li><a href="index.jsp"><img src="1.jpeg" height=35px;
						width="35px"></a>&nbsp;&nbsp;&nbsp;</li>

			</ul>
		</div>







		<div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
			<ul class="navbar-nav ml-auto">

				<%
					String id = (String) session.getAttribute("id");
					if (id != null && !(id.equals("admin"))) {
				%>
				<li class="nav-item">

					<button type="button" class="btn btn-warning dropdown-toggle"
						data-toggle="dropdown">마이페이지</button>

					<div class="dropdown-menu dropdown-menu-right">

						<a class="dropdown-item"
							href="ChangedPersonalInfo.s?id=<%=session.getAttribute("id")%>">개인정보
							수정 및 보기 </a> <a class="dropdown-item" href="userLikeListAction.s">내가
							좋아요 누른 게시물보기</a> <a class="dropdown-item"
							href="AskedPasswordForDelete.jsp">회원 탈퇴</a>
					</div>

				</li>
				<li class="nav-item">
					<button type="button" class="btn btn-danger" data-toggle="modal"
						data-target="#myModal2">로그아웃</button>
				</li>
				<%
					} else if (id == null) {
				%>




				<li class="nav-item">
					<button type="button" class="btn btn-primary"
						onclick="location.href='SignUp.jsp'">회원가입</button>
				</li>
				<li class="nav-item">
					<button type="button" class="btn btn-success" data-toggle="modal"
						data-target="#myModal">로그인</button>


				</li>
				<%
					} else if (id.equals("admin")) {
				%>
















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


























		<%
			}
		%>









	</nav>





	<br>
	<br>
	<div class="container">

		<div class="blog-post">
			<h2 class="blog-post-title">${courseView.course_name }</h2>
			<p class="blog-post-meta">
				작성날짜 : ${courseView.course_post_date }
				<!-- by <a href="#">작성자 이름</a>  -->
				<br> <img src="image\like.JPG"
					style="height: 20px; width: 20px;"> ${courseView.course_like }개


			</p>
			<!-- se2/Insert/null -->
			 <c:choose>
	<c:when test="${likeBean.id == sessionScope.id}">
	　<button type="button" class="btn btn-danger"
					onclick="location.href='courseLikeNo.s?course_num=${courseView.course_num }'">좋아요
					취소</button>
	</c:when>
	
	<c:otherwise>
		　<button type="button" class="btn btn-primary"
					onclick="location.href='courseLike.s?course_num=${courseView.course_num }'">좋아요</button>
	</c:otherwise>
</c:choose>  




			<!--코스 자세히보기  -->
			<!--등록된 코스의 사진 띄워주기-->		
			<div align="center">
				<%
					EditorBean editor = (EditorBean) request.getAttribute("editor");
					if (editor.getImage1().equals("se2/Insert/null")) {
				%>
				<%
					} else if (editor.getImage2().equals("se2/Insert/null")) {
				%>
				<img alt="경로 잘못됨" src="${editor.image1 }" width="900" height="550"><br>

				<%
					} else if (editor.getImage3().equals("se2/Insert/null")) {
				%>
				<img alt="경로 잘못됨" src="${editor.image1 }" width="900" height="550"><br>
				<img alt="경로 잘못됨" src="${editor.image2 }" width="900" height="550"><br>
				<%
					} else if (editor.getImage4().equals("se2/Insert/null")) {
				%>
				<img alt="경로 잘못됨" src="${editor.image1 }" width="900" height="550"><br>
				<img alt="경로 잘못됨" src="${editor.image2 }" width="900" height="550"><br>
				<img alt="경로 잘못됨" src="${editor.image3 }" width="900" height="550"><br>
				<%
					} else if (editor.getImage5().equals("se2/Insert/null")) {
				%>
				<img alt="경로 잘못됨" src="${editor.image1 }" width="900" height="550"><br>
				<img alt="경로 잘못됨" src="${editor.image2 }" width="900" height="550"><br>
				<img alt="경로 잘못됨" src="${editor.image3 }" width="900" height="550"><br>
				<img alt="경로 잘못됨" src="${editor.image4 }" width="900" height="550"><br>
				<%
					} else {
				%>
				<img alt="경로 잘못됨" src="${editor.image1 }" width="900" height="550"><br>
				<img alt="경로 잘못됨" src="${editor.image2 }" width="900" height="550"><br>
				<img alt="경로 잘못됨" src="${editor.image3 }" width="900" height="550"><br>
				<img alt="경로 잘못됨" src="${editor.image4 }" width="900" height="550"><br>
				<img alt="경로 잘못됨" src="${editor.image5 }" width="900" height="550"><br>
				<%
					}
				%>


				<!-- 확인용: <img alt="경로 잘못됨" src="se2/Insert/2018_08_02_142230.jpg"><br> -->
				<%-- 여기가 경로값 : ${editor.image1 }<br>  --%>
				<p>


					<br> <br> <br> ${editor.content }
				</p>
			</div>
			<br>
			<%
				if (session.getAttribute("id").equals("admin")) {
			%>
			<a href="courseDelete.s?forDel_num=${courseView.course_num }">삭제</a>
			<%
				}
			%>
		</div>
		<hr>
		<%-- <c:choose>
			<c:when test="${likeBean.id == sessionScope.id}">
		
				<button type="button" class="btn btn-primary"
					onclick="location.href='courseLike.s?course_num=${courseView.course_num }'">좋아요</button>
			</c:when>

			<c:otherwise>
		
				<button type="button" class="btn btn-danger"
					onclick="location.href='courseLikeNo.s?course_num=${courseView.course_num }'">좋아요
					취소</button>

			</c:otherwise>
		</c:choose> --%>

		<c:choose>
			<c:when test="${likeBean.id == sessionScope.id}">
				<button type="button" class="btn btn-danger"
					onclick="location.href='courseLikeNo.s?course_num=${courseView.course_num }'">좋아요
					취소</button>
			</c:when>

			<c:otherwise>
				<button type="button" class="btn btn-primary"
					onclick="location.href='courseLike.s?course_num=${courseView.course_num }'">좋아요</button>
			</c:otherwise>
		</c:choose>




		<br> <br>



		<table class="table">

			<thead class="thead-dark">
				<tr>
					<th scope="col">번호</th>
					<th scope="col">내용</th>
					<th scope="col">글쓴이</th>
					<th scope="col">삭제여부</th>
				</tr>
			</thead>	<!--댓글달기-->
			<tbody>	
				<c:forEach var="reple" items="${RepleView}">

					<tr>
						<td>${reple.reple_num}</td>
						<td>${reple.reple_content}</td>
						<td>${reple.id}</td>
						<c:if test="${reple.id == sessionScope.id }">
							<td><a
								href="courseRepleDelete.s?reple_num=${reple.reple_num}&course_num=${reple.course_num}">삭제</a></td>
						</c:if>

					</tr>
				</c:forEach>

			</tbody>
		</table>

		<form action="courseReple.s?course_num=${courseView.course_num }"
			method="post">
			<div class="input-group input-group-sm mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="inputGroup-sizing-sm"><input
						class="btn btn-primary" type="submit" value="댓글작성"></span>
				</div>

				<input type="text" name="reple" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm">
			</div>
		</form>



		<br>











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
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>








</body>
</html>


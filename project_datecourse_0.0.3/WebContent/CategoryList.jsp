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


<title>CategoryList</title>



<style>
:root { -
	-jumbotron-padding-y: 3rem;
}

.jumbotron {
	padding-top: var(- -jumbotron-padding-y);
	padding-bottom: var(- -jumbotron-padding-y);
	margin-bottom: 0;
	background-color: #fff;
}

@media ( min-width : 768px) {
	.jumbotron {
		padding-top: calc(var(- -jumbotron-padding-y)* 2);
		padding-bottom: calc(var(- -jumbotron-padding-y)* 2);
	}
}

.jumbotron p:last-child {
	margin-bottom: 0;
}

.jumbotron-heading {
	font-weight: 300;
}

.jumbotron .container {
	max-width: 40rem;
}

footer {
	padding-top: 3rem;
	padding-bottom: 3rem;
}

footer p {
	margin-bottom: .25rem;
}
</style>




</head>

<body>






	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">




		<div class="container">
			<ul class="nav">
				<li><a href="index.jsp"><img src="1.jpeg" height=35px; width="35px"></a>&nbsp;&nbsp;&nbsp;</li>
				
			</ul>
		</div>





<%-- 
		<div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
			<ul class="navbar-nav ml-auto">

				<%
				String id = (String)session.getAttribute("id");
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
		<%-- 		<%
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


























		<%-- <%
			}
		%>



 --%>
		




	</nav>








		<!--해당 카테고리 테이블값 가져오기-->
		<div class="album py-5 bg-light">
			<div class="container">
				<div class="row">
					<c:forEach var="FoodList" items="${FoodList}">
					<div class="col-md-4">
						<div class="card mb-4 shadow-sm">
							<img class="card-img-top" img src="${FoodList.photo}" width="200" height="200"
								alt="Card image cap">
							<div class="card-body">
								<p class="card-text">코스제목: ${FoodList.course_name}<br>상세 위치:${FoodList.course_place_name}</p>
								<p class="card-text">${Foodlist.content }</p>
								<div class="d-flex justify-content-between align-items-center">
									<div class="btn-group">
										<button type="button" class="btn btn-sm btn-outline-secondary" onclick="location.href='courseView.s?course_num=${FoodList.course_num}'">자세히
											보기</button>
									</div>
									<small class="text-muted">${FoodList.course_location}</small>
								</div>
							</div>
						</div>
					</div>
	</c:forEach>
	</div>
	</div>
	</div>

	<!-- <div class="col-md-4">
		<div class="card mb-4 shadow-sm">
			<img class="card-img-top" img src="1.png" alt="Card image cap">
			<div class="card-body">
				<p class="card-text">데이트 코스 간략한
					설명~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</p>
				<div class="d-flex justify-content-between align-items-center">
					<div class="btn-group">
						<button type="button" class="btn btn-sm btn-outline-secondary">자세히
							보기</button>
					</div>
					<small class="text-muted">인천</small>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-4">
		<div class="card mb-4 shadow-sm">
			<img class="card-img-top" img src="1.png" alt="Card image cap">
			<div class="card-body">
				<p class="card-text">데이트 코스 간략한
					설명~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</p>
				<div class="d-flex justify-content-between align-items-center">
					<div class="btn-group">
						<button type="button" class="btn btn-sm btn-outline-secondary">자세히
							보기</button>
					</div>
					<small class="text-muted">부산</small>
				</div>
			</div>
		</div>
	</div>

	<div class="col-md-4">
		<div class="card mb-4 shadow-sm">
			<img class="card-img-top" img src="1.png" alt="Card image cap">
			<div class="card-body">
				<p class="card-text">데이트 코스 간략한
					설명~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</p>
				<div class="d-flex justify-content-between align-items-center">
					<div class="btn-group">
						<button type="button" class="btn btn-sm btn-outline-secondary">자세히
							보기</button>
					</div>
					<small class="text-muted">전주</small>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-4">
		<div class="card mb-4 shadow-sm">
			<img class="card-img-top" img src="1.png" alt="Card image cap">
			<div class="card-body">
				<p class="card-text">데이트 코스 간략한
					설명~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</p>
				<div class="d-flex justify-content-between align-items-center">
					<div class="btn-group">
						<button type="button" class="btn btn-sm btn-outline-secondary">자세히
							보기</button>
					</div>
					<small class="text-muted">속초</small>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-4">
		<div class="card mb-4 shadow-sm">
			<img class="card-img-top" img src="1.png" alt="Card image cap">
			<div class="card-body">
				<p class="card-text">데이트 코스 간략한
					설명~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</p>
				<div class="d-flex justify-content-between align-items-center">
					<div class="btn-group">
						<button type="button" class="btn btn-sm btn-outline-secondary">자세히
							보기</button>
					</div>
					<small class="text-muted">가평</small>
				</div>
			</div>
		</div>
	</div>

	<div class="col-md-4">
		<div class="card mb-4 shadow-sm">
			<img class="card-img-top" img src="1.png" alt="Card image cap">
			<div class="card-body">
				<p class="card-text">데이트 코스 간략한
					설명~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</p>
				<div class="d-flex justify-content-between align-items-center">
					<div class="btn-group">
						<button type="button" class="btn btn-sm btn-outline-secondary">자세히
							보기</button>
					</div>
					<small class="text-muted">강릉</small>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-4">
		<div class="card mb-4 shadow-sm">
			<img class="card-img-top" img src="1.png" alt="Card image cap">
			<div class="card-body">
				<p class="card-text">데이트 코스 간략한
					설명~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</p>
				<div class="d-flex justify-content-between align-items-center">
					<div class="btn-group">
						<button type="button" class="btn btn-sm btn-outline-secondary">자세히
							보기</button>
					</div>
					<small class="text-muted">목포</small>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-4">
		<div class="card mb-4 shadow-sm">
			<img class="card-img-top" img src="1.png" alt="Card image cap">
			<div class="card-body">
				<p class="card-text">데이트 코스 간략한
					설명~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</p>
				<div class="d-flex justify-content-between align-items-center">
					<div class="btn-group">
						<button type="button" class="btn btn-sm btn-outline-secondary">자세히
							보기</button>
					</div>
					<small class="text-muted">부천</small>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
	</div> -->




	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')
	</script>
	<script src="../../assets/js/vendor/popper.min.js"></script>
	<script src="../../dist/js/bootstrap.min.js"></script>
	<script src="../../assets/js/vendor/holder.min.js"></script>
























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
					



<!-- Modal -->
		<div id="myModal" class="modal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">

					<div class="modal-body">


						<form class="form-signin" action="memberLoginAction.s"
							method="post">
							<img class="mb-4" src="1.png" alt="" width="72" height="72">
							<h1 class="h3 mb-3 font-weight-normal">로그인 창</h1>
							
							<label for="inputId" class="sr-only">아이디</label>
							 <input type="text" name="id" id="inputId" class="form-control"
								placeholder="ID" required autofocus> <label
								for="inputPassword" class="sr-only">비밀번호</label> <input
								type="password" name="password" id="inputPassword"
								class="form-control" placeholder="Password" required>

							<button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>

						</form>




					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>























</body>
</html>

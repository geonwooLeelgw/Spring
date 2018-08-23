<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>


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



<style>
.box {
	background-image: url("2.png");
	height: 1500px;
}

.table-bordered {
	margin: auto;
	height: 150px;
	width: 150px;
}

.a {
	height: 150px;
	width: 150px;
}

.form-signin {
	width: 100%;
	max-width: 330px;
	padding: 15px;
	margin: auto;
}

.form-signin .checkbox {
	font-weight: 400;
}

.form-signin .form-control {
	position: relative;
	box-sizing: border-box;
	height: auto;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="text"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}

a:link{color:#6E6E6E; text-decoration:none;}
a:visited{color:#6E6E6E; text-decoration:none;}
a:hover{color:#FAFAFA; text-decoration:none;}
</style>


<script>
if(!checkPoupCookie("close20150406")){

<!--
	function OpenWindow() {
		window.open("advertisement.s", "_blank",
				"height=400, width=400, left=100, top=300");
	}

	-->
}
function checkPoupCookie(cookieName){

	var cookie = document.cookie;

	// 현재 쿠키가 존재할 경우

	if(cookie.length > 0){

	// 자식창에서 set해준 쿠키명이 존재하는지 검색

	startIndex = cookie.indexOf(cookieName);

	// 존재한다면

	if(startIndex != -1){

	return true;

	}else{

	// 쿠키 내에 해당 쿠키가 존재하지 않을 경우

	return false;

	};

	}else{

	// 쿠키 자체가 없을 경우

	return false;

	};

	}



</script>





























</head>

<body onLoad="OpenWindow()">








	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">



		<div class="container">
			<ul class="nav">
				<li><a href="#MainPage">MainPage</a>&nbsp;&nbsp;&nbsp;</li>
				<li><a href="#Category">Category</a>&nbsp;&nbsp;&nbsp;</li>
				<li><a href="#CourseRanking">CourseRanking</a>&nbsp;&nbsp;&nbsp;
				</li>
				<li><a href="#TeamInfo">TeamInfo</a>&nbsp;&nbsp;&nbsp;</li>
			</ul>
		</div>




		<div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
			<ul class="navbar-nav ml-auto">

		<%-- 		<%
					String id = (String) session.getAttribute("id");
					if (id != null && !(id.equals("admin"))) {
				%> --%>
				<li class="nav-item">

					<button type="button" class="btn btn-warning dropdown-toggle"
						data-toggle="dropdown">마이페이지</button>

					<div class="dropdown-menu dropdown-menu-right">
<%-- 
						<a class="dropdown-item"
							href="ChangedPersonalInfo.s?id=<%=session.getAttribute("id")%>">개인정보 --%>
							수정 및 보기 </a> <a class="dropdown-item" href="userLikeListAction.s">내가
							좋아요 누른 게시물보기</a> <a class="dropdown-item"
							href="AskedPasswordForDelete.jsp">회원 탈퇴</a>
					</div>

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
			<%-- 	<%
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





	<div id="MainPage" class="box">
		<h1>MainPage</h1>





		<div id="carouselExampleIndicators" class="carousel slide"
			data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselExampleIndicators" data-slide-to="0"
					class="active"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img class="d-block w-5" src="Photo.JPG" alt="First slide"
						style="width: 50%; height: 5%; margin: auto;">
				</div>
				<div class="carousel-item">
					<img class="d-block w-5" src="후보1.JPG" alt="Second slide"
						style="width: 50%; height: 5%; margin: auto;">
				</div>
				<div class="carousel-item">
					<img class="d-block w-5" src="후보.4.JPG" alt="Third slide"
						style="width: 50%; height: 5%; margin: auto;">
				</div>
			</div>
			<a class="carousel-control-prev" href="#carouselExampleIndicators"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>








	</div>
	<div id="Category" class="box">
		<h1>Category</h1>
		<br>
		<div class="container">
			<div class="col-sm-3" style="margin: auto;">
				<div class="input-group">

				
					<form action="CategorySearch.s" method="post">
					<table>
					<tr>
						<td><input type="text" class="form-control" placeholder="검색어 입력..."
							name="KeywordSearch"></td><td><button class="btn btn-default" type="submit">검색</button></td>
							</tr>
							</table>
					</form>


				</div>
			</div>
			<!-- /input-group -->
		</div>
		<!-- /.col-lg-6 -->

		<br>








		<table class="table table-bordered">
						<!--카테고리마다 고유의 값을 지정-->
			<tr>
				<td><div data-toggle="tooltip" data-placement="top" title="음식"><a href="CategoryFoodList.s?key=tourForEating"><img
						class="a" src="image/Food.jpg"></a></div></td>
				<td><div data-toggle="tooltip" data-placement="top" title="패션"><a href="CategoryFoodList.s?key=Fashion"><img class="a"
						src="image/Fashion.jpg"></a></div></td>
				<td><div data-toggle="tooltip" data-placement="top" title="힐링"><a href="CategoryFoodList.s?key=Healing"><img class="a"
						src="image/Healing.jpg"></a></div></td>
			</tr>


			<tr>
				<td><div data-toggle="tooltip" data-placement="top" title="문화"><a href="CategoryFoodList.s?key=Culture"><img class="a"
						src="image/Culture.jpg"></a></div></td>
				<td><div data-toggle="tooltip" data-placement="top" title="전체보기"><a href="CategoryFoodList.s?key=ViewAll"><img class="a"
						src="image/ViewAll.jpg"></a></div></td>
				<!-- 전체보기 -->
				<td><div data-toggle="tooltip" data-placement="top" title="취미"><a href="CategoryFoodList.s?key=Hobby"><img class="a"
						src="image/hobby.jpg"></a></div></td>
			</tr>
			<tr>
				<td><div data-toggle="tooltip" data-placement="top" title="장소"><a href="CategoryFoodList.s?key=Place"><img class="a"
						src="image/Place.jpg"></a></div></td>
				<td><div data-toggle="tooltip" data-placement="top" title="스포츠"><a href="CategoryFoodList.s?key=Sport"><img class="a"
						src="image/Sport.jpg"></a></div></td>
				<td><div data-toggle="tooltip" data-placement="top" title="카니발"><a href="CategoryFoodList.s?key=Carnival"><img
						class="a" src="image/Carnival.jpg"></a></div></td>
				<!-- 축제 -->

			</tr>



		</table>
	</div>

<script>
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();   
});
</script>

<!-- <div data-toggle="tooltip" data-placement="top" title="courseResult">
  <img src="1.jpeg">
</div>
    

    
    
    


<script>
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();   
});
</script>
    
 -->





	<div id="CourseRanking" class="box">
		<h1>CourseRanking</h1>


		<div id="CourseRanking" class="box">
			<h1 align="center">
				<button type="button" class="btn btn-primary"
					onclick="location.href='courseListRank.s'">코스랭킹</button>
			</h1>






			<%-- <%
				int i = 1;
			%>
			<c:forEach var="RankList" items="${RankList}">
				<%
					if (i % 2 != 0) {
				%>
				<div class="row">
					<div class="col-md-6">
						<%
							}
						%>
						<div class="card flex-md-row mb-4 shadow-sm h-md-250">
							<div class="card-body d-flex flex-column align-items-start">

								<strong class="d-inline-block mb-2 text-primary"><%=i++%>위</strong>

								<h3 class="mb-0">데이트 코스명 : ${RankList.course_name}</h3>
								<div class="mb-1 text-muted">좋아요 ${RankList.course_like}개</div>
								<br>
								<p class="card-text mb-auto">
									코스 지역 : ${RankList.course_location}<br>키워드 :
									${RankList.course_search_keyword}
								</p>
								<a href="#">자세히보기(링크)</a>
							</div>
							<img class="card-img-right flex-auto d-none d-lg-block"
								data-src="holder.js/200x250?theme=thumb"
								alt="Thumbnail [200x250]" style="width: 200px; height: 250px;"
								src="${RankList.photo}" data-holder-rendered="true">
						</div>
						<%
							if (i % 2 != 0) {
						%>
					</div>


					<%
						}
					%>
				</div>
			</c:forEach>  --%>








			<%--나중에 체크 --%>
			<%
				int i = 1;
			%>
			<c:forEach var="RankList" items="${RankList}">
				<div class="row">

					<div class="col-md-8 " style="margin: auto;">

						<div class="card flex-md-row mb-4 shadow-sm h-md-250">
							<div class="card-body d-flex flex-column align-items-start">
								<strong class="d-inline-block mb-2 text-primary"><%=i++%>위
									코스</strong>
								<h3 class="mb-0">데이트 코스명 : ${RankList.course_name}</h3>
								<div class="mb-1 text-muted">좋아요 ${RankList.course_like}개</div>
								<br>
								<p class="card-text mb-auto">
									코스 지역 : ${RankList.course_location}<br>키워드 :
									${RankList.course_search_keyword}
								</p>
								<a href="courseView.s?course_num=${RankList.course_num}">자세히보기(링크)</a>
							</div>
							<img class="card-img-right flex-auto d-none d-lg-block"
								data-src="holder.js/200x250?theme=thumb"
								alt="Thumbnail [200x250]" style="width: 200px; height: 250px;"
								data-holder-rendered="true" src="${RankList.photo}">
						</div>
					</div>




				</div>
			</c:forEach>



















			<%--기본 체크 --%>

			<!--    <div class="row">
            <div class="col-md-6">
                <div class="card flex-md-row mb-4 shadow-sm h-md-250">
                    <div class="card-body d-flex flex-column align-items-start">
                        <strong class="d-inline-block mb-2 text-primary">1위 코스</strong>
                        <h3 class="mb-0">
                            	데이트 코스명
                        </h3>
                        <div class="mb-1 text-muted">좋아요 갯수 : </div><br>
                        <p class="card-text mb-auto">데이트 코스 간략한 설명~~~~~~~~~~~~~~~~~~<br>데이트 코스 간략한 설명~~~~~~~~~~~~~~~~~~</p>
                        <a href="#">자세히보기(링크)</a>
                    </div>
                    <img class="card-img-right flex-auto d-none d-lg-block" data-src="holder.js/200x250?theme=thumb" alt="Thumbnail [200x250]" style="width: 200px; height: 250px;" src="1.png" data-holder-rendered="true">
                </div>
            </div>

            <div class="col-md-6">
                <div class="card flex-md-row mb-4 shadow-sm h-md-250">
                    <div class="card-body d-flex flex-column align-items-start">
                        <strong class="d-inline-block mb-2 text-success">2위 코스</strong>
                        <h3 class="mb-0">
                            	데이트 코스명
                        </h3>
                        <div class="mb-1 text-muted">좋아요 갯수 : </div><br>
                        <p class="card-text mb-auto">데이트 코스 간략한 설명~~~~~~~~~~~~~~~~~~<br>데이트 코스 간략한 설명~~~~~~~~~~~~~~~~~~</p>
                        <a href="#">자세히보기(링크)</a>
                    </div>
                    <img class="card-img-right flex-auto d-none d-lg-block" data-src="holder.js/200x250?theme=thumb" alt="Thumbnail [200x250]" src="1.png" data-holder-rendered="true" style="width: 200px; height: 250px;">
                </div>
            </div>

        </div>

        <div class="row">
            <div class="col-md-6">
                <div class="card flex-md-row mb-4 shadow-sm h-md-250">
                    <div class="card-body d-flex flex-column align-items-start">
                        <strong class="d-inline-block mb-2 text-primary">3위 코스</strong>
                        <h3 class="mb-0">
                            <a class="text-dark" href="#">데이트 코스명</a>
                        </h3>
                        <div class="mb-1 text-muted">좋아요 갯수 : </div><br>
                        <p class="card-text mb-auto">데이트 코스 간략한 설명~~~~~~~~~~~~~~~~~~<br>데이트 코스 간략한 설명~~~~~~~~~~~~~~~~~~</p>
                        <a href="#">자세히보기(링크)</a>
                    </div>
                    <img class="card-img-right flex-auto d-none d-lg-block" data-src="holder.js/200x250?theme=thumb" alt="Thumbnail [200x250]" style="width: 200px; height: 250px;" src="1.png" data-holder-rendered="true">
                </div>
            </div>

            <div class="col-md-6">
                <div class="card flex-md-row mb-4 shadow-sm h-md-250">
                    <div class="card-body d-flex flex-column align-items-start">
                        <strong class="d-inline-block mb-2 text-success">4위 코스</strong>
                        <h3 class="mb-0">
                            <a class="text-dark" href="#">데이트 코스명</a>
                        </h3>
                        <div class="mb-1 text-muted">좋아요 갯수 : </div><br>
                        <p class="card-text mb-auto">데이트 코스 간략한 설명~~~~~~~~~~~~~~~~~~<br>데이트 코스 간략한 설명~~~~~~~~~~~~~~~~~~</p>
                        <a href="#">자세히보기(링크)</a>
                    </div>
                    <img class="card-img-right flex-auto d-none d-lg-block" data-src="holder.js/200x250?theme=thumb" alt="Thumbnail [200x250]" src="1.png" data-holder-rendered="true" style="width: 200px; height: 250px;">
                </div>
            </div>

        </div>

        <div class="row">
            <div class="col-md-6">
                <div class="card flex-md-row mb-4 shadow-sm h-md-250">
                    <div class="card-body d-flex flex-column align-items-start">
                        <strong class="d-inline-block mb-2 text-primary">5위 코스</strong>
                        <h3 class="mb-0">
                            <a class="text-dark" href="#">데이트 코스명</a>
                        </h3>
                        <div class="mb-1 text-muted">좋아요 갯수 : </div><br>
                        <p class="card-text mb-auto">데이트 코스 간략한 설명~~~~~~~~~~~~~~~~~~<br>데이트 코스 간략한 설명~~~~~~~~~~~~~~~~~~</p>
                        <a href="#">자세히보기(링크)</a>
                    </div>
                    <img class="card-img-right flex-auto d-none d-lg-block" data-src="holder.js/200x250?theme=thumb" alt="Thumbnail [200x250]" style="width: 200px; height: 250px;" src="1.png" data-holder-rendered="true">
                </div>
            </div>

            <div class="col-md-6">
                <div class="card flex-md-row mb-4 shadow-sm h-md-250">
                    <div class="card-body d-flex flex-column align-items-start">
                        <strong class="d-inline-block mb-2 text-success">6위 코스</strong>
                        <h3 class="mb-0">
                            <a class="text-dark" href="#">데이트 코스명</a>
                        </h3>
                        <div class="mb-1 text-muted">좋아요 갯수 : </div><br>
                        <p class="card-text mb-auto">데이트 코스 간략한 설명~~~~~~~~~~~~~~~~~~<br>데이트 코스 간략한 설명~~~~~~~~~~~~~~~~~~</p>
                        <a href="#">자세히보기(링크)</a>
                    </div>
                    <img class="card-img-right flex-auto d-none d-lg-block" data-src="holder.js/200x250?theme=thumb" alt="Thumbnail [200x250]" src="1.png" data-holder-rendered="true" style="width: 200px; height: 250px;">
                </div>
            </div>

        </div> -->



		</div>










		<div id="TeamInfo" class="box">
			<h1>TeamInfo</h1>


			<br> <br>

			<div class="row">
				<div class="card col-3">
					<div class="card-header">
						<img src="image/Service.JPG" width="100%" height="100%"
							alt="Service">
					</div>
					<div class="card-body">민호</div>
					<div class="card-footer">
						고객센터 담당<br>
					</div>
					<!-- <button type="button" class="btn btn-info ">연락처</button> -->
				</div>
				<div class="card col-3">
					<div class="card-header">
						<img src="image/cart.JPG" width="140%" height="140%" alt="cart">
					</div>
					<div class="card-body">지웅</div>
					<div class="card-footer">
						인사,정보 담당<br>
					</div>
					<!-- <button type="button" class="btn btn-info ">연락처</button> -->
				</div>
				<div class="card col-3">
					<div class="card-header">
						<img src="image/camera.JPG" width="100%" height="100%" alt=camera">
					</div>
					<div class="card-body">건우</div>
					<div class="card-footer">
						카메라담당<br>
					</div>
					<!-- <button type="button" class="btn btn-info ">연락처</button> -->
				</div>

				<div class="card col-3">
					<div class="card-header">
						ㄱ <img src="image/facebook.JPG" width="100%" height="100%"
							alt="facebook">
					</div>
					<div class="card-body">다훈</div>
					<div class="card-footer">
						SNS마케팅담당<br>
					</div>
					<!-- <button type="button" class="btn btn-info ">연락처</button> -->
				</div>
			</div>




		</div>




		<br> <br>





		<footer class="text-muted">
			<div class="container">
				<p class="float-right">
					<a href="#">위로가기</a>
				</p>
				<h3>홈페이지 정보</h3>
				<p>
					우리 홈페이지는......... <br> <a href="#">웹사이트 만든 회사 정보</a>.
				</p>
			</div>
		</footer>










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

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>










    <meta charset="UTF-8">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>


    <title>SignUp</title>

    <!-- Bootstrap core CSS -->
    <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">




    <style>
        body {
            height: 100%;
        }

        body {
            display: -ms-flexbox;
            display: flex;

            align-items: center;
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

        .form-signup {
            width: 100%;
            max-width: 330px;
            padding: 15px;
            margin: auto;
        }

        .form-signup .checkbox {
            font-weight: 400;
        }

        .form-signup .form-control {
            position: relative;
            box-sizing: border-box;
            height: auto;
            padding: 10px;
            font-size: 16px;
        }

        .form-signup .form-control:focus {
            z-index: 2;
        }

        .form-signup input[type="text"] {

            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;

        }

        .form-signup input[type="email"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }

    </style>






</head>

<body>
  
        <form class="form-signup" action="courseInsert.s" method="post">
         <table align="center">
           <tr>
               <td align="center">
                    <img class="mb-4" src="1.png" alt="" width="72" height="72">
                    <h1 class="h3 mb-3 font-weight-normal">코스삽입 페이지</h1>
               </td>
            </tr>
            
            <tr>
                <td>
                    <label for="course_name" class="sr-only">코스명</label>
                    <input type="text" name="course_name" id="course_name" class="form-control" placeholder="코스명" required autofocus>
                </td>
            </tr>
            
            <tr>
                <td>
                    <label for="course_place_name" class="sr-only">상세장소</label>
                    <input type="text" name="course_place_name" id="course_place_name" class="form-control" placeholder="상세장소" required autofocus>
                </td>
            </tr>
            
            <tr>
                <td>
                    <label for="course_place_tel" class="sr-only">상세장소 전화번호</label>
                    <input type="text" name="course_place_tel" id="course_place_tel" class="form-control" placeholder="상세장소 전화번호" required autofocus>
                </td>
            </tr>
            
            <tr>
                <td>
                    <label for="course_location" class="sr-only">지역</label>
                        <select name="course_location" class="form-control">
                            <option>※ 지역 ※</option>
                            <option value="gapyeong">가평</option>
                            <option value="geojedo">거제도</option>
                            <option value="gwangju">광주</option>
                            <option value="daejeon">대전</option>
                            <option value="daeprica">대프리카</option>
					    	<option value="busan">부산</option>
					    	<option value="seoul">서울</option>
					    	<option value="ulleungdo">울릉도</option>
					    	<option value="ulsan">울산</option>
					    	<option value="incheon">인천</option>
					    	<option value="jejudo">제주도</option>
					    	<option value="cheonan">천안</option>
				        </select>
                </td>
            </tr>
            
            <tr>
                <td>
                    <label for="course_search_keyword" class="sr-only">검색키워드</label>
                        <select name="course_search_keyword" class="form-control">
                            <option>※ 키워드 ※</option>
					    	<option value="tourForEating">tourForEating</option>
					    	<option value="Fashion">Fashion</option>
                            <option value="Healing">Healing</option>
                            <option value="Culture">Culture</option>
                            <option value="Hobby">Hobby</option>
                            <option value="Place">Place</option>
                            <option value="Sport">Sport</option>
                            <option value="Carnival">Carnival</option>
				        </select>
                </td>
            </tr>
            
            <tr>
                <td>
                    <input type="submit" class="btn btn-lg btn-primary btn-block" value="코스삽입">
                </td>
            </tr>
              </table>
        </form>
  
</body>

</html>

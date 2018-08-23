<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
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
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }

    </style>
		





</head>

<body class="text-center">
    <form class="form-signup" action="SignUp.s" method="post">
        <img class="mb-4" src="1.png" alt="" width="72" height="72">
        <h1 class="h3 mb-3 font-weight-normal">회원가입 페이지</h1>
        <label for="inputId" class="sr-only">아이디</label>
        	<input type="text" name="id" id="id" class="form-control" placeholder="ID" required autofocus>
        <label for="inputPassword" class="sr-only">비밀번호</label>
        	<input type="password" name="password" id="password" class="form-control" placeholder="Password" required>
        <label for="inputId" class="sr-only">이름</label>
       	 <input type="text" name="name" id="name" class="form-control" placeholder="Name" required autofocus>
        <label for="inputId" class="sr-only">닉네임</label>
        	<input type="text" name="nickname" id="nickname" class="form-control" placeholder="Nickname" required autofocus>
        <label for="inputId" class="sr-only">이메일</label> 
        	<input type="email" name="email" id="email" class="form-control" placeholder="Email" required autofocus>
		<!-- <label for="inputId" class="sr-only">추천인 아이디</label>
        	<input type="text" name="recommendation" class="form-control" placeholder="Recommend Friend">  -->
			<br>
		<button class="btn btn-lg btn-primary btn-block" type="submit" style="width: 150px; margin: auto;">회원가입</button>



    </form>
</body>

</html>

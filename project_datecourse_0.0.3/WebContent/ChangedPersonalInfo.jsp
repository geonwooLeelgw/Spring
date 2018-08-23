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


    <title>ChangedPersonalInfo</title>

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

        .form-changed {
            width: 100%;
            max-width: 330px;
            padding: 15px;
            margin: auto;
        }

        .form-changed .checkbox {
            font-weight: 400;
        }

        .form-changed .form-control {
            position: relative;
            box-sizing: border-box;
            height: auto;
            padding: 10px;
            font-size: 16px;
        }

        .form-changed .form-control:focus {
            z-index: 2;
        }

        .form-changed input[type="text"] {

            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;

        }

        .form-changed input[type="email"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }

    </style>





</head>

<body class="text-center">

    <form class="form-changed" action="ChangedPersonalInfoModi.s?id=${modifyView.id}" method="post">
        <img class="mb-4" src="1.png" alt="" width="72" height="72">
        <h1 class="h3 mb-3 font-weight-normal">개인정보 보기 및 수정</h1>

		<table class="table">
			<thead>
				<tr>
					<th scope="col">아이디
					</th>
					<td scope="col">${modifyView.id}
					</td>
				</tr>
			</thead>

			<thead>
				<tr>
					<!-- <label for="inputPassword" class="sr-only">비밀번호</label> -->
					<th scope="col">비밀번호
					</th>
					<td scope="col"><input type="password" name="password"
						id="password" class="form-control" placeholder="Password" required>
					</td>
				</tr>
			</thead>

			<thead>
				<tr>
					<th scope="col">이름
					</th>
					<td scope="col"><input type="text" name="name" id="name"
						class="form-control" value="${modifyView.name}" required autofocus>
					</td>
					<!-- <label for="inputId" class="sr-only">이름</label> -->
				</tr>
			</thead>
			<thead>
				<tr>
					<th scope="col">닉네임
					</th>
					<td scope="col"><input type="text" name="nickname"
						id="nickname" class="form-control" value="${modifyView.nickname}"
						required autofocus>
					</td>
					<!-- <label for="inputId" class="sr-only">닉네임</label> -->
				</tr>
			</thead>

			<thead>
				<tr>
					<th scope="col">이메일</th>
					<td scope="col"><input type="email" name="email" id="email"
						class="form-control" value="${modifyView.email}" required
						autofocus></td>
					<!-- <label for="inputId" class="sr-only">이메일</label> -->
				</tr>
			</thead>
		</table>
        <button class="btn btn-lg btn-primary btn-block" type="submit">변경</button>



    </form>
</body>

</html>

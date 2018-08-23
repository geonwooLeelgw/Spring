<%-- 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <meta charset="UTF-8">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>


<style>
   
    body{
        float : left;
        text-align: center;
        
    }
    
</style>    


</head>
<body>
	<!-- <h2>sessionSubmit.jsp</h2> -->
	
	<%
	request.setCharacterEncoding("UTF-8");
	String filename = request.getParameter("filename"); 
	
		if (session.getAttribute("filename1") == null) {
			session.setAttribute("filename1", filename);
			
		} else if (session.getAttribute("filename2") == null) {
			session.setAttribute("filename2", filename);

		} else if (session.getAttribute("filename3") == null) {
			session.setAttribute("filename3", filename);

		} else if (session.getAttribute("filename4") == null) {
			session.setAttribute("filename4", filename);

		} else if (session.getAttribute("filename5") == null) {
			session.setAttribute("filename5", filename);
		}
	%>

	세션1:
	<%=session.getAttribute("filename1")%><br> 세션2:
	<%=session.getAttribute("filename2")%><br> 세션3:
	<%=session.getAttribute("filename3")%><br> 세션4:
	<%=session.getAttribute("filename4")%><br> 세션5:
	<%=session.getAttribute("filename5")%><br> 내용 :
	
	
<form action="CourseEditor.s" method="post">
<input type="hidden" name="filename1" value="<%=session.getAttribute("filename1")%>">
<input type="hidden" name="filename2" value="<%=session.getAttribute("filename2")%>">
<input type="hidden" name="filename3" value="<%=session.getAttribute("filename3")%>">
<input type="hidden" name="filename4" value="<%=session.getAttribute("filename4")%>">
<input type="hidden" name="filename5" value="<%=session.getAttribute("filename5")%>">
<input type="hidden" name="ir1" value="<%=request.getParameter("ir1")%>">

<!-- <input type="submit" value="Action"> -->
<input type="submit" class="btn btn-primary" value="전송">
<button type="button" class="btn btn-danger" onclick="location.href='javascript:window.close()'">닫기</button>    

</form>
</body>
<!-- <head>
   

<body>





    
    
    
    
    
</body> -->
</html>
 --%>
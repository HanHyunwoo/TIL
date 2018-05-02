<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<meta content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>


<h1>메인이야.</h1>


	<!-- name이랑 vo(User.java)에 변수명이랑 같아야한다!!! -->
	<form action="insert.do" method="post">
		<input  type="text"  name="id" placeholder="ID를 입력해주세요"><br>
		<input  type="text"  name="pwd" placeholder="비번을 입력해주세요" ><br>
		<input  type="text"  name="name" placeholder="이름을 입력해주세요"><br>
		<input  type="text"  name="content" placeholder="내용을 입력해주세요"><br>
		<input  type="submit" value="등록">
	</form>


</body>
</html>
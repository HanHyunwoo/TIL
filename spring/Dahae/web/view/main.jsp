<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<meta content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>


<h1>�����̾�.</h1>


	<!-- name�̶� vo(User.java)�� �������̶� ���ƾ��Ѵ�!!! -->
	<form action="insert.do" method="post">
		<input  type="text"  name="id" placeholder="ID�� �Է����ּ���"><br>
		<input  type="text"  name="pwd" placeholder="����� �Է����ּ���" ><br>
		<input  type="text"  name="name" placeholder="�̸��� �Է����ּ���"><br>
		<input  type="text"  name="content" placeholder="������ �Է����ּ���"><br>
		<input  type="submit" value="���">
	</form>


</body>
</html>
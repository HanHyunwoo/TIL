<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
#main_center{
	margin:0 20px;
	width:760px;
	height:480px;
	background:white;
}
th, td{
	border : 3px solid green;
}
</style>
<div id="main_center">
<h1>Item List Page</h1>
<!-- jsp에선 더이상 코드가 아니라 jstl을 써라! -->
<table id="t">
<thead>
	<tr>
	<th>id</th>
	<th>pwd</th>
	<th>name</th>
	</tr>
</thead>
<tbody>
<c:forEach var ="i" items="${itemlist}">
	<tr>
		<td>${i.id}</td>		
		<td>${i.name}</td>
		<td>${i.price}</td>		
	</tr>
</c:forEach></tbody>
</table>
</div>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
#main_center{
	margin:0 20px;
	width:760px;
	height: auto;
	background:white;
}
#imgsize{
	width : 50px;
}
table, td, tr ,th{
	border : 2px solid green;
}
</style>
<div id="main_center">
<h1>Product List</h1>
<table>
<thead>
	<tr>
	<th>id</th>
	<th>name</th>
	<th>price</th>
	<th>date</th>
	<th>image</th>
	</tr>
</thead>
<tbody>
<c:forEach var="index" items="${productlist}">
	<tr>
	<td>${index.id}</td>
	<td>${index.name}</td>
	<td>${index.price}</td>
	<td>${index.regdate}</td>
	<td><img id="imgsize" src='img/${index.imgname}'></td>	
	</tr>
</c:forEach>
</tbody>
</table>
</div>
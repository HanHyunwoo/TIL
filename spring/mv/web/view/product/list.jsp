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
</style>    
    
<div id="main_center">
<h1>Product List Page</h1>

<table>

<form>
	<input type="text" name="id"/> &nbsp;
	<button name="idsearch">ID로 검색</button> &nbsp;
	<button name="namesearch">이름으로 검색</button>
	<br> <br> <hr> <br>
</form>

<thead>
	<tr><th>ID</th><th>NAME</th><th>PRICE</th><th>REGDATE</th><th>IMGNAME</th> </tr>
</thead>
<tbody>

<c:forEach var="u" items="${productlist }">
	<tr>
		<td><a href="productmodify.do?id=${u.id }" >${u.id }</a></td>
		<td>${u.name }</td>
		<td>${u.price }</td>
		<td>${u.regdate }</td>
		<td><img src = "img/${u.imgname }" height="100" width="100" ></td>
	</tr>
</c:forEach>
</tbody>


</table>

</div>












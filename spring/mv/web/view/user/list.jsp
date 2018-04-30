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
<h1>User List Page</h1>
<table>

<form>
	<input type="text" name="id"/> &nbsp;
	<button name="idsearch">ID로 검색</button> &nbsp;
	<button name="namesearch">이름으로 검색</button>
	<br> <br> <hr> <br>
</form>

<thead>
	<tr><th>ID</th><th>PWD</th><th>NAME</th></tr>
</thead>
<tbody>
<c:forEach var="u" items="${userlist }">
	<tr>
		<td><a href="usermodify.do?id=${u.id }" >${u.id }</a></td>
		<td>${u.pwd }</td>
		<td>${u.name }</td>
	</tr>
</c:forEach>
</tbody>
</table>

</div>












<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" 
uri="http://www.springframework.org/tags"%>

    
<!DOCTYPE>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/variable-pie.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/drilldown.js"></script>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>


<style>
/* Global CSS */
*{
	margin:0;
	padding:0;
}
a{
	text-decoration: none;
}
ul,ol{
	list-style: none;
}
/* Header CSS */
header{
	margin:0 auto;
	width:800px;
	height:150px;
	background: red;
}
header > ul > li {
	float:left;
}
header > ul > li > a{
	font-size:1.5em;
	font-style:bold;
	padding:5px 10px;
}
header > ul > li > a:hover{
	color:white;
	background:black;
}
/* Section CSS */
section{
	margin:0 auto;
	width:800px;
	min-height:500px;
	background: gray;
}
/* Footer CSS */
footer{
	margin:0 auto;
	width:800px;
	height:80px;
	background: black;
}
</style>
<script></script>
</head>
<body>
<header>
<h1>
<a href="main.do">
<spring:message code="welcome.txt"/>
</a>
</h1>

<ul>
	<li><a href="userlist.do">User List</a></li>
	<li><a href="useradd.do">User Add</a></li>
	<li><a href="productlist.do">Product List</a></li>
	<li><a href="productadd.do">Product Add</a></li>
</ul>
<ul>
	<li><a href="itemlist.do">Item List</a></li>
	<li><a href="itemadd.do">Item Add</a></li>
</ul>

<!-- Chart1~3 �����̺� �����ͷ� �׸���. -->
<h4><a href="chart1.do">Chart1</a></h4>
<h4><a href="chart2.do">Chart2</a></h4>
<h4><a href="chart3.do">Chart3</a></h4>

<!-- Chart4 ����Ŭ�� �����͸� �Է��ؼ� ������ �м� -->
<h4><a href="chart4.do">Chart4</a></h4>

<h4><a href="chart5.do">R</a></h4>

</header>
<section>

	<c:choose>
		<c:when test="${center == null }">
			<jsp:include page="center.jsp"></jsp:include>
		</c:when>
		
		<c:otherwise>
			<jsp:include page="${center}.jsp"></jsp:include>
		</c:otherwise>
	</c:choose>
	
	
</section>
<footer></footer>
</body>
</html>







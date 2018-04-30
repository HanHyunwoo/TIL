<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<style>
#main_center{
	margin:0 20px;
	width:760px;
	height:480px;
	background:white;
}
</style>    
<script>
function display(input){
	Highcharts.chart('container', {
	    chart: {
	        type: 'variablepie'
	    },
	    title: {
	        text: 'Countries compared by population density and total area.'
	    },
	    tooltip: {
	        headerFormat: '',
	        pointFormat: '<span style="color:{point.color}">\u25CF</span> <b> {point.name}</b><br/>' +
	            'Area (square km): <b>{point.y}</b><br/>' +
	            'Population density (people per square km): <b>{point.z}</b><br/>'
	    },
	    series: [{
	        minPointSize: 50,
	        innerSize: '80%',
	        zMin: 0,
	        name: 'countries',
	        data: input
	    }]
	});
}

$(document).ready(function(){
	// Server에 데이터를 요청한다.
	// AJAX로
	$.ajax({
		url:'chart2impl.do',
		success:function(data){
			alert(data); 
			display(data);
		},
		error:function(){
			alert('fail');
		}
	});
		
	/* var datas = [
		{name:'지훈', y:70},
		{name:'동건', y:60},
		{name:'애리', y:28},
		{name:'준하', y:50},
		{name:'호진', y:90},
		{name:'영무', y:80}
		
		];
	display(datas); */
	
	
});
</script>
<div id="main_center">
<h1>Chart2</h1>
<div id="container" style="min-width: 300px; height: 400px; margin: 0 auto"></div>

</div>








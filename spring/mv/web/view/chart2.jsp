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
	// Server�� �����͸� ��û�Ѵ�.
	// AJAX��
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
		{name:'����', y:70},
		{name:'����', y:60},
		{name:'�ָ�', y:28},
		{name:'����', y:50},
		{name:'ȣ��', y:90},
		{name:'����', y:80}
		
		];
	display(datas); */
	
	
});
</script>
<div id="main_center">
<h1>Chart2</h1>
<div id="container" style="min-width: 300px; height: 400px; margin: 0 auto"></div>

</div>








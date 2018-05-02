<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<style>
#main_center {
	margin: 0 20px;
	width: 760px;
	height: auto;
	background: white;
	opacity : 0.85;
}
</style>
<script>
function display(input, input2){	
	Highcharts.chart('container', {
	    chart: {
	        type: 'column'
	    },
	    title: {
	        text: ' '
	    },
	    xAxis: {
	        type: 'category'
	    },
	    yAxis: {
	        title: {
	            text: '(인구)명 / (검거율)%'
	        }

	    },
	    legend: {
	        enabled: false
	    },
	    plotOptions: {
	        series: {
	            borderWidth: 0,
	            dataLabels: {
	                enabled: true,
	                format: '{point.y}'
	            }
	        }
	    },
	    tooltip: {
	        headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
	        pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y}</b><br/>'
	    },

	    series: [{
	    	colorByPoint: true,	        
	        data:input
	    }],	    
	    drilldown: {
	    	 series: input2
	    
	    }
	});
}
$(document).ready(function(){
   
   $.ajax({
      url:'populationlist.do',
      success:function(data){
    	  $.ajax({
    		  url:'populationlist2.do',
    		 success:function(data2){
    		  	display(data, data2);  
    		  },
    	 	 error:function(){
    	 		alert('data2 fail');
    	 	 }    	  
    	  });
                  
      },
      error:function(){
         alert('data1 fail');
      }
	});
});   


</script>
<div id="main_center"> 
<div class="col-xl-9 col-lg-10 mx-auto">
              <div class="bg-faded rounded p-5">              
                <h2 class="section-heading mb-4">
                  <span class="section-heading-upper">Select 'JINMAN LEE' from BIGDATA where 1403</span>
                  <div style="font-size:30px; padding-top:10px;padding-bottom:10px;">- 서울시 1인가구가 7000명 이상인 동</div>
                  <div style="font-size:30px;">- 해당 동의 구에 대한 범죄별 검거율</div>                  
                </h2>                
                </div>
            </div>
	<div id="container"
		style="min-width: auto; height: auto; margin: 0 auto"></div>
</div>


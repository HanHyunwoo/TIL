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

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>

<script>
function display(input){	

	var chart = Highcharts.chart('container', {

	    chart: {
	        type: 'column'
	    },

	    title: {
	        text: 'Highcharts responsive chart'
	    },

	    subtitle: {
	        text: 'Resize the frame or click buttons to change appearance'
	    },

	    legend: {
	        align: 'right',
	        verticalAlign: 'middle',
	        layout: 'vertical'
	    },

	    xAxis: {
	        categories: ['¸¼À½', 'Èå¸²', '´«ºñ'],
	        labels: {
	            x: -10
	        }
	    },

	    yAxis: {
	        allowDecimals: false,
	        title: {
	            text: 'Amount'
	        }
	    },

	    series: input,

	    responsive: {
	        rules: [{
	            condition: {
	                maxWidth: 500
	            },
	            chartOptions: {
	                legend: {
	                    align: 'center',
	                    verticalAlign: 'bottom',
	                    layout: 'horizontal'
	                },
	                yAxis: {
	                    labels: {
	                        align: 'left',
	                        x: 0,
	                        y: -5
	                    },
	                    title: {
	                        text: null
	                    }
	                },
	                subtitle: {
	                    text: null
	                },
	                credits: {
	                    enabled: false
	                }
	            }
	        }]
	    }
	});

	$('#small').click(function () {
	    chart.setSize(400, 300);
	});

	$('#large').click(function () {
	    chart.setSize(600, 300);
	});
	
}
$(document).ready(function(){
   
   $.ajax({
      url:'r.do',
      success:function(data){
    	 
    	  display(data);
                  
      },
      error:function(){
         alert('data1 fail');
      }
	});
   
});   


</script>
<div id="main_center"> 
	<div id="container" style="min-width: auto; height: auto; margin: 0 auto"></div>
</div>


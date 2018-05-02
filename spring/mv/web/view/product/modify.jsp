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
$(document).ready(function(){
	$('#m_bt').click(function(){
		var c = confirm('수정하시겠습니까?');
		if(c == true){
			$('#product_register').attr({
				'method':'post',
				'action':'productupdate.do',
				'enctype':'multipart/form-data'
			});
			$('#product_register').submit();
		};
	});
});

$(document).ready(function(){
	$('#d_bt').click(function(){
		var c = confirm('삭제하시겠습니까?');
		if(c == true){
			$('#product_register').attr({
				'method':'post',
				'action':'productdelete.do'
			});
			$('#product_register').submit();
		};
	});
});
</script>


<div id="main_center">
<h1>Product Modify Page</h1>

<form id="product_register">
	ID <input type="number" name="id" id="id" value =${product.id} readonly><br>
	NAME <input type="text" name="name" id="name" value =${product.name} ><br>
	PRICE <input type="number" name="price" id="price" value =${product.price} ><br>
	REGDATE <input type="text" name="regdate" id="regdate" value =${product.regdate} disabled="disabled"><br>
	IMGNAME <img src = "img/${product.imgname }" height="100" width="100" >
	<input type="file" name="mf"><br>
	<input type="hidden" name="imgname" id="imgname"><br>
	
	<br>
	
	<input type="button" value="MODIFY" id="m_bt"> &nbsp;
	<input type="button" value="DELETE" id="d_bt"> 
</form>

</div>

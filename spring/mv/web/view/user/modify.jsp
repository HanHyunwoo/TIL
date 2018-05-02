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
			$('#user_register').attr({
				'method':'post',
				'action':'userupdate.do',
				'enctype':'multipart/form-data'
			});
			$('#user_register').submit();
		};
	});
});

$(document).ready(function(){
	$('#d_bt').click(function(){
		var c = confirm('삭제하시겠습니까?');
		if(c == true){
			$('#user_register').attr({
				'method':'post',
				'action':'userdelete.do',
				'enctype':'multipart/form-data'
			});
			$('#user_register').submit();
		};
	});
});
</script>


<div id="main_center">
<h1>User Modify Page</h1>

<form id="user_register">
	ID<input type="text" name="id" id="id" value =${user.id} readonly><br>
	PWD<input type="text" name="pwd" id="pwd" value= ${user.pwd}><br>
	NAME<input type="text" name="name" id="name" value=${user.name}><br>
	
	<input type="button" value="MODIFY" id="m_bt"> &nbsp;
	<input type="button" value="DELETE" id="d_bt"> 
</form>

</div>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   
<script>
$(document).ready(function(){
   $('#r_bt').click(function(){
      var c = confirm('등록 하시겠습니까?');
      if(c == true){
         
         $('#user_register').attr({
            'method':'post',
            'action':'useraddimpl.do'
         });
         $('#user_register').submit();
      };
   });
});
</script>
<title>Insert title here</title>
</head>
<body> 
<form id="user_register">
ID<input type="text" name="id" id="id"><br>
PWD<input type="text" name="pwd" id="pwd"><br>
NAME<input type="text" name="name" id="name"><br>
<input type="button" value="REGISTER" id="r_bt">
</form>
</body>
</html>
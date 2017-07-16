<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
</head>
<body>
	<div>	
		<form id="iform" name="iform">
			<input type="button" value="提交" name="tijiao" onclick="getStrutsJson()">
		</form>
	</div>
</body>
<script type="text/javascript" src="pages/vendor/jQuery/jquery-1.7.2.min.js"></script>

<script type="text/javascript">
function getStrutsJson() {
	$.ajax({
		type: 'post',
		url: 'login_login',
		//url: 'index_index',
		data: {login_name:"admin",password:"adminss",is_remember:"0"},
        dataType: "json",
		success : succFunction
	});
}

function succFunction(tt) { 
    var json = eval(tt); //数组   
    alert("aaaaaaaaaaaaaaaaaa");
    alert(json);
    alert(json.retmsg);
   } 
</script>
</html>
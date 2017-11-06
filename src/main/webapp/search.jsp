<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<div>
	<div>
		<h2>查询手机号码</h2>
		<form action="search" method="post">
			电话号码:<input type="text" name="tel">
			<input type="submit" value="查询">
		</form>
	</div>
	<div>
		<p>查询结果</p>
		<p>${result }</p>
	</div>
</div>	
</body>
</html>

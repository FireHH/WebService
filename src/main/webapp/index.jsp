<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h3>录入数据</h3>
 <form action="uploadexcel" method="post" enctype="multipart/form-data">
	选择文件<input type="file" name="file">
	<input type="submit" value="上传">
</form>
</body>
</html>

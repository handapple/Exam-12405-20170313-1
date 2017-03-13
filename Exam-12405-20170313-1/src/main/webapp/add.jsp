<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="FilmServlet" method="post">
		<table>
			<tr>
				<td>Title:</td>
				<td><input name="title"/></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><input name="description"/></td>
			</tr>
			<tr>
				<td>Language:</td>
				<td><select name="language" value="US">
						<option value="ZHS">中文</option>
						<option value="US">English</option>
					</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="增加"/></td>
				<td><input type="hidden" name="operate" value="add"/></td>
			</tr>
		</table>
	</form>
</body>
</html>
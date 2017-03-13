<%@page import="domain.Film"%>
<%@page import="java.util.List"%>
<%@page import="service.FilmService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>
<% List<Film> list = new FilmService().getResultList();%>
<a href="add.jsp">增加</a><p/>
	<table border="1">
		<tr>
			<th>Film_id</th>
			<th>Title</th>
			<th>Description</th>
			<th>Language</th>
			<th>操作</th>
		</tr>
		<% for(Film f : list){%>
		
		<tr>
			<td><%=f.getFilm_id() %></td>
			<td><%=f.getTitle() %></td>
			<td><%=f.getDescription() %></td>
			<td><%=f.getLanguage() %></td>
			<td><a href="update.jsp?film_id=<%=f.getFilm_id() %>">编辑</a> &nbsp;&nbsp;<a href="FilmServlet?operate=delete&film_id=<%=f.getFilm_id() %>">删除</a></td>
		</tr>
		<%} %>

	</table>

</body>
</html>
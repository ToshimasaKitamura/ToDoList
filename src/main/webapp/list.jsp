<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, java.util.ArrayList, model.dao.dto.TodoDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo List</title>
</head>
<body>
 	<%
        List<TodoDTO> todoList = (List) request.getAttribute("todoList");
    %>
    <% for(TodoDTO todo: todoList){  %>
		<div>
			<h5><%=todo.getTodo()%></h5>
			<h6><%=todo.getTimeLimit()%></h6>
			<a href="update-servlet?<%=constant.Parameters.TODO_ID %>=<%= todo.getId() %>">todoを更新する</a>
			<a href="delete-servlet?<%=constant.Parameters.TODO_ID %>=<%= todo.getId() %>">todoを削除する</a>
			<br></br>
		</div>
    <%
    	} 
    %>
    <form action="insert-servlet" method="post">
    	<label>Todo: </label><input type="text" name=<%= constant.Parameters.TODO %>>><br>
    	<label>Limit: </label><input type="date" name=<%= constant.Parameters.TIME_LIMIT %>>> <br>
    	<input type="submit" value="Todoを登録する">
	</form>

</body>
</html>
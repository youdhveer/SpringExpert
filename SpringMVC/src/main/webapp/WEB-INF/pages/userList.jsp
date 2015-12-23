<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User</title>
</head>
<body>
<h2>Here is a simple CRUD using Spring MVC and MongoDB.</h2>

  	<form action="user/saveUser" method="post">
		<input type="hidden" name="id">
		<label for="name">User name</label>
		<input type="text"  name="name"/> 
		<label for="age">Age</label>
		<input type="text"  name="age"/>
		<input type="submit" value="Add user"/>
	</form>
	<br>
	<form action="user/search" method="post">		
		<label for="searchText">Search User (By Name)</label>
		<input type="text" name="searchText"/> 
		<!-- <label for="age">Age</label>
		<input type="text" name="age"/> -->
		<input type="submit" value="Search"/>
	</form>
	<br>
	<div>Search result :: 
		<span style="color:red;"><c:if test="${!(empty userList)}">${userList.size()}</c:if>
								
		</span>
	</div>
	<br>
	<h5>List of users</h5>
    <table border="1">
    	<thead>
    	<tr><td>Name</td><td>Age</td></tr>
    	</thead>
    	
		<c:forEach var="user" items="${userList}"> 
		<tr>
		<td>${user.name}</td> 
		<td>${user.age}</td>
		</tr>
		</c:forEach>
	</table>        
</body>
</html>

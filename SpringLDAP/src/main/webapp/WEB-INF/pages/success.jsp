<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User</title>
</head>
<body>
<h2>You have successfully authenticated via Spring LDAP</h2>
	
	<br>
	<h5>Authenticated User Details</h5>
    <table border="1">
    	<thead>
    	<tr><td>Name</td><td>Email</td></tr>
    	</thead>
		<tr>
		<td>${userProfile.userName}</td> 
		<td>${userProfile.email} </td>
		</tr>
		
	</table> 
	
	<br/>
	<a href="/SpringLDAP/logout">Logout</a>  
	     
</body>
</html>

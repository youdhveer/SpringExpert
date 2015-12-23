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

  	<form action="stock/add" method="post">
		<input type="hidden" name="id">
		<label for="name">Stock name</label>
		<input type="text"  name="name"/> 
		<label for="symbol">Symbol</label>
		<input type="text"  name="symbol"/>
		<input type="submit" value="Add stock"/>
	</form>
	<br>
	<!-- <form action="stock/search" method="post">		
		<label for="searchText">Search User (By Name)</label>
		<input type="text" name="searchText"/> 
		<label for="age">Age</label>
		<input type="text" name="age"/>
		<input type="submit" value="Search"/>
	</form> -->
	<br>
	<div>Search result :: 
		<span style="color:red;"><c:if test="${!(empty stockList)}">${stockList.size()}</c:if>
								
		</span>
	</div>
	<br>
	<h5>List of Stocks</h5>
    <table border="1">
    	<thead>
    	<tr><td>Id</td><td>Name</td><td>Symbol</td></tr>
    	</thead>
    	
		<c:forEach var="stock" items="${stockList}"> 
		<tr>
		<td>${stock.id}</td> 
		<td>${stock.name}</td> 
		<td>${stock.symbol}</td>
		<td><input type="button" value="Live Quote" onclick="liveQuotes(${stock.symbol})"/></td>
		</tr>
		</c:forEach>
	</table>   
	
	<div id="liveQuoteDiv">
	
	
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>    
        function liveQuotes(symbol){
        	 alert(symbol);       	 
        	 $.ajax(
        		 {
        		   url: "liveQuote", 
        		   data:{symbol:symbol}
        		   success: function(result){
        			   $('#liveQuoteDiv').html(result);
		           }
        	 });
        }
		
		    
		
</script>
     
</body>
</html>

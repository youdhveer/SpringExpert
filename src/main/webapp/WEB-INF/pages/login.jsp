<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <spring:url value="/static/css/bootstrap.min.css" var="bootstrapCss" />	
	<spring:url value="/static/js/bootstrap.min.js" var="bootstrapJs" />

	
	<link href="${bootstrapCss}" rel="stylesheet" />       
	
<title>Spring LDAP Authentication </title>
</head>
<body>

<h3>Spring LDAP Authentication # using Spring LDAP Template</h3>
<br/>

<form class="form-horizontal" action="login" method="post">

<fieldset>
	    <div class="control-group">
	     <label class="control-label" for="email">Email</label>
	     <div class="controls">
	       <input type="text" class="input-small" name="email">
	       <p class="help-block"></p>
	     </div>
	   </div>
	   <div class="control-group">
	     <label class="control-label" for="password">Password</label>
	     <div class="controls">
	       <input type="password" class="input-small" name="password">
	       <p class="help-block"></p>
	     </div>
	   </div>	   
    
	   <div class="control-group "> 
	      <div class="controls">     
		   <input type="submit" value="Login" class="btn btn-primary" />
		  </div>
	   </div>
	   
	    <div class="control-group "> 
	      <div class="controls">     
		    <span style="color:red;">${Error}</span>
		  </div>
	   </div>	  
	   
	   
   </fieldset>
</form>

<br/>
<h3>Simple LDAP Via JNDI Example :: Search User</h3>
<form class="form-horizontal">
<fieldset>
	    <div class="control-group">
	     <label class="control-label" for="emailId">Email</label>
	     <div class="controls">
	       <input type="text" class="input-small" id="emailId">
	       <p class="help-block"></p>
	     </div>
	   </div>	   
    
	   <div class="control-group "> 
	      <div class="controls">     
		   <input type="button" value="Search" class="btn btn-primary" onclick="searchUser()"/>
		  </div>
	   </div>	   
   </fieldset>
</form>


<script	src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="${bootstrapJs}"></script>
<script>
function searchUser(){
	
	var emailId=$('#emailId').val();
	var contextPath='<%=request.getContextPath()%>';
	location.href=contextPath+'/searchLDAPUser?email='+emailId;
	
	/* $.ajax({
		url:"rest/login",
		method :'GET',
		data:{name : name, password : password},
		success:function(response) {
			console.log(response);
	    },
	    error:function(jqXHR,textStatus,errorThrown){
	    	
	    }
			
     }); */
	
	
}

</script>
	
</body>
</html>
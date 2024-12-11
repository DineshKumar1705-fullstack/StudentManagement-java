<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Entries</title> 
<link rel="stylesheet" href="Style.css">

<style>


	*
	{
			font-size:20px;
	
	}
	
	.mydiv
	{
			display:flex;
			justify-content:center;
			height:35em;
			align-items:center;
			background:linear-gradient(blue,white);
	}

	.condiv
	{
			border: 1px solid black;
			border-radius: 15px;
			padding:15px;
			display:flex;
			flex-direction:column;
			justify-content:space-between;				
	}
	
	input[type=text]
	{
	
			padding:8px;
			border-radius:10px;
			border:none;
			font-size:17px;
	
	}
	
	option
	{
	
			font-size:14px;
	
	}
	
	
	
	.buttons
	{
		
			display:flex;
			justify-content:center;
			flex-direction:column;
			margin-left:100px;
			
	
	}
	
	input[type=submit]
	{
			color:red;
			width:45%;
			padding:5px;
			border-radius:10px;
			border:none;
			margin-bottom:4px;
			cursor:pointer;
	}
	
	input[type=submit]:hover
	{
	
		scale:1.02;
		transition:0.2s;
		background-color:tomato;
		color:white;	
	
	}
	
	
	
</style>

</head>
<body>
	<%
String sname=""+request.getParameter("StudentName");
String sreg=""+request.getParameter("StudentRegistration");
String sdept=""+request.getParameter("StudentDepartment");
%>
<div class="mydiv">
<form action="/studentcrud" method="post">
<h1 style="font-size:40px; color:white; text-shadow: 5px 2px 4px gray;">STUDENT RECORD</h1>
<div class="condiv">
<%
if(sname.equals("null"))
{
%>
<input type="text" name="StudentName" value="" placeholder="Enter Student Name" /><br>
<% 
}
else{
	%>
	<input type="text" name="StudentName" value="<%=sname%>"/><br>
	<%
}
if(sreg.equals("null"))
{
%>
<input type="text" name="StudentRegistration" value="" placeholder="Enter Student Registration"/><br>
<%
}
else
{
	%>
	<input type="text" name="StudentRegistration" value="<%=sreg%>"/><br>
	<%
}
%>
<select name="StudentDepartment">
<%
if(sdept.equals("cse"))
{
	%>
	<option value="cse" selected="selected">COMPUTER SCIENCE</option>
	<option value="ece">ELECTRONICS</option>
	<option value="eee">ELECTRICAL</option>
	<%
}
else if(sdept.equals("ece"))
{
	%>
	<option value="cse">COMPUTER SCIENCE</option>
	<option value="ece" selected="selected">ELECTRONICS</option>
	<option value="eee">ELECTRICAL</option>
	<%
}
else if(sdept.equals("eee"))
{
	%>
	<option value="cse">COMPUTER SCIENCE</option>
	<option value="ece">ELECTRONICS</option>
	<option value="eee" selected="selected">ELECTRICAL</option>
	<%
}
else if(sdept.equals("null"))
{
	%>
	<option value="cse">COMPUTER SCIENCE</option>
	<option value="ece">ELECTRONICS</option>
	<option value="eee">ELECTRICAL</option>
	<%
}
%>
</select>
<br>
<div class="buttons">
<input type="submit" name="save" value="SAVE"/>
<input type="submit" name="open" value="OPEN"/>
<input type="submit" name="update" value="UPDATE"/>
<input type="submit" name="delete" value="DELETE"/>
<input type="submit" name="openall" value="OPENALL"/><br>
</div>
</div>
</form>
</div>
</body>
</html>
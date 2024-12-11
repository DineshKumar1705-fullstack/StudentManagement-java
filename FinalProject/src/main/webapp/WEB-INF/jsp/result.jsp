<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="com.example.FinalProject.StudentEntity" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

table
{

		display:flex;
		justify-content:center;
		border: none;

}

tr,th
{

		padding:10px;
		text-align:center;

}

</style>

</head>
<body>

	<%
if(request.getAttribute("student")!=null)
{
	%>
<jsp:include page="StudentDetails.jsp"/>
<table border="1">
<tr>
<th>ID</th>
<th>Name</th>
<th>RegisterNo</th>
<th>Department</th>
</tr>
<%
ArrayList<StudentEntity> m=(ArrayList<StudentEntity>)request.getAttribute("student");
Iterator<StudentEntity> i=m.iterator();
while(i.hasNext())
{
	StudentEntity s=i.next();
	%>
	<tr>
	<td><%=s.getStudentID()%></td>
	<td><%=s.getStudentName()%></td>
	<td><%=s.getStudentRegistration()%></td>
	<td><%=s.getStudentDepartment()%></td>
	</tr>
	<%
	//out.println(s.getStname());
}
}
else if(request.getAttribute("studentreg")!=null)
{
	out.print(request.getAttribute("studentreg"));
	StudentEntity s=(StudentEntity)request.getAttribute("studentreg");
	%>
	<jsp:forward page="StudentDetails.jsp">
	<jsp:param value="<%=s.getStudentName()%>" name="StudentName"/>
	<jsp:param value="<%=s.getStudentRegistration()%>" name="StudentRegistration"/>
	<jsp:param value="<%=s.getStudentDepartment()%>" name="StudentDepartment"/>
	</jsp:forward>
	<%
	}
%>
</table>

</body>
</html>
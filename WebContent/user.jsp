<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New User</title>
</head>
<body>
	<form method="post" action="UserController" name="frmAddUser">
		<input type="hidden" name="action" value="insert"/>
		<p><b>Add User</b></p>
		<table>
		<tr>
				<td>Id</td>
				<td><input type="text" name="userId"/></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="fName"/></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lName"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit"/></td> 
			</tr>
		</table>
	</form>
	<p><a href="UserController?action=listUser">View All User</a></p>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.haluan.bean.*"%>
<%@ page import="com.haluan.dao.*"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All User</title>
</head>
<body>
<%if (session.getAttribute("firstName")!=null)%>
<p><a href="logIn?action=logout">Logout</a>

<p><%=session.getAttribute("firstName") %></p>
<%if (session.getAttribute("firstName")!=null){ %>
<%
//UserBean user = new UserBean();
UserDao dao = new UserDao();
List<UserBean> userList = null;
userList= dao.getAllUsers();
//Iterator<UserBean> itr = userList.iterator();
%>
<table border="1">
<tr>
<th>Id</th>
<th>First Name</th>
<th>Last Name</th>
</tr>
<tr>
<%
/*while(itr.hasNext())
{
System.out.println(user.getId());*/
for (UserBean user : userList) {
%>
<td><%=user.getId()%></td>
<td><%=user.getfName()%></td>
<td><%=user.getlName()%></td>
<td><a
href="UserController?action=editform&userId=<%=user.getId()%>">Update</a></td>
<td><a
href="UserController?action=delete&userId=<%=user.getId()%>">Delete</a></td>

</tr>
<%
}
//}
%>
</table>
<p><a href="UserController?action=insert">Add User</a></p>
<% } %>
</body>
</html>
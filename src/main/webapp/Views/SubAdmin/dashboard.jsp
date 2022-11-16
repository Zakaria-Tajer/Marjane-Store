<%@ page import="Marj.Controller.AdminController" %><%--
  Created by IntelliJ IDEA.
  User: cosmi
  Date: 11/14/2022
  Time: 12:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dashboard</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="${pageContext.request.contextPath}/WebComponents/SubAdminNavbar.js" type="module"></script>


</head>
<body>


<%
    AdminController admins = new AdminController();

    if(session.getAttribute("unique_id") == null) {
        response.sendRedirect(".");
    }

%>

<div class="min-h-screen bg-gray-100">
    <nav-component></nav-component>
</div>
</body>
</html>

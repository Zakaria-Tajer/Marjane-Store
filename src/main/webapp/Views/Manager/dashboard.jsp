<%@ page import="Marj.Controller.ManagerController" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.PromotionsEntity" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="Marj.Data.ManagerData" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %><%--
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
    <script src="${pageContext.request.contextPath}/WebComponents/ManagerNavbar.js" type="module"></script>

    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link
            href="https://fonts.googleapis.com/css2?family=Roboto:wght@500&display=swap"
            rel="stylesheet"
    />
    <script
            src="https://kit.fontawesome.com/8464c41458.js"
            crossorigin="anonymous"
    ></script>

    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link
            href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap"
            rel="stylesheet"
    />
</head>
<body>

<%
    if (session.getAttribute("unique_id") == null) {
        response.sendRedirect(".");
    }
    ManagerController managerController = new ManagerController();
    ManagerData managerData = new ManagerData();
%>

<div class="min-h-screen bg-gray-100 flex">
    <nav-component></nav-component>


    <div class="w-full bg-white min-h-screen">
        <div
                class="m-14 px-3 w-fit h-fit py-2 flex justify-center items-center space-x-5"
        >
            <h1 class="text-xl" style="font-family: 'Roboto', sans-serif">
                Dashboard
            </h1>
            <i class="fa-solid fa-chevron-right"></i>

            <div
                    class="flex justify-center items-center cursor-pointer hover:bg-gray-100 px-6 rounded py-2 space-x-4"
            >
                <i class="fa-solid fa-user"></i>
                <h1 class="text-xl" style="font-family: 'Roboto', sans-serif">
                    Make-Promotion
                </h1>
            </div>
        </div>


        <%
            Calendar rightNow = Calendar.getInstance();
            int hour = rightNow.get(Calendar.HOUR_OF_DAY);

            if (hour < 8 || hour <= 12) {

        %>
        <div class="overflow-x-auto m-14 px-3 py-2 relative shadow-md sm:rounded-lg w-3/4">
            <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
                <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                <tr>
                    <th scope="col" class="py-3 px-6">
                        Promotion id
                    </th>
                    <th scope="col" class="py-3 px-6">
                        reduction
                    </th>
                    <th scope="col" class="py-3 px-6">
                        Stock
                    </th>
                    <th scope="col" class="py-3 px-6">
                        Center id
                    </th>
                    <th scope="col" class="py-3 px-6">
                        Category id
                    </th>
                    <th scope="col" class="py-3 px-6">
                        expiring date
                    </th>
                    <th scope="col" class="py-3 px-6">
                        Status
                    </th>
                    <th scope="col" class="py-3 px-6">
                        Action
                    </th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (PromotionsEntity promos : ManagerData.getPromos()) {
                %>
                <tr class="bg-white border-b dark:bg-gray-900 dark:border-gray-700">
                    <th scope="row" class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                        <%= promos.getPromotionId()%>
                    </th>
                    <td class="py-4 px-6">
                        <%= promos.getReduction()%>
                    </td>
                    <td class="py-4 px-6">
                        <%= promos.getStock()%>
                    </td>
                    <td class="py-4 px-6">
                        <%= promos.getCentersByCenterId().getCity()%>
                    </td>

                    <td class="py-4 px-6">
                        <%= promos.getCategoryByCategoryId().getCategoryName()%>
                    </td>
                    <td class="py-4 px-6">
                        <%= promos.getPromotionExpiringDate()%>
                    </td>
                    <td class="py-4 px-6">
                        <%= promos.getStatus()%>
                    </td>
                    <td class="py-4 px-6">
                        <a href="./EditPromotions.jsp"
                           class="font-medium text-blue-600 dark:text-blue-500 hover:underline">Edit</a>
                    </td>
                </tr>
                <%

                    }
                %>
                </tbody>
            </table>
        </div>

        <%
        } else {
        %>

        <div class="w-full h-1/2 flex items-center justify-center flex-col">
            <iframe class="w-1/2 h-96" src="https://embed.lottiefiles.com/animation/51661"></iframe>
            <h1 class="text-2xl text-[#0055A6]" style="font-family: 'Poppins', sans-serif">Closed</h1>
        </div>

        <%
            }
        %>

    </div>
</div>
</body>
</html>

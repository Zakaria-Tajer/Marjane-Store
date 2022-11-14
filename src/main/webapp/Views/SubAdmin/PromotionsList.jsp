<%@ page import="entity.PromotionsEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="Marj.Controller.PromotionsController" %>
<%@ page import="Marj.Admin" %><%--
  Created by IntelliJ IDEA.
  User: cosmi
  Date: 11/14/2022
  Time: 12:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>P-List</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="${pageContext.request.contextPath}/WebComponents/SubAdminNavbar.js" type="module"></script>
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
    PromotionsController promotionsController = new PromotionsController();
    List<PromotionsEntity> promo = promotionsController.getAllPromotions();
    Admin admin = new Admin();
%>

<div class="min-h-screen bg-gray-100 flex">
    <nav-component></nav-component>

    <div class="w-full h-full m-14 px-3 py-2 space-y-20">
        <div
                class="  w-fit h-fit py-2 flex justify-center items-center space-x-5"
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
                    Create-Manager
                </h1>
            </div>
        </div>
        <div class="overflow-x-auto relative shadow-md sm:rounded-lg w-3/4 ">
            <form action="${pageContext.request.contextPath}/PromotionsList" method="post" class="w-fit">
                <div class="w-fit space-x-5 ml-auto py-2 px-4 mb-2 bg-transparent flex items-center justify-end">
                    <button class="px-10 py-3 rounded-md hover:bg-blue-600 bg-[#0055A6] text-white"
                            style="font-family: 'Roboto', sans-serif" value="1" name="promotions">list of approved
                        promotions
                    </button>
                    <button class="px-10 py-3 rounded-md hover:bg-blue-600 bg-[#0055A6] text-white"
                            style="font-family: 'Roboto', sans-serif" value="2" name="promotions">list of waiting
                        promotions
                    </button>
                    <button class="px-10 py-3 rounded-md hover:bg-blue-600 bg-[#0055A6] text-white"
                            style="font-family: 'Roboto', sans-serif" value="3" name="promotions">list of previous
                        promotions
                    </button>
                    <button class="px-10 py-3 rounded-md hover:bg-blue-600 bg-[#0055A6] text-white"
                            style="font-family: 'Roboto', sans-serif" value="4" name="promotions">list of today
                        promotions
                    </button>
                </div>
            </form>


            <div class="overflow-x-auto relative shadow-md sm:rounded-lg">
                <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
                    <thead class="text-xs text-gray-700 uppercase dark:text-gray-400">
                    <tr>
                        <th scope="col" class="py-3 px-6 bg-gray-50 dark:bg-gray-800">
                            Promotion id
                        </th>
                        <th scope="col" class="py-3 px-6">
                            reduction %
                        </th>
                        <th scope="col" class="py-3 px-6 bg-gray-50 dark:bg-gray-800">
                            promotion unique_id
                        </th>
                        <th scope="col" class="py-3 px-6">
                            Status
                        </th>
                        <th scope="col" class="py-3 px-6">
                            Expiration Date
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        if (session.getAttribute("promotion") != null) {

                            switch ((int) session.getAttribute("promotion")) {
                                case 1: {
                                    for (PromotionsEntity promotion : admin.promosGetter(promo, "!")) {

                    %>
                    <tr class="border-b border-gray-200 dark:border-gray-700">
                        <th scope="row"
                            class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap bg-gray-50 dark:text-white dark:bg-gray-800">
                            <%= promotion.getPromotionId()%>
                        </th>
                        <td class="py-4 px-6">
                            <%= promotion.getReduction()%>
                        </td>
                        <td class="py-4 px-6 bg-gray-50 dark:bg-gray-800">
                            <%= promotion.getPromotionUniqueId()%>
                        </td>
                        <td class="py-4 px-6">
                            <%= promotion.getStatus()%>
                        </td>
                        <td class="py-4 px-6">
                            <%= promotion.getPromotionExpiringDate()%>
                        </td>
                    </tr>

                    <%
                            }
                        }
                        break;
                        case 2: {
                            for (PromotionsEntity promotion : admin.promosGetter(promo, "")) {
                    %>

                    <tr class="border-b border-gray-200 dark:border-gray-700">
                        <th scope="row"
                            class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap bg-gray-50 dark:text-white dark:bg-gray-800">
                            <%= promotion.getPromotionId()%>
                        </th>
                        <td class="py-4 px-6">
                            <%= promotion.getReduction()%>
                        </td>
                        <td class="py-4 px-6 bg-gray-50 dark:bg-gray-800">
                            <%= promotion.getPromotionUniqueId()%>
                        </td>
                        <td class="py-4 px-6">
                            <%= promotion.getStatus()%>
                        </td>
                        <td class="py-4 px-6">
                            <%= promotion.getPromotionExpiringDate()%>
                        </td>
                    </tr>

                    <%

                            }
                        }
                        break;
                        case 3: {
                            for (PromotionsEntity promotion : admin.promotionsGetterFilteredByDate(promo, "")) {
                    %>

                    <tr class="border-b border-gray-200 dark:border-gray-700">
                        <th scope="row"
                            class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap bg-gray-50 dark:text-white dark:bg-gray-800">
                            <%= promotion.getPromotionId()%>
                        </th>
                        <td class="py-4 px-6">
                            <%= promotion.getReduction()%>
                        </td>
                        <td class="py-4 px-6 bg-gray-50 dark:bg-gray-800">
                            <%= promotion.getPromotionUniqueId()%>
                        </td>
                        <td class="py-4 px-6">
                            <%= promotion.getStatus()%>
                        </td>
                        <td class="py-4 px-6">
                            <%= promotion.getPromotionExpiringDate()%>
                        </td>
                    </tr>
                    <%

                            }
                        }
                        break;

                        case 4: {
                            for (PromotionsEntity promotion : admin.promotionsGetterFilteredByDate(promo, "Today")) {
                    %>
                    <tr class="border-b border-gray-200 dark:border-gray-700">
                        <th scope="row"
                            class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap bg-gray-50 dark:text-white dark:bg-gray-800">
                            <%= promotion.getPromotionId()%>
                        </th>
                        <td class="py-4 px-6">
                            <%= promotion.getReduction()%>
                        </td>
                        <td class="py-4 px-6 bg-gray-50 dark:bg-gray-800">
                            <%= promotion.getPromotionUniqueId()%>
                        </td>
                        <td class="py-4 px-6">
                            <%= promotion.getStatus()%>
                        </td>
                        <td class="py-4 px-6">
                            <%= promotion.getPromotionExpiringDate()%>
                        </td>
                    </tr>

                    <%

                                    }
                                }
                                break;
                            }
                        }
                    %>


                    </tbody>
                </table>
            </div>


        </div>

    </div>

</div>
</body>
</html>

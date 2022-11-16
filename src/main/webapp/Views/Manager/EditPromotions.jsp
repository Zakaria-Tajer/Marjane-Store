<%@ page import="entity.PromotionsEntity" %>
<%@ page import="Marj.Data.ManagerData" %>
<%@ page import="Marj.Controller.PromotionsController" %><%--
  Created by IntelliJ IDEA.
  User: cosmi
  Date: 11/14/2022
  Time: 6:14 AM
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

    PromotionsController promotionsController = new PromotionsController();

%>
<div class="w-full bg-gray-400 min-h-screen flex">
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
                    Edit-Promotions
                </h1>
            </div>
        </div>

        <div
                class="flex relative justify-evenly items-center h-1/3 justify-center h-3/4 w-full"
        >
            <form
                    action="${pageContext.request.contextPath}/UpdatePromotions"
                    method="post"
                    class="w-2/5 space-x-2 rounded-md h-fit py-3 px-3 bg-white shadow-2xl rounded-md space-y-20"
            >
                <div class="absolute top-2 w-2/5 flex items-center justify-center">
                    <video autoplay="autoplay" muted="muted" loop="loop" class="w-56 bg-transparent rounded-lg">
                        <source type="video/mp4"
                                src="https://cdnl.iconscout.com/lottie/premium/thumb/customer-support-of-promotions-4203164-3500234.mp4">
                    </video>
                </div>
                <div
                        class="flex items-center space-y-4 justify-center mt-6 flex-col h-fit py-4"
                >
                    <h1
                            style="font-family: 'Poppins', sans-serif"
                            class="text-center py-2 text-xl"
                    >
                        Update promotions
                    </h1>
                    <div class="w-full flex items-center justify-center">
                        <%
                            if(session.getAttribute("errorMsg") == null && session.getAttribute("successUpdate") != null){
                        %>
                        <div class="w-2/3 bg-green-600 py-3 px-3 rounded-md">
                            <h1 class="text-white text-center" style="font-family: 'Poppins', sans-serif">
                                <%= session.getAttribute("successUpdate")%>
                            </h1>
                        </div>
                        <%
                        }  else if(session.getAttribute("errorMsg") != null && session.getAttribute("successUpdate") == null){
                        %>
                        <div class="w-2/3 bg-red-600 py-3 px-3 rounded-md">
                            <h1 class="text-white text-center" style="font-family: 'Poppins', sans-serif">
                                <%= session.getAttribute("errorMsg")%>
                            </h1>
                        </div>
                        <%
                        } else {
                        %>
                        <%

                            }
                        %>
                    </div>
                    <div
                            class="w-2/3 mt-10 h-fit space-y-4 flex items-center flex-col justify-center"
                    >
                        <div class="space-y-4 w-full flex flex-col">
                            <label style="font-family: 'Poppins', sans-serif">Promotion Status</label>
                            <select  name="promotionsId" class="py-3 px- outline-none border-2 border-gray-400 focus:border-[#0055A6] rounded-md">
                                <%
                                    for (PromotionsEntity promos : promotionsController.getAllPromotionsByStatus()) {
                                %>
                                <option  value="<%= promos.getPromotionId()%>"><%= promos.getPromotionId()%> : <%= promos.getCentersByCenterId().getCity() %>
                                </option>
                                <%
                                    }
                                %>
                            </select>
                        </div>

                        <div class="space-y-4 w-full flex flex-col">
                            <label style="font-family: 'Poppins', sans-serif">Promotion Status</label>
                            <select name="promotionsStatus" class="py-3 px- outline-none border-2 border-gray-400 focus:border-[#0055A6] rounded-md">
                                <option value="Accept" style="font-family: 'Poppins', sans-serif">Accept</option>
                            </select>
                        </div>
                    </div>
                    <div
                            class="w-2/3 h-fit space-y-4 flex items-center flex-col justify-center"
                    >
                        <button
                                class="w-full text-white rounded-md py-4 bg-[#0055A6] hover:bg-[#00488d] duration-500"
                                style="font-family: 'Poppins', sans-serif"
                        >
                            update
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

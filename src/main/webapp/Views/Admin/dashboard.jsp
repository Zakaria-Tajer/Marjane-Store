<%@ page import="Marj.Controller.AdminController" %>
<%@ page import="Marj.Data.AdminsCount" %>
<%@ page import="entity.AdminEntity" %>
<%@ page import="entity.CentersEntity" %><%--
  Created by IntelliJ IDEA.
  User: cosmi
  Date: 11/2/2022
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dashboard</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="${pageContext.request.contextPath}/WebComponents/Navbar.js" type="module"></script>
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
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>


</head>
<body>
<%
    AdminController admins = new AdminController();


%>
<div class="w-full min-h-screen flex">
    <nav-component></nav-component>

    <div class="w-full min-h-screen bg-[#EEEEEE] space-y-12 py-10 px-10">
        <h1 class="text-3xl mb-5">Dashboard</h1>

        <div
                class="w-full h-fit py-2 px-2 space-x-3 flex justify-center items-center"
        >
            <div
                    class="w-1/3 bg-[#438FFE] space-y-4 h-56 px-3 py-3 cursor-pointer rounded-md"
            >
                <div class="flex w-full justify-between items-center">
                    <div class="py-3 px-3 bg-gray-100 w-fit rounded-md">
                        <i class="fa-solid fa-users text-3xl text-gray-500"></i>
                    </div>
                    <!--  -->
                    <h1>Chart here</h1>
                    <!--  -->
                </div>
                <div class="w-full">
                    <h1 style="font-family: 'Poppins', sans-serif" class="text-white">
                        Total Admins
                    </h1>
                    <h1 style="font-family: 'Poppins', sans-serif" class="text-white">
                        <%= session.getAttribute("countsAdmin") %>


                    </h1>
                </div>
                <div class="w-full border-2 border-white"></div>

                <h1 id="dates" style="font-family: 'Poppins', sans-serif"></h1>
            </div>

            <div
                    class="w-1/3 bg-white space-y-4 h-56 px-3 py-3 cursor-pointer rounded-md"
            >
                <div class="flex w-full justify-between items-center">
                    <div class="py-3 px-5 bg-gray-100 w-fit rounded-md">
                        <i class="fa-solid fa-user text-3xl"></i>
                    </div>
                    <!--  -->
                    <h1>Chart here</h1>
                    <!--  -->
                </div>
                <div class="w-full">
                    <h1 style="font-family: 'Poppins', sans-serif" class="">
                        New Admins
                    </h1>
                    <h1 style="font-family: 'Poppins', sans-serif" class="">
                        <%= session.getAttribute("countsNewAdmins") %>
                    </h1>
                </div>
                <div class="w-full border-2 border-gray-400"></div>

                <div class="flex items-center space-x-3">
                    <i class="fa-solid fa-plus text-[#0055A6]"></i>
                    <a
                            href="./AddSubAdmin.jsp"
                            style="font-family: 'Poppins', sans-serif"
                            class="text-[#0055A6]"
                    >Add New Admin</a
                    >
                </div>
            </div>

            <div
                    class="w-1/3 bg-white space-y-4 h-56 px-3 py-3 cursor-pointer rounded-md"
            >
                <div class="flex w-full justify-between items-center">
                    <div class="py-3 px-5 bg-gray-100 w-fit rounded-md">
                        <i class="fa-solid fa-users text-3xl text-gray-500"></i>
                    </div>
                    <!--  -->
                    <h1>Chart here</h1>
                    <!--  -->
                </div>
                <div class="w-full">
                    <h1 style="font-family: 'Poppins', sans-serif">Total managers</h1>
                    <h1 style="font-family: 'Poppins', sans-serif">
                        <%= session.getAttribute("countsManager") %>
                    </h1>
                </div>
                <div class="w-full border-2 border-gray-400"></div>

                <h1 id="dates" style="font-family: 'Poppins', sans-serif"></h1>
            </div>

            <div
                    class="w-1/3 bg-white space-y-4 h-56 px-3 py-3 cursor-pointer rounded-md"
            >
                <div class="flex w-full justify-between items-center">
                    <div class="py-3 px-5 bg-gray-100 w-fit rounded-md">
                        <i class="fa-solid fa-tag text-3xl"></i>
                    </div>
                    <!--  -->
                    <h1>Chart here</h1>
                    <!--  -->
                </div>
                <div class="w-full">
                    <h1 style="font-family: 'Poppins', sans-serif">
                        Total Promotions
                    </h1>
                    <h1 style="font-family: 'Poppins', sans-serif">
                        <%= session.getAttribute("countsPromotions") %>
                    </h1>
                </div>
                <div class="w-full border-2 border-gray-400"></div>

                <div class="flex items-center space-x-3">
                    <h1 class="text-gray-400">Promtions for today</h1>
                </div>
            </div>
        </div>

        <div class="flex space-x-4">
            <div class="overflow-x-auto relative w-2/3 shadow-md sm:rounded-lg">
                <table
                        class="w-full text-sm text-left text-gray-500 dark:text-gray-400"
                >
                    <thead
                            class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400"
                    >
                    <tr>
                        <th scope="col" class="py-3 px-6">Admin unique_id</th>
                        <th scope="col" class="py-3 px-6">email</th>
                        <th scope="col" class="py-3 px-6">role</th>
                        <th scope="col" class="py-3 px-6">Entry time</th>
                        <th scope="col" class="py-3 px-6">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for (AdminEntity admin : admins.getAllAdminsCenters()) {
                    %>
                    <tr
                            class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600"
                    >

                        <td class="py-4 px-6"><%= admin.getUniqueId()%>
                        </td>
                        <td class="py-4 px-6"><%= admin.getEmail()%>
                        </td>
                        <td class="py-4 px-6"><%= admin.getRole()%>
                        </td>
                        <td class="py-4 px-6"><%= admin.getNewCommers()%>
                        </td>
                        <td class="py-4 px-6">
                            <form action="${pageContext.request.contextPath}/DeleteAdmin" method="post">
                                <%--                                <a--%>
                                <%--                                        href="?id=<%= admin.getAdminId() %>"--%>
                                <%--                                        class="font-medium text-[#C70000] hover:underline"--%>
                                <%--                                        name="<%= admin.getAdminId() %>"--%>
                                <%--                                >Delete</a--%>
                                <%--                                >--%>
                                <input type="hidden" value="<%= admin.getAdminId() %>" name="id">
                                <input type="submit" placeholder="delete"
                                       class="font-medium text-[#C70000] hover:underline">
                            </form>
                        </td>
                    </tr>
                    <%
                        }
                    %>

                    </tbody>
                </table>
                <nav
                        class="flex justify-between items-center pt-4"
                        aria-label="Table navigation"
                >
              <span class="text-sm font-normal text-gray-500 dark:text-gray-400"
              >Showing
                <span class="font-semibold text-gray-900 dark:text-white"
                >1-10</span
                >
                of
                <span class="font-semibold text-gray-900 dark:text-white"
                >1000</span
                ></span
              >
                    <ul class="inline-flex items-center -space-x-px">
                        <li>
                            <a
                                    href="#"
                                    class="block py-2 px-3 ml-0 leading-tight text-gray-500 bg-white rounded-l-lg border border-gray-300 hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white"
                            >
                                <span class="sr-only">Previous</span>
                                <svg
                                        class="w-5 h-5"
                                        aria-hidden="true"
                                        fill="currentColor"
                                        viewBox="0 0 20 20"
                                        xmlns="http://www.w3.org/2000/svg"
                                        data-darkreader-inline-fill=""
                                        style="--darkreader-inline-fill: currentColor"
                                >
                                    <path
                                            fill-rule="evenodd"
                                            d="M12.707 5.293a1 1 0 010 1.414L9.414 10l3.293 3.293a1 1 0 01-1.414 1.414l-4-4a1 1 0 010-1.414l4-4a1 1 0 011.414 0z"
                                            clip-rule="evenodd"
                                    ></path>
                                </svg>
                            </a>
                        </li>
                        <li>
                            <a
                                    href="#"
                                    class="py-2 px-3 leading-tight text-gray-500 bg-white border border-gray-300 hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white"
                            >1</a
                            >
                        </li>
                        <li>
                            <a
                                    href="#"
                                    class="py-2 px-3 leading-tight text-gray-500 bg-white border border-gray-300 hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white"
                            >2</a
                            >
                        </li>
                        <li>
                            <a
                                    href="#"
                                    aria-current="page"
                                    class="z-10 py-2 px-3 leading-tight text-blue-600 bg-blue-50 border border-blue-300 hover:bg-blue-100 hover:text-blue-700 dark:border-gray-700 dark:bg-gray-700 dark:text-white"
                            >3</a
                            >
                        </li>
                        <li>
                            <a
                                    href="#"
                                    class="py-2 px-3 leading-tight text-gray-500 bg-white border border-gray-300 hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white"
                            >...</a
                            >
                        </li>
                        <li>
                            <a
                                    href="#"
                                    class="py-2 px-3 leading-tight text-gray-500 bg-white border border-gray-300 hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white"
                            >100</a
                            >
                        </li>
                        <li>
                            <a
                                    href="#"
                                    class="block py-2 px-3 leading-tight text-gray-500 bg-white rounded-r-lg border border-gray-300 hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white"
                            >
                                <span class="sr-only">Next</span>
                                <svg
                                        class="w-5 h-5"
                                        aria-hidden="true"
                                        fill="currentColor"
                                        viewBox="0 0 20 20"
                                        xmlns="http://www.w3.org/2000/svg"
                                        data-darkreader-inline-fill=""
                                        style="--darkreader-inline-fill: currentColor"
                                >
                                    <path
                                            fill-rule="evenodd"
                                            d="M7.293 14.707a1 1 0 010-1.414L10.586 10 7.293 6.707a1 1 0 011.414-1.414l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414 0z"
                                            clip-rule="evenodd"
                                    ></path>
                                </svg>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>

            <div
                    class="w-1/3 space-y-3 bg-white h-fit space-y-8 py-3 px-3 rounded-md"
            >
                <div class="flex justify-between items-center">
                    <h1>New & Recent Promotions</h1>
                    <h1>This week</h1>
                </div>
                <div class="flex items-center space-x-5">
                    <div class="flex items-center space-x-2">
                        <div class="w-4 h-4 rounded bg-[#84BCBC]"></div>
                        <h1 style="font-family: 'Poppins', sans-serif">New Promos</h1>
                    </div>
                    <div class="flex items-center space-x-2">
                        <div class="w-4 h-4 rounded bg-[#EA7651]"></div>
                        <h1 style="font-family: 'Poppins', sans-serif">Recent Promos</h1>
                    </div>
                </div>

                <canvas id="myChart"></canvas>
            </div>
        </div>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/WebComponents/ChartComponent.js"></script>
</html>

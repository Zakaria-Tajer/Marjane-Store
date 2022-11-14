<%@ page import="entity.CentersEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="Marj.Controller.SubAdminController" %>
<%@ page import="entity.CategoryEntity" %>
<%@ page import="Marj.Controller.CategorieController" %><%--
  Created by IntelliJ IDEA.
  User: cosmi
  Date: 11/14/2022
  Time: 12:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create-M</title>
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
    SubAdminController subAdminController = new SubAdminController();
    CategorieController categorieController = new CategorieController();
    List<CentersEntity> c = subAdminController.cityMangersRespo();
    List<CategoryEntity> categories = categorieController.getCategory();

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
                    Create-Manager
                </h1>
            </div>
        </div>

        <div
                class="flex relative justify-evenly items-center h-1/3 justify-center h-3/4 w-full"
        >
            <form
                    action="${pageContext.request.contextPath}/CreateManager"
                    method="post"
                    class="w-2/5 space-x-2 rounded-md h-fit py-3 px-3 bg-white shadow-2xl rounded-md space-y-20"
            >
                <div class="absolute top-2 w-2/5 flex items-center justify-center">
<%--                    <video class="w-56 bg-transparent" autoplay loop>--%>
<%--                        <source--%>
<%--                                type="video/mp4"--%>
<%--                                src="https://cdnl.iconscout.com/lottie/premium/thumb/male-account-5284913-4413355.mp4"--%>
<%--                        />--%>
<%--                    </video>--%>
                    <iframe class="w-96 h-44 bg-transparent rounded-md" src="https://embed.lottiefiles.com/animation/82704"></iframe>
                </div>
                <div
                        class="flex items-center space-y-4 justify-center mt-6 flex-col h-fit py-4"
                >
                    <h1
                            style="font-family: 'Poppins', sans-serif"
                            class="text-center py-2 text-xl"
                    >
                        Add Manager
                    </h1>
                    <div class="w-full flex items-center justify-center">
                        <%
                            if(session.getAttribute("ErrorEmail") == null && session.getAttribute("SuccessEmail") != null){
                        %>
                        <div class="w-2/3 bg-green-600 py-3 px-3 rounded-md">
                            <h1 class="text-white text-center" style="font-family: 'Poppins', sans-serif">
                                <%= session.getAttribute("SuccessEmail")%>
                            </h1>
                        </div>
                        <%
                        }  else if(session.getAttribute("ErrorEmail") != null && session.getAttribute("SuccessEmail") == null){
                        %>
                        <div class="w-2/3 bg-red-600 py-3 px-3 rounded-md">
                            <h1 class="text-white text-center" style="font-family: 'Poppins', sans-serif">
                                <%= session.getAttribute("ErrorEmail")%>
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
                        <div class="space-y-4 w-full flex flex-col mx-auto">
                            <label  style="font-family: 'Poppins', sans-serif"
                            >Email address</label
                            >
                            <input
                                    type="email"
                                    placeholder="example@example.com"
                                    class="w-full py-3 px-4 focus:border-[#0055A6] border-2 rounded-md outline-none"
                                    name="email"
                                    style="font-family: 'Poppins', sans-serif"
                            />
                        </div>
                        <div class="space-y-4 w-full flex flex-col">
                            <label  style="font-family: 'Poppins', sans-serif"
                            >Password</label
                            >
                            <input
                                    type="password"
                                    placeholder="***********"
                                    class="w-full py-3 px-4 focus:border-[#0055A6] border-2 rounded-md outline-none"
                                    name="password"
                                    style="font-family: 'Poppins', sans-serif"
                            />
                        </div>
                        <div class="space-y-4 w-full flex flex-col">
                            <label class="" style="font-family: 'Poppins', sans-serif">City</label>
                            <select name="CityID"
                                    class="w-full py-3 px-2 border-2 border-gray-400 outline-none focus:border-blue-600 rounded-md ">
                                <%
                                    for (CentersEntity centers : c) {
                                %>
                                <option value="<%= centers.getCenterId()%>"><%= centers.getCity() %>
                                </option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        <div class="space-y-4 w-full flex flex-col">
                            <label class="" style="font-family: 'Poppins', sans-serif">City</label>
                            <select name="categoryId"
                                    class="w-full py-3 px-2 border-2 border-gray-400 outline-none focus:border-blue-600 rounded-md ">
                                <%
                                    for (CategoryEntity category : categories) {
                                %>
                                <option value="<%= category.getCategoryId()%>"><%= category.getCategoryName() %>
                                </option>
                                <%
                                    }
                                %>
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
                            Create
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>


</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: cosmi
  Date: 10/31/2022
  Time: 9:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>

</head>
<body class="">

<div
        class="min-h-screen w-full flex px-10">

    <div class=" w-1/2 min-h-full ">
        <iframe class="w-full h-full" src="https://embed.lottiefiles.com/animation/88882"></iframe>
    </div>
    <div class="w-full md:w-full lg:w-1/2 mx-auto md:mx-0 flex justify-center items-center">
        <div class="bg-white p-10 flex flex-col w-full shadow-2xl rounded-xl">
            <h2 class="text-2xl font-bold text-[#0055A6] text-left mb-5">
                Sigin
            </h2>
            <form action="${pageContext.request.contextPath}/AdminLogin" class="w-full" method="post">
                <div id="inputt" class="flex flex-col w-full my-5">
                    <label for="username" class="text-gray-500 mb-2"
                    >Email</label
                    >
                    <input
                            type="text"
                            id="username"
                            name="email"
                            placeholder="Please insert your username"
                            class="appearance-none border-2 border-gray-100 rounded-lg px-4 py-3 placeholder-gray-300 focus:outline-none focus:ring-2 focus:ring-[#0055A6] focus:shadow-lg"
                    />
                </div>
                <div id="input" class="flex flex-col w-full my-5">
                    <label for="password" class="text-gray-500 mb-2"
                    >Password</label
                    >
                    <input
                            type="password"
                            id="password"
                            name="password"
                            placeholder="Please insert your password"
                            class="appearance-none border-2 border-gray-100 rounded-lg px-4 py-3 placeholder-gray-300 focus:outline-none focus:ring-2 focus:ring-[#0055A6] focus:shadow-lg"
                    />
                </div>
                <div id="button" class="flex flex-col w-1/2 mx-auto my-5">

                    <button type="submit" class="py-3 px-4 bg-[#0055A6] rounded-md text-white">Login</button>
                    <div class="flex justify-evenly mt-5">
                        <a
                                href="#"
                                class="w-full text-center font-medium text-gray-500"
                        >Recover password!</a
                        >
                        <a
                                href="#"
                                class="w-full text-center font-medium text-gray-500"
                        >Singup!</a
                        >
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>



</body>
</html>


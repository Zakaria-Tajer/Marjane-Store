<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Document</title>
    <script src="https://cdn.tailwindcss.com"></script>
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
    <script
            defer
            src="https://unpkg.com/alpinejs@3.x.x/dist/cdn.min.js"
    ></script>
    <script src="${pageContext.request.contextPath}/WebComponents/Navbar.js" type="module"></script>
</head>
<body>
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
                    sub-admin
                </h1>
            </div>
        </div>

        <div
                class="flex relative justify-evenly items-center h-1/3 justify-center h-3/4 w-full"
        >
            <form
                    action="${pageContext.request.contextPath}/AddSubAdmin"
                    method="post"
                    class="w-2/5 space-x-2 rounded-md h-fit py-3 px-3 bg-white shadow-2xl rounded-md space-y-20"
            >
                <div class="absolute top-2 w-2/5 flex items-center justify-center">
                    <video class="w-56 bg-transparent" autoplay loop>
                        <source
                                type="video/mp4"
                                src="https://cdnl.iconscout.com/lottie/premium/thumb/male-account-5284913-4413355.mp4"
                        />
                    </video>
                </div>
                <div
                        class="flex items-center space-y-4 justify-center mt-6 flex-col h-fit py-4"
                >
                    <h1
                            style="font-family: 'Poppins', sans-serif"
                            class="text-center py-2 text-xl"
                    >
                        Add admin
                    </h1>

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

<script>
    let isOpen = true;
    let isClosed = false;

    const switcher = (close, open, person) => {
        console.log(person);
        if (person !== "admin") {
            isOpen = false;
            isClosed = true;
        } else {
            isOpen = true;
            isClosed = false;
        }
    };

    const closed = () => {
        return isClosed;
    };
    const opened = () => {
        return isOpen;
    };
</script>
</body>
</html>

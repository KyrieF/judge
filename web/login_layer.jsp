<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2019/8/23
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <title>登陆 - Justice</title>
    <!-- Meta tag Keywords -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="Utilizer Login Form template Responsive, Login form web template, Flat Pricing tables, Flat Drop downs Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />

    <script>
        addEventListener("load", function() {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <!-- //Meta tag Keywords -->
    <!-- Custom-Files -->
    <!-- Bootstrap-Core-CSS -->
    <link rel="stylesheet" href="css/login_style.css" type="text/css" media="all" />
    <!-- Style-CSS -->

    <!-- /Fonts -->
    <link href="//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700" rel="stylesheet">
    <!-- //Fonts -->
</head>

<body>
<!-- main -->
<div class="main-top-intro">
    <div class="bg-layer">
        <!-- header -->
        <div class="wrapper">
            <header>
                <div class="header-w3layouts">
                    <h1>
                        <a class="navbar-brand logo" href="login_layer.jsp">
                            JUSTICE
                        </a>
                    </h1>
                </div>
                <div class="nav_w3pvt">
                    <nav>

                        <ul class="menu">
                            <li class="active">
                                <a href="index.jsp">普通用户</a>
                            </li>
                            <li class="">
                                <a href="#">我是律师</a>
                            </li>
                        </ul>
                    </nav>
                </div>
                <div class="clear"></div>

            </header>
            <!-- //header -->
            <div class="content-inner-info">
                <h2>Say Hello MyLayer</h2>
                <div class="content-w3layouts-main">

                    <div class="form-w3ls-left-info">
                        <form action=LoginServlet method="post">

                            <input name="tel" type="text" placeholder="手机或邮箱" required="" />
                            <input name="status" type="hidden" required="" value="false" required="" />
                            <input name="password" type="password" placeholder="密码" required=""/>
                            <div class="bottom">
                                <button class="btn" type="submit">登陆</button>
                            </div>
                            <div class="bottom_forget">
                                <a href="passwordforget.jsp" class="register_color">忘记密码？</a>

                            </div>
                            <div class="bottom_register">
                                <a href="register.jsp" class="register_color">注册</a>

                            </div>
                        </form>
                    </div>

                </div>
            </div>
            <!-- copyright -->
            <div class="copy-w3layouts-inf">
                <div class="scu">
                    <p style="color: white;"> 2019 JUSTICE Login. All rights reserved
                    </p>

                </div>


            </div>
            <!-- //copyright -->
        </div>
    </div>
</div>
<!-- //main -->

</body>

</html>
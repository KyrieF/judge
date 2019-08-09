<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
            <a class="navbar-brand logo" href="index.jsp">
              JUSTICE
            </a>
          </h1>
        </div>
        <div class="nav_w3pvt">
          <nav>
            <ul class="menu">
              <li class="active">
                <a href="#">普通用户</a>
              </li>
              <li class="">
                <a href="login_layer.html">我是律师</a>
              </li>
            </ul>
          </nav>
        </div>
        <div class="clear"></div>

      </header>
      <!-- //header -->
      <div class="content-inner-info">
        <h2>Say Hello MyUser</h2>
        <div class="content-w3layouts-main">

          <div class="form-w3ls-left-info">
            <form action="LoginServlet" method="post">

              <input type="text" placeholder="用户名" required="" name = "tel"/>
              <input type="hidden" name="status" value="false" required="" />
              <input type="password" placeholder="密码" required="" name = "password"/>
              <div class="bottom">
                <button class="btn" type="submit">登陆</button>
              </div>
              <div class="bottom_register">
                <a href="login_layer.html" class="register_color">忘记密码？</a>

              </div>
              <div class="bottom_register">
                <a href="login_layer.html" class="register_color">注册</a>

              </div>
            </form>
          </div>

        </div>
      </div>
      <!-- copyright -->
      <div class="copy-w3layouts-inf">
        <div class="scu">
          <p style="color: white;">© 2019 JUSTICE Login. All rights reserved
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
<script>

  //取出传回来的参数error并与yes比较
  var errori ='<%=request.getParameter("error")%>';
  if(errori=='yes'){
    alert("登录失败!");
  }
</script>
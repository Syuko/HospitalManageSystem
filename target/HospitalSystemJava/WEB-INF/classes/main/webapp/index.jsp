<%--
  Created by IntelliJ IDEA.
  User: 郑江峰
  Date: 2020/3/25
  Time: 13:09
  登录页
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored= "false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="vendor/font-awesome/css/font-awesome.min.css">
    <!-- Fontastic Custom icon font-->
    <link rel="stylesheet" href="css/fontastic.css">
    <!-- Google fonts - Poppins -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="img/favicon.ico">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
    <script src="vendor/jquery/jquery.min.js"></script>

</head>
<body>
<div class="page login-page">
    <div class="container d-flex align-items-center">
        <div class="form-holder has-shadow">
            <div class="row">
                <!-- Logo & Information Panel-->
                <div class="col-lg-6">
                    <div class="info d-flex align-items-center">
                        <div class="content">
                            <div class="logo">
                                <h1>登录</h1>
                            </div>
                            <h3>医院住院病房与护理管理系统</h3>
                        </div>
                    </div>
                </div>
                <!-- Form Panel    -->
<%--                <script type="text/javascript">--%>
<%--                    $(document).ready(function(){--%>
<%--                        $("#loginSubmit").click(function () {--%>
<%--                            // alert($("#loginForm").serialize());--%>
<%--                            $.getJSON("http://localhost:8080/HospitalSystemJava_war/LoginServlet","option=login&"+$("#loginForm").serialize(),function (data){--%>

<%--                                // $("#msg").html("有了");--%>
<%--                                if (data != null){--%>
<%--                                    // alert("登录成功");--%>
<%--                                    location.href="doctorWork.jsp";--%>
<%--                                }else {--%>
<%--                                    // alert("登录失败");--%>
<%--                                    $("#msg").html("用户名密码错误");--%>
<%--                                }--%>
<%--                                // location.href="doctorWork.jsp";--%>
<%--                            });--%>
<%--                        });--%>
<%--                    });--%>
<%--                </script>--%>

                <div class="col-lg-6 bg-white">
                    <div class="form d-flex align-items-center">
                        <div class="content">
                            <form method="post" id="loginForm" class="form-validate" action="LoginServlet?option=login&">
                                <div class="form-group">
                                    <input id="login-username" type="text" name="loginUserId" required data-msg="请输入你的工号" class="input-material">
                                    <label for="login-username" class="label-material">工号</label>
                                </div>
                                <div class="form-group">
                                    <input id="login-password" type="password" name="loginPassword" required data-msg="请输入密码" class="input-material">
                                    <label for="login-password" class="label-material">密码</label>
                                </div>
                                <div class="i-checks">
                                    <input id="doctor" type="radio" checked="" value="doctor" name="a" class="radio-template">
                                    <label for="doctor" style="padding-right: 25px">医生</label>
                                    <input id="nurse" type="radio" value="nurse" name="a" class="radio-template">
                                    <label for="nurse">护士</label>
                                </div>
                                <div id="errmsg" type="hidden" style="color: red">${errorMessage}</div>
                                <span id="errormsg"></span>
                                <button id="loginSubmit" type="submit" class="btn btn-primary" onclick="loginFunction">登录</button>
                                <!-- This should be submit button but I replaced it with <a> for demo purposes-->
                            </form>
                            <a href="#" class="forgot-pass">忘记密码?</a><br>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="copyrights text-center">
        <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
        </p>
    </div>
</div>
<!-- JavaScript files-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/popper.js/umd/popper.min.js"> </script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="vendor/jquery.cookie/jquery.cookie.js"> </script>
<script src="vendor/chart.js/Chart.min.js"></script>
<script src="vendor/jquery-validation/jquery.validate.min.js"></script>
<!-- Main File-->
<script src="js/front.js"></script>
</body>
</html>
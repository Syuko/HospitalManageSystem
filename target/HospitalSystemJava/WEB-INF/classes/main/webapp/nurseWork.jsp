<%--
  Created by IntelliJ IDEA.
  User: sushu
  Date: 2021/3/28
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored= "false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>护士工作站</title>
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
    <style>
        .pagination {
            /*padding-left: 200px;*/
            width: 500px;
            display: inline-block;
            margin: 20px auto;
            border-radius: 4px;
            float: right;
        }

        .pagination > li {
            display: inline
        }

        .pagination > li > a, .pagination > li > span {
            position: relative;
            float: left;
            padding: 6px 12px;
            margin-left: -1px;
            line-height: 1.42857143;
            color: #337ab7;
            text-decoration: none;
            background-color: #fff;
            border: 1px solid #ddd
        }

        .pagination > li:first-child > a, .pagination > li:first-child > span {
            margin-left: 0;
            border-top-left-radius: 4px;
            border-bottom-left-radius: 4px
        }

        .pagination > li:last-child > a, .pagination > li:last-child > span {
            border-top-right-radius: 4px;
            border-bottom-right-radius: 4px
        }

        .pagination > li > a:focus, .pagination > li > a:hover, .pagination > li > span:focus, .pagination > li > span:hover {
            color: #23527c;
            background-color: #eee;
            border-color: #ddd
        }

        .pagination > .active > a, .pagination > .active > a:focus, .pagination > .active > a:hover, .pagination > .active > span, .pagination > .active > span:focus, .pagination > .active > span:hover {
            z-index: 2;
            color: #fff;
            cursor: default;
            background-color: #337ab7;
            border-color: #337ab7
        }

        .pagination > .disabled > a, .pagination > .disabled > a:focus, .pagination > .disabled > a:hover, .pagination > .disabled > span, .pagination > .disabled > span:focus, .pagination > .disabled > span:hover {
            color: #777;
            cursor: not-allowed;
            background-color: #fff;
            border-color: #ddd
        }

        .pagination-lg > li > a, .pagination-lg > li > span {
            padding: 10px 16px;
            font-size: 18px
        }

        .pagination-lg > li:first-child > a, .pagination-lg > li:first-child > span {
            border-top-left-radius: 6px;
            border-bottom-left-radius: 6px
        }

        .pagination-lg > li:last-child > a, .pagination-lg > li:last-child > span {
            border-top-right-radius: 6px;
            border-bottom-right-radius: 6px
        }

        .pagination-sm > li > a, .pagination-sm > li > span {
            padding: 5px 10px;
            font-size: 12px
        }

        .pagination-sm > li:first-child > a, .pagination-sm > li:first-child > span {
            border-top-left-radius: 3px;
            border-bottom-left-radius: 3px
        }

        .pagination-sm > li:last-child > a, .pagination-sm > li:last-child > span {
            border-top-right-radius: 3px;
            border-bottom-right-radius: 3px
        }

        .row {
            padding-top: 10px;
            padding-bottom: 10px;
        }
    </style>
</head>
<body>
<div class="page">
    <!-- Main Navbar-->
    <header class="header">
        <nav class="navbar">
            <!-- Search Box-->
            <div class="search-box">
                <button class="dismiss"><i class="icon-close"></i></button>
                <form id="searchForm" action="#" role="search">
                    <input type="search" placeholder="What are you looking for..." class="form-control">
                </form>
            </div>
            <div class="container-fluid">
                <div class="navbar-holder d-flex align-items-center justify-content-between">
                    <!-- Navbar Header-->
                    <div class="navbar-header">
                        <!-- Navbar Brand --><a href="index.html" class="navbar-brand d-none d-sm-inline-block">
                        <div class="brand-text d-none d-lg-inline-block"><span><strong>住院系统&nbsp;-&nbsp;</strong></span>护士工作站
                        </div>
                        <div class="brand-text d-none d-sm-inline-block d-lg-none"><strong>BD</strong></div>
                    </a>
                        <!-- Toggle Button--><a id="toggle-btn" href="#"
                                                class="menu-btn active"><span></span><span></span><span></span></a>
                    </div>
                    <!-- Navbar Menu -->
                    <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
                        <!-- Search-->
                        <li class="nav-item d-flex align-items-center"><a id="search" href="#"><i
                                class="icon-search"></i></a></li>
                        <!-- Notifications-->
                        <li class="nav-item dropdown"><a id="notifications" rel="nofollow" data-target="#" href="#"
                                                         data-toggle="dropdown" aria-haspopup="true"
                                                         aria-expanded="false" class="nav-link"><i
                                class="fa fa-bell-o"></i><span class="badge bg-red badge-corner">1</span></a>
                            <ul aria-labelledby="notifications" class="dropdown-menu">
                                <li><a rel="nofollow" href="#" class="dropdown-item">
                                    <div class="notification">
                                        <div class="notification-content"><i class="fa fa-envelope bg-green"></i>最新排班表发布
                                        </div>
                                        <div class="notification-time"><small>4 分钟前</small></div>
                                    </div>
                                </a></li>
                                <a rel="nofollow" href="#" class="dropdown-item all-notifications text-center"> <strong>查看所有信息 </strong></a></li>
                            </ul>
                        </li>

                        <!-- Logout    -->
                        <li class="nav-item"><a href="index.jsp" class="nav-link logout"> <span
                                class="d-none d-sm-inline">登出</span><i class="fa fa-sign-out"></i></a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <div class="page-content d-flex align-items-stretch">
        <!-- Side Navbar -->
        <nav class="side-navbar">
            <!-- Sidebar Header-->
            <div class="sidebar-header d-flex align-items-center">
                <div class="title">
                    <h1 class="h4">您好：${nurse.nurseName}护士</h1>

                </div>
            </div>
            <!-- Sidebar Navidation Menus--><span class="heading">工作区</span>
            <ul class="list-unstyled">
                <li class="active"><a href="${pageContext.request.contextPath}/NurseWorkServlet?option=showPatientBe"> <i class="icon-home"></i>入住安排 </a></li>
                <li><a href="#exampledropdownDropdown" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>住院楼 </a>
                    <ul id="exampledropdownDropdown" class="collapse list-unstyled ">
                        <c:forEach items="${builds}" var="builds">
                            <li><a href="${pageContext.request.contextPath}/NurseWorkServlet?option=showRoomMessage&buildName=${builds.buildName}">${builds.buildName}</a></li>
                        </c:forEach>
                    </ul>
                </li>
                <li><a href="${pageContext.request.contextPath}/NurseWorkServlet?option=showNurseSchedule"> <i class="icon-padnote"></i>排班表 </a></li>
                <li><a href="${pageContext.request.contextPath}/NurseWorkServlet?option=nurseChoiceDrug"> <i class="icon-flask"></i>药物配置 </a></li>
                <li><a href="#"> <i class="icon-interface-windows"></i>收银台 </a></li>
            </ul>
            <span class="heading">拓展</span>
            <ul class="list-unstyled">
                <li><a href="#"> <i class="icon-flask"></i>护士长排班 </a></li>
                <li><a href="#"> <i class="icon-screen"></i>病房自定义 </a></li>
            </ul>
        </nav>
        <!-- Side Navbar END -->

        <div class="content-inner">
            <!-- Page Header-->
            <header class="page-header">
                <div class="container-fluid">
                    <h2 class="no-margin-bottom">入住安排</h2>
                </div>
            </header>
            <!-- Breadcrumb-->
            <div class="breadcrumb-holder container-fluid">
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.html">护士工作站</a></li>
                    <li class="breadcrumb-item active">安排病房</li>
                </ul>
            </div>
            <section class="tables">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <!--          新表-->
                            <!-- Advanced Tables -->
                            <div class="card">
                                <div class="card-content">
                                    <div class="table-responsive">

                                        <table class="table table-striped table-bordered table-hover text-center"
                                               id="dataTables-example">
                                            <thead>
                                            <tr>
                                                <th>病号</th>
                                                <th>姓名</th>
                                                <th>性别</th>
                                                <th>年龄</th>
                                                <th>联系方式</th>
                                                <th>患者症状</th>
                                                <th>操作</th>
                                            </tr>
                                            </thead>
                                            <tbody>

                                            <c:forEach items="${patientList}" var="p">
                                                <tr class="gradeA">
                                                    <td>${p.patientId}</td>
                                                    <td>${p.patientName}</td>
                                                    <c:if test="${p.patientSex == 'm'}">
                                                        <td>男</td>
                                                    </c:if>
                                                    <c:if test="${p.patientSex == 'f'}">
                                                        <td>女</td>
                                                    </c:if>
                                                    <td>${p.patientAge}</td>
                                                    <td>${p.patientPhone}</td>
                                                    <td>${p.patientHistory}</td>
                                                    <td class="center">
                                                        <a href="${pageContext.request.contextPath}/NurseWorkServlet?option=showEmptyBed&patientId=${p.patientId}"><button type="button" data-toggle="modal"  class="btn btn-primary" >安排床位 </button></a>
                                                    </td>
                                                </tr>
                                            </c:forEach>


                                            </tbody>
                                        </table>
                                    </div>

                                </div>
                            </div>
                            <!--End Advanced Tables -->
                            <!--          新表结束-->
                        </div>

                    </div>
                </div>
            </section>


            <!-- Page Footer-->
            <footer class="main-footer">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm-6">
                            <p>Copyright &copy; 2019.Company name All rights reserved.<a target="_blank"
                                                                                         href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
                            </p>
                        </div>
                        <div class="col-sm-6 text-right">
                            <p></p>
                            <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
                        </div>
                    </div>
                </div>
            </footer>
        </div>



    </div>
</div>
<!-- JavaScript files-->
<!-- jQuery Js -->
<script src="js/dataTables/jquery-1.10.2.js"></script>

<!-- Bootstrap Js -->
<!--<script src="js/dataTables/bootstrap.min.js"></script>-->

<!-- Metis Menu Js -->
<!--<script src="js/dataTables/jquery.metisMenu.js"></script>-->
<!-- Morris Chart Js -->

<!-- DATA TABLE SCRIPTS -->
<script src="js/dataTables/jquery.dataTables.js"></script>
<script src="js/dataTables/dataTables.bootstrap.js"></script>
<script>
    $(document).ready(function () {
        $('#dataTables-example').dataTable();
    });
</script>
<!--    <script src="vendor/jquery/jquery.min.js"></script>-->
<script src="vendor/popper.js/umd/popper.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="vendor/jquery.cookie/jquery.cookie.js"></script>
<script src="vendor/chart.js/Chart.min.js"></script>
<script src="vendor/jquery-validation/jquery.validate.min.js"></script>
<!-- Main File-->
<script src="js/front.js"></script>
</body>
</html>

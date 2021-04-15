<%--
  Created by IntelliJ IDEA.
  User: sushu
  Date: 2021/3/30
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored= "false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <!-- Bootstrap CSS-->
    <!--    <link rel="stylesheet" href="css/bootstrap.css">-->
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
        .row{
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
                        <div class="brand-text d-none d-lg-inline-block"><span><strong>住院系统&nbsp;-&nbsp;</strong></span>医生工作站
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
                    <h1 class="h4">您好：${doctor.doctorName}医生</h1>
                </div>
            </div>
            <!-- Sidebar Navidation Menus--><span class="heading">工作区</span>
            <ul class="list-unstyled">
                <li><a href="doctorWork.jsp"> <i class="icon-home"></i>患者信息登记 </a></li>
                <li class="active"><a href="${pageContext.request.contextPath}/DoctorWorkServlet?option=selectPatientAndAdvice&doctorId=${doctor.doctorId}"> <i class="icon-grid"></i>医嘱编写 </a></li>
                <li><a href="charts.html"> <i class="fa fa-bar-chart"></i>图表 </a></li>
            </ul>
        </nav>
        <div class="content-inner">
            <!-- Page Header-->
            <header class="page-header">
                <div class="container-fluid">
                    <h2 class="no-margin-bottom">患者列表</h2>
                </div>
            </header>
            <!-- Breadcrumb-->
            <div class="breadcrumb-holder container-fluid">
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.html">主页</a></li>
                    <li class="breadcrumb-item active">患者列表</li>
                </ul>
            </div>
            <section class="tables">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <!--          新表-->
                            <!-- Advanced Tables -->
                            <div class="card">
                                <!-- Modal-->

                                <div class="card-content">
                                    <div class="table-responsive">

                                        <table class="table table-striped table-bordered table-hover text-center"
                                               id="dataTables-example">
                                            <thead>
                                            <tr>
                                                <th>姓名</th>
                                                <th>性别</th>
                                                <th>年龄</th>
                                                <th>联系方式</th>
                                                <th>患者症状</th>
                                                <th>住院</th>
                                                <th>更新时间</th>
                                                <th>操作</th>
                                            </tr>
                                            </thead>
                                            <tbody >
                                            <c:forEach items="${adviceList}" var="a">
<%--                                                <script>--%>
<%--                                                    function myFunction(p1) {--%>
<%--                                                        alert(p1);--%>
<%--                                                        var shortAdvice = "${a.shortAdvice}";--%>
<%--                                                        document.getElementById('shortAdvice').value = shortAdvice;--%>
<%--                                                        document.getElementById('longAdvice').value="bbbb";--%>
<%--                                                    }--%>
<%--                                                </script>--%>
                                            <tr class="gradeA">
                                                <td contentEditable="true">${a.patient.patientName}</td>
                                                <td contentEditable="true">${a.patient.patientSex}</td>
                                                <td contentEditable="true">${a.patient.patientAge}</td>
                                                <td contentEditable="true">${a.patient.patientPhone}</td>
                                                <td contentEditable="true">${a.patient.patientHistory}</td>
                                                <td>
                                                    <c:if test="${a.patient.patientBe == 'y'}">
                                                        <input  name="beHospitalized" checked type="checkbox" value="y" class="checkbox-template">
                                                    </c:if>
                                                    <c:if test="${a.patient.patientBe != 'y'}">
                                                        <input  name="beHospitalized" type="checkbox" value="y" class="checkbox-template">
                                                    </c:if>
                                                </td>
                                                <td>${a.time}</td>
                                                <td class="center">
                                                    <button  type="submit" data-toggle="modal" class="btn btn-primary" >修改</button>
                                                    <button  type="button" data-toggle="modal" data-target="#myModal${a.dpId}" class="btn btn-danger">医嘱</button>
                                                </td>
                                                <div id="myModal${a.dpId}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" class="modal fade text-left">
                                                    <div role="document" class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h4 id="exampleModalLabel" class="modal-title">医嘱内容</h4>
                                                                <button type="button" data-dismiss="modal" aria-label="Close" class="close"><span aria-hidden="true">×</span></button>
                                                            </div>
                                                            <form action="${pageContext.request.contextPath}/DoctorWorkServlet?option=updateAdvice&dpId=${a.dpId}&doctorId=${doctor.doctorId}&" method="post">
                                                                <div class="modal-body">
                                                                    <p>在此进行医嘱查看与编辑</p>

                                                                    <div class="form-group">
                                                                        <label>短期医嘱</label>
                                                                        <input name="shortAdvice" type="text" class="form-control" value="${a.shortAdvice}">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label>长期医嘱</label>
                                                                        <textarea name="longAdvice" type="text" class="form-control" >${a.longAdvice}</textarea>
                                                                    </div>
                                                                </div>
                                                                <div class="modal-footer">
                                                                    <button type="button" data-dismiss="modal" class="btn btn-secondary">关闭</button>
                                                                    <button type="submit" class="btn btn-primary">确认修改</button>
                                                                </div>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>
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
                            <p>Copyright &copy; 2019.Company name All rights reserved.</p>
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

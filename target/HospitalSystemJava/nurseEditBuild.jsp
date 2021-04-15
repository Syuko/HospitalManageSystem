<%--
  Created by IntelliJ IDEA.
  User: sushu
  Date: 2021/4/6
  Time: 14:41
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
        .table-responsive td button{
            width: 45px;
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
                <li><a href="${pageContext.request.contextPath}/NurseWorkServlet?option=showPatientBe"> <i class="icon-home"></i>入住安排 </a></li>
                <li><a href="#exampledropdownDropdown" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>住院楼 </a>
                    <ul id="exampledropdownDropdown" class="collapse list-unstyled ">
                        <c:forEach items="${builds}" var="builds">
                            <li><a href="${pageContext.request.contextPath}/NurseWorkServlet?option=showRoomMessage&buildName=${builds.buildName}">${builds.buildName}</a></li>
                        </c:forEach>
                    </ul>
                </li>
                <li><a href="${pageContext.request.contextPath}/NurseWorkServlet?option=showNurseSchedule"> <i class="icon-padnote"></i>排班表 </a></li>
                <li><a href="${pageContext.request.contextPath}/NurseWorkServlet?option=nurseChoiceDrug"> <i class="icon-flask"></i>药物配置 </a></li>
                <li><a href="${pageContext.request.contextPath}/NurseWorkServlet?option=nursePatientAccount"> <i class="icon-interface-windows"></i>收银台 </a></li>
            </ul>
            <c:if test="${nurse.nursePosition == '护士长'}">
                <span class="heading">拓展</span>
                <ul class="list-unstyled">
                    <li><a href="${pageContext.request.contextPath}/NurseWorkServlet?option=editSchedule"> <i class="icon-flask"></i>护士长排班 </a></li>
                    <li class="active"><a href="${pageContext.request.contextPath}/NurseWorkServlet?option=nurseShowBuildAndHome"> <i class="icon-screen"></i>病房自定义 </a></li>
                    <li><a href="${pageContext.request.contextPath}/NurseWorkServlet?option=nurseManageDrug"> <i class="icon-screen"></i>药物管理 </a></li>
                </ul>
            </c:if>
        </nav>
        <!-- Side Navbar END -->
        <div class="content-inner">
            <!-- Page Header-->
            <header class="page-header">
                <div class="container-fluid">
                    <h2 class="no-margin-bottom">自定义病房</h2>
                </div>
            </header>
            <!-- Breadcrumb-->
            <div class="breadcrumb-holder container-fluid">
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.html">护士工作站</a></li>
                    <li class="breadcrumb-item active">自定义病房</li>
                </ul>
            </div>

            <section class="tables">
                <div class="container-fluid">
                    <div id="errmsg" type="hidden" style="color: red">${errorMessage}</div>
                    <div class="row">
                        <script>
                            $(document).ready(function(){
                                $(".test").click(function () {
                                    var val=$(this).attr("id");
                                    // alert(val);
                                    $("#addHome").text(val);
                                    $("#creatBuildName").val(val);
                                })

                            });
                        </script>
                        <c:forEach items="${buildList}" var="building">

                            <div class="col-lg-12" id="build">
                            <div class="card">
                                <div class="card-close">
                                    <div class="dropdown">
                                        <button type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="dropdown-toggle"><i class="fa fa-ellipsis-v"></i></button>
                                        <div aria-labelledby="closeCard1" class="dropdown-menu dropdown-menu-right has-shadow"><a href="#" class="dropdown-item remove"> <i class="fa fa-times"></i>Close</a><a href="#" class="dropdown-item edit"> <i class="fa fa-gear"></i>Edit</a></div>
                                    </div>
                                </div>
                                <div class="card-header d-flex align-items-center">
                                    <h3 class="h4">住院楼:<strong id="buildName">${building.buildName}</strong></h3>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped " >
                                            <thead>
                                            <tr>
                                                <th>楼层</th>
                                                <th>房间</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${building.tier}" var="tier">
                                                <tr>
                                                    <th scope="row">${tier}</th>
                                                    <td>
                                                        <c:forEach items="${homeList}" var="home">
                                                            <c:if test="${home.homeTier == tier && home.build.buildName == building.buildName}">
                                                                <a href="${pageContext.request.contextPath}/NurseWorkServlet?option=showHomeMessage&homeId=${home.homeId}&"><button class="btn-primary" >${home.homeName}</button></a>
                                                            </c:if>
                                                        </c:forEach>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                        <div style="float: right">

                                            <a href="${pageContext.request.contextPath}/NurseWorkServlet?option=deleteBuild&buildName=${building.buildName}"><button class="btn btn-danger">删除该楼</button></a>
                                            <button class="btn btn-primary test" id="${building.buildName}" data-toggle="modal" data-target="#homeModal">添加病房</button>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                    <button class="btn btn-primary" data-toggle="modal" data-target="#buildModal" style="float: right">添加住院楼</button>

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

        <!--        住院楼modal-->
        <div id="buildModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" class="modal fade text-left">
            <div role="document" class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">添加住院楼</h4>
                        <button type="button" data-dismiss="modal" aria-label="Close" class="close"><span aria-hidden="true">×</span></button>
                    </div>
                    <div class="modal-body">
                        <form method="post" action="${pageContext.request.contextPath}/NurseWorkServlet?option=addBuild">
                            <div class="form-group">
                                <label>住院楼名称</label>
                                <input type="text" name="buildName" placeholder="住院楼名称" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>楼层数</label>
                                <input type="text" name="buildTierNum" placeholder="楼层数" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>单层最大病房数</label>
                                <input type="text" name="buildHomeNum" placeholder="最大病房数" class="form-control">
                            </div>

                            <div class="modal-footer">
                                <button type="button" data-dismiss="modal" class="btn btn-secondary">关闭</button>
                                <button type="submit" class="btn btn-primary">提交</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>

        <div id="homeModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" class="modal fade text-left">
            <div role="document" class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4  class="modal-title" >向<strong id="addHome"></strong>添加病房</h4>
                        <button type="button" data-dismiss="modal" aria-label="Close" class="close"><span aria-hidden="true">×</span></button>
                    </div>
                    <div class="modal-body">
                        <form method="post" action="${pageContext.request.contextPath}/NurseWorkServlet?option=addHome">
                            <div class="form-group">
                                <label>住院楼名</label>
                                <input type="text" name="oldBuildName" placeholder="住院楼" class="form-control" id="creatBuildName">
                            </div>
                            <div class="form-group">
                                <label>病房名</label>
                                <input type="text" name="homeName" placeholder="病房名" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>最大病床数</label>
                                <input type="text" name="homeBedNum" placeholder="病床数" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>所属楼层</label>
                                <input type="text" name="homeTier" placeholder="楼层" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>病房类型</label>
                                <input type="text" name="homeType" placeholder="病房类型" class="form-control">
                            </div>
                            <div class="modal-footer">
                                <button type="button" data-dismiss="modal" class="btn btn-secondary">关闭</button>
                                <button type="submit" class="btn btn-primary">提交</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
        <!--        病房modal end-->

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
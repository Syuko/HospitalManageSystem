<%--
  Created by IntelliJ IDEA.
  User: sushu
  Date: 2021/4/7
  Time: 22:45
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
                    <li  class="active"><a href="${pageContext.request.contextPath}/NurseWorkServlet?option=editSchedule"> <i class="icon-flask"></i>护士长排班 </a></li>
                    <li><a href="${pageContext.request.contextPath}/NurseWorkServlet?option=nurseShowBuildAndHome"> <i class="icon-screen"></i>病房自定义 </a></li>
                    <li><a href="${pageContext.request.contextPath}/NurseWorkServlet?option=nurseManageDrug"> <i class="icon-screen"></i>药物管理 </a></li>
                </ul>
            </c:if>
        </nav>
        <!-- Side Navbar END -->
        <div class="content-inner">
            <!-- Page Header-->
            <header class="page-header">
                <div class="container-fluid">
                    <h2 class="no-margin-bottom">查看排班表</h2>
                </div>
            </header>
            <!-- Breadcrumb-->
            <div class="breadcrumb-holder container-fluid">
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.html">护士工作站</a></li>
                    <li class="breadcrumb-item active">排班表</li>
                </ul>
            </div>

            <section class="tables">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <script>
                                $(document).ready(function(){
                                    $(".test").click(function () {
                                        var val=$(this).attr("id");
                                        var currentRow=$(this).closest("tr");
                                        var mon=currentRow.find("td:eq(1)").text();
                                        var tue=currentRow.find("td:eq(2)").text();
                                        var wed=currentRow.find("td:eq(3)").text();
                                        var thu=currentRow.find("td:eq(4)").text();
                                        var fri=currentRow.find("td:eq(5)").text();
                                        var sat=currentRow.find("td:eq(6)").text();
                                        var sun=currentRow.find("td:eq(7)").text();
                                        var backM=currentRow.find("td:eq(8)").text();
                                        // alert(val);
                                        $("#mon").val(mon);
                                        $("#tue").val(tue);
                                        $("#wed").val(wed);
                                        $("#thu").val(thu);
                                        $("#fri").val(fri);
                                        $("#sat").val(sat);
                                        $("#sun").val(sun);
                                        $("#backM").val(backM);

                                        $("#nurseId").val(val);
                                    })

                                });
                            </script>
                            <div class="card">
                                <div class="card-close">
                                    <div class="dropdown">
                                        <button type="button" id="closeCard1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="dropdown-toggle"><i class="fa fa-ellipsis-v"></i></button>
                                        <div aria-labelledby="closeCard1" class="dropdown-menu dropdown-menu-right has-shadow"><a href="#" class="dropdown-item remove"> <i class="fa fa-times"></i>Close</a><a href="#" class="dropdown-item edit"> <i class="fa fa-gear"></i>Edit</a></div>
                                    </div>
                                </div>
                                <div class="card-header d-flex align-items-center">
                                    <h3 class="h4">一周内排班表</h3>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">

                                        <table class="table table-striped text-center" >
                                            <thead>
                                            <tr>
                                                <th>工号</th>
                                                <th>姓名</th>
                                                <th>周一</th>
                                                <th>周二</th>
                                                <th>周三</th>
                                                <th>周四</th>
                                                <th>周五</th>
                                                <th>周六</th>
                                                <th>周日</th>
                                                <th>备注</th>
                                                <th>操作</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${nurseScheduleList}" var="ns">
                                                <tr id="${ns.nurse.nurseId}">
                                                    <th scope="row">${ns.nurse.nurseId}</th>
                                                    <td>${ns.nurse.nurseName}</td>
                                                    <td>${ns.mon}</td>
                                                    <td>${ns.tue}</td>
                                                    <td>${ns.wed}</td>
                                                    <td>${ns.thu}</td>
                                                    <td>${ns.fri}</td>
                                                    <td>${ns.sat}</td>
                                                    <td>${ns.sun}</td>
                                                    <td>${ns.remark}</td>
                                                    <td>
                                                        <button class="btn btn-primary test"  data-toggle="modal" data-target="#scheduleModal" id="${ns.nurse.nurseId}">修改</button>
                                                    </td>
                                                </tr>
                                            </c:forEach>


                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
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

            <div id="scheduleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" class="modal fade text-left">
                <div role="document" class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">修改排班</h4>
                            <button type="button" data-dismiss="modal" aria-label="Close" class="close"><span aria-hidden="true">×</span></button>
                        </div>
                        <div class="modal-body">
                            <form method="post" action="${pageContext.request.contextPath}/NurseWorkServlet?option=updateSchedule">
                                <div class="form-group">
                                    <label>护士</label>
                                    <input type="text" name="nurseId"  class="form-control" id="nurseId">
                                </div>
                                <div class="form-group">
                                    <label>周一</label>
                                    <input type="text" name="mon" class="form-control" id="mon">
                                </div>
                                <div class="form-group">
                                    <label>周二</label>
                                    <input type="text" name="tue"  class="form-control" id="tue">
                                </div>
                                <div class="form-group">
                                    <label>周三</label>
                                    <input type="text" name="wed"  class="form-control" id="wed">
                                </div>
                                <div class="form-group">
                                    <label>周四</label>
                                    <input type="text" name="thu" class="form-control" id="thu">
                                </div>
                                <div class="form-group">
                                    <label>周五</label>
                                    <input type="text" name="fri"  class="form-control" id="fri">
                                </div>
                                <div class="form-group">
                                    <label>周六</label>
                                    <input type="text" name="sat"  class="form-control" id="sat">
                                </div>
                                <div class="form-group">
                                    <label>周日</label>
                                    <input type="text" name="sun"  class="form-control" id="sun">
                                </div>
                                <div class="form-group">
                                    <label>备注</label>
                                    <input type="text" name="backM"  class="form-control" id="backM">
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

        </div>



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

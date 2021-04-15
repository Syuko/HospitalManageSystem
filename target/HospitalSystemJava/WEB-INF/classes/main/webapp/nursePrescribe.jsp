<%--
  Created by IntelliJ IDEA.
  User: sushu
  Date: 2021/4/6
  Time: 8:08
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
    <title>Home</title>
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
    <script src="js/dataTables/jquery-1.10.2.js"></script>

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

        #dataTables-example_length{
            float: left;
        }

        .modal input{
            width: 100px;
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
                    <h1 class="h4">您好：${nurse.nurseName}护士</h1>

                </div>
            </div>
            <!-- Sidebar Navidation Menus--><span class="heading">工作区</span>
            <ul class="list-unstyled">
                <li ><a href="${pageContext.request.contextPath}/NurseWorkServlet?option=showPatientBe"> <i class="icon-home"></i>入住安排 </a></li>
                <li><a href="#exampledropdownDropdown" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>住院楼 </a>
                    <ul id="exampledropdownDropdown" class="collapse list-unstyled ">
                        <c:forEach items="${builds}" var="builds">
                            <li><a href="${pageContext.request.contextPath}/NurseWorkServlet?option=showRoomMessage&buildName=${builds.buildName}">${builds.buildName}</a></li>
                        </c:forEach>
                    </ul>
                </li>
                <li><a href="${pageContext.request.contextPath}/NurseWorkServlet?option=showNurseSchedule"> <i class="icon-padnote"></i>排班表 </a></li>
                <li class="active"><a href="${pageContext.request.contextPath}/NurseWorkServlet?option=nurseChoiceDrug"> <i class="icon-flask"></i>药物配置 </a></li>
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
                    <h2 class="no-margin-bottom">药物配置</h2>
                </div>
            </header>
            <!-- Forms Section-->
            <section class="forms">
                <!--            modal-->
                <script>
                    $(document).ready(function(){
                        //用于读取所选表行单元格数据(值)的代码
                        $("#dataTables-example").on('click','.btnSelect',function(){
                            // alert("1");
                            //获得当前行
                            var currentRow=$(this).closest("tr");
                            var drugId=currentRow.find("td:eq(0)").text(); //获得当前行第一个TD值 id
                            var drugName=currentRow.find("td:eq(1)").text(); //获得当前行第一个TD值 名称
                            var drugNum=currentRow.find("td:eq(2)").text(); //获得当前行第一个TD值 库存
                            var drugAdd=currentRow.find("td:eq(3)").text(); //获得当前行第一个TD值 位置

                            // alert(drugId)

                            $("#drugId").val(drugId);
                            $("#drugName").val(drugName);
                            $("#drugAdd").val(drugAdd);

                        });
                    });
                </script>

                <div id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" class="modal fade text-left">
                    <div role="document" class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4  class="modal-title">药物表</h4>
                                <button type="button" data-dismiss="modal" aria-label="Close" class="close"><span aria-hidden="true">×</span></button>
                            </div>
                            <div class="modal-body">


                                <table class="table table-striped table-bordered table-hover text-center"
                                       id="dataTables-example">
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>名称</th>
                                        <th>库存</th>
                                        <th>位置</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${drugList}" var="d">
                                        <tr class="gradeA">
                                            <td>${d.drugId}</td>
                                            <td>${d.drugName}</td>
                                            <td>${d.drugNum}</td>
                                            <td>${d.drugAdd}</td>
                                            <c:if test="${d.drugNum <= 0}">
                                                <td class="center">
                                                    <button type="button" data-dismiss="modal" class="btn btn-primary btnSelect" disabled="disabled">不足</button>
                                                </td>
                                            </c:if>
                                            <c:if test="${d.drugNum > 0}">
                                                <td class="center">
                                                    <button type="button" data-dismiss="modal" class="btn btn-primary btnSelect" >确定</button>
                                                </td>
                                            </c:if>
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>

                            </div>
                            <div class="modal-footer">
                                <button type="button" data-dismiss="modal" class="btn btn-secondary">关闭</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!--            modal end-->
                <div class="container-fluid">
                    <div class="row">
                        <!-- Form Elements -->
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-close">
                                    <div class="dropdown">
                                        <button type="button" id="closeCard5" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="dropdown-toggle"><i class="fa fa-ellipsis-v"></i></button>
                                        <div aria-labelledby="closeCard5" class="dropdown-menu dropdown-menu-right has-shadow"><a href="#" class="dropdown-item remove"> <i class="fa fa-times"></i>Close</a><a href="#" class="dropdown-item edit"> <i class="fa fa-gear"></i>Edit</a></div>
                                    </div>
                                </div>
                                <div class="card-header d-flex align-items-center">
                                    <h3 class="h4">药物选择</h3>
                                </div>
                                <div class="card-body">
                                    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/NurseWorkServlet?option=addPrescribeList&nurseId=${nurse.nurseId}&">
                                        <div class="form-group row">
                                            <c:if test="${patientId == null}">
                                                <label class="col-sm-3 form-control-label">病号</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" name="patientId">
                                                </div>
                                            </c:if>
                                            <c:if test="${patientId != null}">
                                                <label class="col-sm-3 form-control-label">病号</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" name="patientId" value="${patientId}">
                                                </div>
                                            </c:if>
                                        </div>
                                        <div class="line"></div>

                                        <div class="form-group row">
                                            <label class="col-sm-3 form-control-label">选择药品</label>

                                            <div class="col-sm-9 form-inline">
                                                <div class="form-group">
                                                    <button type="button" data-toggle="modal" data-target="#myModal" class="btn btn-primary">点此选择</button>
                                                </div>
                                                <div class="form-group">
                                                    <label for="drugId" class="sr-only">id</label>
                                                    <input id="drugId" type="text" placeholder="ID" class="mr-3 form-control" name="drugId">
                                                </div>
                                                <div class="form-group">
                                                    <label for="drugName" class="sr-only">名称</label>
                                                    <input id="drugName" type="text" placeholder="名称" class="mr-3 form-control" >
                                                </div>
                                                <div class="form-group">
                                                    <label for="drugAdd" class="sr-only">位置</label>
                                                    <input id="drugAdd" type="text" placeholder="位置" class="mr-3 form-control">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="line"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-3 form-control-label">数量</label>
                                            <div class="col-sm-9">
                                                <input  type="text" class="form-control" name="pickNum" >
                                            </div>
                                        </div>

                                        <div class="line"></div>
                                        <div class="form-group row">
                                            <div class="col-sm-4 offset-sm-3" style="float: right">
                                                <button type="submit" class="btn btn-primary">提交</button>
                                            </div>
                                        </div>
                                    </form>
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

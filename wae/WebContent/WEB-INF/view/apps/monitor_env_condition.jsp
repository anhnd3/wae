<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Hệ Thống Giám Sát Vườn Thông Minh</title>

<!-- Bootstrap Core CSS -->
<link
	href="${pageContext.request.contextPath }/resources/admin/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="${pageContext.request.contextPath }/resources/admin/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- DataTables CSS -->
<link
	href="${pageContext.request.contextPath }/resources/admin/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="${pageContext.request.contextPath }/resources/admin/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">

<!-- Datetime picker CSS -->
<link
	href="${pageContext.request.contextPath }/resources/admin/vendor/datetime-picker/jquery.datetimepicker.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="${pageContext.request.contextPath }/resources/admin/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Morris Charts CSS -->
<link
	href="${pageContext.request.contextPath }/resources/admin/vendor/morrisjs/morris.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="${pageContext.request.contextPath }/resources/admin/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0;">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand"
					href="${pageContext.request.contextPath }/apps/mec"
					style="padding: 0px 15px;"> <img
					style="height: 50px; width: 50px; float:left;" alt="logo wae"
					src="${pageContext.request.contextPath }/resources/mainsite/images/logo-wae.png">
					<h4 style="line-height: 30px; margin-left: 60px;">Hệ Thống Giám Sát Vườn Thông Minh</h4>
				</a>
			</div>
			<!-- /.navbar-header -->
			<ul class="nav navbar-top-links navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="javascript:void(0);"
					aria-expanded="false"> <i class="fa fa-bell fa-fw"></i><span>
							Cập nhật lần cuối: 2017-05-01 12:00:00</span>
				</a>
			</ul>
			<!-- /.user -->
			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li><a href="${pageContext.request.contextPath }/apps/mec"><i
								class="fa fa-location-arrow fa-fw"></i> Tổng hợp thông tin</a></li>
					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>
		<!-- /Navigation -->

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header">Trạng thái mới nhất</h3>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-3 col-md-6">
					<div class="panel panel-red">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-thermometer-half fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">26</div>
									<div>(Đơn vị: độ C)</div>
								</div>
							</div>
						</div>
						<a href="javascript:void(0)">
							<div class="panel-footer">
								<span class="pull-left">Nhiệt Độ</span> <span class="pull-right"><i
									class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-tint fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">12</div>
									<div>(Đơn vị: %)</div>
								</div>
							</div>
						</div>
						<a href="javascript:void(0);">
							<div class="panel-footer">
								<span class="pull-left">Độ ẩm môi trường</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-globe fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">40</div>
									<div>(Đơn vị: %)</div>
								</div>
							</div>
						</div>
						<a href="javascript:void(0);">
							<div class="panel-footer">
								<span class="pull-left">Độ ẩm đất</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<div class="panel panel-green">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-toggle-on fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">ON</div>
									<div>(Máy bơm)</div>
								</div>
							</div>
						</div>
						<a href="javascript:void(0)">
							<div class="panel-footer">
								<span class="pull-left">Lịch sử hoạt động</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-12 col-md-12 col-xm-12 col-xs-12">
					<div style="width: 30%; margin: auto;">
						<div class="panel panel-danger">
							<div class="panel-heading">
								<div class="row">
									<div class="col-xs-3">
										<i class="fa fa-exclamation-triangle fa-5x"></i>
									</div>
									<div class="col-xs-9 text-right">
										<div class="huge">Lỗi</div>
										<div>(Máy bơm)</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header">Đồ thị nhiệt độ, độ ẩm trong ngày</h3>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-6">
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-bar-chart-o fa-fw"></i> Đồ thị nhiệt độ
							<div class="pull-right">
								<div class="btn-group">
									<button type="button"
										class="btn btn-default btn-xs dropdown-toggle"
										data-toggle="dropdown">
										Actions <span class="caret"></span>
									</button>
								</div>
							</div>
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div id="morris-area-chart-temperature"></div>
						</div>
						<!-- /.panel-body -->
					</div>
				</div>
				<!-- /.end col-lg-6 -->
				<div class="col-lg-6">
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-bar-chart-o fa-fw"></i> Đồ thị độ ẩm
							<div class="pull-right">
								<div class="btn-group">
									<button type="button"
										class="btn btn-default btn-xs dropdown-toggle"
										data-toggle="dropdown">
										Actions <span class="caret"></span>
									</button>
								</div>
							</div>
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div id="morris-area-chart-humidity"></div>
						</div>
						<!-- /.panel-body -->
					</div>
				</div>
				<!-- /.end col-lg-6 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/vendor/datatables/js/jquery.dataTables.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/vendor/datatables-responsive/dataTables.responsive.js"></script>

	<!-- Datetime picker JavaScript -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/vendor/datetime-picker/jquery.datetimepicker.js"></script>

	<!-- Morris Charts JavaScript -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/vendor/raphael/raphael.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/vendor/morrisjs/morris.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/dist/js/sb-admin-2.js"></script>

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script type="text/javascript">
		$(document).ready(
				function() {
					$('#data-table').DataTable(
							{
								"responsive" : true,
								"iDisplayLength" : 10,
								"aLengthMenu" : [
										[ 10, 15, 25, 35, 50, 100, -1 ],
										[ 10, 15, 25, 35, 50, 100, "All" ] ],
								"oSearch" : {
									"sSearch" : ""
								},
								"order" : []
							});

					Morris.Line({
						element : 'morris-area-chart-temperature',
						data : [ {
							period : '2017-05-01 00:00:00',
							temperature : 28,
						}, {
							period : '2017-05-01 01:00:00',
							temperature : 26,
						}, {
							period : '2017-05-01 02:00:00',
							temperature : 24,
						}, {
							period : '2017-05-01 03:00:00',
							temperature : 24,
						}, {
							period : '2017-05-01 04:00:00',
							temperature : 24,
						}, {
							period : '2017-05-01 05:00:00',
							temperature : 25,
						}, {
							period : '2017-05-01 06:00:00',
							temperature : 26,
						}, {
							period : '2017-05-01 07:00:00',
							temperature : 27,
						}, {
							period : '2017-05-01 08:00:00',
							temperature : 28,
						}, {
							period : '2017-05-01 09:00:00',
							temperature : 28,
						}, {
							period : '2017-05-01 10:00:00',
							temperature : 30,
						}, {
							period : '2017-05-01 11:00:00',
							temperature : 30,
						}, {
							period : '2017-05-01 12:00:00',
							temperature : 33,
						} ],
						xkey : 'period',
						ykeys : [ 'temperature' ],
						labels : [ 'Nhiệt độ' ],
						pointSize : 1,
						hideHover : 'auto',
						resize : true
					});

					Morris.Line({
						element : 'morris-area-chart-humidity',
						data : [ {
							period : '2017-05-01 00:00:00',
							air : 28,
							ground : 30
						}, {
							period : '2017-05-01 01:00:00',
							air : 29,
							ground : 31
						}, {
							period : '2017-05-01 02:00:00',
							air : 28,
							ground : 30
						}, {
							period : '2017-05-01 03:00:00',
							air : 27,
							ground : 29
						}, {
							period : '2017-05-01 04:00:00',
							air : 28,
							ground : 28
						}, {
							period : '2017-05-01 05:00:00',
							air : 32,
							ground : 40
						}, {
							period : '2017-05-01 06:00:00',
							air : 56,
							ground : 62
						}, {
							period : '2017-05-01 07:00:00',
							air : 45,
							ground : 50
						}, {
							period : '2017-05-01 08:00:00',
							air : 60,
							ground : 42
						}, {
							period : '2017-05-01 09:00:00',
							air : 54,
							ground : 55
						}, {
							period : '2017-05-01 10:00:00',
							air : 10,
							ground : 34
						}, {
							period : '2017-05-01 11:00:00',
							air : 67,
							ground : 89
						}, {
							period : '2017-05-01 12:00:00',
							air : 100,
							ground : 10
						} ],
						xkey : 'period',
						ykeys : [ 'air', 'ground' ],
						labels : [ "Độ ẩm không khí", "Độ ẩm đất" ],
						pointSize : 1,
						hideHover : 'auto',
						resize : true
					});
				});
	</script>
</body>

</html>
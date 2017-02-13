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

<title>Hệ thống hỗ trợ tham gia giao thông an toàn</title>

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
					href="${pageContext.request.contextPath }/apps/gps-tracking"
					style="padding: 0px;"> <img alt="logo-quangtrung"
					src="${pageContext.request.contextPath }/resources/admin/apps/images/logocqt.png"
					style="width: 250px; height: 50px;">
				</a>
			</div>
			<!-- /.navbar-header -->
			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li><a
							href="${pageContext.request.contextPath }/apps/gps-tracking"><i
								class="fa fa-location-arrow fa-fw"></i> Thống kê vị trí</a></li>
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
					<h1 class="page-header">Hệ thống hỗ trợ tham gia giao thông an
						toàn</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading" style="min-height: 80px;">
							<div class="form-group col-lg-4">
								<label>Thiết bị</label> <select class="form-control"
									disabled="disabled">
									<option>GPS-001</option>
								</select>
							</div>
							<div class="form-group col-lg-4">
								<label>Kiểu thống kê</label> <select class="form-control"
									id="type-report">
									<option value="0">Tất cả</option>
									<option value="1">Theo ngày</option>
								</select>
							</div>
							<div class="form-group col-lg-4" style="display: none;">
								<label>Ngày</label> <input class="form-control" id="report-date">
							</div>
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="col-lg-6">
								<table class="table table-striped table-bordered table-hover"
									id="blog-category-table">
									<thead>
										<tr>
											<th>Thời gian</th>
											<th>Địa điểm</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${locations }" var="tmpLocation">
											<tr>
												<td>${tmpLocation.time }</td>
												<td><a href="javascript:void(0)"
													onclick="viewMap('${tmpLocation.location }')"></a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- /.table-responsive -->
							<div class="col-lg-6" style="height: 550px;">
								<div id="google-maps" style="height: 100%;"></div>
							</div>
							<!-- /.google-map -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
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
		src="${pageContext.request.contextPath }/resources/admin/vendor/datatables/js/jquery.dataTables.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/vendor/datatables-responsive/dataTables.responsive.js"></script>

	<!-- Datetime picker JavaScript -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/vendor/datetime-picker/jquery.datetimepicker.js"></script>

	<!-- Custom Theme JavaScript -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/dist/js/sb-admin-2.js"></script>

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script type="text/javascript">
		$(document).ready(
				function() {
					$('#blog-category-table').DataTable(
							{
								responsive : true,
								"iDisplayLength" : 15,
								"aLengthMenu" : [
										[ 10, 15, 25, 35, 50, 100, -1 ],
										[ 10, 15, 25, 35, 50, 100, "All" ] ],
								"oSearch" : {
									"sSearch" : ""
								}
							});
					$('#type-report').change(function() {
						var type = $(this).val();
						switch (parseInt(type)) {
						case 1:
							$('#report-date').parent().show();
							break;
						default:
							$('#report-date').parent().hide();
							break;
						}
					});

					$('#report-date').datetimepicker({
						timepicker : false,
						format : 'd-m-Y',
						lang : 'en'
					});
				});
	</script>

	<!-- Init google map here -->
	<script type="text/javascript">
		var map;
		function initMap() {
			map = new google.maps.Map(document.getElementById('google-maps'), {
				center : {
					lat : -34.397,
					lng : 150.644
				},
				zoom : 10
			});
		}
	</script>
	<script type="text/javascript"
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCABAsDXwnbiQ5vSIEwL5hhAmLgf0gLRMM&callback=initMap"
		async defer></script>
</body>

</html>
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
			<ul class="nav navbar-top-links navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#" aria-expanded="false"> <i
						class="fa fa-user fa-fw"></i><span> Phan Hoàng Phước -
							Nguyễn Văn Phước</span>
				</a>
			</ul>
			<!-- /.user -->
			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li><a
							href="${pageContext.request.contextPath }/apps/gps-tracking"><i
								class="fa fa-location-arrow fa-fw"></i> Định vị vị trí</a></li>
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
							<div class="form-group col-lg-3">
								<label>Thiết bị
									<button type="button" class="btn btn-primary btn-xs">
										<i class="fa fa-plus"></i>
									</button>
								</label> <select class="form-control">
									<option>GPS-001</option>
								</select>
							</div>
							<div class="form-group col-lg-3">
								<label>Kiểu hiển thị</label> <select class="form-control"
									disabled="disabled">
									<option value="0">Tất cả</option>
								</select>
							</div>
							<div class="form-group col-lg-3" style="display: none;">
								<label>Ngày</label> <input class="form-control" id="report-date">
							</div>
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="col-lg-7">
								<table class="table table-striped table-bordered table-hover"
									id="blog-category-table">
									<thead>
										<tr>
											<th>Thời gian</th>
											<th>Địa điểm</th>
											<th>Bản đồ</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${locations }" var="tmpLocation">
											<tr>
												<td>${tmpLocation.time }</td>
												<td>${tmpLocation.address }</td>
												<td><a href="javascript:void(0)"
													onclick="viewMap('${tmpLocation.latitude }', '${tmpLocation.longtitude }')">
														<button type="button" class="btn btn-primary btn-xs">
															<i class="fa fa-eye"></i>
														</button>
												</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- /.table-responsive -->
							<div class="col-lg-5" style="height: 500px;">
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
		src="${pageContext.request.contextPath }/resources/admin/vendor/datatables/js/jquery.dataTables.js"></script>
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
								"iDisplayLength" : 10,
								"aLengthMenu" : [
										[ 10, 15, 25, 35, 50, 100, -1 ],
										[ 10, 15, 25, 35, 50, 100, "All" ] ],
								"oSearch" : {
									"sSearch" : ""
								},
								"order" : []
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

	<!-- Google map here -->
	<script type="text/javascript">
		var map;
		var marker;
		var geocoder;
		var infowindow;

		function initMap() {
			geocoder = new google.maps.Geocoder();
			infowindow = new google.maps.InfoWindow();

			var longtitude = parseFloat('${lastLongtitude}');
			var latitude = parseFloat('${lastLatitude}');
			var myLatLng = {
				lat : latitude,
				lng : longtitude
			};

			// render google map with geocoding
			map = new google.maps.Map(document.getElementById('google-maps'), {
				center : myLatLng,
				zoom : 16
			});

			// marker point in map
			var marker = new google.maps.Marker({
				map : map,
				position : myLatLng
			});

			infowindow.setContent('${lastAddress}');
			infowindow.open(map, marker);
		}

		function viewMap(lat, lng) {
			var latlng = {
				lat : parseFloat(lat),
				lng : parseFloat(lng)
			};

			geocoder.geocode({
				'location' : latlng
			}, function(results, status) {
				if (status === 'OK') {
					if (results[0]) {
						map.setZoom(16);
						var marker = new google.maps.Marker({
							position : latlng,
							map : map
						});
						infowindow.setContent(results[0].formatted_address);
						infowindow.open(map, marker);
					} else {
						window.alert('Không có kết quả');
					}
				} else {
					window.alert('Toạ độ không chính xác: ' + status);
				}
			});

		}
	</script>
	<script type="text/javascript"
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCABAsDXwnbiQ5vSIEwL5hhAmLgf0gLRMM&callback=initMap"
		async defer></script>
</body>

</html>
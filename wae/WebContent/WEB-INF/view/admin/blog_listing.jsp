<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>WAE Tools - Blog Listing</title>

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
		<jsp:include page="/WEB-INF/view/admin/navigator.jsp">
			<jsp:param name="modifyAdmin" value="${modifyAdmin }" />
		</jsp:include>
		<!-- /Navigation -->

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">${blogCategory.name }'sBlog</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							${blogCategory.name }'s blog listing <a
								href="blog-form?blogCategoryId=${blogCategory.id }"><button
									type="button" class="btn btn-primary btn-xs"
									style="float: right;">Create</button></a>
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<table style="width: 100%"
								class="table table-striped table-bordered table-hover"
								id="blog-category-table">
								<thead>
									<tr>
										<th>Id</th>
										<th>Title</th>
										<th>Time</th>
										<th>Author</th>
										<th>Highlight</th>
										<th>Type</th>
										<th>Status</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${blogs }" var="tmpBlog">
										<tr>
											<td>${tmpBlog.id }</td>
											<td>${tmpBlog.title }</td>
											<td><jsp:useBean id="dateValue" class="java.util.Date" />
												<jsp:setProperty name="dateValue" property="time"
													value="${tmpBlog.time }" /> <fmt:formatDate
													value="${dateValue}" pattern="MM/dd/yyyy HH:mm" /></td>
											<td>${tmpBlog.author }</td>
											<c:choose>
												<c:when test="${tmpBlog.highlight == true }">
													<td><i class="fa fa-check"></i></td>
												</c:when>
												<c:otherwise>
													<td><i class="fa fa-ban"></i></td>
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${tmpBlog.type == 0 }">
													<td>Tutorial</td>
												</c:when>
												<c:when test="${tmpBlog.type == 1 }">
													<td>News</td>
												</c:when>
												<c:otherwise>
													<td>User</td>
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${tmpBlog.status == true }">
													<td><i class="fa fa-check"></i></td>
												</c:when>
												<c:otherwise>
													<td><i class="fa fa-ban"></i></td>
												</c:otherwise>
											</c:choose>
											<td><a
												href="blog-detail?blogCategoryId=${tmpBlog.categoryId }&id=${tmpBlog.id }"><i
													class="fa fa-edit"></i> </a>| <a
												onclick="return confirm('Do you want to delete blog: ${tmpBlog.title}?')"
												href="blog-delete?blogCategoryId=${tmpBlog.categoryId }&id=${tmpBlog.id }"><i
													class="fa fa-trash-o"></i></a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<!-- /.table-responsive -->
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

	<!-- Custom Theme JavaScript -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/dist/js/sb-admin-2.js"></script>

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document).ready(
				function() {
					$('#blog-category-table').DataTable(
							{
								responsive : true,
								"iDisplayLength" : 100,
								"aLengthMenu" : [
										[ 10, 15, 25, 35, 50, 100, -1 ],
										[ 10, 15, 25, 35, 50, 100, "All" ] ],
								"oSearch" : {
									"sSearch" : ""
								}
							});
				});
	</script>

</body>

</html>
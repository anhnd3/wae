<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>WAE Tools - Team Form</title>

<!-- Bootstrap Core CSS -->
<link
	href="${pageContext.request.contextPath }/resources/admin/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="${pageContext.request.contextPath }/resources/admin/vendor/metisMenu/metisMenu.min.css"
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
					<h1 class="page-header">Team Form</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Team Form</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12">
									<form:form role="form" action="team-form-execute"
										modelAttribute="team" method="POST" acceptCharset="UTF-8">
										<div class="form-group col-lg-3">
											<label>Teammate Name</label>
											<form:input path="name" cssClass="form-control"
												placeholder="Teammate name" autofocus="autofocus"
												required="true" />
											<p class="help-block alert-danger">
												<form:errors path="name"></form:errors>
											</p>
											<form:hidden path="id" />
										</div>
										<div class="form-group col-lg-3">
											<label>Title</label>
											<form:input path="title" cssClass="form-control"
												placeholder="title" />
											<p class="help-block alert-danger">
												<form:errors path="title"></form:errors>
											</p>
										</div>
										<div class="form-group col-lg-6">
											<label>Avatar</label>
											<form:input path="avatar" cssClass="form-control"
												placeholder="avatar" />
											<p class="help-block alert-danger">
												<form:errors path="avatar" />
											</p>
										</div>
										<div class="form-group col-lg-3">
											<label>Facebook</label>
											<form:input path="facebook" cssClass="form-control"
												placeholder="facebook" />
											<p class="help-block alert-danger">
												<form:errors path="facebook"></form:errors>
											</p>
										</div>
										<div class="form-group col-lg-3">
											<label>Twitter</label>
											<form:input path="twitter" cssClass="form-control"
												placeholder="twitter" />
											<p class="help-block alert-danger">
												<form:errors path="twitter"></form:errors>
											</p>
										</div>
										<div class="form-group col-lg-3">
											<label>LinkedIn</label>
											<form:input path="linkedIn" cssClass="form-control"
												placeholder="linkedIn" />
											<p class="help-block alert-danger">
												<form:errors path="linkedIn"></form:errors>
											</p>
										</div>
										<div class="form-group col-lg-3">
											<label>Google Plus</label>
											<form:input path="googlePlus" cssClass="form-control"
												placeholder="googlePlus" />
											<p class="help-block alert-danger">
												<form:errors path="googlePlus"></form:errors>
											</p>
										</div>
										<div class="form-group col-lg-12">
											<label>Description</label>
											<form:textarea rows="3" path="shortDesc"
												cssClass="form-control" placeholder="Description" />
											<p class="help-block alert-danger"></p>
										</div>
										<div class="form-group col-lg-2">
											<label>Status</label>
											<div class="checkbox">
												<label> <form:checkbox path="status" />Enable
												</label>
											</div>
										</div>
										<div class="form-group col-lg-12">
											<button type="submit" class="btn btn-default">Save</button>
											<button type="reset" class="btn btn-default">Reset</button>
										</div>
									</form:form>
								</div>
								<!-- /.col-lg-12 (nested) -->
							</div>
							<!-- /.row (nested) -->
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

	<!-- Custom Theme JavaScript -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/dist/js/sb-admin-2.js"></script>

</body>

</html>
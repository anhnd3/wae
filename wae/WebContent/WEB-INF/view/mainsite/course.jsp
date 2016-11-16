<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html class="no-js">
<head>
<!-- Basic Page Needs
        ================================================== -->
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath }/resources/mainsite/images/favicon.png">
<title>We are engineers - Khoá học</title>
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="author" content="">
<!-- Mobile Specific Metas
        ================================================== -->
<meta name="format-detection" content="telephone=no">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--
        ==================================================
        Import static file (css/js)
        ================================================== -->
<jsp:include page="/WEB-INF/view/mainsite/static.jsp" />
</head>
<body>
	<!--
        ==================================================
        Header Section Start
        ================================================== -->
	<jsp:include page="/WEB-INF/view/mainsite/header.jsp" />
	<!-- 
        ================================================== 
            Global Page Section Start
        ================================================== -->
	<section class="global-page-header">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="block">
						<h2>Khoá học</h2>
						<ol class="breadcrumb">
							<li><a href="${pageContext.request.contextPath }"> <i
									class="ion-ios-home"></i> Trang chủ
							</a></li>
							<li class="active">Khoá học</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- 
        ================================================== 
            Course Section Start
        ================================================== -->
	<section id="blog-full-width">
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<div class="sidebar">
						<div class="author widget">
							<img class="img-responsive"
								src="${pageContext.request.contextPath }/resources/mainsite/images/author/author-bg.jpg">
							<div class="author-body text-center">
								<div class="author-img">
									<img
										src="${pageContext.request.contextPath }/resources/mainsite/images/author/author.jpg">
								</div>
								<div class="author-bio">
									<h3>Jonathon Andrew</h3>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing
										elit. Deserunt magnam asperiores consectetur, corporis ullam
										impedit.</p>
								</div>
							</div>
						</div>
						<div class="recent-post widget">
							<h3>Khoá học mới nhất</h3>
							<ul>
								<c:forEach items="${lastestCourses }" var="tmpCourse">
									<li><a
										href="${pageContext.request.contextPath }/course/detail/${tmpCourse.id}">${tmpCourse.title }
									</a></li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-md-8">
					<c:forEach items="${courses }" var="tmpCourse">
						<article class="wow fadeInDown" data-wow-delay=".3s"
							data-wow-duration="500ms">
							<div class="blog-post-image">
								<a href="post-fullwidth.html"><img class="img-responsive"
									src="${tmpCourse.thumbnail }" alt="" /></a>
							</div>
							<div class="blog-content">
								<h2 class="blogpost-title">
									<a href="post-fullwidth.html">${tmpCourse.title }</a>
								</h2>
								<div class="blog-meta">
									<span>${tmpCourse.teacher }</span>
								</div>
								<p>${tmp.desc }</p>
								<a
									href="${pageContext.request.contextPath }/course/detail/${tmpCourse.id}"
									class="btn btn-dafault btn-details">Xem chi tiết</a>
							</div>
						</article>
					</c:forEach>
				</div>
			</div>
		</div>
	</section>

	<!--
            ==================================================
            Partner Section Start
            ================================================== -->
	<jsp:include page="/WEB-INF/view/mainsite/partner.jsp">
		<jsp:param value="${partners }" name="partners" />
	</jsp:include>
	<!--
            ==================================================
            Footer Section Start
            ================================================== -->
	<jsp:include page="/WEB-INF/view/mainsite/footer.jsp" />
	<!-- /#footer -->

</body>
</html>
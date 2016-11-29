<%@page import="vn.wae.spring.utils.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="no-js">
<head>
<!-- Basic Page Needs
        ================================================== -->
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath }/resources/mainsite/images/favicon.png">
<title>We are engineers - Tin tức - ${news.title }</title>
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
						<h2>Dự án</h2>
						<ol class="breadcrumb">
							<li><a href="${pageContext.request.contextPath }/"> <i
									class="ion-ios-home"></i> Trang chủ
							</a></li>
							<li class="active">Dự án</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--/#Page header-->

	<!-- 
        ================================================== 
            Gallery Section Start
        ================================================== -->
	<section id="gallery" class="gallery">
		<div class="container">
			<div class="row">
				<c:forEach items="${projects}" var="tmpProject">
					<div class="col-sm-4 col-xs-12">
						<figure class="wow fadeInLeft animated portfolio-item animated"
							data-wow-duration="300ms" data-wow-delay="0ms"
							style="visibility: visible; animation-duration: 300ms; -webkit-animation-duration: 300ms; animation-delay: 0ms; -webkit-animation-delay: 0ms; animation-name: fadeInLeft; -webkit-animation-name: fadeInLeft;">
							<div class="img-wrapper">
								<img src="${tmpProject.thumbnail }" class="img-responsive"
									alt="${tmpProject.name }">
								<div class="overlay">
									<div class="buttons">
										<a rel="gallery" class="fancybox"
											href="${tmpProject.thumbnail }">Demo</a>
									</div>
								</div>
							</div>
						</figure>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>
	<!--
            ==================================================
            Footer Section Start
            ================================================== -->
	<jsp:include page="/WEB-INF/view/mainsite/footer.jsp" />
	<script type="text/javascript">
		$(document).ready(function() {
			$('.single-post .post-content img').addClass('img-responsive');
		});
	</script>
	<!-- /#footer -->
</body>
</html>
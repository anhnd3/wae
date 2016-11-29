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
<title>We are engineers - Khoá học ${course.title }</title>
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
<!-- Facebook config sharing  -->
<meta property="fb:app_id" content="1784359991819774" />
<meta property="og:image" content="${course.thumbnail }" />
<meta property="og:description" content="${course.desc }" />
<meta property="og:url" content="${shareLink }" />
<meta property="og:title" content="${course.title }" />
<!-- #End facebook config sharing -->
</head>
<body>
	<!-- 
		==================================================
		Facebook SDK
		================================================== 
	 -->
	<div id="fb-root"></div>
	<script>
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.8&appId=1784359991819774";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>
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
						<h2>${course.title }</h2>
						<div class="portfolio-meta">
							<span> Giảng viên: ${course.teacher }</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--/#Page header-->

	<!-- 
        ================================================== 
            Course Section Start
        ================================================== -->
	<section class="single-post">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="social-share">
						<div class="fb-like" data-href="${shareLink }"
							data-layout="standard" data-action="like" data-size="small"
							data-show-faces="true" data-share="true"></div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="post-content">${course.fullDesc }</div>
				</div>
			</div>
		</div>
	</section>
	<!--
            ==================================================
            Footer Section Start
            ================================================== -->
	<jsp:include page="/WEB-INF/view/mainsite/footer.jsp" />
	<!-- /#footer -->

</body>
</html>
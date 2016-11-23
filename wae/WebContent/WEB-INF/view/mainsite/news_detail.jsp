<%@page import="vn.wae.spring.utils.StringUtils"%>
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

<meta property="og:image" content="${news.thumbnail }" />

<meta property="og:description" content="${news.shortDesc }" />

<meta property="og:url" content="${shareLink }" />

<meta property="og:title" content="${news.title }" />

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
						<h2>${news.title }</h2>
						<div class="portfolio-meta">
							<span> Tác giả: ${news.author }</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--/#Page header-->

	<!-- 
        ================================================== 
            news Section Start
        ================================================== -->
	<section class="single-post">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="post-img">
						<img class="img-responsive" alt="" src="${news.fullImage }">
					</div>
					<div class="post-content">${news.fullDesc }</div>
					<h4>Chia sẻ bài viết</h4>
					<ul class="social-share">
						<li>
							<div class="fb-share-button" data-href="${shareLink }"
								data-layout="button" data-size="large" data-mobile-iframe="true">
								<a class="fb-xfbml-parse-ignore" target="_blank"
									href="https://www.facebook.com/sharer/sharer.php?u=${encodeShareLink }&amp;src=sdkpreparse">Share</a>
							</div>
						</li>
					</ul>
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
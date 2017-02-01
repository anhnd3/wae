<%@page import="vn.wae.spring.utils.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:useBean id="convertString" class="vn.wae.spring.utils.StringUtils"></jsp:useBean>
<jsp:useBean id="convertTimestamp" class="vn.wae.spring.utils.TimeUtils"></jsp:useBean>
<!DOCTYPE html>
<html class="no-js">
<head>
<!-- Basic Page Needs
        ================================================== -->
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath }/resources/mainsite/images/favicon.png">
<title>We are engineers - Giáo trình - bài giảng</title>
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
						<h2>Giáo trình - Bài giảng</h2>
						<ol class="breadcrumb">
							<li><a href="${pageContext.request.contextPath }/"> <i
									class="ion-ios-home"></i> Trang chủ
							</a></li>
							<li class="active">Giáo trình - Bài giảng</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- 
        ================================================== 
            News Section Start
        ================================================== -->
	<section id="blog-full-width">
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<c:forEach items="${blogs }" var="tmpBlog">
						<article class="wow fadeInDown" data-wow-delay=".3s"
							data-wow-duration="500ms">
							<div class="blog-post-image">
								<a
									href="${pageContext.request.contextPath }/tutorial/${convertString.getTitleFilterCharVn(tmpBlog.title) }/${tmpBlog.id}"><img
									class="img-responsive" src="${tmpBlog.thumbnail }" alt="" /></a>
							</div>
							<div class="blog-content">
								<h2 class="blogpost-title">
									<a
										href="${pageContext.request.contextPath }/tutorial/${convertString.getTitleFilterCharVn(tmpBlog.title) }/${tmpBlog.id}">${tmpBlog.title }</a>
								</h2>
								<div class="blog-meta">
									<span>${convertTimestamp.timestampToString(tmpBlog.time,"dd-MM-yyyy HH:mm") }</span>
									<span>${tmpBlog.author }</span>
								</div>
								<p>${tmpBlog.shortDesc }</p>
								<a
									href="${pageContext.request.contextPath }/tutorial/${convertString.getTitleFilterCharVn(tmpBlog.title) }/${tmpBlog.id}"
									class="btn btn-dafault btn-details">Xem chi tiết</a>
							</div>
						</article>
					</c:forEach>
					<c:if test="${showPagination }">
						<nav style="text-align: center;" aria-label="Page navigation">
							<ul class="pagination">
								<li><a
									href="${pageContext.request.contextPath }/tutorial/1"
									aria-label="Previous"> <span aria-hidden="true">«</span>
								</a></li>
								<c:forEach items="${paginations }" var="page">
									<c:if test="${page == currentPage }">
										<li class="active"><a>${page }</a></li>
									</c:if>
									<c:if test="${page != currentPage }">
										<li><a
											href="${pageContext.request.contextPath }/tutorial/${page}">${page }</a></li>
									</c:if>
								</c:forEach>
								<li><a
									href="${pageContext.request.contextPath }/tutorial/${fn:length(paginations)}"
									aria-label="Next"> <span aria-hidden="true">»</span>
								</a></li>
							</ul>
						</nav>
					</c:if>
				</div>
				<div class="col-md-4">
					<div class="sidebar">
						<%-- <div class="author widget">
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
						</div> --%>
						<div class="categories widget">
							<h3 class="widget-head">Danh mục</h3>
							<ul>
								<c:forEach items="${categories }" var="tmpCategory">
									<li><a href="">${tmpCategory.name }</a> <span
										class="badge">${tmpCategory.totalBlog }</span></li>
								</c:forEach>
							</ul>
						</div>
						<div class="recent-post widget">
							<h3>Tin tức mới nhất</h3>
							<ul>
								<c:forEach items="${lastestBlog }" var="tmpBlog">
									<li><a
										href="${pageContext.request.contextPath }/tutorial/${convertString.getTitleFilterCharVn(tmpBlog.title) }/${tmpBlog.id}">${tmpBlog.title }
									</a></li>
								</c:forEach>
							</ul>
						</div>
					</div>
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
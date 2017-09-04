<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="convertString" class="vn.wae.spring.utils.StringUtils"></jsp:useBean>
<!DOCTYPE html>
<html class="no-js">
<head>
<!-- Basic Page Needs
        ================================================== -->
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath }/resources/mainsite/images/favicon.png">
<title>We are engineers - Trang chủ</title>
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
        Slider Section Start
        ================================================== -->
	<section id="hero-area">
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center">
					<div class="block wow fadeInUp" data-wow-delay=".3s">

						<!-- Slider -->
						<section class="cd-intro">
							<h1 class="wow fadeInUp animated cd-headline slide"
								data-wow-delay=".4s">
								<span>Chào bạn đến với We are Engineers</span>
							</h1>
						</section>
						<!-- cd-intro -->
						<!-- /.slider -->
						<!-- <h2 class="wow fadeInUp animated" data-wow-delay=".6s">Với
							một thời gian dài trong việc đào tạo về kỹ thuật điện tử, chúng
							tôi tự hào có thể giúp bạn nhanh chóng nắm bắt và trở thành một
							kỹ thuật viên hoặc một nhà sáng tạo trẻ trong lĩnh vực điện tử.</h2> -->
						<h2 class="wow fadeInUp animated" data-wow-delay=".6s">Website đang được bảo trì và nâng cấp.</h2>
						<c:if test="${showSectionWork}">
							<a
								class="btn-lines dark light wow fadeInUp animated smooth-scroll btn btn-default btn-green"
								data-wow-delay=".9s" href="#works" data-section="#works">Xem
								hoạt động</a>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--/#main-slider-->
	<!--
            ==================================================
            Portfolio Section Start
            ================================================== -->
	<c:if test="${showSectionWork}">
		<section id="works" class="works">
			<!-- Show Course -->
			<c:if test="${showCourse}">
				<div class="container">
					<div class="section-heading">
						<h1 class="title wow fadeInDown" data-wow-delay=".3s">Khoá
							học</h1>
					</div>
					<div class="row">
						<c:forEach items="${courses}" var="tmpCourse">
							<div class="col-sm-4 col-xs-12">
								<figure class="wow fadeInLeft animated portfolio-item"
									data-wow-duration="500ms" data-wow-delay="0ms">
									<div class="img-wrapper">
										<img src="${tmpCourse.thumbnail }" class="img-responsive"
											alt="this is a title">
										<div class="overlay">
											<div class="buttons">
												<a
													href="${pageContext.request.contextPath }/course/${convertString.getTitleFilterCharVn(tmpCourse.title) }/${tmpCourse.id}">Chi
													tiết</a>
											</div>
										</div>
									</div>
									<figcaption>
										<h4>
											<a
												href="${pageContext.request.contextPath }/course/${convertString.getTitleFilterCharVn(tmpCourse.title) }/${tmpCourse.id}">
												${tmpCourse.title } </a>
										</h4>
										<p>${tmpCourse.desc }</p>
									</figcaption>
								</figure>
							</div>
						</c:forEach>
					</div>
				</div>
			</c:if>
			<!-- # Show Course -->
			<!-- Show Blog -->
			<c:if test="${showBlog}">
				<div class="container">
					<div class="section-heading">
						<h1 class="title wow fadeInDown" data-wow-delay=".3s">Tin tức
							- Hoạt động</h1>
					</div>
					<div class="row">
						<c:forEach items="${blogs}" var="tmpBlog">
							<div class="col-sm-4 col-xs-12">
								<figure class="wow fadeInLeft animated portfolio-item"
									data-wow-duration="500ms" data-wow-delay="0ms">
									<div class="img-wrapper">
										<img src="${tmpBlog.thumbnail }" class="img-responsive"
											alt="this is a title">
										<div class="overlay">
											<div class="buttons">
												<a target="_blank"
													href="${pageContext.request.contextPath }/news/${convertString.getTitleFilterCharVn(tmpBlog.title) }/${tmpBlog.id}">Chi
													tiết</a>
											</div>
										</div>
									</div>
									<figcaption>
										<h4>
											<a
												href="${pageContext.request.contextPath }/news/${convertString.getTitleFilterCharVn(tmpBlog.title) }/${tmpBlog.id}">
												${tmpBlog.title } </a>
										</h4>
										<p>${tmpBlog.shortDesc }</p>
									</figcaption>
								</figure>
							</div>
						</c:forEach>
					</div>
				</div>
			</c:if>
			<!-- # Show Blog -->
			<!-- Show Project -->
			<c:if test="${showProject}">
				<div class="container">
					<div class="section-heading">
						<h1 class="title wow fadeInDown" data-wow-delay=".3s">Dự án</h1>
					</div>
					<div class="row">
						<c:forEach items="${projects}" var="tmpProject">
							<div class="col-sm-4 col-xs-12">
								<figure class="wow fadeInLeft animated portfolio-item"
									data-wow-duration="500ms" data-wow-delay="0ms">
									<div class="img-wrapper">
										<img src="${tmpProject.thumbnail }" class="img-responsive"
											alt="this is a title">
										<div class="overlay">
											<div class="buttons">
												<a rel="gallery" class="fancybox"
													href="${tmpProject.thumbnail }">${tmpProject.name }</a>
											</div>
										</div>
									</div>
									<figcaption>
										<h4>
											<a href="#"> ${tmpProject.name } </a>
										</h4>
										<p>${tmpProject.shortDesc }</p>
									</figcaption>
								</figure>
							</div>
						</c:forEach>
					</div>
				</div>
			</c:if>
			<!-- # Show Project -->
		</section>
	</c:if>
	<!-- #works -->
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="no-js">
<head>
<!-- Basic Page Needs
        ================================================== -->
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath }/resources/mainsite/images/favicon.png">
<title>We are engineer - Trang chủ</title>
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
								<span>HI, MY NAME IS JONATHON &amp; I AM A</span><br> <span
									class="cd-words-wrapper"> <b class="is-visible">DESIGNER</b>
									<b>DEVELOPER</b> <b>FATHER</b>
								</span>
							</h1>
						</section>
						<!-- cd-intro -->
						<!-- /.slider -->
						<h2 class="wow fadeInUp animated" data-wow-delay=".6s">
							With 10 years experience, I've occupied many roles including
							digital design director,<br> web designer and developer.
							This site showcases some of my work.
						</h2>
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
            Slider Section Start
            ================================================== -->
	<section id="about">
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-sm-6">
					<div class="block wow fadeInLeft" data-wow-delay=".3s"
						data-wow-duration="500ms">
						<h2>ABOUT ME</h2>
						<p>Hello, I’m a UI/UX Designer &amp; Front End Developer from
							Victoria, Australia. I hold a master degree of Web Design from
							the World University.And scrambled it to make a type specimen
							book. It has survived not only five centuries</p>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Error, adipisci voluptatum repudiandae, natus impedit repellat
							aut officia illum at assumenda iusto reiciendis placeat.
							Temporibus, vero.</p>
					</div>

				</div>
				<div class="col-md-6 col-sm-6">
					<div class="block wow fadeInRight" data-wow-delay=".3s"
						data-wow-duration="500ms">
						<img
							src="${pageContext.request.contextPath }/resources/mainsite/images/about/about.jpg"
							alt="">
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- /#about -->
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
						<p class="wow fadeInDown" data-wow-delay=".5s">
							Aliquam lobortis. Maecenas vestibulum mollis diam. Pellentesque
							auctor neque nec urna. Nulla sit amet est. Aenean posuere <br>
							tortor sed cursus feugiat, nunc augue blandit nunc, eu
							sollicitudin urna dolor sagittis lacus.
						</p>
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
												<a rel="gallery" class="fancybox"
													href="${tmpCourse.thumbnail }">${tmpCourse.title }</a> <a
													target="_blank" href="#">Chi tiết</a>
											</div>
										</div>
									</div>
									<figcaption>
										<h4>
											<a href="#"> ${tmpCourse.title } </a>
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
						<h1 class="title wow fadeInDown" data-wow-delay=".3s">Hoạt
							động</h1>
						<p class="wow fadeInDown" data-wow-delay=".5s">
							Aliquam lobortis. Maecenas vestibulum mollis diam. Pellentesque
							auctor neque nec urna. Nulla sit amet est. Aenean posuere <br>
							tortor sed cursus feugiat, nunc augue blandit nunc, eu
							sollicitudin urna dolor sagittis lacus.
						</p>
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
												<a rel="gallery" class="fancybox"
													href="${tmpBlog.thumbnail }">${tmpBlog.title }</a> <a
													target="_blank" href="#">Chi tiết</a>
											</div>
										</div>
									</div>
									<figcaption>
										<h4>
											<a href="#"> ${tmpBlog.title } </a>
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
						<h1 class="title wow fadeInDown" data-wow-delay=".3s">Dự án
							đã hoàn thiện</h1>
						<p class="wow fadeInDown" data-wow-delay=".5s">
							Aliquam lobortis. Maecenas vestibulum mollis diam. Pellentesque
							auctor neque nec urna. Nulla sit amet est. Aenean posuere <br>
							tortor sed cursus feugiat, nunc augue blandit nunc, eu
							sollicitudin urna dolor sagittis lacus.
						</p>
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
													href="${tmpProject.thumbnail }">${tmpProject.name }</a> <a
													target="_blank" href="#">Chi tiết</a>
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
	<section id="clients">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2 class="subtitle text-center wow fadeInUp animated"
						data-wow-duration="500ms" data-wow-delay=".3s">Our Happy
						Clinets</h2>
					<p class="subtitle-des text-center wow fadeInUp animated"
						data-wow-duration="500ms" data-wow-delay=".5s">Lorem ipsum
						dolor sit amet, consectetur adipisicing elit. Labore, error.</p>
					<div id="clients-logo" class="owl-carousel">
						<c:forEach items="${partners }" var="tmpPartner">
							<div>
								<a href="${tmpPartner.targetLink }" target="_blank"> <img
									src="${tmpPartner.thumbnail }" alt="${tmpPartner.name }">
								</a>
							</div>
						</c:forEach>
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
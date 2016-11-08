<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
						<a
							class="btn-lines dark light wow fadeInUp animated smooth-scroll btn btn-default btn-green"
							data-wow-delay=".9s" href="#works" data-section="#works">View
							Works</a>

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
	<section id="works" class="works">
		<div class="container">
			<div class="section-heading">
				<h1 class="title wow fadeInDown" data-wow-delay=".3s">Latest
					Works</h1>
				<p class="wow fadeInDown" data-wow-delay=".5s">
					Aliquam lobortis. Maecenas vestibulum mollis diam. Pellentesque
					auctor neque nec urna. Nulla sit amet est. Aenean posuere <br>
					tortor sed cursus feugiat, nunc augue blandit nunc, eu sollicitudin
					urna dolor sagittis lacus.
				</p>
			</div>
			<div class="row">
				<div class="col-sm-4 col-xs-12">
					<figure class="wow fadeInLeft animated portfolio-item"
						data-wow-duration="500ms" data-wow-delay="0ms">
						<div class="img-wrapper">
							<img
								src="${pageContext.request.contextPath }/resources/mainsite/images/portfolio/item-1.jpg"
								class="img-responsive" alt="this is a title">
							<div class="overlay">
								<div class="buttons">
									<a rel="gallery" class="fancybox"
										href="${pageContext.request.contextPath }/resources/mainsite/images/portfolio/item-1.jpg">Demo</a>
									<a target="_blank" href="single-portfolio.html">Details</a>
								</div>
							</div>
						</div>
						<figcaption>
							<h4>
								<a href="#"> Dew Drop </a>
							</h4>
							<p>Redesigne UI Concept</p>
						</figcaption>
					</figure>
				</div>
				<div class="col-sm-4 col-xs-12">
					<figure class="wow fadeInLeft animated" data-wow-duration="500ms"
						data-wow-delay="300ms">
						<div class="img-wrapper">
							<img
								src="${pageContext.request.contextPath }/resources/mainsite/images/portfolio/item-2.jpg"
								class="img-responsive" alt="this is a title">
							<div class="overlay">
								<div class="buttons">
									<a rel="gallery" class="fancybox"
										href="${pageContext.request.contextPath }/resources/mainsite/images/portfolio/item-2.jpg">Demo</a>
									<a target="_blank" href="single-portfolio.html">Details</a>
								</div>
							</div>
						</div>
						<figcaption>
							<h4>
								<a href="#"> Bottle Mockup </a>
							</h4>
							<p>Lorem ipsum dolor sit.</p>
						</figcaption>
					</figure>
				</div>
				<div class="col-sm-4 col-xs-12">
					<figure class="wow fadeInLeft animated" data-wow-duration="500ms"
						data-wow-delay="300ms">
						<div class="img-wrapper">
							<img
								src="${pageContext.request.contextPath }/resources/mainsite/images/portfolio/item-3.jpg"
								class="img-responsive" alt="">
							<div class="overlay">
								<div class="buttons">
									<a rel="gallery" class="fancybox"
										href="${pageContext.request.contextPath }/resources/mainsite/images/portfolio/item-3.jpg">Demo</a>
									<a target="_blank" href="single-portfolio.html">Details</a>
								</div>
							</div>
						</div>
						<figcaption>
							<h4>
								<a href="#"> Table Design </a>
							</h4>
							<p>Lorem ipsum dolor sit amet.</p>
						</figcaption>
					</figure>
				</div>
				<div class="col-sm-4 col-xs-12">
					<figure class="wow fadeInLeft animated" data-wow-duration="500ms"
						data-wow-delay="600ms">
						<div class="img-wrapper">
							<img
								src="${pageContext.request.contextPath }/resources/mainsite/images/portfolio/item-4.jpg"
								class="img-responsive" alt="">
							<div class="overlay">
								<div class="buttons">
									<a rel="gallery" class="fancybox"
										href="${pageContext.request.contextPath }/resources/mainsite/images/portfolio/item-4.jpg">Demo</a>
									<a target="_blank" href="single-portfolio.html">Details</a>
								</div>
							</div>
						</div>
						<figcaption>
							<h4>
								<a href="#"> Make Up elements </a>
							</h4>
							<p>Lorem ipsum dolor.</p>
						</figcaption>
					</figure>
				</div>
				<div class="col-sm-4 col-xs-12">
					<figure class="wow fadeInLeft animated" data-wow-duration="500ms"
						data-wow-delay="900ms">
						<div class="img-wrapper">
							<img
								src="${pageContext.request.contextPath }/resources/mainsite/images/portfolio/item-5.jpg"
								class="img-responsive" alt="">
							<div class="overlay">
								<div class="buttons">
									<a rel="gallery" class="fancybox"
										href="${pageContext.request.contextPath }/resources/mainsite/images/portfolio/item-5.jpg">Demo</a>
									<a target="_blank" href="single-portfolio.html">Details</a>
								</div>
							</div>
						</div>
						<figcaption>
							<h4>
								<a href="#"> Shoping Bag Concept </a>
							</h4>
							<p>Lorem ipsum dolor.</p>
						</figcaption>
					</figure>
				</div>
				<div class="col-sm-4 col-xs-12">
					<figure class="wow fadeInLeft animated" data-wow-duration="500ms"
						data-wow-delay="1200ms">
						<div class="img-wrapper">
							<img
								src="${pageContext.request.contextPath }/resources/mainsite/images/portfolio/item-6.jpg"
								class="img-responsive" alt="">
							<div class="overlay">
								<div class="buttons">
									<a rel="gallery" class="fancybox"
										href="${pageContext.request.contextPath }/resources/mainsite/images/portfolio/item-6.jpg">Demo</a>
									<a target="_blank" href="single-portfolio.html">Details</a>
								</div>
							</div>
						</div>
						<figcaption>
							<h4>
								<a href="#"> Caramel Bottle </a>
							</h4>
							<p>Lorem ipsum dolor.</p>
						</figcaption>
					</figure>
				</div>
			</div>
		</div>
	</section>
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
						<div>
							<img
								src="${pageContext.request.contextPath }/resources/mainsite/images/clients/logo-1.jpg"
								alt="">
						</div>
						<div>
							<img
								src="${pageContext.request.contextPath }/resources/mainsite/images/clients/logo-2.jpg"
								alt="">
						</div>
						<div>
							<img
								src="${pageContext.request.contextPath }/resources/mainsite/images/clients/logo-3.jpg"
								alt="">
						</div>
						<div>
							<img
								src="${pageContext.request.contextPath }/resources/mainsite/images/clients/logo-4.jpg"
								alt="">
						</div>
						<div>
							<img
								src="${pageContext.request.contextPath }/resources/mainsite/images/clients/logo-5.jpg"
								alt="">
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
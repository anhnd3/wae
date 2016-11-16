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
<title>We are engineers - Giới thiệu</title>
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
						<h2>Giới thiệu</h2>
						<ol class="breadcrumb">
							<li><a href="${pageContext.request.contextPath }"> <i class="ion-ios-home"></i>
									Trang chủ
							</a></li>
							<li class="active">Giới thiệu</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- 
        ================================================== 
            Company Description Section Start
        ================================================== -->
	<section class="company-description">
		<div class="container">
			<div class="row">
				<div class="col-md-6 wow fadeInLeft" data-wow-delay=".1s">
					<img src="${pageContext.request.contextPath }/resources/mainsite/images/about/about-company.jpg" alt=""
						class="img-responsive">
				</div>
				<div class="col-md-6">
					<div class="block">
						<h3 class="subtitle wow fadeInUp" data-wow-delay=".1s"
							data-wow-duration="500ms">Why We are Different</h3>
						<p class="wow fadeInUp" data-wow-delay=".2s"
							data-wow-duration="500ms">Sed ut perspiciatis unde omnis iste
							natus error sit voluptatem accusantium doloremque laudantium,
							totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et
							quasi architecto beatae vitae dicta sunt explicabo. Nemo enim
							ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit,
							sed quia consequun. Lorem ipsum dolor sit amet, consectetur
							adipiscing elit, sed do eiusmod tempor incididunt ut labore et
							dolore magna aliqua.</p>
						<p class="wow fadeInUp" data-wow-delay=".3s"
							data-wow-duration="500ms">Temporibus autem quibusdam et aut
							officiis debitis aut rerum necessitatibus saepe eveniet ut et
							voluptates repudiandae sint et molestiae non recusandae.</p>

					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- 
        ================================================== 
            Company Feature Section Start
        ================================================== -->
	<section class="about-feature clearfix">
		<div class="container-fluid">
			<div class="row">
				<div class="block about-feature-1 wow fadeInDown"
					data-wow-duration="500ms" data-wow-delay=".1s">
					<h2>Why Choose Us</h2>
					<p>Sed ut perspiciatis unde omnis iste natus error sit
						voluptatem accusantium doloremque laudantium, totam rem aperiam,
						eaque ipsa quae ab illo inventore veritatis et quasi architecto
						beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia
						voluptas.</p>
				</div>
				<div class="block about-feature-2 wow fadeInDown"
					data-wow-duration="500ms" data-wow-delay=".2s">
					<h2 class="item_title">What You Get</h2>
					<p>Sed ut perspiciatis unde omnis iste natus error sit
						voluptatem accusantium doloremque laudantium, totam rem aperiam,
						eaque ipsa quae ab illo inventore veritatis et quasi architecto
						beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia
						voluptas.</p>
				</div>
				<div class="block about-feature-3 wow fadeInDown"
					data-wow-duration="500ms" data-wow-delay=".3s">
					<h2 class="item_title">Meet The Energy</h2>
					<p>Sed ut perspiciatis unde omnis iste natus error sit
						voluptatem accusantium doloremque laudantium, totam rem aperiam,
						eaque ipsa quae ab illo inventore veritatis et quasi architecto
						beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia
						voluptas.</p>
				</div>
			</div>
		</div>
	</section>

	<!-- 
        ================================================== 
            Team Section Start
        ================================================== -->
	<section id="team">
		<div class="container">
			<div class="row">
				<h2 class="subtitle text-center">Thành viên</h2>
				<c:forEach items="${teams }" var="tmpTeam">
					<div class="col-md-3">
						<div class="team-member wow fadeInLeft" data-wow-duration="500ms"
							data-wow-delay=".3s">
							<div class="team-img">
								<img src="${tmpTeam.avatar }" class="team-pic"
									alt="${tmpTeam.name }">
							</div>
							<h3 class="team_name">${tmpTeam.name }w</h3>
							<p class="team_designation">${tmpTeam.title }</p>
							<p class="team_text">${tmpTeam.shortDesc }</p>
							<p class="social-icons">
								<a href="${tmpTeam.facebook }" class="facebook" target="_blank"><i
									class="ion-social-facebook-outline"></i></a> <a
									href="${tmpTeam.twitter }" target="_blank"><i
									class="ion-social-twitter-outline"></i></a> <a
									href="${tmpTeam.linkedIn }" target="_blank"><i
									class="ion-social-linkedin-outline"></i></a> <a
									href="${tmpTeam.googlePlus }" target="_blank"><i
									class="ion-social-googleplus-outline"></i></a>
							</p>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>

	<!--
            ==================================================
            Partner Section Start
            ================================================== -->
	<jsp:include page="/WEB-INF/view/mainsite/partner.jsp">
		<jsp:param value="${partners }" name="partners"/>
	</jsp:include>
	<!--
            ==================================================
            Footer Section Start
            ================================================== -->
	<jsp:include page="/WEB-INF/view/mainsite/footer.jsp" />
	<!-- /#footer -->

</body>
</html>
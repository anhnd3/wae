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
<title>We are engineers - Liên hệ</title>
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
						<h2>Liên hệ</h2>
						<ol class="breadcrumb">
							<li><a href="${pageContext.request.contextPath }/"> <i
									class="ion-ios-home"></i> Trang chủ
							</a></li>
							<li class="active">Liên hệ</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- 
        ================================================== 
            Contact Section Start
        ================================================== -->
	<section id="contact-section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="block">
						<h2 class="subtitle wow fadeInDown" data-wow-duration="500ms"
							data-wow-delay=".3s">Liên hệ với chúng tôi</h2>
						<p class="subtitle-des wow fadeInDown" data-wow-duration="500ms"
							data-wow-delay=".5s">Gửi tin nhắn cho chúng tôi khi bạn cần
							tư vấn hoặc giải đáp thắc mắc, chúng tôi sẽ sớm trả lời cho bạn</p>
						<div class="contact-form">
							<form:form id="contact-form" method="POST" role="form"
								htmlEscape="true" modelAttribute="message"
								action="${pageContext.request.contextPath }/contact/send-message">
								<div class="form-group wow fadeInDown" data-wow-duration="500ms"
									data-wow-delay=".2s">
									<form:input path="name" placeholder="Họ và tên"
										cssClass="form-control" htmlEscape="true" />
								</div>
								<div class="form-group wow fadeInDown" data-wow-duration="500ms"
									data-wow-delay=".3s">
									<form:input path="email" placeholder="Email"
										cssClass="form-control" htmlEscape="true" />
								</div>
								<div class="form-group wow fadeInDown" data-wow-duration="500ms"
									data-wow-delay=".4s">
									<form:input path="subject" placeholder="Tiêu đề"
										cssClass="form-control" htmlEscape="true" />
								</div>
								<div class="form-group wow fadeInDown" data-wow-duration="500ms"
									data-wow-delay=".5s">
									<form:textarea path="message" placeholder="Tin nhắn"
										cssClass="form-control" rows="6" htmlEscape="true" />
								</div>
								<div id="submit" class="wow fadeInDown"
									data-wow-duration="500ms" data-wow-delay=".6s">
									<input type="submit" id="contact-submit"
										class="btn btn-default btn-send" value="Gửi tin nhắn">
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
			<div class="row address-details">
				<div class="col-md-4">
					<div class="address wow fadeInLeft" data-wow-duration="500ms"
						data-wow-delay=".3s">
						<i class="ion-social-facebook"></i>
						<h5>
							<a href="https://www.facebook.com/waeVN" target="_blank">Wae
								Fanpage</a>
						</h5>
					</div>
				</div>
				<div class="col-md-4">
					<div class="email wow fadeInLeft" data-wow-duration="500ms"
						data-wow-delay=".7s">
						<i class="ion-ios-email-outline"></i>
						<p>lienhe.wae@gmail.com</p>
					</div>
				</div>
				<div class="col-md-4">
					<div class="phone wow fadeInLeft" data-wow-duration="500ms"
						data-wow-delay=".9s">
						<i class="ion-ios-telephone-outline"></i>
						<p>0169 210 3017</p>
					</div>
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
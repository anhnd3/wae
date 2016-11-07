<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>We Are Engineer - Countdown</title>
<meta name="viewport"
	content="width=device-width, minimum-scale=1.0, maximum-scale=1.0" />
<!-- CSS start here -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/countdown/css/bootstrap.min.css"
	media="screen">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/countdown/css/styles.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/countdown/css/font-awesome.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/countdown/css/animate.css" />
<!-- CSS end here -->
<!-- Google fonts start here -->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Roboto:300'
	rel='stylesheet' type='text/css'>
<!-- Google fonts end here -->
</head>
<body class="ux">
	<div class="bg-overlay"></div>
	<!-- Preloader start here -->
	<div id="preloader">
		<div id="status"></div>
	</div>
	<!-- Preloader end here -->
	<!-- About Icon start here -->
	<div class="about-us">
		<a href="#" class="fa fa-file-text-o tool-tip" data-toggle="modal"
			data-target=".bs-example-modal-lg" data-placement="right"
			title="About"></a>
	</div>
	<!-- About Icon end here -->
	<!-- Contact Icon start here -->
	<div class="contact-us">
		<a href="#" class="fa fa-envelope-o tool-tip" data-toggle="modal"
			data-target=".bs-example-modal-lg2" data-placement="left"
			title="Contact"></a>
	</div>
	<!-- Contact Icon end here -->
	<!-- Main container start here -->
	<section class="container main-wrapper">
		<!-- Logo start here -->
		<section id="logo" class="fade-down">
			<a class="logo" href="#">We are Coming ...</a>
		</section>
		<!-- Logo end here -->
		<!-- Count Down start here -->
		<section class="count-down-wrapper fade-down">
			<!-- Countdown dashboard start -->
			<div class="container">
				<div id="countdown_dashboard" class="fade-in">
					<div class="dash weeks_dash">
						<span class="dash_title">weeks</span>
						<div class="digit">0</div>
						<div class="digit">0</div>
					</div>
					<div class="dash days_dash">
						<span class="dash_title">days</span>
						<div class="digit">0</div>
						<div class="digit">0</div>
					</div>

					<div class="dash hours_dash">
						<span class="dash_title">hours</span>
						<div class="digit">0</div>
						<div class="digit">0</div>
					</div>

					<div class="dash minutes_dash">
						<span class="dash_title">minutes</span>
						<div class="digit">0</div>
						<div class="digit">0</div>
					</div>

					<div class="dash seconds_dash">
						<span class="dash_title">seconds</span>
						<div class="digit">0</div>
						<div class="digit">0</div>
					</div>

				</div>
			</div>
			<!-- Countdown dashboard end -->
		</section>
		<!-- Count Down end here -->
		<!-- Newsletter start here -->
		<section class="newsletter row fade-down">
			<form:form cssClass="contact-form col-md-6 fade-down validate"
				method="POST"
				action="${pageContext.request.contextPath }/countdown/submit-email"
				modelAttribute="emailUser" id="submitFormEmail" htmlEscape="true">
				<div class="form-group">
					<div>
						<span class="email-ico"> <i class="fa fa-envelope-o"></i>
						</span>
						<form:input type="email" path="email" id="email" name="email"
							cssClass="required email"
							placeholder="Enter your email here to stay tuned"
							htmlEscape="true" />
						<form:hidden path="id" />
						<button id="submit" type="submit" class="btn-submit">Submit</button>
					</div>
				</div>
				<div class="form-respond"></div>
			</form:form>
		</section>
		<!-- Newsletter end here -->
		<!-- Social icons start here -->
		<ul class="connect-us row fade-down">
			<li><a href="#" class="fb tool-tip" title="Facebook"><i
					class="fa fa-facebook"></i></a></li>
			<li><a href="#" class="twitter tool-tip" title="Twitter"><i
					class="fa fa-twitter"></i></a></li>
			<li><a href="#" class="gplus tool-tip" title="Google Plus"><i
					class="fa fa-google-plus"></i></a></li>
			<li><a href="#" class="linkedin tool-tip" title="Linkedin"><i
					class="fa fa-linkedin"></i></a></li>
			<li><a href="#" class="ytube tool-tip" title="You Tube"><i
					class="fa fa-youtube-play"></i></a></li>
			<li><a href="#" class="dribbble tool-tip" title="Dribbble"><i
					class="fa fa-dribbble"></i></a></li>
			<li><a href="#" class="pinterest tool-tip" title="Pinterest"><i
					class="fa fa-pinterest-square"></i></a></li>
		</ul>
		<!-- Social icons end here -->
		<!-- Footer start here -->
		<footer class="fade-down">
			<p class="footer-text">&copy; We are engineer 2016, All Rights
				Reserved.</p>
		</footer>
		<!-- Footer end here -->
	</section>
	<!-- About start here -->
	<div class="modal fade bs-example-modal-lg" role="dialog"
		aria-hidden="true" data-keyboard="true" data-backdrop="static"
		tabindex="-1">
		<a href="#" class="fa fa-times cls-pop" data-dismiss="modal"></a>
		<div class="modal-dialog modal-lg clearfix">
			<div class="modal-content pop-up">
				<h3>About US</h3>
				<div class="clearfix">
					<div>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut
							a risus sapien. Aenean non purus dolor. In ante nisl, gravida nec
							feugiat a, congue vel quam. Vivamus nisl ante, feugiat at sapien
							et, molestie ornare neque. Quisque mattis leo at odio malesuada,
							sed ullamcorper quam condimentum. Curabitur suscipit purus ac
							urna vestibulum tristique. Aliquam at massa vitae diam rhoncus
							malesuada. Duis vitae lacus risus. Cras sit amet felis in felis
							imperdiet tincidunt vitae vel augue. Donec consectetur faucibus
							orci, et lacinia felis eleifend non. Integer risus turpis,
							pulvinar nec consectetur quis, lacinia sed urna. Phasellus a
							vehicula ante, a blandit libero.</p>
						<p>Morbi et venenatis quam. Class aptent taciti sociosqu ad
							litora torquent per conubia nostra, per inceptos himenaeos. Ut ut
							tellus id nunc suscipit hendrerit vitae at ipsum. Nullam vel
							metus in ipsum rutrum rhoncus. Aliquam vel condimentum leo. Nulla
							ac tellus quis lacus condimentum tincidunt. Pellentesque ac
							vulputate felis. Suspendisse quis laoreet elit, et venenatis ex.
							Vivamus sit amet leo leo. Phasellus eu orci diam. Integer et
							lectus ipsum. Cras eget commodo eros. Proin eleifend eros ut
							justo vulputate, sed ultrices justo elementum. Nunc ac felis
							tristique, pretium neque quis, dignissim eros.</p>
					</div>
				</div>
				<ul class="features">
					<li>Animated Countdown Timer</li>
					<li>Twitter bootstrap Based</li>
					<li>Fully Responsive Design</li>
					<li>Ajax Email Signup form with validation</li>
					<li>Well structured and commented code</li>
					<li>Easily customizable</li>
					<li>Well Guided Documentation</li>
					<li>Google web fonts</li>
					<li>FontAwesome icons</li>
				</ul>
			</div>
		</div>
	</div>
	<!-- About end here -->
	<!-- Contact start here -->
	<div class="modal fade bs-example-modal-lg2" role="dialog"
		aria-hidden="true" data-keyboard="true" data-backdrop="static"
		tabindex="-1">
		<a href="#" class="fa fa-times cls-pop" data-dismiss="modal"></a>
		<div class="modal-dialog modal-lg">
			<div class="modal-content pop-up pop-up-cnt">
				<h3>Contact us</h3>

				<div class="clearfix cnt-wrap">
					<form:form id="contactform" name="contactform"
						action="${pageContext.request.contextPath }/countdown/send-message"
						method="post" htmlEscape="true" modelAttribute="message">
						<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 columns">
							<form:input path="name" placeholder="Name" />
							<form:hidden path="id" />
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 columns">
							<form:input path="email" placeholder="Email" />
						</div>
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 columns">
							<form:textarea path="message" placeholder="Message" />
						</div>
						<div
							class="col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center columns">
							<button name="submit" id="submit" class="contact-btn-submit"
								type="submit">Send</button>
						</div>
					</form:form>
				</div>

				<div class="clearfix cnt-wrap">
					<div class="col-md-4 col-sm-4">
						<i class="fa fa-phone"></i>
						<h4>Phone</h4>
						<p>
							Phone: (000) 555 1212<br />Mobile: (000) 555 0100<br />Fax:
							(000) 555 0101
						</p>
					</div>

					<div class="col-md-4 col-sm-4">
						<i class="fa fa-envelope-o"></i>
						<h4>Email</h4>
						<p>
							info@sitename.com<br />info@sitename.com
						</p>
					</div>
					<div class="col-md-4 col-sm-4">
						<i class="fa fa-map-marker"></i>
						<h4>Address</h4>
						<p>
							123 Some Street, <br> Sed varius nulla <br> Some City,
							AA 12345
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Contact end here -->
	<!-- Main container start here -->
	<!-- Javascript framework and plugins start here -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/resources/countdown/js/jquery.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/resources/countdown/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/countdown/js/jquery.validate.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/countdown/js/modernizr.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/resources/countdown/js/appear.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/countdown/js/jquery.knob.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/resources/countdown/js/jquery.lwtCountdown-1.0.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/countdown/js/jquery.ccountdown.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/resources/countdown/js/cufon-yui.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/resources/countdown/js/CaramelNuggets_400.font.js"></script>
	<script type="text/javascript">
		Cufon.replace('a.logo', {
			fontFamily : 'CaramelNuggets'
		});
	</script>
	<script
		src="${pageContext.request.contextPath }/resources/countdown/js/init.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/countdown/js/general.js"></script>
	<!-- Javascript framework and plugins end here -->
</body>
</html>
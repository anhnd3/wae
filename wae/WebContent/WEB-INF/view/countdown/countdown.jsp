<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>We Are Engineers - Countdown</title>
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
			title="Giới thiệu"></a>
	</div>
	<!-- About Icon end here -->
	<!-- Contact Icon start here -->
	<div class="contact-us">
		<a href="#" class="fa fa-envelope-o tool-tip" data-toggle="modal"
			data-target=".bs-example-modal-lg2" data-placement="left"
			title="Liên hệ"></a>
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
						<span class="dash_title">tuần</span>
						<div class="digit">0</div>
						<div class="digit">0</div>
					</div>
					<div class="dash days_dash">
						<span class="dash_title">ngày</span>
						<div class="digit">0</div>
						<div class="digit">0</div>
					</div>

					<div class="dash hours_dash">
						<span class="dash_title">giờ</span>
						<div class="digit">0</div>
						<div class="digit">0</div>
					</div>

					<div class="dash minutes_dash">
						<span class="dash_title">phút</span>
						<div class="digit">0</div>
						<div class="digit">0</div>
					</div>

					<div class="dash seconds_dash">
						<span class="dash_title">giây</span>
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
							placeholder="Đăng ký email để nhận tin tức" htmlEscape="true" />
						<form:hidden path="id" name="id" id="id" />
						<button id="submit" type="submit" class="btn-submit">Đăng
							ký</button>
					</div>
				</div>
				<div class="form-respond"></div>
			</form:form>
		</section>
		<!-- Newsletter end here -->
		<!-- Social icons start here -->
		<ul class="connect-us row fade-down">
			<li><a href="http://youngmakers.vn/" target="_blank"
				title="Young Markers"> <img alt="Young markers"
					src="https://scontent.fhan1-1.fna.fbcdn.net/v/t34.0-12/15049689_979596945483649_897005047_n.png?oh=63317512fc555f2c55ab7b4ecafe8b54&oe=582B0D70"
					width="150px" height="80px">
			</a></li>
			<li><a href="http://fablabsaigon.org/" target="_blank"
				title="Fablab SaiGon"> <img alt="Fablab SaiGon"
					src="https://scontent.fhan1-1.fna.fbcdn.net/v/t35.0-12/15034062_979597518816925_1941810535_o.png?oh=4d402b32000cb2082785494305d2c772&oe=582B2B40"
					width="150px" height="80px">
			</a></li>
		</ul>
		<!-- Social icons end here -->
		<!-- Footer start here -->
		<footer class="fade-down">
			<p class="footer-text">&copy; We are engineers 2016. Developed by
				AnhND</p>
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
				<h3>Giới thiệu</h3>
				<div class="clearfix">
					<div>
						<p>
							<strong>WAE (We Are Engineers)</strong> là trung tâm đào tạo và
							cung cấp giải pháp ở 2 lĩnh vực Giáo dục và Giải pháp kĩ thuật.
							WAE hoạt động dựa trên nền tảng kiến thức (Knowledge) và thực
							hành (Practical) với phương châm “Thực hành là trên hết”. Chúng
							tôi không dạy lí thuyết “suông”, luôn luôn có đầy đủ thiết bị cho
							bạn thực hành và “nghịch” ngay tại lớp.
						</p>
						<ul>
							<li>Ở mảng Giáo dục: WAE đào tạo kiến thức từ sơ khởi đến
								chuyên sâu về lập trình và điện tử với các mảng chính: Lập trình
								chuyên sâu, IoT (Internet of thing) và Kỹ thuật tự động (Robot,
								các máy CNC) trong Arduino.</li>
							<li>Ở mảng Giải pháp kĩ thuật: WAE tư vấn và cung cấp các
								giải pháp lẫn mô hình kĩ thuật theo nhu cầu từ học tập cho đến
								sản xuất đời sống của từng cá nhân hoặc doanh nghiệp.</li>
						</ul>

						<p>
							<strong>Vì sao nên chọn lớp học WAE?</strong>
						</p>
						<ul>
							<li>Phương pháp tiếp cận từ thực tế: Không bị bó buộc bởi
								giáo trình, không “bó tay” trước các đề tài mở, WAE giúp “hiện
								thực hóa” ý tưởng của các bạn học viên theo 3 bước: Có ý tưởng
								-> Hình thành đề tài -> Thực hành tại lớp học</li>
							<li>Tư vấn, giải quyết ngay tại chỗ mọi thắc mắc, dưới sự
								hướng dẫn của chúng tôi, những người có kinh nghiệm giảng dạy và
								thích “bị hỏi”.</li>
						</ul>
					</div>
				</div>
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
				<h3>Liên hệ</h3>

				<div class="clearfix cnt-wrap">
					<form:form id="contactform" name="contactform"
						action="${pageContext.request.contextPath }/countdown/send-message"
						method="post" htmlEscape="true" modelAttribute="message">
						<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 columns">
							<form:input path="name" placeholder="Họ và tên" />
							<form:hidden path="id" />
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 columns">
							<form:input path="email" placeholder="Email" />
						</div>
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 columns">
							<form:textarea path="message" placeholder="Nội dung tin nhắn" />
						</div>
						<div
							class="col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center columns">
							<button name="submit" id="submit" class="contact-btn-submit"
								type="submit">Gửi</button>
						</div>
					</form:form>
				</div>

				<div class="clearfix cnt-wrap">
					<div class="col-md-4 col-sm-4">
						<i class="fa fa-phone"></i>
						<h4>Điện thoại</h4>
						<p>Di động: 0169 210 3017</p>
					</div>

					<div class="col-md-4 col-sm-4">
						<i class="fa fa-envelope-o"></i>
						<h4>Email</h4>
						<p>lienhe.wae@gmail.com</p>
					</div>
					<div class="col-md-4 col-sm-4">
						<i class="fa fa-facebook"></i>
						<h4>Fanpage</h4>
						<p>
							<a
								href="https://www.facebook.com/We-are-Engineers-207800236329343"
								target="_blank">We are engineers</a>
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
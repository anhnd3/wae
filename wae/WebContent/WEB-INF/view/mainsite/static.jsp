<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="now" class="java.util.Date" />
<!-- Template CSS Files
        ================================================== -->
<!-- Twitter Bootstrs CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/mainsite/css/bootstrap.min.css">
<!-- Ionicons Fonts Css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/mainsite/css/ionicons.min.css">
<!-- animate css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/mainsite/css/animate.css">
<!-- Hero area slider css-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/mainsite/css/slider.css">
<!-- owl craousel css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/mainsite/css/owl.carousel.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/mainsite/css/owl.theme.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/mainsite/css/jquery.fancybox.css">
<!-- template main css file -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/mainsite/css/main.css?rand=${now.getTime()}">
<!-- responsive css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/mainsite/css/responsive.css">

<!-- Template Javascript Files
        ================================================== -->
<!-- modernizr js -->
<script
	src="${pageContext.request.contextPath }/resources/mainsite/js/vendor/modernizr-2.6.2.min.js"></script>
<!-- jquery -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<!-- owl carouserl js -->
<script
	src="${pageContext.request.contextPath }/resources/mainsite/js/owl.carousel.min.js"></script>
<!-- bootstrap js -->
<script
	src="${pageContext.request.contextPath }/resources/mainsite/js/bootstrap.min.js"></script>
<!-- wow js -->
<script
	src="${pageContext.request.contextPath }/resources/mainsite/js/wow.min.js"></script>
<!-- slider js -->
<script
	src="${pageContext.request.contextPath }/resources/mainsite/js/slider.js"></script>
<script
	src="${pageContext.request.contextPath }/resources/mainsite/js/jquery.fancybox.js"></script>
<!-- template main js -->
<script
	src="${pageContext.request.contextPath }/resources/mainsite/js/main.js"></script>

<!-- Facebook sdk-->
<script>
	window.fbAsyncInit = function() {
		FB.init({
			appId : '1784359991819774',
			xfbml : true,
			version : 'v2.8'
		});
	};

	(function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id)) {
			return;
		}
		js = d.createElement(s);
		js.id = id;
		js.src = "//connect.facebook.net/en_US/sdk.js";
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));
</script>

<!-- Heatmap -->
<script>
(function(h,e,a,t,m,p) {
m=e.createElement(a);m.async=!0;m.src=t;
p=e.getElementsByTagName(a)[0];p.parentNode.insertBefore(m,p);
})(window,document,'script','https://u.heatmap.it/log.js');
</script>
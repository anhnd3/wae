<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header id="top-bar" class="navbar-fixed-top animated-header">
	<div class="container">
		<div class="navbar-header">
			<!-- responsive nav button -->
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<!-- /responsive nav button -->

			<!-- logo -->
			<div class="navbar-brand">
				<a href="${pageContext.request.contextPath }/"> <img
					src="${pageContext.request.contextPath }/resources/mainsite/images/logo.png"
					alt="">
				</a>
			</div>
			<!-- /logo -->
		</div>
		<!-- main menu -->
		<nav class="collapse navbar-collapse navbar-right" role="navigation">
			<div class="main-menu">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${pageContext.request.contextPath }/">Trang
							chủ</a></li>
					<li><a href="${pageContext.request.contextPath }/about">Giới
							thiệu</a></li>
					<li><a href="${pageContext.request.contextPath }/course/1">Khoá
							học</a></li>
					<%-- <li><a href="${pageContext.request.contextPath }/tutorial/1">Tutorial</a></li> --%>
					<li><a href="${pageContext.request.contextPath }/news/1">Tin
							tức</a></li>
					<li><a href="${pageContext.request.contextPath }/project">Dự
							án</a></li>
					<%-- <li><a href="${pageContext.request.contextPath }/service">Kỹ
							thuật tự động</a></li> --%>
					<li><a href="${pageContext.request.contextPath }/contact">Liên
							hệ</a></li>
				</ul>
			</div>
		</nav>
		<!-- /main nav -->
	</div>
</header>
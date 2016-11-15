<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-default navbar-static-top" role="navigation"
	style="margin-bottom: 0">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="index.html">WAE Admin</a>
	</div>
	<!-- /.navbar-header -->

	<ul class="nav navbar-top-links navbar-right">
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
				<i class="fa fa-caret-down"></i>
		</a>
			<ul class="dropdown-menu dropdown-user">
				<li><a href="logout"><i class="fa fa-sign-out fa-fw"></i>
						Logout</a></li>
			</ul> <!-- /.dropdown-user --></li>
		<!-- /.dropdown -->
	</ul>
	<!-- /.navbar-top-links -->
	<div class="navbar-default sidebar" role="navigation">
		<div class="sidebar-nav navbar-collapse">
			<ul class="nav" id="side-menu">
				<li><a href="dashboard"><i class="fa fa-dashboard fa-fw"></i>
						Dashboard</a></li>
				<li><a href="blog-category"><i class="fa fa-pencil fa-fw"></i>
						Blog Category</a></li>
				<li><a href="course"><i class="fa fa-stack-overflow fa-fw"></i>
						Course</a></li>
				<li><a href="message"><i class="fa fa-envelope fa-fw"></i>
						Message</a></li>
				<li><a href="partner"><i class="fa fa-user-md fa-fw"></i>
						Partner</a></li>
				<li><a href="project"><i class="fa fa-photo fa-fw"></i>
						Project</a></li>
				<li><a href="team"><i class="fa fa-users fa-fw"></i> Team</a></li>
				<li><a href="email"><i class="fa fa-envelope-square fa-fw"></i>
						Email User</a></li>
				<li><a href="log-access"><i class="fa fa-sign-in fa-fw"></i>
						Log Access</a></li>
				<c:if test="${param.modifyAdmin == 'true'}">
					<li><a href="user"><i class="fa fa-user fa-fw"></i> Admin</a></li>
				</c:if>
			</ul>
		</div>
		<!-- /.sidebar-collapse -->
	</div>
	<!-- /.navbar-static-side -->
</nav>
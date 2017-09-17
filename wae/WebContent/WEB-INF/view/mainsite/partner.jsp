<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section id="clients">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2 class="subtitle text-center wow fadeInUp animated"
					data-wow-duration="500ms" data-wow-delay=".3s">Đối tác hoạt động</h2>
				<div id="clients-logo" class="owl-carousel">
					<c:forEach items="${partners }" var="tmpPartner">
						<div>
							<a href="${tmpPartner.targetLink }" target="_blank"> <img
								width="228px" height="114px" src="${tmpPartner.thumbnail }"
								alt="${tmpPartner.name }">
							</a>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</section>
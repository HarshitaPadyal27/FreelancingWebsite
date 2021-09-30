<%@page import="java.util.HashMap"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title><jsp:include page="projectTitle.jsp"></jsp:include></title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="assets/img/favicon.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
<link href="assets/vendor/aos/aos.css" rel="stylesheet">
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="assets/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
<link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="assets/css/style.css" rel="stylesheet">
</head>

<body style="background-color: Cornsilk;">
	<!-- ======= Header ======= -->
	<header id="header" class="fixed-top d-flex align-items-center ">
	<div
		class="container d-flex align-items-center justify-content-between">

		<h1 class="logo" style="color: white;"><jsp:include
				page="projectTitle.jsp"></jsp:include></h1>

		<nav id="navbar" class="navbar"> <%@ include
			file="Header/userHeader.jsp"%> <i
			class="bi bi-list mobile-nav-toggle"></i> </nav>
	</div>
	</header>
	<!-- End Header -->

	<!-- ======= Hero Section ======= -->
	<br />
	<br />
	<br />
	<!-- ======= Icon Boxes Section ======= -->
	<section id="icon-boxes" class="icon-boxes"> </section>
	<!-- End Icon Boxes Section -->
	</section>

	<!-- ======= Services Section ======= -->
	<section id="services" class="services">
	<div class="container" data-aos="fade-up">

		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-3" data-aos-delay="100"></div>
			<div class="col-md-3"></div>
		</div>


		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8" data-aos-delay="100">
				<div class="icon-box">
					<h2 align="center" style="color: red;">Upload Post</h2>
					<div class="row" align="center">
						<div class="col-md-12">
							<div class="icon-box">
							<form action="UploadPost" method="POST">
								<table id="example" class="table table-bordered">
									<tr>
										<td>Requirement Description</td>
										<td><textarea rows="4" name="description" cols="50"></textarea></td>
									</tr>
									<tr>
										<td>Technology</td>
										<td><textarea rows="3" cols="30" name="technology"></textarea></td>
									</tr>
									<tr>
										<td>Number of Days</td>
										<td><input type="number" name="days" value="0" required="required"></td>
									</tr>
									<tr>
										<td></td>
										<td><button type="submit" class="btn btn-success">Upload Post</button></td>
									</tr>
								</table>



							</div>
						</div>
					</div>


				</div>
			</div>
			<div class="col-md-2"></div>
		</div>

	</div>
	</section>
	<!-- End Services Section -->

	<!-- ======= Footer ======= -->
	<footer id="footer">
	<div class="container">
		<div class="copyright"></div>
		<div class="credits">
			<jsp:include page="projectTitle.jsp"></jsp:include>
		</div>
	</div>
	</footer>

	<div id="preloader"></div>
	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<!-- Vendor JS Files -->
	<script src="assets/vendor/aos/aos.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
	<script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script src="assets/vendor/php-email-form/validate.js"></script>
	<script src="assets/vendor/swiper/swiper-bundle.min.js"></script>

	<!-- Template Main JS File -->
	<script src="assets/js/main.js"></script>

</body>

</html>
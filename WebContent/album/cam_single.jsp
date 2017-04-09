<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>Camera Image</title>
		<!-- Animate -->
		<link rel="stylesheet" href="../css/animate.css">
		<!-- Bootstrap  -->
		<link rel="stylesheet" href="../css/bootstrap.css">
		<link rel="stylesheet" href="../css/style.css">
		<script src="http://code.jquery.com/jquery-1.4.4.min.js"></script>
		<script>
			$(document).ready(function(){
				var pnum = "<%=request.getParameter("pnum")%>";
				var cnum = "<%=request.getParameter("cnum")%>";
				var img1 = document.getElementById('img1');
				img1.setAttribute("src","../upload/" + pnum + "/" + pnum + "_" + cnum + ".jpg");		
			});

		</script>
	</head>
		
	<body>
		<!-- END #fh5co-offcanvas -->
		<header id="fh5co-header">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12 col-md-12 text-center">
						<h1 id="fh5co-logo">Camera Image</h1>
					</div>
				</div>
			</div>
		</header>

		<!-- END #fh5co-header -->
		<div class="container-fluid">
			<div class="row fh5co-post-entry single-entry">
				<article class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 col-xs-12 col-xs-offset-0">
					<figure class="animate-box" id="imgbox">
						<img alt="Image" class="responsive" id="img1">
					</figure>
					<span class="fh5co-meta animate-box">Travel</span>
				</article>
			</div>
		</div>

		<!-- jQuery -->
		<script src="../js/jquery.min.js"></script>
		<!-- Waypoints -->
		<script src="../js/jquery.waypoints.min.js"></script>
		<!-- Main JS -->
		<script src="../js/main.js"></script>

	</body>
</html>

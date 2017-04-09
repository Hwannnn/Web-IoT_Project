<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>Camera Images</title>
		<!-- Animate -->
		<link rel="stylesheet" href="../css/animate.css">
		<!-- Bootstrap  -->
		<link rel="stylesheet" href="../css/bootstrap.css">
		<link rel="stylesheet" href="../css/style.css">
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script>
			$(document).ready(function(){
				var pnum = "<%=request.getParameter("pnum")%>";
				var cnum = "<%=request.getParameter("cnum")%>";

				for(var i=1; i<=cnum; i++) {

					var article = document.createElement('article');
					var figure = document.createElement('figure');
					var a = document.createElement('a');
					var h2 = document.createElement('h2');
					var img = document.createElement('img');
					
					
					h2.innerHTML = pnum + "_"+ i +".jpg";
					article.setAttribute("class", "col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12 animate-box");
					a.setAttribute("href","./cam_single.jsp?pnum="+pnum+"&cnum="+i);
					img.setAttribute("src","../upload/" + pnum + "/" + pnum + "_" + i + ".jpg");
					img.setAttribute("alt","Image");
					img.setAttribute("class","img-responsive");
					
					document.getElementById("row fh5co-post-entry single-entry").appendChild(article);
					article.appendChild(figure);
					figure.appendChild(a);
					a.appendChild(img);
					article.appendChild(h2);
				}				
				jQuery.ajax({
			        type:"GET",
			        url:"../upload/"+ pnum + "/" + pnum + ".json",
			        dataType:"JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
			        success : function(data) {
			            $("#cam_num").text(data.cam_num);
			            $("#total_num").text(data.total_num);
			        },
			        complete : function(data) {},
			        error : function(xhr, status, error) {
			             alert("에러발생");
			        }
			    });
			});

		</script>
	</head>

	<body>
		<!-- END #fh5co-offcanvas -->
		<header id="fh5co-header">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12 col-md-12 text-center">
						<h1 id="fh5co-logo">Camera Images </h1>
						(<span id="cam_num"></span>/<span id="total_num"></span>)
					</div>
				</div>
			</div>
		</header>

		<!-- END #fh5co-header -->
		<div class="container-fluid">
			<div class="row fh5co-post-entry single-entry" id="row fh5co-post-entry single-entry">
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

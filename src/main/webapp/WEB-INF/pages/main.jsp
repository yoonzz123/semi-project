<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" href="css/default.css" rel="stylesheet" />
<link type="text/css" href="css/header.css" rel="stylesheet" />
<link type="text/css" href="css/report.css" rel="stylesheet" />
<link type="text/css " href="css/main.css" rel="stylesheet">
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/member.js"></script>
<script src="js/main.js"></script>
</head>
<body>
	<div class="mainDiv">
		<%@ include file="header.jsp" %>
	</div>
	<div class="wrap">

		<section class="sec01">
			<article class="inner">
				<div class="tb_row">
					<div class="tb_cell">
						<nav class="nav_list">
							<ul class="list">
								<li><a href="#toDay"> <span class="txt">TODAY</span> <span
										class="mask"></span> <span class="mask2"></span>
								</a></li>
								<li><a href="#imgMask"> <span class="txt">상품</span> <span
										class="mask"></span> <span class="mask2"></span>
								</a></li>
								<li><a href="#txtMask"> <span class="txt">인기상품</span> <span
										class="mask"></span> <span class="mask2"></span>
								</a></li>
								<li><a href="#overLap"> <span class="txt">세일</span> <span
										class="mask"></span> <span class="mask2"></span>
								</a></li>
							</ul>
						</nav>
					</div>
				</div>
				<div class="bg_rotate"></div>
			</article>
		</section>
		<section id="toDay" class="section_today">
			<article class="date_box">
				<div class="tb_row">
					<div class="tb_cell">
						<strong class="t_date">TODAY</strong>
						<div class="date_count"></div>
					</div>
				</div>
			</article>
		</section>
		<section id="imgMask" class="section_product">
			<article class="prd_mask">
				<div class="tit_wrap">
					<h2 class="com_tit01">상품</h2>
					<p class="com_txt01"></p>
				</div>
				<ul class="img_list">
					<li>
						<figure class="img_content">
							<img src="./images/1.jpg">
						</figure>
					</li>
					<li>
						<figure class="img_content">
							<img src="./images/2.jpg">
						</figure>
					</li>
					<li>
						<figure class="img_content">
							<img src="./images/3.jpg">
						</figure>
					</li>
					<li>
						<figure class="img_content">
							<img src="./images/4.jpg">
						</figure>
					</li>
				</ul>
			</article>
			<article class="text_img">
				<div class="text_area">
					<h3 class="tit">인기상품</h3>
					<p class="txt"></p>
				</div>
				<div class="img_area">
					<figure>
						<img src="./images/6.jpg">
					</figure>
				</div>
			</article>
		</section>
		<section id="txtMask" class="section_textmask">
			<article class="txt_area">
				<div class="tit_wrap">
					<h2 class="com_tit01">TEAM IT</h2>
					<p class="com_txt01">imagination</p>
				</div>
				<div class="motion_area">
					<div class="text_box">
						<div class="left">
							<p class="txt_com txt01">
								<span>저희 쇼핑몰에</span>
							</p>
						</div>
						<div class="right">
							<p class="txt_com txt01">
								<span>저희 쇼핑몰에</span>
							</p>
						</div>
					</div>
					<div class="text_box type02">
						<div class="left">
							<p class="txt_com txt01">
								<span>방문해 주셔서!</span>
							</p>
						</div>
						<div class="right">
							<p class="txt_com txt01">
								<span>방문해 주셔서!</span>
							</p>
						</div>
					</div>
					<div class="text_box type03">
						<div class="left">
							<p class="txt_com txt01">
								<span>감사합니다!</span>
							</p>
						</div>
						<div class="right">
							<p class="txt_com txt01">
								<span>감사합니다!</span>
							</p>
						</div>
					</div>
				</div>
			</article>
		</section>
		<section id="overLap" class="section_overlap">
			<article class="overlap_box">
				<div class="tit_wrap">
					<h2 class="com_tit01">99%세일</h2>
					<p class="com_txt01"></p>
				</div>
				<figure class="img_device">
					<img src="./images/8.jpg">
				</figure>
				<div class="bg_change color01"></div>
				<div class="bg_change color02"></div>
				<div class="bg_change color03"></div>
				<div class="bg_change color04"></div>
			</article>
		</section>
	</div>
</body>
</html>
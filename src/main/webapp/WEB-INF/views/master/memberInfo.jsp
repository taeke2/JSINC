<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<title>JS.Inc</title>
<!-- Favicons -->
<link href="resources/img/favicon.png" rel="icon">
<link href="resources/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Bootstrap core CSS -->
<link href="resources/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!--external css-->
<link href="resources/lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href="resources/lib/advanced-datatable/css/demo_page.css" rel="stylesheet" />
<link href="resources/lib/advanced-datatable/css/demo_table.css" rel="stylesheet" />
<link rel="stylesheet" href="resources/lib/advanced-datatable/css/DT_bootstrap.css" />
<!-- Custom styles for this template -->
<link href="resources/css/style.css" rel="stylesheet">
<link href="resources/css/style-responsive.css" rel="stylesheet">
</head>

<body>
	<section id="container">
		<!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
		<!--header start-->
		<header class="header black-bg">
			<div class="sidebar-toggle-box">
				<div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
			</div>
			<!--logo start-->
			<a href="memberMng" class="logo"><b>JS<span>Inc</span></b></a>
			<!--logo end-->
			<div class="top-menu">
				<ul class="nav pull-right top-menu">
					<li><a class="logout" href="logout">로그아웃</a></li>
				</ul>
			</div>
		</header>
		<!--header end-->
		<!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
		<!--sidebar start-->
		<aside>
			<div id="sidebar" class="nav-collapse ">
				<!-- sidebar menu start-->
				<ul class="sidebar-menu" id="nav-accordion">
					<h5 class="centered">
						<i class="fa fa-user"></i> 관리자
					</h5>
					<!-- 사원 관리 -->
					<li class="mt">
						<a class="active" href="memberMng"> 
							<i class="fa fa-asterisk"></i>
							<span>사원 관리</span>
						</a>
					</li>

					<!-- 커뮤니티 관리 -->
					<li>
						<a href="communityMng"> 
							<i class="fa fa-asterisk"></i>
							<span>커뮤니티 승인/삭제</span>
						</a>
					</li>

					<!-- 설문 관리 -->
					<li>
						<a href="surveyMng"> 
							<i class="fa fa-asterisk"></i>
							<span>설문 승인/삭제</span>
						</a>
					</li>
				</ul>
				<!-- sidebar menu end-->
			</div>
		</aside>
		<!--sidebar end-->
		<!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<h3>
					<i class="fa fa-angle-right"></i> 사원 정보
				</h3>
				<div class="row mb">
					<!-- page start-->
					<div class="content-panel">
						<div class="form-panel">
							<h4 class="mb">
								<i class="fa fa-angle-right"></i> 수정하기
							</h4>
							<form class="form-horizontal style-form" method="get" action="memberEdit">
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">사원 번호</label>
									<div class="col-sm-10">
										<input class="form-control round-form" id="disabledInput" type="text" placeholder="${member.empNo }" disabled>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">이름</label>
									<div class="col-sm-10">
										<input type="text" class="form-control round-form" name="name" value="${member.name }">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">생년월일</label>
									<div class="col-sm-10">
										<input type="text" class="form-control round-form" name="birth" value="${member.birth }">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">이메일</label>
									<div class="col-sm-10">
										<input type="text" class="form-control round-form" name="email" value="${member.userEmail }">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">전화번호</label>
									<div class="col-sm-10">
										<input type="text" class="form-control round-form" name="pn" value="${member.phoneNumber }">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">성별</label>
									<div class="col-lg-10">
										<select class="form-control" id="gender" name="gender">
											<c:choose>
												<c:when test="${member.gender eq '남' }">
													<option value="남" selected="selected">남</option>
													<option value="여">여</option>
												</c:when>
												<c:otherwise>
													<option value="남">남</option>
													<option value="여" selected="selected">여</option>
												</c:otherwise>
											</c:choose>
											
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">직급</label>
									<div class="col-lg-10">
										<select class="form-control" id="rank" name="rank">
											<option value="${member.rank }" selected="selected">${member.rank }</option>
											<option value="사원">사원</option>
											<option value="주임">주임</option>
											<option value="대리">대리</option>
											<option value="과장">과장</option>
											<option value="부장">부장</option>
											<option value="이사">이사</option>
											<option value="대표">대표</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">부서</label>
									<div class="col-lg-10">
										<select class="form-control" id="dep" name="dep">
											<option value="${member.dep }" selected="selected">${member.dep }</option>
											<option value="개발부">개발부</option>
											<option value="경영지원부">경영지원부</option>
											<option value="경리부">경리부</option>
											<option value="품질관리부">품질관리부</option>
											<option value="해외영업부">해외영업부</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 col-sm-2 control-label"></label>
									<div class="col-lg-10">
										<input type="submit" value="수정" class="btn btn-round btn-success">
										<input type="button" value="취소" class="btn btn-round btn-danger" onclick="location.href='memberMng'">
									</div>
								</div>
							</form>
						</div>
					</div>
					<!-- page end-->
				</div>
				<!-- /row -->
			</section>
			<!-- /wrapper -->
		</section>
		<!-- /MAIN CONTENT -->
		<!--main content end-->
		<jsp:include page="../default/footer.jsp"/>
	</section>
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="resources/lib/jquery/jquery.min.js"></script>
	<script type="text/javascript" language="javascript" src="resources/lib/advanced-datatable/js/jquery.js"></script>
	<script src="resources/lib/bootstrap/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript" src="resources/lib/jquery.dcjqaccordion.2.7.js"></script>
	<script src="resources/lib/jquery.scrollTo.min.js"></script>
	<script src="resources/lib/jquery.nicescroll.js" type="text/javascript"></script>
	<script type="text/javascript" language="javascript" src="resources/lib/advanced-datatable/js/jquery.dataTables.js"></script>
	<script type="text/javascript" src="resources/lib/advanced-datatable/js/DT_bootstrap.js"></script>
	<!--common script for all pages-->
	<script src="resources/lib/common-scripts.js"></script>
	<!--script for this page-->
	<script src="resources/lib/ckeditor/ckeditor.js"></script>
</body>

</html>

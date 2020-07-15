<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
<title>JS.Inc</title>
<link href="resources/img/favicon.png" rel="icon">
<meta charset="utf-8">
</head>

<body>
	<section id="container">
		<jsp:include page="../default/header.jsp"/>
		<!--sidebar start-->
      <aside>
         <div id="sidebar" class="nav-collapse ">
            <!-- sidebar menu start-->
            <ul class="sidebar-menu" id="nav-accordion">
               <p class="centered">
                  <a href="profile">
                     <img src="resources/img${user.img}" class="img-circle" width="80">
                  </a>
               </p>
               <h5 class="centered"><i class="fa fa-user"></i> ${user.name } <br>(${user.userEmail })</h5>
               
               <!-- 출/퇴근 관리 -->
               <li class="mt">
                  <a href="attendance"> 
                     <i class="fa fa-asterisk"></i> <span>출/퇴근</span>
                  </a>
               </li>
               
               <!-- 커뮤니티 -->
               <li class="sub-menu">
                  <a href="javascript:;"> 
                     <i class="fa fa-desktop"></i> <span>커뮤니티</span>
                  </a>
                  <ul class="sub">
                     <li><a href="createCommunity">커뮤니티 만들기</a></li>
                     <li><a href="allCommunity">전체 커뮤니티</a></li>
                     <li><a href="joinCommunity">가입 커뮤니티</a></li>
                     
                  </ul>
               </li>
               
               <!-- 게시판 -->
               <li class="sub-menu"><a href="javascript:;"> <i
                     class="fa fa-cogs"></i> <span>게시판</span>
               </a>
                  <ul class="sub">
                     <li><a href="allCompanyBoard">전사 게시판</a></li>
                     <li><a href="departmentBoard">부서 게시판</a></li>
                     <li><a href="referenceBoard">자료실 게시판</a></li>
                  </ul>
               </li>
               
               <!-- 전자 결재 -->
               <li class="sub-menu">
                  <a href="javascript:;"> 
                     <i class="fa fa-book"></i>  <span>전자 결재</span>
                  </a>
                  <ul class="sub">
                     <li><a href="newSign">결재 상신</a></li>
                     <li><a href="signApprove">결재 승인</a></li>
                     <li><a href="signWait">결재 대기</a></li>
                     <li><a href="signSuccess">결재 완료</a></li>
                  </ul>
               </li>
               
               <!-- 주소록 -->
               <li >
                  <a href="addressBook"> 
                     <i class="fa fa-tasks"></i><span>주소록</span>
                  </a>
               </li>
               
               <!-- 캘린더 -->
               <li>
                  <a href="toDoList">
                     <i class="fa fa-th"></i><span>스케줄</span>
                  </a>
               </li>
               

               
               <!-- 보고 -->
               <li>
                  <a href="report"> 
                     <i class=" fa fa-bar-chart-o"></i><span>보고</span>
               		</a>
               </li>
               
               <!-- 쪽지 -->
               <li class="sub-menu">
                  <a href="javascript:;"> 
                     <i class="fa fa-comments-o"></i> <span>쪽지함</span><span class="label label-theme pull-right mail-info">${msgAlarm }</span>
                  </a>
                  <ul class="sub">
                     <li><a href="sentMessage">보낸 쪽지함</a></li>
                     <li><a href="RecMessage">받은 쪽지함</a></li>
                  </ul>
               </li>
               
               <!-- 설문 -->
               <li class="sub-menu">
                  <a class="active" href="javascript:;"> 
                     <i class="fa fa-map-marker"></i>  <span>설문</span>
                  </a>
                  <ul class="sub">
                  	 <li><a href="createSurvey">새 설문 작성</a></li>
                     <li><a href="startedSurvey">진행중인 설문</a></li>
                     <li><a href="endSurvey">마감된 설문</a></li>
                     <li><a href="mySurvey">내가 만든 설문</a></li>
                  </ul>
               </li>
            </ul>
            <!-- sidebar menu end-->
         </div>
      </aside>
      <!--sidebar end-->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<h3>
					<i class="fa fa-angle-right"></i> ${survey.title}
				</h3>
				<div class="row mt">
					<!--  DATE PICKERS -->
					<div class="col-lg-12">
						<div class="form-panel">
							<form action="surveyResult?title=${survey.text }" class="form-horizontal style-form">
								<div class="form-group ">
									<label for="ccomment" class="control-label col-lg-2" style="text-align: center;">설문 내용</label>
									<div class="col-lg-10">
										<p>${survey.text }</p>
									</div>
								</div>
								<div class="form-group">
									<label for="ccomment" class="control-label col-lg-2" style="text-align: center;">결과</label>
									<div class="col-lg-10">
										참여자 수 : <b style="color: blue;">${total }</b> 명<br><br>
										<c:choose>
											<c:when test="${opt == 2 }">
												1. <b style="color: blue;">${answer1 }</b> 명&nbsp;(<fmt:formatNumber value="${(answer1 / total)}" type="percent"/>)
												<div class="progress progress-striped">
													
													<div class="progress-bar progress-bar-success" role="progressbar" aria-valuemax="100" style="width: ${(answer1 / total)*100}%"></div>
												</div>
												2. <b style="color: blue;">${answer2 }</b> 명&nbsp;(<fmt:formatNumber value="${(answer2 / total)}" type="percent"/>)
												<div class="progress progress-striped">
													<div class="progress-bar progress-bar-info" role="progressbar" aria-valuemax="100" style="width: ${(answer2 / total)*100}%"></div>
												</div>
											</c:when>
											<c:otherwise>
												1. <b style="color: blue;">${answer1 }</b> 명&nbsp;(<fmt:formatNumber value="${(answer1 / total)}" type="percent"/>)
												<div class="progress progress-striped">
													<div class="progress-bar progress-bar-success" role="progressbar" aria-valuemax="100" style="width: ${(answer1 / total)*100}%"></div>
												</div>
												2. <b style="color: blue;">${answer2 }</b> 명&nbsp;(<fmt:formatNumber value="${(answer2 / total)}" type="percent"/>)
												<div class="progress progress-striped">
													<div class="progress-bar progress-bar-info" role="progressbar" aria-valuemax="100" style="width: ${(answer2 / total)*100}%"></div>
												</div>
												3. <b style="color: blue;">${answer3 }</b> 명&nbsp;(<fmt:formatNumber value="${(answer3 / total)}" type="percent"/>)
												<div class="progress progress-striped">
													<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuemax="100" style="width: ${(answer3 / total)*100}%"></div>
												</div>
												4. <b style="color: blue;">${answer4 }</b> 명&nbsp;(<fmt:formatNumber value="${(answer4 / total)}" type="percent"/>)
												<div class="progress progress-striped">
													<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuemax="100" style="width: ${(answer4 / total)*100}%"></div>
												</div>
												5. <b style="color: blue;">${answer5 }</b> 명&nbsp;(<fmt:formatNumber value="${(answer5 / total)}" type="percent"/>)
												<div class="progress progress-striped">
													<div class="progress-bar progress-bar-five" role="progressbar" aria-valuemax="100" style="width: ${(answer5 / total)*100}%"></div>
												</div>
											</c:otherwise>
										</c:choose>
										
										<!--<canvas id="doughnut" height="300" width="400"></canvas>-->
									</div>
								</div>
							</form>
						</div>
						<!-- /form-panel -->
					</div>
					<!-- /col-lg-12 -->
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
	<script src="resources/lib/bootstrap/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript" src="resources/lib/jquery.dcjqaccordion.2.7.js"></script>
	<script src="resources/lib/jquery.scrollTo.min.js"></script>
	<script src="resources/lib/jquery.nicescroll.js" type="text/javascript"></script>
	<!--common script for all pages-->
	<script src="resources/lib/common-scripts.js"></script>
	<!--script for this page-->
	<script src="resources/lib/jquery-ui-1.9.2.custom.min.js"></script>
	<script type="text/javascript" src="resources/lib/bootstrap-fileupload/bootstrap-fileupload.js"></script>
	<script type="text/javascript" src="resources/lib/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="resources/lib/bootstrap-daterangepicker/date.js"></script>
	<script type="text/javascript" src="resources/lib/bootstrap-daterangepicker/daterangepicker.js"></script>
	<script type="text/javascript" src="resources/lib/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript" src="resources/lib/bootstrap-daterangepicker/moment.min.js"></script>
	<script type="text/javascript" src="resources/lib/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>
	<script src="resources/lib/advanced-form-components.js"></script>
	<!--script for this page-->
	<script src="resources/lib/chart-master/Chart.js"></script>
	<script src="resources/lib/chartjs-conf.js"></script>
</body>

</html>
										
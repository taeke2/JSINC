<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- by성택_출&퇴근 페이지_20200527 -->

<!DOCTYPE html>
<html lang="en">
<head>
<title>JS.Inc</title>
<link href="resources/img/favicon.png" rel="icon">
</head>

<body>
	<section id="container">
		<jsp:include page="../default/header.jsp" />
		<!--sidebar start-->
		<aside>
			<div id="sidebar" class="nav-collapse ">
				<!-- sidebar menu start-->
				<ul class="sidebar-menu" id="nav-accordion">
					<p class="centered">
						<a href="profile"> <img src="resources/img${user.img}"
							class="img-circle" width="80">
						</a>
					</p>
					<h5 class="centered">
						<i class="fa fa-user"></i> ${user.name } <br>(${user.userEmail })
					</h5>

					<!-- 출/퇴근 관리 -->
					<li class="mt"><a class="active" href="attendance"> <i
							class="fa fa-asterisk"></i> <span>출/퇴근</span>
					</a></li>

					<!-- 커뮤니티 -->
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-desktop"></i> <span>커뮤니티</span>
					</a>
						<ul class="sub">
							<li><a href="createCommunity">커뮤니티 만들기</a></li>
							<li><a href="allCommunity">전체 커뮤니티</a></li>
							<li><a href="joinCommunity">가입 커뮤니티</a></li>

						</ul></li>

					<!-- 게시판 -->
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-cogs"></i> <span>게시판</span>
					</a>
						<ul class="sub">
							<li><a href="allCompanyBoard">전사 게시판</a></li>
							<li><a href="departmentBoard">부서 게시판</a></li>
							<li><a href="referenceBoard">자료실 게시판</a></li>
						</ul></li>

					<!-- 전자 결재 -->
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-book"></i> <span>전자 결재</span>
					</a>
						<ul class="sub">
							<li><a href="newSign">결재 상신</a></li>
							<li><a href="signApprove">결재 승인</a></li>
							<li><a href="signWait">결재 대기</a></li>
							<li><a href="signSuccess">결재 완료</a></li>
						</ul></li>

					<!-- 주소록 -->
					<li><a href="addressBook"> <i class="fa fa-tasks"></i><span>주소록</span>
					</a></li>

					<!-- 캘린더 -->
					<li><a href="toDoList"> <i class="fa fa-th"></i><span>스케줄</span>
					</a></li>



					<!-- 보고 -->
					<li><a href="report"> <i class=" fa fa-bar-chart-o"></i><span>보고</span>
					</a></li>

					<!-- 쪽지 -->
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-comments-o"></i> <span>쪽지함</span><span
							class="label label-theme pull-right mail-info">${msgAlarm }</span>
					</a>
						<ul class="sub">
							<li><a href="sentMessage">보낸 쪽지함</a></li>
							<li><a href="RecMessage">받은 쪽지함</a></li>
						</ul></li>

					<!-- 설문 -->
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-map-marker"></i> <span>설문</span>
					</a>
						<ul class="sub">
							<li><a href="createSurvey">새 설문 작성</a></li>
							<li><a href="startedSurvey">진행중인 설문</a></li>
							<li><a href="endSurvey">마감된 설문</a></li>
							<li><a href="mySurvey">내가 만든 설문</a></li>
						</ul></li>
				</ul>
				<!-- sidebar menu end-->
			</div>
		</aside>
		<!--sidebar end-->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<div class="row mt">
					<div class="col-lg-6 col-md-6 col-sm-12">
						<!--  BUTTONS ROUND -->
						<div class="showback">
							<h4>
								<i class="fa fa-angle-right"></i> 출근
							</h4>
							<form action="goWork">
								<button type="submit" class="btn btn-primary btn-lg btn-block">
									<i class="fa fa-check-circle"></i>출&nbsp;&nbsp;근
								</button>
								<br>

							</form>
						</div>
						<!--  BUTTONS GROUP -->
						<div class="showback">
							<h4>
								<i class="fa fa-angle-right"></i> 퇴근
							</h4>
							<form action="leaveWork">
								<button type="submit" class="btn btn-default btn-lg btn-block">
									<i class="fa fa-check-circle-o"></i> 퇴&nbsp;&nbsp;근
								</button>
								<br>

							</form>
						</div>
						<!-- /showback -->
						<!--  BUTTONS NESTING -->
						<div class="showback">
							<h4>
								<i class="fa fa-angle-right"></i> Time
							</h4>
							<h5>출근 : ${applicationScope.start.goWork }</h5>
							<h5>퇴근 : ${applicationScope.end.leaveWork }</h5>
						</div>
						<!-- /showback -->
					</div>

					<!-- /col-lg-6 -->
					<div class="col-lg-6 col-md-6 col-sm-12">
						<!--  SPLIT BUTTONS -->
						<div class="showback">
							<div>
								<h4>
									<i class="fa fa-angle-right"></i> 근무 기록
								</h4>
								<form action="list">
									<div class="btn-group">
										<button type="submit" class="btn btn-theme" name="month"
											value="01">Jan</button>
										<button type="submit" class="btn btn-default" name="month"
											value="02">Feb</button>
										<button type="submit" class="btn btn-theme" name="month"
											value="03">Mar</button>
										<button type="submit" class="btn btn-default" name="month"
											value="04">Apr</button>
										<button type="submit" class="btn btn-theme" name="month"
											value="05">May</button>
										<button type="submit" class="btn btn-default" name="month"
											value="06">Jun</button>
										<button type="submit" class="btn btn-theme" name="month"
											value="07">Jul</button>
										<button type="submit" class="btn btn-default" name="month"
											value="08">Aug</button>
										<button type="submit" class="btn btn-theme" name="month"
											value="09">Sep</button>
										<button type="submit" class="btn btn-default" name="month"
											value="10">Oct</button>
										<button type="submit" class="btn btn-theme" name="month"
											value="11">Nov</button>
										<button type="submit" class="btn btn-default" name="month"
											value="12">Dec</button>
									</div>
								</form>
								<hr>
								<table class="table">
									<thead>
										<tr>
											<th>날짜</th>
											<th>출근</th>
											<th>퇴근</th>
											<th>근무시간</th>
										</tr>
									</thead>
									<!-- 출/퇴근 시간 리스트 -->
									<tbody>
										<c:forEach items="${lists }" var="dto_att">
											<tr>
												<td>2020.${month }</td>
												<td>${dto_att.goWork }</td>
												<td>${dto_att.leaveWork }</td>
												<td>${dto_att.workTime }시간</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<h5>
									<b style="color: blue;">${month }</b>월 총 근무 시간 : <b
										style="color: blue;">${totWorkTime }</b> (h)
								</h5>
							</div>
						</div>
						<!-- /showback -->
					</div>
					<!-- /col-lg-6 -->
				</div>
				<!--/ row -->
			</section>
			<!-- /wrapper -->
		</section>
		<!-- /MAIN CONTENT -->
		<!--main content end-->
		<jsp:include page="../default/footer.jsp" />
	</section>
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="resources/lib/jquery/jquery.min.js"></script>

	<script src="resources/lib/bootstrap/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="resources/lib/jquery.dcjqaccordion.2.7.js"></script>
	<script src="resources/lib/jquery.scrollTo.min.js"></script>
	<script src="resources/lib/jquery.nicescroll.js" type="text/javascript"></script>
	<!--common script for all pages-->
	<script src="resources/lib/common-scripts.js"></script>
</body>

</html>

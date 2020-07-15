<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>

<style type="text/css">
ul li img {
	width: 100%;
	height: 300px;
}
</style>

<title>JS.Inc</title>
<link href="resources/img/favicon.png" rel="icon">

</head>
<body>
	<section id="container">
		<jsp:include page="default/header.jsp" />
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
					<h5 class="centered">
						<i class="fa fa-user"></i> ${user.name } <br>(${user.userEmail })
					</h5>

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
					<li class="sub-menu">
						<a href="javascript:;"> 
							<i class="fa fa-cogs"></i> <span>게시판</span>
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
							<i class="fa fa-book"></i> <span>전자 결재</span>
						</a>
						<ul class="sub">
							<li><a href="newSign">결재 상신</a></li>
							<li><a href="signApprove">결재 승인</a></li>
							<li><a href="signWait">결재 대기</a></li>
							<li><a href="signSuccess">결재 완료</a></li>
						</ul>
					</li>

					<!-- 주소록 -->
					<li>
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
							<i class="fa fa-comments-o"></i> <span>쪽지함</span>
							<span class="label label-theme pull-right mail-info">${msgAlarm }</span>
						</a>
						<ul class="sub">
							<li><a href="sentMessage">보낸 쪽지함</a></li>
							<li><a href="RecMessage">받은 쪽지함</a></li>
						</ul>
					</li>

					<!-- 설문 -->
					<li class="sub-menu">
						<a href="javascript:;"> 
							<i class="fa fa-map-marker"></i> <span>설문</span>
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
				<div class="row">
					<div class="col-lg-9 main-chart">
					<!-- 사진 슬라이드 -->
						<div class="border-head"></div>
						<div class="custom-bar-chart" style="width: 100%; margin: 0 auto; margin-bottom: 50px;">
							<div align="center" style="margin: 0 auto;">
								<ul class="bxSlider">
									<li><img alt="" src="resources/bxSli/img/pic01.png"></a></li>
									<li><img alt="" src="resources/bxSli/img/pic02.jpg"></a></li>
									<li><img alt="" src="resources/bxSli/img/pic03.png"></a></li>
								</ul>
							</div>
						</div>
						<div class="row mt">
							<!-- SERVER STATUS PANELS -->
							<div class="col-md-4 col-sm-4 mb">
								<div class="grey-panel pn donut-chart">
									<div class="grey-header">
										<h5>SERVER LOAD</h5>
									</div>
									<canvas id="serverstatus01" height="120" width="120"></canvas>
									<script>
										var doughnutData = [ {
											value : 70,
											color : "#FF6B6B"
										}, {
											value : 30,
											color : "#fdfdfd"
										} ];
										var myDoughnut = new Chart(document
												.getElementById(
														"serverstatus01")
												.getContext("2d"))
												.Doughnut(doughnutData);
									</script>
									<div class="row">
										<div class="col-sm-6 col-xs-6 goleft">
											<p>
												Usage<br />Increase:
											</p>
										</div>
										<div class="col-sm-6 col-xs-6">
											<h2>21%</h2>
										</div>
									</div>
								</div>
								<!-- /grey-panel -->
							</div>
							<!-- /col-md-4-->
							<div class="col-md-4 col-sm-4 mb">
								<div class="darkblue-panel pn">
									<div class="darkblue-header">
										<h5>DROPBOX STATICS</h5>
									</div>
									<canvas id="serverstatus02" height="120" width="120"></canvas>
									<script>
										var doughnutData = [ {
											value : 60,
											color : "#1c9ca7"
										}, {
											value : 40,
											color : "#f68275"
										} ];
										var myDoughnut = new Chart(document
												.getElementById(
														"serverstatus02")
												.getContext("2d"))
												.Doughnut(doughnutData);
									</script>
									<p>April 17, 2014</p>
									<footer>
										<div class="pull-left">
											<h5>
												<i class="fa fa-hdd-o"></i> 17 GB
											</h5>
										</div>
										<div class="pull-right">
											<h5>60% Used</h5>
										</div>
									</footer>
								</div>
								<!--  /darkblue panel -->
							</div>
							<!-- /col-md-4 -->
							<div class="col-md-4 col-sm-4 mb">
								<!-- REVENUE PANEL -->
								<div class="green-panel pn">
									<div class="green-header">
										<h5>REVENUE</h5>
									</div>
									<div class="chart mt">
										<div class="sparkline" data-type="line" data-resize="true"
											data-height="75" data-width="90%" data-line-width="1"
											data-line-color="#fff" data-spot-color="#fff"
											data-fill-color="" data-highlight-line-color="#fff"
											data-spot-radius="4"
											data-data="[200,135,667,333,526,996,564,123,890,464,655]"></div>
									</div>
									<p class="mt">
										<b>$ 17,980</b><br />Month Income
									</p>
								</div>
							</div>
							<!-- /col-md-4 -->
						</div>
						<!-- /row -->
						<div class="row">
							<!-- WEATHER PANEL -->
							<div class="col-md-4 mb">
								<div class="weather pn">
									<i class="cicon"></i>
									<h2 class="ctemp">현재 온도:</h2>
									<h4 class="humtemp">습도:</h4>
									<h4>종로구</h4>
								</div>
							</div>
							<!-- /col-md-4-->

							<!-- DIRECT SURVEY PANEL -->
							<div class="col-md-8 mb">
								<div class="message-p pn">
									<div class="message-header">
										<h5>참여하지 않은 설문</h5>
									</div>
									<c:if test="${empty survey}">
										<div class="col-md-9">
											<p class="message">모든 설문을 참여하였습니다.</p>
										</div>
									</c:if>
									<div align="right" style="margin-right: 10px;">
										<button type="button" class="btn btn-round btn-info" onclick="location.href='startedSurvey'">설문하러 가기</button>
									</div>
									<div class="row">
										<c:forEach items="${survey}" var="dto_sur" begin="0" end="1">
											<div class="col-md-9">
												<p>
													작성자 : <name>${dto_sur.writer }</name>
												</p>
												<p class="small">Today</p>
												<p class="message">제목 : ${dto_sur.title }</p>
												<br>
											</div>
										</c:forEach>
									</div>
								</div>
							</div>
							<!-- /col-md-8  -->
						</div>
						<!-- /row -->
					</div>
					<!-- /col-lg-9 END SECTION MIDDLE -->
					<!-- **********************************************************************************************************************************************************
              RIGHT SIDEBAR CONTENT
              *********************************************************************************************************************************************************** -->
					<div class="col-lg-3 ds">
						<!-- RECENT MESSAGE SECTION -->
							<h4 class="centered mt">읽지 않은 메세지</h4>
					
				<c:if test="${empty recList}">
						<div class="desc" align="center" style="margin-bottom: 250px;">
							<a href="RecMessage">받은 쪽지함 바로가기</a>
						</div>
				</c:if>	
						<c:forEach var="rec" items="${recList }" begin="0" end="3">
						<div class="desc">
							<div class="thumb">
								<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
							</div>
							
								<p>
									${rec.sentTime }
									<br /><a href="recContentView?subject=${rec.subject }&content=${rec.content}&sentTime=${rec.sentTime}&sender=${rec.sender}&senderRank=${rec.senderRank}&senderDep=${rec.senderDep}&senderEmpNo=${rec.senderEmpNo}">${rec.sender }</a>&nbsp;${rec.senderRank }님이  메세지를 보내셨습니다.<br />
								</p>
						
						</div>
						</c:forEach>
						<!-- CALENDAR-->
						<div id="calendar" class="mb">
							<div class="panel green-panel no-margin">
								<div class="panel-body">
									<div id="date-popover" class="popover top"
										style="cursor: pointer; disadding: block; margin-left: 33%; margin-top: -50px; width: 175px;">
										<div class="arrow"></div>
										<h3 class="popover-title" style="disadding: none;"></h3>
										<div id="date-popover-content" class="popover-content"></div>
									</div>
									<div id="my-calendar"></div>
								</div>
							</div>
						</div>
						<!-- / calendar -->
						<!-- Company Logo -->
						<img src="resources/img/favicon.png" style="padding: 75px 0 75px 0; width: 100%; heigth: 100%;">
					</div>
					<!-- /col-lg-3 -->
				</div>
				<!-- /row -->
			</section>
		</section>
		<!--main content end-->
		<jsp:include page="default/footer.jsp" />
	</section>
	<!-- 날씨 -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

	<script>
	$.getJSON('http://api.openweathermap.org/data/2.5/weather?lat=37.5711258&lon=126.991981&APPID=254aee44df076ff4abe18019eaec0bbf', function(data){
		var $cTemp=Math.floor(data.main.temp-273.15)+"ºC";
		var $minTemp=Math.floor(data.main.temp_min-273.15);
	 	var $maxTemp=Math.floor(data.main.temp_max-273.15);
	 	var $cDate=data.dt;
	 	var $wIcon=data.weather[0].icon;
	 	var $hum=(data.main.humidity+"%");
	 	
	 	$('.ctemp').append($cTemp)
	 	$('.humtemp').append($hum)
	 	$('.cicon').append('<img src="http://openweathermap.org/img/wn/'+$wIcon+'@2x.png"/>')
	    });

	</script>

	<!--날씨 end  -->
	<!-- slider -->
	<link rel="stylesheet" href="resources/bxSli/css/jquery.bxslider.css">
	<script src="resources/bxSli/js/jquery-3.5.1.min.js"></script>
	<script src="resources/bxSli/js/jquery.bxslider.js"></script>
	<script src="resources/bxSli/images/controls.png"></script>
	<!-- slider end -->
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="resources/lib/bootstrap/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="resources/lib/jquery.dcjqaccordion.2.7.js"></script>
	<script src="resources/lib/jquery.scrollTo.min.js"></script>
	<script src="resources/lib/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="resources/lib/jquery.sparkline.js"></script>
	<!--common script for all pages-->
	<script src="resources/lib/common-scripts.js"></script>
	<script type="text/javascript"
		src="resources/lib/gritter/js/jquery.gritter.js"></script>
	<script type="text/javascript" src="resources/lib/gritter-conf.js"></script>
	<!--script for this page-->
	<script src="resources/lib/sparkline-chart.js"></script>
	<script src="resources/lib/zabuto_calendar.js"></script>

	<script type="application/javascript">
		
    $(document).ready(function() {
      $("#date-popover").popover({
        html: true,
        trigger: "manual"
      });
      $("#date-popover").hide();
      $("#date-popover").click(function(e) {
        $(this).hide();
      });

      $("#my-calendar").zabuto_calendar({
        action: function() {
          return myDateFunction(this.id, false);
        },
        action_nav: function() {
          return myNavFunction(this.id);
        },
        ajax: {
          url: "show_data.php?action=1",
          modal: true
        },
        legend: [{
            type: "text",
            label: "",
            badge: ""
          },
          {
            type: "block",
            label: "",
          }
        ]
      });
    });

    function myNavFunction(id) {
      $("#date-popover").hide();
      var nav = $("#" + id).data("navigation");
      var to = $("#" + id).data("to");
      console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
    }
    
    $(document).ready(function() {
		$(".bxSlider").bxSlider({
			auto : true,
			speed : 500,
			pause:5000,
			

		});

	});
	</script>
</body>

</html>

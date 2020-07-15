<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JS.Inc</title>
<link href="resources/img/favicon.png" rel="icon">
</head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="Dashboard">
  <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
  <title>Dashio - Bootstrap Admin Template</title>

  <!-- Favicons -->
  <link href="resources/img/favicon.png" rel="icon">
  <link href="resources/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Bootstrap core CSS -->
  <link href="resources/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!--external css-->
  <link href="resources/lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <!-- Custom styles for this template -->
  <link href="resources/css/style.css" rel="stylesheet">
  <link href="resources/css/style-responsive.css" rel="stylesheet">
<body>
<jsp:include page="../default/header.jsp" />
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
                  <a class="active" href="javascript:;"> 
                     <i class="fa fa-book"></i>  <span>전자 결재</span>
                  </a>
                  <ul class="sub">
                     <li><a href="newSign">결재 상신</a></li>
                     <li class="active"><a href="signApprove">결재 승인</a></li>
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
                  <a  href="javascript:;"> 
                     <i class="fa fa-comments-o"></i> <span>쪽지함</span><span class="label label-theme pull-right mail-info">${msgAlarm }</span>
                  </a>
                  <ul class="sub">
                     <li><a href="sentMessage">보낸 쪽지함</a></li>
                     <li><a href="RecMessage">받은 쪽지함</a></li>
                  </ul>
               </li>
               
               <!-- 설문 -->
               <li class="sub-menu">
                  <a href="javascript:;"> 
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
					<i class="fa fa-angle-right"></i> 결재 승인
				</h3>
        <!-- page start-->
      
          <div class="col-sm-13">
            <section class="panel">
              <header class="panel-heading wht-bg">
                
                
                  
                  
              </header>
              <div class="panel-body ">
                <div class="mail-header row">
                  <div class="col-md-8">
                    <h4 class="pull-left"><b>제목:</b> ${sign.title } </h4>
                  </div>
                  
                </div>
                <div class="mail-sender">
                  <div class="row">
                    <div class="col-md-4">
                      <p>
                      	<b>작성자 :</b> ${sign.writer }&nbsp;&nbsp;&nbsp;
                      	<b>부서 :</b> ${sign.department }
                      	</p>
                      <fmt:formatDate value="${sign.regdate }" pattern="yyyy-MM-dd (E) HH:mm:ss (a)"/> 
                      
                    </div>
                  </div>
                </div>

                <div class="view-mail">
                                <c:set var="signs" value="${sign.signs }"></c:set>
							<%
								String signs = (String) pageContext.getAttribute("signs");
								if (signs.equals("휴가")) {
							%>
							<div>
										<b>신청한 휴가 일자 :</b>
										${sign.startDT }~ ${sign.endDT }<br>
										<b>휴가 사유 :</b>
										${sign.content}<br>
							</div>
							<%
								} else if (signs.equals("외근")) {
							%>
							<div>
										<b>신청한 외근 일자 :</b>
										${sign.outwork }<br>
										<b>외근 지역 :</b>
										${sign.worklocation}<br>
										<b>작업 내용 :</b>
										${sign.content }<br>
									
								
							</div>
							<%
								} else if (signs.equals("연장근무")) {
							%>
							<div>
										<b>신청한 연장 시간 :</b>
										${sign.startDT }~ ${sign.endDT }<br>
										<b>연장 근무 사유 :</b>
										${sign.content }<br>
								<%
									}  
								%>
								<c:set var="auth" value="${user.authority }"></c:set>
								<%
								String StringAuth = String.valueOf(pageContext.getAttribute("auth"));
								int auth = Integer.parseInt(StringAuth);
								if(auth>3){%>
									<div>
										<button type="button" class="btn btn-success" value="승인" name="approved" onclick="location.href='confirm?bno=${sign.bno}'">승인</button>
										<button type="button" class="btn btn-theme04" value="반려" name="reject" onclick="location.href='reject?bno=${sign.bno}'">반려</button>
									</div>
								<%}%>
                </div>
                <hr>
              
                <div class="compose-btn pull-left">
                  	<a href="signApprove"><button class="btn btn-sm btn-theme"><i class="fa fa-reply"></i> 목록으로</button></a>
                	<button id="delete" class="btn btn-sm btn-theme04">삭제하기</button>
                </div>
              </div>
            </section>
          </div>
        </div>
      </section>
      <!-- /wrapper -->
    </section>
    <!-- /MAIN CONTENT -->
    <!--main content end-->
	 <jsp:include page="../default/footer.jsp"/>
	
                <!-- js placed at the end of the document so the pages load faster -->
  <script src="resources/lib/jquery/jquery.min.js"></script>
  <script src="resources/lib/bootstrap/js/bootstrap.min.js"></script>
  <script class="include" type="text/javascript" src="resources/lib/jquery.dcjqaccordion.2.7.js"></script>
  <script src="resources/lib/jquery.scrollTo.min.js"></script>
  <script src="resources/lib/jquery.nicescroll.js" type="text/javascript"></script>
  <!--common script for all pages-->
  <script src="resources/lib/common-scripts.js"></script>
  <!--script for this page-->
  <c:set var="userName" value="${user.name }"></c:set>
  <c:set var="userRank" value="${user.rank }"></c:set>
  <c:set var="viewName" value="${sign.writer }"></c:set>
<script>
<% 
	String userRank = (String)pageContext.getAttribute("userRank");
	String userName = (String)pageContext.getAttribute("userName");
	String viewName = (String)pageContext.getAttribute("viewName");
	String chk = userName+" "+userRank;
%>
				
				$("#delete").on('click',function() {
					<% if(chk.equals(viewName)){%>
						location.href = "deleteSign?bno=${sign.bno}";
					<%}else{%>
						alert("작성자가 아니면 삭제할 수 없습니다!");
						location.href = "departmentBoard";
					<%}%>
				});
        </script>
</body>
</html>

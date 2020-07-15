<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
<title>JS.Inc</title>
<link href="resources/img/favicon.png" rel="icon">
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
                  <a class="active" href="toDoList">
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
					<i class="fa fa-angle-right"></i> 스케줄
				</h3>
				<!-- SORTABLE TO DO LIST -->
				<div class="row mt">
					<div class="col-md-12">
						<section class="task-panel tasks-widget">
							<div class="panel-heading">
								<div class="pull-left">
									<h5>
										<i class="fa fa-tasks"></i> 오늘 할 일
									</h5>
								</div>
								<br>
							</div>
							<div class="panel-body">
								<div class="task-content">
									<ul class="task-list">
										<c:forEach items="${list }" var="dto_todo">
											<c:choose>
												<c:when test="${dto_todo.checked eq 'Y' }">
													<li>
														<div class="task-title">
															<span class="task-title-sp" style="text-decoration: line-through;">${dto_todo.todo}</span> 
															<div class="pull-right">
																<button class="btn btn-success btn-xs" onclick="location.href='check?btns=${dto_todo.todo}'">				
																	<i class=" fa fa-check"></i>
																</button>
																<button class="btn btn-primary btn-xs" onclick="location.href='editPage?btns=${dto_todo.todo}'">
																	<i class="fa fa-pencil"></i>
																</button>
																<button class="btn btn-danger btn-xs" onclick="location.href='delete?btns=${dto_todo.todo}'">
																	<i class="fa fa-trash-o "></i>
																</button>
															</div>
														</div>
													</li>
												</c:when>
												<c:otherwise>
													<li>
														<div class="task-checkbox">
															<input type="checkbox" class="list-child" name="check" value="${dto_todo.todo}"/>
														</div>
														<div class="task-title">
															<span class="task-title-sp">${dto_todo.todo}</span> 
															<div class="pull-right">
																<button class="btn btn-success btn-xs" onclick="location.href='check?btns=${dto_todo.todo}'">				
																	<i class=" fa fa-check"></i>
																</button>
																<button class="btn btn-primary btn-xs" onclick="location.href='editPage?btns=${dto_todo.todo}'">
																	<i class="fa fa-pencil"></i>
																</button>
																<button class="btn btn-danger btn-xs" onclick="location.href='delete?btns=${dto_todo.todo}'">
																	<i class="fa fa-trash-o "></i>
																</button>
															</div>
														</div>
													</li>
												</c:otherwise>
											</c:choose>
											
										</c:forEach>
										
									</ul>
								</div>
								<div class=" add-task-row">
									<a class="btn btn-success btn-sm pull-left" href="addTodo">Add New Tasks</a> 
									
								</div>
							</div>
						</section>
					</div>
					<!-- /col-md-12-->
				</div>
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
	<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
	<script src="resources/lib/tasks.js" type="text/javascript"></script>
	
	<script>
		jQuery(document).ready(function() {
			TaskList.initTaskWidget();
		});

		$(function() {
			$("#sortable").sortable();
			$("#sortable").disableSelection();
		});
	</script>

</body>

</html>

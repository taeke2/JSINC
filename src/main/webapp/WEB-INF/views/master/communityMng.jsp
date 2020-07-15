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
						<a href="memberMng"> 
							<i class="fa fa-asterisk"></i>
							<span>사원 관리</span>
						</a>
					</li>

					<!-- 커뮤니티 관리 -->
					<li>
						<a class="active" href="communityMng"> 
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
						<div class="adv-table">
							<table cellpadding="0" cellspacing="0" border="0"
								class="display table table-bordered" id="hidden-table-info">
								<thead>
									<tr>
										<th>번호</th>
										<th>커뮤니티(명)</th>
										<th>회원수</th>
										<th>마스터</th>
										<th></th>
										
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list }" var="dto">
										<!-- <form action="edit"> -->
											<tr>
												<td><h5>${dto.cNo }</h5></td>
												<td><h5>${dto.title }</h5></td>
												<td><h5>${dto.members }</h5></td>
												<td><h5>${dto.name } ${dto.rank }</h5></td>
												<c:choose>
													<c:when test="${dto.autho eq 'N' }">
														<td align="center">
															<button type="button" class="btn btn-round btn-success" onclick="location.href='permissionCom?title=${dto.title}'">
																<i class="fa fa-check"></i> 승인
															</button>
															<button type="button" class="btn btn-round btn-warning" onclick="location.href='deleteCom?title=${dto.title}'">
																<i class="fa fa-certificate"></i> 승인 취소
															</button>
														</td>
													</c:when>
													<c:otherwise>
														<td align="center">
															<button type="button" class="btn btn-round btn-theme04" onclick="location.href='deleteCom?title=${dto.title}'">
																<i class="fa fa-trash-o"></i> 삭제
															</button>
														</td>
													</c:otherwise>
												</c:choose>
											</tr>
										<!-- </form> -->
									</c:forEach>
								</tbody>
							</table>
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
	<script type="text/javascript">
		/* Formating function for row details 
		function fnFormatDetails(oTable, nTr) {
			var aData = oTable.fnGetData(nTr);
			var sOut = '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">';
			sOut += '<tr><td>Rendering engine:</td><td>' + aData[2] + '</td></tr>';
			sOut += '</table>';
			return sOut;
		}
		*/
		$(document).ready(
			function() {
				var nCloneTh = document.createElement('th');
				var nCloneTd = document.createElement('td');
				/*
				nCloneTd.innerHTML = '<img src="resources/lib/advanced-datatable/images/details_open.png">';
				nCloneTd.className = "center";
				*/
				
				$('#hidden-table-info thead tr').each(
					function() {
						this.insertBefore(nCloneTh,this.childNodes[0]);
					}
				);

				$('#hidden-table-info tbody tr').each(
					function() {
						this.insertBefore(nCloneTd.cloneNode(true),this.childNodes[0]);
					}
				);
				
				/*
				 * Initialse DataTables, with no sorting on the 'details' column
				 */
				 
				var oTable = $('#hidden-table-info').dataTable({
					"aoColumnDefs" : [ {"bSortable" : false, "aTargets" : [ 0 ]} ], "aaSorting" : [ [ 1, 'asc' ] ]
				});

				/* Add event listener for opening and closing details
				 * Note that the indicator for showing which row is open is not controlled by DataTables,
				 * rather it is done here
				 */
				
				 /*
				$('#hidden-table-info tbody td img').live('click',
					function() {
						var nTr = $(this).parents('tr')[0];
						if (oTable.fnIsOpen(nTr)) {
							this.src = "resources/lib/advanced-datatable/images/details_open.png";
							oTable.fnClose(nTr);
						} else {
							this.src = "resources/lib/advanced-datatable/images/details_close.png";
							oTable.fnOpen(nTr,fnFormatDetails(oTable,nTr),'details');
						}
					}
				);*/
			}
		);
	</script>
</body>

</html>

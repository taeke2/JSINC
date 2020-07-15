<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<!-- Favicons -->
  <link href="img/favicon.png" rel="icon">
  <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

<meta charset="UTF-8">
<title>JS.Inc</title>
<link href="resources/img/favicon.png" rel="icon">
</head>
<body>
  <!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
    <!--main content start-->
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
				<li class="mt"><a href="attendance"> <i
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
				<li class="sub-menu">
					<a class="active" href="javascript:;"> 
						<i class="fa fa-cogs"></i> <span>게시판</span>
					</a>
					<ul class="sub">
						<li class="active"><a href="allCompanyBoard">전사 게시판</a></li>
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
	<section id="main-content">
    
      <section class="wrapper">
        <h3><i class="fa fa-angle-right"></i> 전사 게시판</h3>
        <hr>
        <div class="row mb">
        <a href="writeBoard" style="padding-left: 10px; padding-bottom: 10px;"><button type="button" class="btn btn-sm btn-success">글쓰기</button></a>
        	
          <!-- page start-->
          <div class="content-panel">
          <div style="padding-right: 30px; float: right;" align="right"  >
        	</div>
            <div class="adv-table">
              
              <table cellpadding="0" cellspacing="0" border="0" class="display table table-bordered" id="hidden-table-info">
                <thead>
                  <tr>
                    <th><center>제목</center></th>
                    <th><center>작성자</center></th>
                    <th><center>작성일</center></th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="board" items="${board}">
                  <tr>
                    <td><a href="allCompanyCon?bno=${board.bno}">${board.title }</td>
                    <td>${board.writer }</td>
                    <td><fmt:formatDate value="${board.regdate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                  </tr>
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
      <jsp:include page="../default/footer.jsp" />
    </section>
    <!-- /MAIN CONTENT -->
    <!--main content end-->	

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
  <script type="text/javascript">
    /* Formating function for row details 
    function fnFormatDetails(oTable, nTr) {
      var aData = oTable.fnGetData(nTr);
      var sOut = '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">';
      sOut += '<tr><td>글 내용물';
      sOut += ''
      sOut += '</td></tr>';

      return sOut;
    }
*/
    $(document).ready(function() {
    	$('#write').on('click', function() {
			location.href = 'writeBoard'
		})
      /*
       * Insert a 'details' column to the tabl
       e
       */
      var nCloneTh = document.createElement('th');
      var nCloneTd = document.createElement('td');
      /*
      nCloneTd.innerHTML = '<img src="resource/lib/advanced-datatable/images/details_open.png">';
      nCloneTd.className = "center";
	  */
      $('#hidden-table-info thead tr').each(function() {
        this.insertBefore(nCloneTh, this.childNodes[0]);
      });

      $('#hidden-table-info tbody tr').each(function() {
        this.insertBefore(nCloneTd.cloneNode(true), this.childNodes[0]);
      });

      /*
       * Initialse DataTables, with no sorting on the 'details' column
       */
      var oTable = $('#hidden-table-info').dataTable({
        "aoColumnDefs": [{
          "bSortable": false,
          "aTargets": [0]
        }],
        "aaSorting": [
          [3, 'desc']
        ]
      });

      /* Add event listener for opening and closing details
       * Note that the indicator for showing which row is open is not controlled by DataTables,
       * rather it is done here
       
      $('#hidden-table-info tbody td img').live('click', function() {
        var nTr = $(this).parents('tr')[0];
        if (oTable.fnIsOpen(nTr)) {
           This row is already open - close it 
          this.src = "resources/lib/advanced-datatable/images/details_open.png";
          oTable.fnClose(nTr);
        } else {
           Open this row 
          this.src = "resources/lib/advanced-datatable/images/details_close.png";
          oTable.fnOpen(nTr, fnFormatDetails(oTable, nTr), 'details');
        }
      });*/
    });
  </script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JS.Inc</title>
</head>
<!-- Favicons -->
<link href="resources/img/favicon.png" rel="icon">
<link href="resources/img/apple-touch-icon.png" rel="apple-touch-icon">
<!-- Bootstrap core CSS -->
<link href="resources/lib/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!--external css-->
<link href="resources/lib/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
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
                  <a class="active" href="javascript:;"> 
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
				<i class="fa fa-angle-right"></i>커뮤니티 글
				<c:choose>
					<c:when test="${signBut==1 }">
						<button type="button" class="btn btn-round btn-danger" style="margin: 10px;"
							onclick="location.href='leave?title=${view.title}'">탈퇴 하기..</button>
					</c:when>
					<c:otherwise>
						<button type="button" class="btn btn-round btn-success"
							onclick="location.href='signUp?title=${view.title}&cno=${view.cNo }'">가입 하기</button>
					</c:otherwise>
				</c:choose>
			</h3>

			<script type="text/javascript">
			$('#sign').ready(function(){
				$('#sign').click(function(){
					alert("가입이 완료 되었습니다.")
					console.log("aaaaaa")
				});
			});
			</script>

			<div class="showback">
				<h4>
					<i class="fa fa-angle-right"></i> <b>마스터</b>
				</h4>
				<h4>- <font style="color: blue;">${view.name } ${view.rank }</font></h4>
				<h4>
					<i class="fa fa-angle-right"></i> <b>커뮤니티 명</b>
				</h4>
				<h4>- <font style="color: blue;">${view.title }</font></h4>
				<h4>
					<i class="fa fa-angle-right"></i> <b>소개</b>
				</h4>
				<h4 style="margin-left: 10px;"><font style="color: blue;">${view.content }</font></h4>
			</div>
			
			<input type="text" id="hide" style="visibility: hidden;" value="${view.title }">
			<div style="width: 90%" align="left">
			<form name="fo">
				<div class="form-group">
					<div class="showback">
						<h4>
							<i class="fa fa-angle-right"></i>게시글을 작성 해주세요
						</h4>
						
							<textarea class="form-control" id="contact-message" placeholder="내용을 입력해주세요" rows="5" data-rule="required" name="content"></textarea>
							<button type="submit" class="btn btn-round btn-info" style="margin: 10px;" onclick="register('A')">이야기하기</button>
							<input type="text" value="${view.title }" name="title" style="visibility: hidden;">
							<input type="text" value="${view.cNo }" name="cno" style="visibility: hidden;">
						
					</div>
				</div>
				<hr style="border: ridge 10px lightgray; margin-left: 10px;">

				<div class="room-box">
					<c:forEach items="${conList }" var="con">
						<c:choose>
	
							<c:when test="${con.step > 0 }">
								<span style="font-size: 13pt; color: black"> 
									<span class="fa fa-mail-forward">${con.content } </span>
								</span>
								<span class="text-primary"> 
									<i class="fa fa-user"></i>&nbsp;<a onclick="replyTo('${view.cNo}','${con.idgroup }','${con.step }','${con.indent }','${con.name }','${con.rank }')" style="cursor: pointer;" >${con.name }&nbsp;${con.rank}&nbsp;</a> <i class="fa fa-calendar"></i>&nbsp;${con.com_date }<br>
								</span>
							</c:when>
							<c:when test="${con.step == 0 }">
			
								<h5 class="text-primary" style="margin-top: 30px;">
									<i class="fa fa-user"></i><a onclick="replyTo('${view.cNo}','${con.idgroup }','${con.step }','${con.indent }','${con.name }','${con.rank }')" style="cursor: pointer;">&nbsp;${con.name }&nbsp;${con.rank}&nbsp;</a>
									<i class="fa fa-calendar"></i>&nbsp;${con.com_date }
								</h5>
								<span style="font-size: 13pt; color: black">${con.content }</span>
								<br>
							</c:when>
						</c:choose>
					</c:forEach>
					<div>
						<c:set var="idgroup" value="${con.idgroup }" />
						
							<input type="text" style="width: 60%; margin-top: 20px;" placeholder="댓글 입력" name="reply" id="reply">
							<button type="button" class="btn btn-round btn-success" onclick="register('B')">등록</button>
							<input type="text" name="cno" id="cn" style="visibility: hidden;"><input type="text" name="idGroup" id="idGroup" style="visibility: hidden;">
							<input type="text" name="step" id="step" style="visibility: hidden;"><input type="text" name="indent" id="indent" style="visibility: hidden;">
				</form>		
					
					</div>
				</div>
			</div>
		</section>
	</section>
	<script type="text/javascript">
	function replyTo(cNo,idGroup,step,indent,name,rank){
		$('#cn').val(cNo);
		$('#idGroup').val(idGroup);
		$('#step').val(step);
		$('#indent').val(indent);
		$('#reply').val("@"+name+rank+' ')
	}
	
	function register(arg){
		if(arg=="A"){
			if($("#contact-message").val()==""){
				alert("내용을 작성해주세요")
				$("#contact-message").focus()
				return false;
			}
			if(${signBut != 1 }){
				alert("가입을 해주시기 바랍니다")
				$("#contact-message").focus()
				return false;
			}
			fo.action="contentView";
			fo.submit();
			
		}else if(arg=="B"){
			if($('#cn').val()==""){
				alert("댓글을 작성 하고싶은 사람의 이름을 클릭해주세요")
				return false
			}
			fo.action="reply";
			fo.submit();
		}
	}
	

	
	
	
</script>
	<!--main content end-->
	<jsp:include page="../default/footer.jsp" />
	<script src="resources/bxSli/js/jquery-3.5.1.min.js"></script>
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
	<script type="text/javascript">
    /* Formating function for row details */
    function fnFormatDetails(oTable, nTr) {
      var aData = oTable.fnGetData(nTr);
      var sOut = '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">';
      sOut += '<tr><td>Rendering engine:</td><td>' + aData[1] + ' ' + aData[4] + '</td></tr>';
      sOut += '<tr><td>Link to source:</td><td>Could provide a link here</td></tr>';
      sOut += '<tr><td>Extra info:</td><td>And any further details here (images etc)</td></tr>';
      sOut += '</table>';

      return sOut;
    }

    $(document).ready(function() {
      /*
       * Insert a 'details' column to the table
       */
      var nCloneTh = document.createElement('th');
      var nCloneTd = document.createElement('td');
      nCloneTd.innerHTML = '<img src="lib/advanced-datatable/images/details_open.png">';
      nCloneTd.className = "center";

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
          [1, 'asc']
        ]
      });

      /* Add event listener for opening and closing details
       * Note that the indicator for showing which row is open is not controlled by DataTables,
       * rather it is done here
       */
      $('#hidden-table-info tbody td img').live('click', function() {
        var nTr = $(this).parents('tr')[0];
        if (oTable.fnIsOpen(nTr)) {
          /* This row is already open - close it */
          this.src = "lib/advanced-datatable/media/images/details_open.png";
          oTable.fnClose(nTr);
        } else {
          /* Open this row */
          this.src = "lib/advanced-datatable/images/details_close.png";
          oTable.fnOpen(nTr, fnFormatDetails(oTable, nTr), 'details');
        }
      });
    });
  </script>
</body>
</html>
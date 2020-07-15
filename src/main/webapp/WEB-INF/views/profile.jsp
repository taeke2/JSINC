<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
<title>JS.Inc</title>
<link href="resources/img/favicon.png" rel="icon">
   <script type="text/javascript">
      function pwChk() {
         pw1 = document.getElementById("newPW").value;
         pw2 = document.getElementById("newChk").value;
         var button = document.getElementById("change");
         if (pw1 == pw2) {
            document.getElementById("lbl_pw2").innerHTML = "일치";
            button.disabled = false;
         } else {
            document.getElementById("lbl_pw2").innerHTML = "불일치";
            document.getElementById("newPW").value = "";
            document.getElementById("newChk").value = "";
            document.getElementById("newPW").focus();
            button.disabled = true;
         }
      }
   </script>
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
         <section class="wrapper site-min-height">
            <div class="row mt">
               <div class="col-lg-12">
                  <div class="row content-panel">
                     <div class="col-md-4 profile-text mt mb centered">
                        <div class="right-divider hidden-sm hidden-xs">
                           <h4>${user.empNo }</h4>
                           <h6>Employee Number</h6>
                           <h4>${workDays }(일)</h4>
                           <h6>Working days this month : ${loginMonth }</h6>
                           <h4>${workTimes }(h)</h4>
                           <h6>Working hours this month : ${loginMonth }</h6>
                        </div>
                     </div>
                     <!-- /col-md-4 -->
                     <div class="col-lg-4 col-md-4 col-sm-4 mb">
                        <div class="content-panel pn">
                           <div id="profile-02">
                              <div class="user">
                                 <img src="${pageContext.request.contextPath }/resources/img/${user.img}" class="img-circle" width="80">
                                 <h4>${user.name }</h4>
                              </div>
                           </div>
                           <div class="pr2-social centered">
                              <a href="#"><i class="fa fa-twitter"></i></a> 
                              <a href="#"><i class="fa fa-facebook"></i></a> 
                              <a href="#"><i class="fa fa-dribbble"></i></a>
                           </div>
                        </div>
                        <!-- /panel -->
                     </div>
                     <div class="col-lg-4 col-md-4 col-sm-4 mb">
                        <h4>
                           <i class="fa fa-angle-right"></i> 비밀번호
                        </h4>
                        <!-- Button trigger modal -->
                        <button class="btn btn-success btn-lg" data-toggle="modal" data-target="#myModal">비밀번호 변경</button>
                        <!-- Modal -->
                        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                           <div class="modal-dialog">
                              <div class="modal-content">
                                 <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title" id="myModalLabel">비밀번호 변경</h4>
                                 </div>
                                 <form action="changePw" method="post" onsubmit="return nowChk();">
                                    <div class="modal-body">
                                       <input type="password" placeholder="현재 비밀번호" id="usingPW" class="form-control" name="nowPW">
                                    </div>
                                    <div class="modal-body">
                                       <input type="password" placeholder="새 비밀번호" id="newPW" class="form-control" name="newPW">
                                    </div>
                                    <div class="modal-body">
                                       <input type="password" placeholder="새 비밀번호 확인" id="newChk" class="form-control" name="newChk" onchange="pwChk()"><br>
                                       <label id="lbl_pw2"></label>
                                    </div>
                                    <div class="modal-footer">
                                       <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
                                       <button type="submit" class="btn btn-primary" disabled="disabled" id="change">변경</button>
                                    </div>
                                 </form>
                                 <script type="text/javascript">
                                       function nowChk(){
                                          if($("#usingPW").val()!=${user.password}){
                                             alert("현재 비밀번호가 일치하지 않습니다.")
                                             $("#usingPW").focus()
                                             return false;
                                          }
                                          
                                          alert("비밀번호가 변경되었습니다.")
                                          
                                       }
                                    </script>
                              </div>
                           </div>
                        </div>
                        <!-- /panel -->
                     </div>
                  </div>
                  <!-- /row -->
               </div>
               
               <!-- /col-lg-12 -->
               <div class="col-lg-12 mt">
                  <div class="row content-panel">
                     <div class="panel-heading">
                        <ul class="nav nav-tabs nav-justified">
                           <li><a data-toggle="tab" href="#edit">Edit Profile</a></li>
                        </ul>
                     </div>
                     <!-- /panel-heading -->
                     <div class="panel-body">
                        <div class="tab-content">
                           <div id="edit" class="tab-pane">
                              <div class="row">
                                 <div class="col-lg-8 col-lg-offset-2 detailed">
                                    <h4 class="mb">Company Information</h4>
                                    <form role="form" class="form-horizontal">
                                       <div class="form-group">
                                          <label class="col-lg-2 control-label">회사</label> 
                                          <label class="col-lg-2 control-label">JS.Inc</label>
                                       </div>
                                       <div class="form-group">
                                          <label class="col-lg-2 control-label">직급</label> 
                                          <label class="col-lg-2 control-label">${user.dep }</label>
                                       </div>
                                       <div class="form-group">
                                          <label class="col-lg-2 control-label">부서</label> 
                                          <label class="col-lg-2 control-label">${user.rank }</label>
                                       </div>
                                       <div class="form-group">
                                          <label class="col-lg-2 control-label">사번</label> 
                                          <label class="col-lg-2 control-label">${user.empNo }</label>
                                       </div>
                                       <div class="form-group">
                                          <label class="col-lg-2 control-label">이메일</label> 
                                          <label class="col-lg-2 control-label">${user.userEmail }</label>
                                       </div>
                                    </form>
                                 </div>
                                 <div class="col-lg-8 col-lg-offset-2 detailed mt">
                                    <h4 class="mb">Personal Information</h4>
                                    <form role="form" class="form-horizontal" action="editProfile">
                                       <!-- 프로필 사진 변경 div 
                                                   <div class="form-group">
                                                      <label class="col-lg-2 control-label"> 프로필 사진</label>
                                                      <div class="col-lg-6">
                                                         <input type="file" id="exampleInputFile" class="file-pos" name="img">
                                                      </div>
                                                   </div>
                                                   -->
                                       <div class="form-group">
                                          <label class="col-lg-2 control-label">이름</label>
                                          <div class="col-lg-6">
                                             <input type="text" placeholder="이름" id="name"
                                                class="form-control" value="${user.name }" name="name">
                                          </div>
                                       </div>
                                       <div class="form-group">
                                          <label class="col-lg-2 control-label">생년월일</label>
                                          <div class="col-lg-6">
                                             <input type="text" placeholder="생년월일" id="birth"
                                                class="form-control" value="${user.birth }" name="birth">
                                          </div>
                                       </div>
                                       <div class="form-group">
                                          <label class="col-lg-2 control-label">전화번호</label>
                                          <div class="col-lg-6">
                                             <input type="text" placeholder="생년월일 예)910525" id="phone"
                                                class="form-control" value="${user.phoneNumber }" name="phoneNumber">
                                          </div>
                                       </div>
                                       <div class="form-group">
                                          <label for="inputEmailReceiveYn" class="col-lg-2 control-label">이메일 수신여부</label>
                                          <div class="col-lg-10">
                                             <label class="radio-inline"> 
                                                <input type="radio" id="emailReceiveYn" name="mailChk" value="Y" checked>
                                                동의합니다.
                                             </label> 
                                             <label class="radio-inline"> 
                                                <input type="radio" id="emailReceiveYn" name="mailChk" value="N">
                                                동의하지 않습니다.
                                             </label>
                                          </div>
                                       </div>
                                       <div class="form-group">
                                          <label for="inputPhoneNumber"
                                             class="col-lg-2 control-label">SMS 수신여부</label>
                                          <div class="col-lg-10">
                                             <label class="radio-inline"> 
                                                <input type="radio" id="smsReceiveYn" name="smsChk" value="Y" checked>동의합니다.
                                             </label> 
                                             <label class="radio-inline"> 
                                                <input type="radio" id="smsReceiveYn" name="smsChk" value="N"> 동의하지 않습니다.
                                             </label>
                                          </div>
                                       </div>
                                       <div class="form-group">
                                          <div class="col-lg-offset-2 col-lg-10">
                                             <button class="btn btn-theme" type="submit">Save</button>
                                             <button class="btn btn-theme04" type="button"
                                                onclick="location.href='profile'">Cancel</button>
                                          </div>
                                       </div>
                                    </form>
                                 </div>
                                 <!-- /col-lg-8 -->
                              </div>
                              <!-- /row -->
                           </div>
                           <!-- /tab-pane -->
                        </div>
                        <!-- /tab-content -->
                     </div>
                     <!-- /panel-body -->
                  </div>
                  <!-- /col-lg-12 -->
               </div>
               <!-- /row -->
            </div>
            <!-- /container -->
         </section>
         <!-- /wrapper -->
      </section>
      <!-- /MAIN CONTENT -->

      <!--main content end-->
      <jsp:include page="default/footer.jsp" />
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
   <!--script for this page-->
   <!-- MAP SCRIPT - ALL CONFIGURATION IS PLACED HERE - VIEW OUR DOCUMENTATION FOR FURTHER INFORMATION -->
   <script type="text/javascript"
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyASm3CwaK9qtcZEWYa-iQwHaGi3gcosAJc&sensor=false"></script>
         
   <script>
   
      $('.contact-map')
            .click(
                  function() {

                     //google map in tab click initialize
                     function initialize() {
                        var myLatlng = new google.maps.LatLng(40.6700,
                              -73.9400);
                        var mapOptions = {
                           zoom : 11,
                           scrollwheel : false,
                           center : myLatlng,
                           mapTypeId : google.maps.MapTypeId.ROADMAP
                        }
                        var map = new google.maps.Map(document
                              .getElementById('map'), mapOptions);
                        var marker = new google.maps.Marker({
                           position : myLatlng,
                           map : map,
                           title : 'Dashio Admin Theme!'
                        });
                     }
                     google.maps.event.addDomListener(window, 'click',
                           initialize);
                  });
   </script>
</body>

</html>

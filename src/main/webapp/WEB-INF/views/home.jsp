<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<!-- by성택,해준_로그인페이지_20200518 -->

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<title>JS.Inc</title>
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
</head>

<body>
	<div id="login-page">
		<div class="container">
			<form class="form-login" name="formLogin">
				<h2 class="form-login-heading">sign in now</h2>
				<div class="login-wrap">
					<input type="text" name="empNo" class="form-control"
						placeholder="사원 번호" autofocus><br> <input
						type="password" name="password" class="form-control"
						placeholder="비밀번호"> <label class="checkbox"> <span
						class="pull-right"> <a data-toggle="modal"
							href="login#myModal"> 비밀번호를 잊으셨습니까?</a>
					</span>
					</label>
					<button class="btn btn-theme btn-block" type="button"
						onclick="form_submit('L')">
						<!-- 'L'(Login)값을 인자로 전달 -->
						<i class="fa fa-lock"></i> 로그인
					</button>
					<hr>
					<div class="login-social-link centered">
						<p>관리자 계정으로 로그인</p>
						<button class="btn btn-facebook" type="button"
							style="width: 100%;" onclick="form_submit('M')">관리자 로그인</button>
							<!-- 'M'(Master Login)값을 인자로 전달 -->
					</div>
					<hr>
					<div class="registration">
						아직 계정이 없으신가요?<br /> <a href="join"> 회원가입 </a>
					</div>
				</div>

				<!-- Modal -->
				<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
					tabindex="-1" id="myModal" class="modal fade">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title">비밀번호 찾기</h4>
							</div>
							<div class="modal-body">
								<p>아래에 이메일 주소를 입력하여 비밀번호를 재설정하십시오.</p>
								<input type="text" name="userEmail" placeholder="E-mail"
									autocomplete="off" class="form-control placeholder-no-fix"
									id="email">
							</div>
							<div class="modal-footer">
								<button data-dismiss="modal" class="btn btn-default"
									type="button">취소</button>
								<button data-dismiss="modal" class="btn btn-theme" type="button"
									name="lostPw" onclick="lost()">전송</button>
							</div>
						</div>
					</div>
				</div>
				<!-- /modal -->

				<!-- Login submit setting -->
				<script type="text/javascript">
					// by성택_인자가 'L'이면 사원 로그인, 'M'이면 관리자 로그인_20200615 추가
					function form_submit(arg) {
						if (arg == "L") {
							document.formLogin.action = "loginChk";
							document.formLogin.submit();
						} else if (arg == "M") {
							document.formLogin.action = "masterLogin";
							document.formLogin.submit();
						}
					}
				</script>

				<!-- Password reset -->
				<script type="text/javascript">
					// by해준_해당하는 이메일로 임시비밀번호를 전송_20200613
					function lost() {
						$.ajax({
							url : "lostPw",
							data : {
								"userEmail" : $('#email').val()
							},
							type : "GET",
							success : function(data) {
								alert("전송 완료")
								console.log("성공")
							},
							error : function() {
								console.log("실패")
							}
						});
					}
				</script>
			</form>
		</div>
	</div>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="resources/lib/jquery/jquery.min.js"></script>
	<script src="resources/lib/bootstrap/js/bootstrap.min.js"></script>
	<!--BACKSTRETCH-->
	<script type="text/javascript"
		src="resources/lib/jquery.backstretch.min.js"></script>
	<script>
		$.backstretch("resources/img/login-bg.jpg", {
			speed : 500
		});
	</script>
</body>
</html>
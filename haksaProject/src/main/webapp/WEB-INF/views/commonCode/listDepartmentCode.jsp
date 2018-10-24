<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>부서코드 관리</title>

<!-- Bootstrap core CSS-->
<link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template-->
<link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

<!-- Page level plugin CSS-->
<link href="/resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/resources/css/sb-admin.css" rel="stylesheet">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
	   <script>
	       $(document).ready(function() {
	           $("#keyword").keyup(function() {
	               var selectBox = $("#selectBox option:selected").val();
	               var word = $('#keyword').val();
	               $("#deptTable > tbody").children().hide();
	               if(selectBox == "code"){
	                   	var temp = $("#deptTable > tbody > tr").find("td:nth-child(1):contains('" + word + "')");
	                   	
	               }else if(selectBox == "name"){
						var temp = $("#deptTable > tbody > tr").find("td:nth-child(5):contains('" + word + "')");    
						
	               }else if(selectBox == "agencyName"){
	               		var temp = $("#deptTable > tbody > tr").find("td:nth-child(2):contains('" + word + "')");
	               		
	               }else if(selectBox == "orgName"){
	               		var temp = $("#deptTable > tbody > tr").find("td:nth-child(3):contains('" + word + "')");
	               		
	               }else if(selectBox == "division"){
	               		var temp = $("#deptTable > tbody > tr").find("td:nth-child(4):contains('" + word + "')");
	               		
	               }else if(selectBox == "establishDate"){
	               		var temp = $("#deptTable > tbody > tr").find("td:nth-child(7):contains('" + word + "')");
	               		
	               }else if(selectBox == "check_a_use"){
	               		var temp = $("#deptTable > tbody > tr").find("td:nth-child(11):contains('" + word + "')");
	               		
	               }else if(selectBox == "check_a_change"){
	               		var temp = $("#deptTable > tbody > tr").find("td:nth-child(12):contains('" + word + "')");
	               		
	               }
	               $(temp).parent().show();
	           });
	           
	           $('#addDepartment').click(function(){
					window.location.href="/common/codes/addDepartmentCodeForm";
				});
	       });
	  	</script>
</head>

<body id="page-top">

	<jsp:include page="/WEB-INF/views/module/nav.jsp"/>

	<div id="wrapper">

		<jsp:include page="/WEB-INF/views/module/sidebar.jsp"/>

		<div id="content-wrapper">

			<div class="container-fluid">
			<!-- 여기에 내용이 담긴다 -->
				<div class="mail-box">
					<aside class="lg-side">
						<div class="inbox-head">
							<div class="input-append">
								<input type="text" class="sr-input" placeholder="">
								<button class="btn sr-btn" type="button">
									<i class="fa fa-search"></i>
								</button>
								&ensp; <select class="btn btn-info">
									<option value="code">코드</option>
									<option value="name">부서 명</option>
									<option value="agencyName">소속 기관</option>
									<option value="orgName">소속 기구</option>
									<option value="division">구분</option>
									<option value="establishDate">설치일자</option>
									<option value="check_a_use">사용 유무</option>
									<option value="check_a_change">변경 유무</option>
								</select>
								&ensp;
								<button class="btn btn-info" type="button" id="addDepartment">입력</button>
							</div>
						</div>
						<div class="inbox-body">
							<div class="mail-option">
								<table class="table table-inbox table-hover">
									<tbody>
										<tr class="unread">
											<td class="view-message  dont-show">부서코드</td>
											<td>기관명</td>
											<td>기구명</td>
											<td>부서학과구분</td>
											<td class="view-message  text-left">부서명(국문)</td>
											<td>부서명(영문)</td>
											<td>설치일자</td>
											<td class="view-message  text-left">대표전화번호</td>
											<td>졸업학년</td>
											<td>코드 사용유무</td>
											<td>코드 변경유무</td>
										</tr>

										<c:forEach var="dept" items="${list}">
											<tr>
												<td>${dept.deptCode}</td>
												<td>${dept.agencyName}</td>
												<td>${dept.orgName}</td>
												<td>${dept.deptForEduOrAdmin}</td>
												<td>${dept.deptNameKorean}</td>
												<td>${dept.deptNameEnglish}</td>
												<td>${dept.deptEstablishDate}</td>
												<td>${dept.deptRepPhoneNumber}</td>
												<td>${dept.deptGraduatedGrade}</td>
												<td>${dept.deptIsUsed}</td>
												<td>${dept.deptIsChanged}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</aside>
				</div>
			</div>
			<!-- /.container-fluid -->

			<!-- Sticky Footer -->
			<footer class="sticky-footer">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright © Haksa 2018</span>
					</div>
				</div>
			</footer>

		</div>
		<!-- /.content-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">Ã</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="/resources/vendor/jquery/jquery.min.js"></script>
	<script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Page level plugin JavaScript-->
	<script src="/resources/vendor/chart.js/Chart.min.js"></script>
	<script src="/resources/vendor/datatables/jquery.dataTables.js"></script>
	<script src="/resources/vendor/datatables/dataTables.bootstrap4.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/resources/js/sb-admin.min.js"></script>

	<!-- Demo scripts for this page-->
	<script src="/resources/js/demo/datatables-demo.js"></script>
	<script src="/resources/js/demo/chart-area-demo.js"></script>

</body>
</html>
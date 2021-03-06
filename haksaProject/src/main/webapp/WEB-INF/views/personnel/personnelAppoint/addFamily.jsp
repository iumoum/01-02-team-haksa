<!-- 이응빈 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
	<head>
	
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport"
			content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
		<title>가족사항 입력</title>
		
		<!-- Bootstrap core CSS-->
		<link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		
		<!-- Custom fonts for this template-->
		<link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
		
		<!-- Page level plugin CSS-->
		<link href="/resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
		
		<!-- Custom styles for this template-->
		<link href="/resources/css/sb-admin.css" rel="stylesheet">
		
		<style>
			#enrolScoreMain{
				text-align : left;
				font-weight: bold;
				font-size: 30px;
			}
			
			#form {
				text-align : right;
			}
		</style>
		
		<script>
			// 뒤로가기 버튼 눌렀을 시 페이지 이동
			function goBack(){
				window.history.back();
			}
		</script>
	</head>
	
	<body id="page-top">
	
		<jsp:include page="/WEB-INF/views/module/nav.jsp"/>
	
		<div id="wrapper">
	
			<jsp:include page="/WEB-INF/views/module/sidebar.jsp"/>
	
			<div id="content-wrapper">
	
				<div class="container-fluid">
				<!-- 여기에 내용이 담긴다 -->
					<form action="${pageContext.request.contextPath}/personnelAppoint/saveFamily" method="post">
						<input type="button" class="btn btn-info" onclick="goBack()" value="뒤로가기"/>
						<input type="submit" class="btn btn-primary" id="form" value="저장"/>
						<br>
						<table class="table table-bordered">
							<tr>
								<td scope="col" colspan="10">
									<p id="enrolScoreMain">* 교직원 가족사항</p>
								</td>
							</tr>
							
							<tr>
								<c:choose>
									<c:when test="${permanentAppointmentSchoolPersonnelNumber ne null}">
										<th>교직원번호</th>
										<td><input type="text" class="form-control" name="permanentAppointmentSchoolPersonnelNumber" id="appointmentSchoolPersonnelNumber" value='${permanentAppointmentSchoolPersonnelNumber}'></td>
									</c:when>
									<c:when test="${temporaryAppointmentSchoolPersonnelNumber ne null}">
										<th>교직원번호</th>
										<td><input type="text" class="form-control" name="temporaryAppointmentSchoolPersonnelNumber" id="appointmentSchoolPersonnelNumber" value='${temporaryAppointmentSchoolPersonnelNumber}'></td>
									</c:when>
									<c:when test="${otherAppointmentSchoolPersonnelNumber ne null}">
										<th>교직원번호</th>
										<td><input type="text" class="form-control" name="otherAppointmentSchoolPersonnelNumber" id="appointmentSchoolPersonnelNumber" value='${otherAppointmentSchoolPersonnelNumber}'></td>
									</c:when>
								</c:choose>
								<th>가족관계</th>
								<td><input type="text" class="form-control" name="familyRelationship" id="familyRelationship" placeholder="가족관계"></td>
								<th>성명</th>
								<td><input type="text" class="form-control" name="familyName" id="familyName" placeholder="성명"></td>
					   		</tr>
					   		
					   		<tr>
								<th>생년월일</th>
								<td><input type="date" class="form-control" name="familyBirthday" id="familyBirthday"></td>
								<th>학력</th>
								<td><input type="text" class="form-control" name="familyAcademicBackground" id="familyAcademicBackground" placeholder="학력"></td>
								<th>직업</th>
								<td><input type="text" class="form-control" name="familyJob" id="familyJob" placeholder="직업"></td>
					   		</tr>
					   		
					   		<tr>
					   			<th>전화번호</th>
								<td><input type="text" class="form-control" name="familyPhoneNumber" id="familyPhoneNumber" placeholder="전화번호"></td>
								<th>주소</th>
								<td><input type="text" class="form-control" name="familyResidence" id="familyResidence" placeholder="주소"></td>
					   		</tr>
			    		</table>
		    		</form>
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
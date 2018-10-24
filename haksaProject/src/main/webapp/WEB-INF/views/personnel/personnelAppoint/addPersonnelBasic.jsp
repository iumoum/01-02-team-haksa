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
	
		<title>인사기본사항 입력</title>
		
		<!-- Bootstrap core CSS-->
		<link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		
		<!-- Custom fonts for this template-->
		<link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
		
		<!-- Page level plugin CSS-->
		<link href="/resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
		
		<!-- Custom styles for this template-->
		<link href="/resources/css/sb-admin.css" rel="stylesheet">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		
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
			
			$.ajax({
				url:'/rest/jobPositionCode'
				, type:'GET'
				, dataType:'JSON'
				, success: function(data){
					$(data).each(function(index, item){
						$('#personnelBasicAnnualIncomeDivision').append("<option value="+item.jobPositionCode+">"+item.jobPositionNameKorean+"</option>");
					})
				}
			})
		</script>
	</head>
	
	<body id="page-top">
	
		<jsp:include page="/WEB-INF/views/module/nav.jsp"/>
	
		<div id="wrapper">
	
			<jsp:include page="/WEB-INF/views/module/sidebar.jsp"/>
	
			<div id="content-wrapper">
	
				<div class="container-fluid">
				<!-- 여기에 내용이 담긴다 -->
					<form id="form">
						<input type="button" class="btn btn-info" onclick="goBack()" value="뒤로가기"/>
						<input type="button" class="btn btn-primary" id="savePersonnelPromotion" value="저장"/>
					</form>
					<br>
					<table class="table table-bordered">
						<tr>
							<td scope="col" colspan="10">
								<p id="enrolScoreMain">* 교직원 인사기본사항</p>
							</td>
						</tr>
						<tr>
							<th>교직원번호</th>
							<td><input type="text" class="form-control" name="appointmentSchoolPersonnelNumber" id="appointmentSchoolPersonnelNumber" placeholder="교직원번호"></td>
							<th>채용분류</th>
							<td>
								<select class="form-control" id="personnelBasicHireDivision">
									<option value="선택">선택</option>
									<option value="정규직">정규직</option>
									<option value="비정규직">비정규직</option>
									<option value="무기계약">무기계약</option>
								</select>
							</td>
							<th>연봉구분</th>
							<td>
								<select class="form-control" id="personnelBasicAnnualIncomeDivision">
									<option value="선택">선택</option>
								</select>
							</td>
						</tr>
						
						<tr>
							<th>현직(전직)기관</th>
							<td><input type="text" class="form-control" name="personnelBasicOrganization" id="personnelBasicOrganization" placeholder="현직(전직)기관"></td>
							<th>생년월일</th>
							<td><input type="date" class="form-control" name="personnelBasicYearsMonthDay" id="personnelBasicYearsMonthDay"></td>
							<th>재임용여부</th>
							<td>
								<select class="form-control" id="personnelBasicReassignCheck">
									<option value="선택">선택</option>
									<option value="Y">YES</option>
									<option value="N">NO</option>
								</select>
							</td>
						</tr>
						<tr>
							<th>겸직여부</th>
							<td>
								<select class="form-control" id="personnelBasicOtherOfficial">
									<option value="선택">선택</option>
									<option value="Y">YES</option>
									<option value="N">NO</option>
								</select>
							</td>
							<th>사무실 전화번호</th>
							<td><input type="text" class="form-control" name="personnelBasicOfficeTelephoneNumber" id="personnelBasicOfficeTelephoneNumber" placeholder="사무실 전화번호"></td>
							<th>정년보장</th>
							<td>
								<select class="form-control" id="personnelBasicRetirementGuarantee">
									<option value="선택">선택</option>
									<option value="Y">YES</option>
									<option value="N">NO</option>
								</select>
							</td>
						</tr>
						
						<tr>
							<th>현직(전직)직위</th>
							<td><input type="text" class="form-control" name="personnelBasicPostposition" id="personnelBasicPostposition" placeholder="현직(전직)직위"></td>
							<th>음양구분</th>
							<td><input type="text" class="form-control" name="personnelBasicLunarSolarDivision" id="personnelBasicLunarSolarDivision" placeholder="음양구분"></td>
							<th>센터입소일</th>
							<td><input type="date" class="form-control" name="personnelBasicCenterEnterDay" id="personnelBasicCenterEnterDay"></td>
						</tr>
					</table>
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
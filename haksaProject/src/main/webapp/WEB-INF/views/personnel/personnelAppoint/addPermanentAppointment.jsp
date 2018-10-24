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
	
		<title>정규직 임용정보 입력 페이지</title>
		
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
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		
		<script>
			$(document).ready(function() {
				// 조회 버튼 눌렀을 시 페이지 이동
				$("#permanentAppointmentList").click(function(){
					window.location.href="/personnelAppoint/listPermanentAppointment";
				})
				
				$.ajax({
					url:'/rest/countryCode'
					, type:'GET'
					, dataType:'JSON'
					, success: function(data){
						$(data).each(function(index, item){
							$('#countryCode').append("<option value="+item.countryCode+">"+item.countryNameKorean+"</option>");
						})
					}
				})
			
				$.ajax({
					url:'/rest/personnelCommonAppointmentCode'
					, type:'GET'
					, dataType:'JSON'
					, success: function(data){
						$(data).each(function(index, item){
							$('#personnelCommonAppointmentCode').append("<option value="+item.personnelCommonAppointmentCode+">"+item.personnelCommonAppointmentCodeName+"</option>");
						})
					}
				})
				
				$.ajax({
					url:'/rest/teamCode'
					, type:'GET'
					, dataType:'JSON'
					, success: function(data){
						$(data).each(function(index, item){
							$('#teamCode').append("<option value="+item.teamCode+">"+item.teamNameKorean+"</option>");
						})
					}
				})
				
				$.ajax({
					url:'/rest/haksaJobRank'
					, type:'GET'
					, dataType:'JSON'
					, success: function(data){
						$(data).each(function(index, item){
							$('#haksaJobRank').append("<option value="+item.haksaJobRank+">"+item.jobRankNameKorean+"</option>");
						})
					}
				})
				
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
				<h1>인사관리 > 임명관리</h1>
				<br>
				<p id="enrolScoreMain">* 정규직 임용 정보 입력</p>
				<form id="form">
					<input type="button" class="btn btn-info" id="permanentAppointmentList" value="조회"/>
					<input type="button" class="btn btn-primary" id="savePermanentAppointment" value="저장"/>
				</form>
				<br>
				<table id="table" class="table table-bordered">
					<tr>
						<th>사진</th>
						<td><input type="file" class="form-control" name="humanPicture" id="humanPicture"></td>
						<th>교직원번호</th>
						<td><input type="text" class="form-control" name="appointmentSchoolPersonnelNumber" id="appointmentSchoolPersonnelNumber" placeholder="교직원번호"></td>
						<th>주민번호</th>
						<td>
							<input type="text" id="humanResidentRegistrationNumber1" name="humanResidentRegistrationNumber1" maxlength="6" style="width:60px">
							<span>-</span>
							<input type="text" id="humanResidentRegistrationNumber2" name="humanResidentRegistrationNumber2" maxlength="7" style="width:66px">
						</td>
					</tr>
					
					<tr>
						<th>성명</th>
						<td><input type="text" class="form-control" name="humanName" id="humanName" placeholder="성명"></td>
						<th>성명(영어)</th>
						<td><input type="text" class="form-control" name="humanNameEnglish" id="humanNameEnglish" placeholder="성명(영어)"></td>
						<th>성별</th>
						<td>
							<select class="form-control" id="humanGender">
								<option value="선택">선택</option>
								<option value="M">남성</option>
								<option value="W">여성</option>
							</select>
						</td>
					</tr>
				
					<tr>
						<th>국가코드</th>
						<td>
							<select class="form-control" id="countryCode">
								<option value="선택">선택</option>
							</select>
						</td>
						<th>발령명</th>
						<td>
							<select class="form-control" id="personnelCommonAppointmentCode">
								<option value="선택">선택</option>
							</select>
						</td>
						<th>발령팀</th>
						<td>
							<select class="form-control" id="teamCode">
								<option value="선택">선택</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<th>발령직급</th>
						<td>
							<select class="form-control" id="haksaJobRank">
								<option value="선택">선택</option>
							</select>
						</td>
						<th>지급연봉</th>
						<td><input type="text" class="form-control" name="appointmentPermanentAnnualIncome" id="appointmentPermanentAnnualIncome" placeholder="지급연봉"></td>
						<th>경력구분</th>
						<td>
							<select class="form-control" id="appointmentPermanentCareerDivision">
								<option value="선택">선택</option>
								<option value="신입">신입</option>
								<option value="경력">경력</option>
							</select>
						</td>	
					</tr>
					
				  	<tr>
				  		<th>호봉</th>
						<td><input type="text" class="form-control" name="appointmentPermanentSalaryclass" id="appointmentPermanentSalaryclass" placeholder="호봉"></td>
						<th>계약시작기간</th>
						<td><input type="date" class="form-control" name="appointmentPermanentContractStartTerm" id="appointmentPermanentContractStartTerm"></td>
						<th>계약만료기간</th>
						<td><input type="date" class="form-control" name="appointmentPermanentContractEndTerm" id="appointmentPermanentContractEndTerm"></td>		
					</tr>
					<tr>
						<th>임용시작기간</th>
						<td><input type="date" class="form-control" name="appointmentPermanentAppointmentStartTerm" id="appointmentPermanentAppointmentStartTerm"></td>
						<th>임용만료기간</th>
						<td><input type="date" class="form-control" name="appointmentPermanentAppointmentEndTerm" id="appointmentPermanentAppointmentEndTerm"></td>
						<th>임명일</th>
						<td><input type="date" class="form-control" name="appointmentAppointDay" id="appointmentAppointDay" placeholder="임명일"></td>
					</tr>
					<tr>
						<th>임명사유</th>
						<td colspan="6"><textarea class="form-control" name="promotionAppointReason" id="promotionAppointReason" ></textarea></td>
					</tr>
					<tr>
						<th>호봉승급월</th>
						<td><input type="text" class="form-control" name="appointmentPermanentSalaryclassPromotion" id="appointmentPermanentSalaryclassPromotion" placeholder="호봉승급월"></td>
						<th>병역여부</th>
						<td>
							<select class="form-control" id="humanMilitaryService">
								<option value="선택">선택</option>
								<option value="미필">미필</option>
								<option value="군필">군필</option>
							</select>
						</td>
					</tr>
				</table>
			</div>
			<!-- /.content-wrapper -->
		</div>
		<!-- /#wrapper -->
		</div>
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
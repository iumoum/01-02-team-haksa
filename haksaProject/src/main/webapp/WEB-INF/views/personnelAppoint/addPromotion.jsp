<!-- 이응빈 -->
<!--  승진처리 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
	<head>
	
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport"
			content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
		<title>승진처리 페이지</title>
		
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
		
		<!-- ajax 에서 jquery 사용하기 위한 페이지 불러옴 -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script>  
			// 입력 버튼 눌렀을 시 입력 페이지 이동	
			function addPersonnelPromotion(){
			    window.location.href="/personnelAppoint/addPromotion";
			}
			
			// 조회 버튼 눌렀을 시 조회 페이지 이동
			function personnelPromotionList(){
			    window.location.href="/personnelAppoint/listPromotionProcess";
			}
			
			// 저장 버튼 눌렀을 시 비동기 방식을 이용한 데이터 값 저장
			$(document).ready(function(){
				$.ajax({
					url:'/rest/haksaJobRank'
					, type:'GET'
					, dataType:'JSON'
					, success: function(data){
						$(data).each(function(index, item){
							$('#rankCode').append("<option value="+item.haksaJobRank+">"+item.jobRankNameKorean+"</option>");
						})
					}
				})
				
				$('#savePersonnelPromotion').click(function(){
					let obj = new Object();
					
					obj.promotionNumber = $('#promotionNumber').val();
					obj.appointmentSchoolPersonnelNumber = $('#appointmentSchoolPersonnelNumber').val();
					obj.rankCode = $('#rankCode').val();
					obj.promotionAppointmentAnnualIncome = $('#promotionAppointmentAnnualIncome').val();
					obj.promotionAppointmentSalaryclass = $('#promotionAppointmentSalaryclass').val();
					obj.promotionDay = $('#promotionDay').val();
					obj.promotionAppointmentDay = $('#promotionAppointmentDay').val();
					obj.promotionAppointReason = $('#promotionAppointReason').val();
					obj.promotionRegistrationDate = $('#promotionRegistrationDate').val();
					obj.promotionModificationDate = $('#promotionModificationDate').val(); 
					
				    
					let jsonData = JSON.stringify(obj);
				    
				    // data:{dto의 변수명 : let으로 선언한 변수명}
				    $.ajax({
				    	url:"/personnelAppoint/savePromotion"
				    	, type:'POST'
				    	, dataType:'JSON'
				    	, data: jsonData
				    	, contentType: 'application/json; charset=UTF-8'
				    	, success: function() {
				    		location.href='${pageContext.request.contextPath}/personnelAppoint/addPromotion';
				    	}, error: function(request,status,error){
				            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				        }
				    })
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
					<h1>인사관리 > 승진처리(총무,교무)</h1>
					<br>
					<!-- 인사기본사항 -->
					<form id="form">
						<input type='button' class="btn btn-info" onclick='personnelPromotionList()' value='조회'/>
						<input type='button' class="btn btn-primary" id='savePersonnelPromotion' value='저장'/>
					</form>
					<br>
					<table class="table table-bordered">
						<tr>
							<td scope="col" colspan="10">
								<p id="enrolScoreMain">* 승진처리</p>
							</td>
						</tr>
						
						<tr>
							<th>교직원번호</th>
							<td><input type="text" class="form-control" name="appointmentSchoolPersonnelNumber" id="appointmentSchoolPersonnelNumber" placeholder="교직원번호"></td>
							<th>직급</th>
							<td>
								<select class="form-control" id="rankCode">
									<option value="선택">선택</option>
								</select>
							</td>
				   			<th>발령연봉</th>
							<td><input type="text" class="form-control" name="promotionAppointmentAnnualIncome" id="promotionAppointmentAnnualIncome" placeholder="발령연봉"></td>
				   		</tr>
						
						<tr>
							<th>발령호봉</th>
							<td><input type="text" class="form-control" name="promotionAppointmentSalaryclass" id="promotionAppointmentSalaryclass" placeholder="발령호봉"></td>
							<th>승진일</th>
							<td><input type="date" class="form-control" name="promotionDay" id="promotionDay" placeholder="승진일"></td>
							<th>임용일</th>
							<td><input type="date" class="form-control" name="promotionAppointmentDay" id="promotionAppointmentDay" placeholder="임용일"></td>
						</tr>
						
						<tr>
							<th>임명사유</th>
							<td colspan="6"><textarea class="form-control" name="promotionAppointReason" id="promotionAppointReason" ></textarea></td>
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
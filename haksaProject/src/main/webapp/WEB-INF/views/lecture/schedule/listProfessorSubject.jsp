<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>교수강의과목 리스트</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!-- Bootstrap core CSS-->
		<link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<!-- Custom fonts for this template-->
		<link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
		<!-- Page level plugin CSS-->
		<link href="/resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
		<!-- Custom styles for this template-->
		<link href="/resources/css/sb-admin.css" rel="stylesheet">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				// 학기 조회
				$.ajax({
					url:'/rest/schedule/semester'
					, type:'GET'
					, dataType:'JSON'
					, success:function(data){
						$(data).each(function(index, item){
							$('#semesterCode').append("<option value="+item.semesterCode+">"+item.semesterCode+"</option>");
						})
					}
				})
				
				// 학과 조회
				$("#semesterCode").change(function(){
					let code = $('#semesterCode option:selected').val();
					console.log(code);
					if(code != '선택') {
						$.ajax({
							url:'/rest/schedule/department'
							, type:'GET'
							, dataType:'JSON'
							, data: {semesterCode:code}
							, success: function(data){
								$('#departmentCode').empty();
								$('#departmentCode').append("<option value='선택'>선택</option>");
								$(data).each(function(index, item){
									$('#departmentCode').append("<option value="+item.deptNameKorean+">"+item.deptNameKorean+"</option>");
								})
							}
						})
					} else {
						$('#departmentCode').empty();
						$('#departmentCode').append("<option value='선택'>선택</option>");
					}
				})
				
				// 교직원번호로 교수 이름 검색
				$('#professorSearch').click(function(){
					let professorNumber = $('#professorNumber').val();
					
					$.ajax({
						url:'/rest/schedule/professorName'
						, type:'GET'
						, data: {professorNumber:professorNumber}
						, success:function(data){
							console.log('success');
							console.log(data)
							$('#professorName').val(data);
						}
					})
				})
				
				// 교수강의과목조회
				$('#subjectSearch').click(function(){
					let semesterCode = $('#semesterCode option:selected').val();
					let departmentCode = $('#departmentCode option:selected').val();
					let professorNumber = $('#professorNumber').val();
					
					if("선택" != semesterCode && "선택" != departmentCode && null != professorNumber){
						$.ajax({
							url:'/rest/schedule/professorSubject'
							, type:'POST'
							, async:false
							, dataType:'JSON'
							, data: {semesterCode:semesterCode, departmentCode:departmentCode, professorNumber:professorNumber}
							, success: function(data){
								console.log("success");
				                $(data).each(function(index, item){
				                	totalNumber = (item.subjectHoursTheory+item.subjectHoursPractice);
				                	$('#subjectTable > tbody').append('<tr>');
				                	$('#subjectTable > tbody').append('<td>'+item.subjectName+'</td>');
				                	$('#subjectTable > tbody').append('<td>'+item.deptName+'</td>');
				                	$('#subjectTable > tbody').append('<td>'+item.classByDepartmentGrade+'</td>');
				                	$('#subjectTable > tbody').append('<td>'+item.classByDepartmentDayAndNight+'</td>');
				                	$('#subjectTable > tbody').append('<td>'+item.classByDepartmentClass+'</td>');
				                	$('#subjectTable > tbody').append('<td>'+item.typeOfCompletionName+'</td>');
				                	$('#subjectTable > tbody').append('<td>'+item.subjectScoreGraduation+'</td>');
				                	$('#subjectTable > tbody').append('<td>'+totalNumber+'</td>');
				                	$('#subjectTable > tbody').append('</tr>');
				                })
							}
						})
					}
					$(this).attr('disabled',true);
				})
			});
		</script>
	</head>
	<body id="page-top">
		<jsp:include page="/WEB-INF/views/module/nav.jsp"/>
		
		<div id="wrapper">
			<jsp:include page="/WEB-INF/views/module/sidebar.jsp"/>
			
			<div id="content-wrapper">
				<div class="container-fluid">
					<div class="mail-box">
						<aside class="lg-side">
							<div class="inbox-head">
								<div class="input-append">
									<input type="text" class="sr-input" placeholder="교직원번호">
									<button class="btn sr-btn" type="button">
										<i class="fa fa-search"></i>
									</button>
									&ensp;
									<input type="text" id="professorName" readonly>
									&nbsp;
									<span>년도-학기 :</span>&nbsp; 
									<select name="yearBox" id="semesterCode" class="btn btn-info">
										<option value="선택">선택</option>
									</select> 
									&ensp;
									<span>학과 :</span>&nbsp; 
									<select name="departmentBox" id="departmentCode" class="btn btn-info">
										<option value="선택">선택</option>
									</select>&emsp;
									<button type="button" id="subjectSearch" class="btn btn-info">조회</button>
								</div>
							</div>
							<div class="inbox-body">
								<div class="mail-option">
									<table class="table table-inbox table-hover" id="subjectTable">
										<thead>
											<tr class="unread">
												<td class="view-message  dont-show">과목</td>
												<td>학과</td>
												<td>학년</td>
												<td>주야</td>
												<td>반</td>
												<td>이수구분</td>
												<td>학점</td>
												<td class="view-message  text-left">총시수</td>
											</tr>
										</thead>
										<tbody>
										</tbody>
									</table>
								</div>
							</div>
						</aside>
					</div>
				<footer class="sticky-footer">
					<div class="container my-auto">
						<div class="copyright text-center my-auto">
							<span>Copyright © Haksa 2018</span>
						</div>
					</div>
				</footer>
			</div>
		</div>
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
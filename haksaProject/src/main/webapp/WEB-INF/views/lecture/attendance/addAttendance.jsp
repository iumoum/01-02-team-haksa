<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>출석부 생성</title>
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
				
				// 학년 조회
				$('#departmentCode').change(function(){
					let code = $('#departmentCode option:selected').val();
					if(code != '선택'){
						$.ajax({
							url:'/rest/schedule/grade'
							, type:'GET'
							, dataType:'JSON'
							, data:{departmentCode:code}
							, success: function(data){
								$('#gradeCode').empty();
								$('#gradeCode').append("<option value='선택'>선택</option>");
								$(data).each(function(index, item){
									$('#gradeCode').append("<option value="+item.classByDepartmentGrade+">"+item.classByDepartmentGrade+"</option>");
								})
							}
						})
					} else {
						$('#gradeCode').empty();
						$('#gradeCode').append("<option value='선택'>선택</option>");
					}
				})
				
				// 반 조회
				$('#gradeCode').change(function(){
					let code = $('#gradeCode option:selected').val();
					if(code != '선택'){
						$.ajax({
							url:'/rest/schedule/class'
							, type:'GET'
							, dataType:'JSON'
							, data:{gradeCode:code}
							, success: function(data){
								$('#classCode').empty();
								$('#classCode').append("<option value='선택'>선택</option>");
								$(data).each(function(index, item){
									$('#classCode').append("<option value="+item.classByDepartmentClass+">"+item.classByDepartmentClass+"</option>");
								})
							}
						})
					} else {
						$('#classCode').empty();
						$('#classCode').append("<option value='선택'>선택</option>");
					}
				})
				
				// 과목 조회
				$('#classCode').change(function(){
					let departmentCode = $('#departmentCode option:selected').val();
					let gradeCode = $('#gradeCode option:selected').val();
					let classCode = $('#classCode option:selected').val();
					if('선택' != departmentCode && '선택' != gradeCode && '선택' != classCode){
						$.ajax({
							url:'/rest/attendance/subject'
							, type:'POST'
							, dataType:'JSON'
							, data:{departmentCode:departmentCode, gradeCode:gradeCode, classesCode:classCode}
							, success: function(data){
								$('#subjectCode').empty();
								$('#subjectCode').append("<option value='선택'>선택</option>");
								$(data).each(function(index, item){
									$('#subjectCode').append("<option value="+item.subjectNameKorean+">"+item.subjectNameKorean+"</option>");
								})
							}
						})
					} else {
						$('#subjectCode').empty();
						$('#subjectCode').append("<option value='선택'>선택</option>");
					}
				})
				
				// 강의일자 조회
				$('#subjectCode').change(function(){
					let subjectCode = $('#subjectCode option:selected').val();
					if('선택' != subjectCode){
						$.ajax({
							url:'/rest/attendance/lectureDate'
							, type:'GET'
							, dataType:'JSON'
							, data:{subjectCode:subjectCode}
							, success: function(data){
								$('#lectureDateCode').empty();
								$('#lectureDateCode').append("<option value='선택'>선택</option>");
								$(data).each(function(index, item){
									$('#lectureDateCode').append("<option value="+item.prelectDate+">"+item.prelectDate+"</option>");
								})
							}
						})
					} else {
						$('#lectureDateCode').empty();
						$('#lectureDateCode').append("<option value='선택'>선택</option>");
					}
				})
				
				// 출석부 폼 생성
				$("#attendance").click(function(){
					let semesterCode = $('#semesterCode option:selected').val();
					let departmentCode = $('#departmentCode option:selected').val();
					let gradeCode = $('#gradeCode option:selected').val();
					let classCode = $('#classCode option:selected').val();
					let subjectCode = $('#subjectCode option:selected').val();
					
					if("선택" != semesterCode && "선택" != departmentCode && "선택" != gradeCode && "선택" != classCode && "선택" != subjectCode){
						$.ajax({
							url:'/rest/attendance/course'
							, type:'POST'
							, dataType:'JSON'
							, data: {semesterCode:semesterCode, departmentCode:departmentCode, gradeCode:gradeCode, classesCode:classCode, subjectCode:subjectCode}
							, success: function(data){
								console.log("success");
				                $(data).each(function(index, item){
				                	courseLists = data.courseList; // 학과, 학년, 학번
				                	courseNames = data.courseName; // 이름
				                	$.each(courseNames, function(index, item){
				                		courseLists[index].humanName = item;
				                	})
				                	$.each(courseLists, function(index, item){
					                	$('#attendanceTable > tbody').append('<tr>');
				                		$('#attendanceTable > tbody').append('<td>'+item.enrolCourseDeptName+'</td>');
					                	$('#attendanceTable > tbody').append('<td>'+item.enrolCourseSchoolYear+'</td>');
					                	$('#attendanceTable > tbody').append('<td>'+item.enrolCourseStudentNumber+'</td>');
					                	$('#attendanceTable > tbody').append('<td>'+item.humanName+'</td>');
					                	$('#attendanceTable > tbody').append('<td><input type="radio" name="'+item.enrolCourseStudentNumber+'attendance" value="attendance" />출석 <input type="radio" name="'+item.enrolCourseStudentNumber+'attendance" value="absent" />결석 <input type="radio" name="'+item.enrolCourseStudentNumber+'attendance" value="tardy" />지각 <input type="radio" name="'+item.enrolCourseStudentNumber+'attendance" value="other" />기타 </td>');
					                	$('#attendanceTable > tbody').append('</tr>');
				                	})
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
										&ensp; 
										년도-학기 : 
										<select name="yearBox" id="semesterCode" class="btn btn-info">
											<option value="선택">선택</option>
										</select> 
										&ensp;
										학과 : 
										<select name="departmentBox" id="departmentCode" class="btn btn-info">
											<option value="선택">선택</option>
										</select>
										&ensp;
										학년 : 
										<select name="gradeBox" id="gradeCode" class="btn btn-info">
											<option value="선택">선택</option>
										</select>
										&ensp;
										반 : 
										<select name="classBox" id="classCode" class="btn btn-info">
											<option value="선택">선택</option>
										</select> 
										&ensp;
										과목 : 
										<select name="subjectBox" id="subjectCode" class="btn btn-info">
											<option value="선택">선택</option>
										</select>
										&ensp;
										강의일자 : 
										<select name="lectureDateBox" id="lectureDateCode" class="btn btn-info">
											<option value="선택">선택</option>
										</select>
										&emsp;
										<button type="button" id="attendance" class="btn btn-info">조회</button>
										&emsp;
										<button type="button" class="btn btn-info">저장</button>
									</div>
								</div>
								<div class="inbox-body">
									<div class="mail-option">
										<form action="#" method="post">
											<table class="table table-inbox table-hover" id="attendanceTable">
												<thead>
													<tr class="unread">
														<td class="view-message  dont-show">학과</td>
														<td>학년</td>
														<td>학번</td>	
														<td>이름</td>	
														<td class="view-message  text-left">상태</td>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</form>
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
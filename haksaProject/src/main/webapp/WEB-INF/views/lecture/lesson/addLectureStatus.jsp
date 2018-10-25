<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>강의 상황서 입력</title>
		<!-- Bootstrap core CSS-->
		<link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		
		<!-- Custom fonts for this template-->
		<link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
		
		<!-- Page level plugin CSS-->
		<link href="/resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
		
		<!-- Custom styles for this template-->
		<link href="/resources/css/sb-admin.css" rel="stylesheet">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		
		<script>
			$(document).ready(function(){
				// 과목코드
				$.ajax({
					url:'/rest/subjectCode'
					, type:'GET'
					, dataType:'JSON'
					, success: function(data){
						$(data).each(function(index, item){
							$('#subjectCode').append("<option value="+item.subjectCode+">"+item.subjectName+"</option>");
						})
					}
				})
				
				// 강의실 코드
				$.ajax({
					url:'/rest/roomCode'
					, type:'GET'
					, dataType:'JSON'
					, success: function(data){
						$(data).each(function(index, item){
							$('#roomCode').append("<option value="+item.roomCode+">"+item.roomNumber+"호</option>");
						})
					}
				})
				
				// 이수구분 코드
				$.ajax({
					url:'/rest/typeOfCompletionCode'
					, type:'GET'
					, dataType:'JSON'
					, success: function(data){
						$(data).each(function(index, item){
							$('#typeOfCompletionCode').append("<option value="+item.typeOfCompletionCode+">"+item.typeOfCompletionName+"</option>");
						})
					}
				})
				
				$.ajax({
					url:'/rest/deptCode'
					, type:'GET'
					, dataType:'JSON'
					, success: function(data){
						$(data).each(function(index, item){
							$('#deptCode').append("<option value="+item.deptCode+">"+item.deptNameKorean+"</option>");
						})
					}
				})
				
				$('#deptCode').change(function(){
					let code = $("#deptCode option:selected").val();
					if(code !== '선택') {
						$.ajax({
							url:'/rest/grade'
							, type:'GET'
							, dataType:'JSON'
							, data: {deptCode: code}
							, success: function(data){
								$('#classByDepartmentGrade').empty();
								$('#classByDepartmentGrade').append("<option value='0'>선택</option>");
								$('#classByDepartmentClass').empty();
								$('#classByDepartmentClass').append("<option value='선택'>선택</option>");
								$(data).each(function(index, item){
									$('#classByDepartmentGrade').append("<option value="+(index+1)+">"+(index+1)+"학년</option>");
								})
							}
						})
						
						$('#classByDepartmentGrade').change(function(){
							let code = $("#deptCode option:selected").val();
							let gradeCode = $("#classByDepartmentGrade option:selected").val();
							if(gradeCode !== 0) {
								$.ajax({
									url:'/rest/departmentClass'
									, type:'GET'
									, dataType:'JSON'
									, data: {deptCode: code, deptGraduatedGrade: gradeCode}
									, success: function(data){
										$('#classByDepartmentClass').empty();
										$('#classByDepartmentClass').append("<option value='선택'>선택</option>");
										$(data).each(function(index, item){
											$('#classByDepartmentClass').append("<option value="+item+">"+item+"반</option>");
										})
									}
								})
							} else {
								$('#classByDepartmentClass').empty();
								$('#classByDepartmentClass').append("<option value='선택'>선택</option>");
							}
						})
					} else {
						$('#classByDepartmentGrade').empty();
						$('#classByDepartmentGrade').append("<option value='0'>선택</option>");
						$('#classByDepartmentClass').empty();
						$('#classByDepartmentClass').append("<option value='선택'>선택</option>");
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
					<form id="form">
						<a href="/lesson/lecture/lectureStatus"><input type='button' class="btn btn-info" value='조회'></a>
						<input type='button' class="btn btn-success" id="addButton" value='저장'/>
					</form>
					<br>
					<table class="table table-bordered">
						<tr>
							<td scope="col" colspan="10">
								<p id="enrolScoreMain">* 강의 상황서 입력</p>
							</td>
						</tr>
						<tr>
							<th>강의 상황서 번호</th>
							<td><input type="text" class="form-control" name="lectureStatusNumber" id="lectureStatusNumber" placeholder="강의 상황서 번호"></td>
							<th>과목</th>
							<td>
								<select class="form-control" name="subjectCode" id="subjectCode">
									<option value="선택">선택</option>
								</select>
							</td>
							<th>학과</th>
							<td>
								<select class="form-control" name="deptCode" id="deptCode">
									<option value="선택">선택</option>
								</select>
							</td>
				   		</tr>
				   		
				   		<tr>
							<th>학년</th>
							<td>
								<select class="form-control" name="classByDepartmentGrade" id="classByDepartmentGrade">
									<option value="선택">선택</option>
								</select>
							</td>
							<th>반</th>
							<td>
								<select class="form-control" name="classByDepartmentClass" id="classByDepartmentClass">
									<option value="선택">선택</option>
								</select>
							</td>
							<th>주야</th>
							<td>
								<select class="form-control" name="classByDepartmentDayAndNight" id="classByDepartmentDayAndNight">
									<option value="선택">선택</option>
									<option value="주">주</option>
									<option value="야">야</option>
								</select>
							</td>
				   		</tr>
				   		
				   		<tr>
							<th>강의실</th>
							<td>
								<select class="form-control" name="roomCode" id="roomCode">
									<option value="선택">선택</option>
								</select>
							</td>
							<th>이수구분</th>
							<td>
								<select class="form-control" name="typeOfCompletionCode" id="typeOfCompletionCode">
									<option value="선택">선택</option>
								</select>
							</td>
							<th>수강 인원</th>
							<td><input type="text" class="form-control" name="lectureStatusLimitNumber" id="lectureStatusLimitNumber" placeholder="수강 인원"></td>
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
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>학생정보 리스트</title>
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
							$('#grade').empty();
							$('#grade').append("<option value='0'>선택</option>");
							$('#departmentClass').empty();
							$('#departmentClass').append("<option value='선택'>선택</option>");
							$(data).each(function(index, item){
								$('#grade').append("<option value="+(index+1)+">"+(index+1)+"학년</option>");
							})
						}
					})
					
					$('#grade').change(function(){
						let code = $("#deptCode option:selected").val();
						let gradeCode = $("#grade option:selected").val();
						if(gradeCode !== 0) {
							$.ajax({
								url:'/rest/departmentClass'
								, type:'GET'
								, dataType:'JSON'
								, data: {deptCode: code, deptGraduatedGrade: gradeCode}
								, success: function(data){
									$('#departmentClass').empty();
									$('#departmentClass').append("<option value='선택'>선택</option>");
									$(data).each(function(index, item){
										$('#departmentClass').append("<option value="+item+">"+item+"반</option>");
									})
								}
							})
						} else {
							$('#departmentClass').empty();
							$('#departmentClass').append("<option value='선택'>선택</option>");
						}
					})
				} else {
					$('#grade').empty();
					$('#grade').append("<option value='0'>선택</option>");
					$('#departmentClass').empty();
					$('#departmentClass').append("<option value='선택'>선택</option>");
				}
			})
			
			$('#searchButton').click(function(){
				let code = $("#deptCode option:selected").val();
				let gradeCode = $("#grade option:selected").val();
				let departmentClassCode = $("#departmentClass option:selected").val();
				let dayAndNightCode = $("#dayAndNight option:selected").val();
				let stateCode = $("#state option:selected").val();
				let studentNumberCode = $("#studentNumber").val();
				
				$.ajax({
					url:'/rest/studentList'
					, type:'GET'
					, dataType:'JSON'
					, data: {deptCode: code, classByDepartmentGrade: gradeCode, classByDepartmentClass: departmentClassCode, classByDepartmentDayAndNight: dayAndNightCode, studentState: stateCode, studentNumber: studentNumberCode}
					, success: function(data){
						$('#list').empty();
						$(data).each(function(index, item){
							$('#list').append("<tr>");
							$('#list').append("<td><a href='/detailStudentInfo?studentNumber="+item.studentNumber+"'>"+item.studentNumber+"</a></td>");
							$('#list').append("<td>"+item.humanName+"</td>");
							$('#list').append("<td>"+item.deptNameKorean+"</td>");
							$('#list').append("<td>"+item.classByDepartmentGrade+"</td>");
							$('#list').append("<td>"+item.classByDepartmentClass+"</td>");
							$('#list').append("<td>"+item.classByDepartmentDayAndNight+"</td>");
							$('#list').append("<td>"+item.studentState+"</td>");
							$('#list').append("</tr>");
						})
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
				<!-- 여기에 내용이 담긴다 -->
					<h1>학적 관리 > 학생정보 > 학생 리스트</h1>
					
					<form id="form">
						<a href="/insertStudentInfo"><input type='button' class="btn btn-info" value='학생정보 입력'></a>
					</form>
					<br>
			
					학과
					<select name="deptCode" id="deptCode">
					<option value="선택">선택</option>
					</select>
					
					학년
					<select name="grade" id="grade">
					<option value="0">선택</option>
					</select>
			
					반
					<select name="departmentClass" id="departmentClass">
					<option value="선택">선택</option>
					</select>
					
					주야
					<select name="dayAndNight" id="dayAndNight">
					<option value="선택">선택</option>
					<option value="주">주간</option>
					<option value="야">야간</option>
					</select>
					
					구분
					<select name="state" id="state">
					<option value="선택">선택</option>
					<option value="재학">재학생</option>
					<option value="휴학">휴학생</option>
					<option value="졸업">졸업생</option>
					</select>
					
					학번 <input id="studentNumber" name="studentNumber" type="text"/>
					
					<input type='button' class="btn btn-success" id="searchButton" value='조회'/>
				
				    <table border="1">
				        <thead>
				            <tr>
				                <th>학번</th>
				                <th>성명</th>
				                <th>학과</th>
				                <th>학년</th>
				                <th>반</th>
				                <th>주야</th>
				                <th>학생상태</th>
				            </tr>
				        </thead>
				        <tbody id="list">
				        </tbody>
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
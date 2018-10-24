<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>학생정보 입력</title>
		<!-- Bootstrap core CSS-->
		<link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		
		<!-- Custom fonts for this template-->
		<link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
		
		<!-- Page level plugin CSS-->
		<link href="/resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
		
		<!-- Custom styles for this template-->
		<link href="/resources/css/sb-admin.css" rel="stylesheet">
		
		<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
		<script src="//code.jquery.com/jquery.min.js"></script>
		<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
		<script>
			$(document).ready(function() {
				$("#dialog1").hide();
				$("#dialog2").hide();
				$("#dialog3").hide();
				
				// 학번 숫자만
				$("#studentNumber").on("keyup", function() {
				    $(this).val($(this).val().replace(/[^0-9]/g,""));
				});
				
				// 주민번호 앞자리 숫자만
				$("#humanResidentRegistrationNumber1").on("keyup", function() {
				    $(this).val($(this).val().replace(/[^0-9]/g,""));
				});
				
				// 주민번호 뒷자리 숫자만
				$("#humanResidentRegistrationNumber2").on("keyup", function() {
				    $(this).val($(this).val().replace(/[^0-9]/g,""));
				});
				
				// 영문 성명 영어만
				$("#humanNameEnglish").on("keyup", function() {
					$(this).val($(this).val().replace(/[^a-zA-Z]/gi,""));
				});
				
				// 한글 성명 한글만
				$("#humanName").on("keyup", function() {
					$(this).val($(this).val().replace(/[a-z0-9]|[ \[\]{}()<>?|`~!@#$%^&*-_+=,.;:\'"\\]/g,""));
				});
				
				$("#studentEntranceDate").datepicker({
					dateFormat: 'yy-mm-dd'
				});
				
				$("#studentGraduationScheduleDate").datepicker({
					dateFormat: 'yy-mm-dd'
				});
				
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
				
				$("#studentInfoButton").click(function() {
					let date_pattern = /^(19|20)\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1])$/;
					
					if($('#humanPicture').val().length < 1 || $('#studentNumber').val().length < 1 || $('#humanName').val().length < 1 || $('#humanResidentRegistrationNumber1').val().length < 6 || $('#humanResidentRegistrationNumber2').val().length < 7 || $('#countryCode').val() === "선택" || $('#humanNameEnglish').val().length < 1 || $('#humanGender').val() === "선택" || $('#humanMilitaryService').val() === "선택" || $('#deptCode').val() === "선택" || $('#grade').val() === "선택" || $('#departmentClass').val() === "선택" || $('#classByDepartmentDayAndNight').val() === "선택" || $('#studentEntranceDate').val().length < 1 || $('#studentGraduationScheduleDate').val().length < 1) {
						$("#dialog2").dialog();
					} else if(!date_pattern.test($("#studentEntranceDate").val()) || !date_pattern.test($("#studentGraduationScheduleDate").val())) {
						$("#dialog3").dialog();
					} else {
						let recordId = "<%= session.getAttribute("userId") %>"
						let humanPicture = $("#humanPicture").val();
						let studentNumber = $("#studentNumber").val();
						let humanName = $("#humanName").val();
						let humanResidentRegistrationNumber = $("#humanResidentRegistrationNumber1").val() + "-" + $("#humanResidentRegistrationNumber2").val();
						let countryCode = $("#countryCode").val();
						let humanNameEnglish = $("#humanNameEnglish").val();
						let humanGender = $("#humanGender").val();
						let humanMilitaryService = $("#humanMilitaryService").val();
						let deptCode = $("#deptCode").val();
						let grade = $("#grade").val();
						let departmentClass = $("#departmentClass").val();
						let classByDepartmentDayAndNight = $("#classByDepartmentDayAndNight").val();
						let studentEntranceDate = $("#studentEntranceDate").val();
						let studentGraduationScheduleDate = $("#studentGraduationScheduleDate").val();
						let request = {
							recordId: recordId, humanPicture: humanPicture, studentNumber: studentNumber, humanName: humanName, humanResidentRegistrationNumber: humanResidentRegistrationNumber, countryCode: countryCode, humanNameEnglish: humanNameEnglish, humanGender: humanGender, humanMilitaryService: humanMilitaryService, deptCode: deptCode, classByDepartmentGrade: grade, classByDepartmentClass: departmentClass, classByDepartmentDayAndNight: classByDepartmentDayAndNight, studentEntranceDate: studentEntranceDate, studentGraduationScheduleDate: studentGraduationScheduleDate
						}
						$.ajax({
							url:'/rest/addStudentInfo'
							, type:'POST'
							, contentType: 'application/json;charset=UTF-8'
							, dataType:'JSON'
							, data: JSON.stringify(request)
							, success: function(data){
								if(data === "학번중복") {
									$("#dialog1").dialog();
								} else {
									window.location.href="/listStudentInfo";
								}
							}
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
					<form id="form">
						<a href="/listStudentInfo"><input type='button' class="btn btn-info" value='조회'></a>
						<input type='button' class="btn btn-success" id="studentInfoButton" value='저장'/>
					</form>
					<br>
					<table class="table table-bordered">
						<tr>
							<td scope="col" colspan="10">
								<p id="enrolScoreMain">* 학생정보 입력</p>
							</td>
						</tr>
						<tr>
							<th>사진</th>
							<td><input type="file" class="form-control" name="humanPicture" id="humanPicture"></td>
							<th>학번</th>
							<td><input type="text" class="form-control" name="studentNumber" id="studentNumber" placeholder="학번"></td>
							<th>성명</th>
							<td><input type="text" class="form-control" name="humanName" id="humanName" placeholder="성명"></td>
				   		</tr>
				   		
				   		<tr>
							<th>주민번호</th>
							<td>
								<input type="text" id="humanResidentRegistrationNumber1" name="humanResidentRegistrationNumber1" maxlength="6" style="width:60px">
								<span>-</span>
								<input type="text" id="humanResidentRegistrationNumber2" name="humanResidentRegistrationNumber2" maxlength="7" style="width:66px">
							</td>
							<th>국가</th>
							<td>
								<select class="form-control" name="countryCode" id="countryCode">
									<option value="선택">선택</option>
								</select>
							</td>
							<th>성명(영어)</th>
							<td><input type="text" class="form-control" name="humanNameEnglish" id="humanNameEnglish" placeholder="성명(영어)"></td>
				   		</tr>
				   		
				   		<tr>
							<th>성별</th>
							<td>
								<select class="form-control" name="humanGender" id="humanGender">
									<option value="선택">선택</option>
									<option value="M">남</option>
									<option value="W">여</option>
								</select>
							</td>
							<th>병역여부</th>
							<td>
								<select class="form-control" name="humanMilitaryService" id="humanMilitaryService">
									<option value="선택">선택</option>
									<option value="미필">미필</option>
									<option value="군필">군필</option>
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
								<select class="form-control" name="grade" id="grade">
									<option value="0">선택</option>
								</select>
							</td>
							<th>반</th>
							<td>
								<select class="form-control" name="departmentClass" id="departmentClass">
									<option value="선택">선택</option>
								</select>
							</td>
							<th>주야</th>
							<td>
								<select class="form-control" name="classByDepartmentDayAndNight" id="classByDepartmentDayAndNight">
									<option value="선택">선택</option>
									<option value="주">주간</option>
									<option value="야">야간</option>
								</select>
							</td>
				   		</tr>
				   		
				   		<tr>
							<th>입학일자</th>
							<td><input type="text" class="form-control" name="studentEntranceDate" id="studentEntranceDate" placeholder="입학일자"></td>
							<th>졸업예정일자</th>
							<td colspan="3"><input type="text" class="form-control" name="studentGraduationScheduleDate" id="studentGraduationScheduleDate" placeholder="졸업예정일자"></td>
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
		<div id="dialog1" title="학번 중복">
			<p>중복된 학번입니다.</p>
		</div>
		<div id="dialog2" title="다시 입력하여 주세요.">
			<p>양식이 맞지 않습니다.</p>
		</div>
		<div id="dialog3" title="다시 입력하여 주세요.">
			<p>날짜 형식이 맞지 않습니다.</p>
		</div>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>반 변경 입력</title>
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
				
				// 학번 숫자만 입력되게
				$("#studentNumber").on("keyup", function() {
				    $(this).val($(this).val().replace(/[^0-9]/g,""));
				});
				
				// 변경사유 한글만 입력되게
				$("#classChangeReason").on("keyup", function() {
					$(this).val($(this).val().replace(/[a-z0-9]|[ \[\]{}()<>?|`~!@#$%^&*-_+=,.;:\'"\\]/g,""));
				});
				
				$("#classChangeDate").datepicker({
					dateFormat: 'yy-mm-dd'
				});
				
				$("#addClassChange").click(function() {
					let date_pattern = /^(19|20)\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1])$/;
					
					if($('#studentNumber').val().length < 1 || $('#classChangeBefore').val() === "선택" || $('#classChangeAfter').val() === "선택" || $('#classChangeBeforeDayAndNight').val() === "선택" || $('#classChangeAfterDayAndNight').val() === "선택" || $('#classChangeDate').val().length < 1 || $('#classChangeReason').val().length < 1) {
						$("#dialog2").dialog();
					} else if(!date_pattern.test($("#classChangeDate").val())) {
						$("#dialog3").dialog();
					} else {
						let recordId = "<%= session.getAttribute("userId") %>"
						let studentNumber = $("#studentNumber").val();
						let classChangeBefore = $("#classChangeBefore").val();
						let classChangeAfter = $("#classChangeAfter").val();
						let classChangeBeforeDayAndNight = $("#classChangeBeforeDayAndNight").val();
						let classChangeAfterDayAndNight = $("#classChangeAfterDayAndNight").val();
						let classChangeDate = $("#classChangeDate").val();
						let classChangeReason = $("#classChangeReason").val();
						let request = {
								recordId: recordId, studentNumber: studentNumber, classChangeBefore: classChangeBefore, classChangeAfter: classChangeAfter, classChangeBeforeDayAndNight: classChangeBeforeDayAndNight, classChangeAfterDayAndNight: classChangeAfterDayAndNight, classChangeDate: classChangeDate, classChangeReason: classChangeReason
						}
						$.ajax({
							url:'/rest/addClassChange'
							, type:'POST'
							, contentType: 'application/json;charset=UTF-8'
							, dataType:'JSON'
							, data: JSON.stringify(request)
							, success: function(data){
								if(data === "학번없음") {
									$("#dialog1").dialog();
								} else {
									window.location.href="/listClassChange";
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
				<!-- 여기에 내용이 담긴다 -->
					<form id="form">
						<a href="/listClassChange"><input type='button' class="btn btn-info" value='조회'></a>
						<input type='button' class="btn btn-success" id="addClassChange" value='저장'/>
					</form>
					<br>
					<table class="table table-bordered">
						<tr>
							<td scope="col" colspan="10">
								<p id="enrolScoreMain">* 반 변경 입력</p>
							</td>
						</tr>
						<tr>
							<th>학번</th>
							<td><input type="text" class="form-control" name="studentNumber" id="studentNumber" placeholder="학번"></td>
							<th>변경 전 반</th>
							<td>
								<select class="form-control" name="classChangeBefore" id="classChangeBefore">
									<option value="선택">선택</option>
									<option value="A">A</option>
									<option value="B">B</option>
								</select>
							</td>
							<th>변경 후 반</th>
							<td>
								<select class="form-control" name="classChangeAfter" id="classChangeAfter">
									<option value="선택">선택</option>
									<option value="A">A</option>
									<option value="B">B</option>
								</select>
							</td>
				   		</tr>
				   		
				   		<tr>
							<th>변경 전 주야</th>
							<td>
								<select class="form-control" name="classChangeBeforeDayAndNight" id="classChangeBeforeDayAndNight">
									<option value="선택">선택</option>
									<option value="주">주간</option>
									<option value="야">야간</option>
								</select>
							</td>
							<th>변경 후 주야</th>
							<td>
								<select class="form-control" name="classChangeAfterDayAndNight" id="classChangeAfterDayAndNight">
									<option value="선택">선택</option>
									<option value="주">주간</option>
									<option value="야">야간</option>
								</select>
							</td>
							<th>변경일자</th>
							<td><input type="text" class="form-control" name="classChangeDate" id="classChangeDate"></td>
				   		</tr>
				   		
				   		<tr>
							<th>변경사유</th>
							<td colspan="6"><textarea class="form-control" rows="4" cols="50" id="classChangeReason" name="classChangeReason"></textarea></td>
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
		<div id="dialog1" title="학번이 존재하지 않습니다.">
			<p>학번을 다시 확인하여 주세요.</p>
		</div>
		<div id="dialog2" title="다시 입력하여 주세요.">
			<p>양식이 맞지 않습니다.</p>
		</div>
		<div id="dialog3" title="다시 입력하여 주세요.">
			<p>날짜 형식이 맞지 않습니다.</p>
		</div>
	</body>
</html>
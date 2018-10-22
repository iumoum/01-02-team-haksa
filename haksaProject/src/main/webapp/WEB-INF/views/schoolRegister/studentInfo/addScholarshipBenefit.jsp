<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>장학금 수혜내역 입력</title>
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
				$("#scholarshipGiveDate").datepicker({
					dateFormat: 'yy-mm-dd'
				});
				
				$("#addScholarshipBenefit").click(function() {
					if($('#studentNumber').val().length < 1 || $('#scholarshipName').val().length < 1 || $('#scholarship').val().length < 1 || $('#scholarshipSeparation').val().length < 1 || $('#scholarshipGiveOrganization').val().length < 1 || $('#scholarshipGiveDate').val().length < 1 || $('#scholarshipDetail').val().length < 1 || $('#scholarshipFile').val().length < 1) {
						$("#dialog2").dialog();
					} else {
						let recordId = "<%= session.getAttribute("userId") %>"
						let studentNumber = $("#studentNumber").val();
						let scholarshipName = $("#scholarshipName").val();
						let scholarship = $("#scholarship").val();
						let scholarshipSeparation = $("#scholarshipSeparation").val();
						let scholarshipGiveOrganization = $("#scholarshipGiveOrganization").val();
						let scholarshipGiveDate = $("#scholarshipGiveDate").val();
						let scholarshipDetail = $("#scholarshipDetail").val();
						let scholarshipFile = $("#scholarshipFile").val();
						let request = {
								recordId: recordId, studentNumber: studentNumber, scholarshipName: scholarshipName, scholarship: scholarship, scholarshipSeparation: scholarshipSeparation, scholarshipGiveOrganization: scholarshipGiveOrganization, scholarshipGiveDate: scholarshipGiveDate, scholarshipDetail: scholarshipDetail, scholarshipFile: scholarshipFile
						}
						$.ajax({
							url:'/rest/addScholarshipBenefit'
							, type:'POST'
							, contentType: 'application/json;charset=UTF-8'
							, dataType:'JSON'
							, data: JSON.stringify(request)
							, success: function(data){
								if(data === "학번없음") {
									$("#dialog1").dialog();
								} else {
									window.location.href="/listScholarshipBenefit";
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
						<a href="/listScholarshipBenefit"><input type='button' class="btn btn-info" value='조회'></a>
						<input type='button' class="btn btn-success" id="addScholarshipBenefit" value='저장'/>
					</form>
					<br>
					<table class="table table-bordered">
						<tr>
							<td scope="col" colspan="10">
								<p id="enrolScoreMain">* 장학금 입력</p>
							</td>
						</tr>
						<tr>
							<th>학번</th>
							<td><input type="text" class="form-control" name="studentNumber" id="studentNumber" placeholder="학번"></td>
							<th>장학명</th>
							<td><input type="text" class="form-control" name="scholarshipName" id="scholarshipName" placeholder="장학명"></td>
							<th>장학금액</th>
							<td><input type="text" class="form-control" name="scholarship" id="scholarship" placeholder="장학금액"></td>
				   		</tr>
				   		
				   		<tr>
							<th>장학금(구분)</th>
							<td><input type="text" class="form-control" name="scholarshipSeparation" id="scholarshipSeparation" placeholder="장학금(구분)"></td>
							<th>수여기관</th>
							<td><input type="text" class="form-control" name="scholarshipGiveOrganization" id="scholarshipGiveOrganization" placeholder="수여기관"></td>
							<th>지급일자</th>
							<td><input type="text" class="form-control" name="scholarshipGiveDate" id="scholarshipGiveDate"></td>
				   		</tr>
				   		
				   		<tr>
							<th>상세내용</th>
							<td><input type="text" class="form-control" name="scholarshipDetail" id="scholarshipDetail"></td>
							<th>첨부파일</th>
							<td><input type="file" class="form-control" name="scholarshipFile" id="scholarshipFile"></td>
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
	</body>
</html>
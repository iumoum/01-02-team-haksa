<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>가족사항 입력</title>
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
		<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
		
		<script>
			$(document).ready(function() {
				$("#sample6_execDaumPostcode").click(function() {
					new daum.Postcode({
			            oncomplete: function(data) {
			                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

			                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
			                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			                var fullAddr = ''; // 최종 주소 변수
			                var extraAddr = ''; // 조합형 주소 변수

			                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
			                    fullAddr = data.roadAddress;

			                } else { // 사용자가 지번 주소를 선택했을 경우(J)
			                    fullAddr = data.jibunAddress;
			                }

			                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
			                if(data.userSelectedType === 'R'){
			                    //법정동명이 있을 경우 추가한다.
			                    if(data.bname !== ''){
			                        extraAddr += data.bname;
			                    }
			                    // 건물명이 있을 경우 추가한다.
			                    if(data.buildingName !== ''){
			                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
			                    }
			                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
			                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
			                }

			                // 주소 정보를 해당 필드에 넣는다.
			                document.getElementById('sample6_address').value = fullAddr;

			                // 커서를 상세주소 필드로 이동한다.
			                document.getElementById('sample6_address2').focus();
			            }
			        }).open();
			    })
			    
				$("#dialog2").hide();
				
				$("#familyBirthday").datepicker({
					dateFormat: 'yy-mm-dd'
				});
				
				$("#goBack").click(function() {
					window.history.back();
				});
				
				$("#addFamily").click(function() {
					let familyResidence = $(sample6_address).val() + " " + $(sample6_address2).val();
					
					if($('#familyRelationship').val().length < 1 || $('#familyName').val().length < 1 || $('#familyPhoneNumber').val().length < 1 || $('#familyBirthday').val().length < 1 || $('#familyAcademicBackground').val().length < 1 || $('#familyJob').val().length < 1 || $('#sample6_address').val().length < 1 || $('#sample6_address2').val().length < 1) {
						$("#dialog2").dialog();
					} else {
						let studentNumber = ${familyStudentNumber.studentNumber};
						let recordId = "<%= session.getAttribute("userId") %>"
						let familyRelationship = $("#familyRelationship").val();
						let familyName = $("#familyName").val();
						let familyPhoneNumber = $("#familyPhoneNumber").val();
						let familyBirthday = $("#familyBirthday").val();
						let familyAcademicBackground = $("#familyAcademicBackground").val();
						let familyJob = $("#familyJob").val();
						let request = {
								recordId: recordId, studentNumber: studentNumber, familyRelationship: familyRelationship, familyName: familyName, familyPhoneNumber: familyPhoneNumber, familyBirthday: familyBirthday, familyAcademicBackground: familyAcademicBackground, familyJob: familyJob, familyResidence: familyResidence
						}
						$.ajax({
							url:'/rest/addFamily'
							, type:'POST'
							, contentType: 'application/json;charset=UTF-8'
							, dataType:'JSON'
							, data: JSON.stringify(request)
							, success: function(data){
								if(data === "입력성공") {
									window.location.href="/detailStudentInfo?studentNumber=${familyStudentNumber.studentNumber}";
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
						<a href="/listStudentInfo"><input type='button' class="btn btn-info" value='학생정보 조회'></a>
						<input type='button' class="btn btn-success" id="addFamily" value='저장'/>
						<input type='button' class="btn btn-info" id="goBack" value='뒤로가기'>
					</form>
					<br>
					<table class="table table-bordered">
						<tr>
							<td scope="col" colspan="10">
								<p id="enrolScoreMain">* 가족사항 입력</p>
							</td>
						</tr>
						<tr>
							<th>가족관계</th>
							<td><input type="text" class="form-control" name="familyRelationship" id="familyRelationship" placeholder="가족관계"></td>
							<th>성명</th>
							<td><input type="text" class="form-control" name="familyName" id="familyName" placeholder="성명"></td>
							<th>전화번호</th>
							<td><input type="text" class="form-control" name="familyPhoneNumber" id="familyPhoneNumber" placeholder="전화번호"></td>
				   		</tr>
				   		
				   		<tr>
							<th>생년월일</th>
							<td><input type="text" class="form-control" name="familyBirthday" id="familyBirthday" placeholder="생년월일"></td>
							<th>학력</th>
							<td><input type="text" class="form-control" name="familyAcademicBackground" id="familyAcademicBackground" placeholder="학력"></td>
							<th>직업</th>
							<td><input type="text" class="form-control" name="familyJob" id="familyJob" placeholder="직업"></td>
				   		</tr>
				   		
				   		<tr>
				   			<td><input type="button" id="sample6_execDaumPostcode" value="우편번호 찾기"></td>
				   			<td colspan="2"><input type="text" class="form-control" id="sample6_address" placeholder="주소"></td>
				   			<td colspan="2"><input type="text" class="form-control" id="sample6_address2" placeholder="상세주소"></td>
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
		<div id="dialog2" title="다시 입력하여 주세요.">
			<p>양식이 맞지 않습니다.</p>
		</div>
	</body>
</html>
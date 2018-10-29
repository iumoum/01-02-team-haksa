<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<title>상담구분코드 관리</title>
	
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
			$('#addButton').click(function(){
				window.location.href="/schoolRegister/codes/addTypeOfCounsel";
			})
			
			// 상담구분코드 검색
			$("#keyword").keyup(function() {
                var selectBox = $("#selectBox option:selected").val();
                var word = $('#keyword').val();
                $("#counselCode > tbody").children().hide();
                if(selectBox == "counsel"){
                    var temp = $("#counselCode > tbody > tr").find("td:nth-child(2):contains('" + word + "')");
                } else if(selectBox == "conunselResult"){
                    var temp = $("#counselCode > tbody > tr").find("td:nth-child(3):contains('" + word + "')");
                }
                $(temp).parent().show();
            });
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
			
				<div class="mail-box">
					<aside class="lg-side">
						<div class="inbox-head">
							<div class="input-append">
								<input type="text" class="sr-input" placeholder="" id="keyword">
								<button class="btn sr-btn" type="button">
									<i class="fa fa-search"></i>
								</button>
								&ensp;
								<select class="btn btn-info" id="selectBox">
									<option value="counsel">상담구분</option>
									<option value="conunselResult">상담결과</option>
								</select>
								&ensp;
								<button class="btn btn-info" type="button">입력</button>		
							</div>
						</div>
						<div class="inbox-body">
							<div class="mail-option">
								<table class="table table-inbox table-hover" id="counselCode">
									<thead>
										<tr class="unread">
											<td class="view-message  dont-show">상담구분 코드</td>
											<td>상담구분 명</td>
											<td></td>
											<td></td>
											<td>상담결과 명</td>
											<td>코드 사용유무</td>
											<td>코드 변경사유</td>
											<td>시스템 등록일자</td>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="row" items="${resultOfCounselCodes}">
											<tr class="">
												<td class="view-message  dont-show">${row.counselResultCode}</td>
												<td colspan="3" class="view-message">${row.counselTypeName}</td>
												<td>${row.counselResultName}</td>
												<td>${row.counselResultIsUsed}</td>
												<td>${row.counselResultIsChanged}</td>
												<td>${row.counselResultRegisteredDate}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</aside>
				</div>	
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
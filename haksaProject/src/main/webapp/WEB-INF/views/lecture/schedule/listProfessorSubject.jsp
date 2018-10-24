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
									<input type="text" class="sr-input" placeholder="">
									<button class="btn sr-btn" type="button">
										<i class="fa fa-search"></i>
									</button>
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
									주야 : 
									<select name="dayBox" id="dayCode" class="btn btn-info">
										<option value="선택">선택</option>
										<option value="주">주</option>
										<option value="야">야</option>
									</select>
									&emsp;
									<button type="button" id="click" class="btn btn-info">조회</button>
								</div>
							</div>
							<div class="inbox-body">
								<div class="mail-option">
									<form action="${pageContext.request.contextPath}/scheduleAdd"
										method="post">
										<table class="table table-inbox table-hover">
											<thead>
												<tr class="unread">
													<td class="view-message  dont-show">과목명</td>
													<td>담당교수</td>
													<td></td>
													<td></td>
													<td>강의실</td>
													<td>요일</td>
													<td class="view-message  text-left">교시</td>
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
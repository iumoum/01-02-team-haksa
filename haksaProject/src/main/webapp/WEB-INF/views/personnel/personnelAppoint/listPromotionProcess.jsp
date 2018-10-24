<!-- 이응빈 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
	<head>
	
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport"
			content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
		<title>승진처리 리스트</title>
		
		<!-- Bootstrap core CSS-->
		<link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		
		<!-- Custom fonts for this template-->
		<link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
		
		<!-- Page level plugin CSS-->
		<link href="/resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
		
		<!-- Custom styles for this template-->
		<link href="/resources/css/sb-admin.css" rel="stylesheet">
		
		<style>
			#enrolScoreMain{
				text-align : left;
				font-weight: bold;
				font-size: 30px;
			}
			
			#form {
				text-align : right;
			}
		</style>
		
		<script>  
			// 입력 버튼 눌렀을 시 페이지 이동	
			function addPersonnelPromotion(){
			    window.location.href="/personnelAppoint/addPromotion";
			}
			
			// 조회 버튼 눌렀을 시 페이지 이동
			function personnelPromotionList(){
			    window.location.href="/personnelAppoint/listPromotionProcess";
			}
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
									<input type="text" class="sr-input" placeholder="Tìm kiếm">
									<button class="btn sr-btn" type="button">
										<i class="fa fa-search"></i>
									</button>
									&ensp; 
									<input type='button' class="btn sr-btn" onclick='personnelPromotionList()' value='조회'/>
									&ensp; 
									<input type='button' class="btn sr-btn" onclick='addPersonnelPromotion()' value='입력'/> 
									&ensp;
									<button class="btn sr-btn" type="button">저장</button>
								</div>
							</div>
							<div class="inbox-body">
								<div class="mail-option">
									<table class="table table-inbox table-hover">
										<tbody>
											<tr class="unread">
												<td class="view-message  dont-show">승진번호</td>
												<td>교직원번호</td>
												<td>발령직급</td>
												<td>발령연봉</td>
												<td>발령호봉</td>
												<td>승진일</td>
												<th>임용일</th>
												<td class="view-message  text-left">임명사유</td>
											</tr>
	
											<c:forEach var="personnel" items="${promotionList}">
												<tr class="">
													<td>${personnel.promotionNumber}</td>
													<td>${personnel.appointmentSchoolPersonnelNumber}</td>
													<td>${personnel.rankCode}</td>
													<td>${personnel.promotionAppointmentAnnualIncome}</td>
													<td>${personnel.promotionAppointmentSalaryclass}</td>
													<td>${personnel.promotionDay}</td>
													<td>${personnel.promotionAppointmentDay}</td>
													<td>${personnel.promotionAppointReason}</td>
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
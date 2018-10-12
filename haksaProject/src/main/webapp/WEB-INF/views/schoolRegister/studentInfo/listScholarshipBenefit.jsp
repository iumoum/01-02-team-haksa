<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>장학금 수혜내역 리스트</title>
		<!-- Bootstrap core CSS-->
		<link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		
		<!-- Custom fonts for this template-->
		<link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
		
		<!-- Page level plugin CSS-->
		<link href="/resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
		
		<!-- Custom styles for this template-->
		<link href="/resources/css/sb-admin.css" rel="stylesheet">
	</head>
	
	<body id="page-top">

		<jsp:include page="/WEB-INF/views/module/nav.jsp"/>
	
		<div id="wrapper">

			<jsp:include page="/WEB-INF/views/module/sidebar.jsp"/>
	
			<div id="content-wrapper">

				<div class="container-fluid">
				<!-- 여기에 내용이 담긴다 -->
					<h1>학적 관리 > 장학금 수혜내역</h1>
					
					<form id="form">
						<a href="/insertScholarshipBenefit"><input type='button' class="btn btn-info" value='입력'></a>
					</form>
					<br>
				
				    <table border="1">
				        <thead>
				            <tr>
				            	<th>장학금수혜번호</th>
				                <th>학번</th>
				                <th>장학명</th>
				                <th>장학금액</th>
				                <th>장학금(구분)</th>
				                <th>수여기관</th>
				                <th>상세내용</th>
				                <th>첨부파일</th>
				                <th>지급일자</th>
				            </tr>
				        </thead>
				        <tbody>
							<c:forEach var="scholarshipBenefit" items="${scholarshipBenefit}">
				                <tr>
				                	<td>${scholarshipBenefit.scholarshipBenefitNumber}</td>
				                    <td>${scholarshipBenefit.studentNumber}</td>
				                    <td>${scholarshipBenefit.scholarshipName}</td>
				                    <td>${scholarshipBenefit.scholarship}</td>
				                    <td>${scholarshipBenefit.scholarshipSeparation}</td>
				                    <td>${scholarshipBenefit.scholarshipGiveOrganization}</td>
				                    <td>${scholarshipBenefit.scholarshipDetail}</td>
				                    <td>${scholarshipBenefit.scholarshipFile}</td>
				                    <td>${scholarshipBenefit.scholarshipGiveDate}</td>
				                </tr>
				            </c:forEach>
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
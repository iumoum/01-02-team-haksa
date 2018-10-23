<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>


<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>수강신청 및 정정</title><!-- Bootstrap core CSS-->
<link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template-->
<link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

<!-- Page level plugin CSS-->
<link href="/resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/resources/css/sb-admin.css" rel="stylesheet">
<style>
	.printScoreRankInClassMain{
		text-align : left;
		font-weight: bold;
	}
</style>

</head>

<body id="page-top">

	<jsp:include page="/WEB-INF/views/module/nav.jsp"/>

	<div id="wrapper">

		<jsp:include page="/WEB-INF/views/module/sidebar.jsp"/>

		<div id="content-wrapper">

			<div class="container-fluid">
			<!-- 여기에 내용이 담긴다 -->
				<form action="/courseAndScore/printScoreRankInClass" method="post">
					<table class="table table-bordered">
						<tr align="right">
							<td scope="col" colspan="10">
								<p class = "printScoreRankInClassMain">반 석차조회 리스트 </p>
								<p class = "printScoreRankInClassMain"> 반 입력 : 
									<select name="ClassName">
										<option value="A">A</option>
										<option value="B">B</option>
									</select>
								</p>
								<button type="button" class="btn btn-info">이전화면</button>
								<button type="submit" class="btn btn-info">조회하기</button>
							</td>
						</tr>
						<tr>
							<td scope="col" colspan="10"></td>
						</tr>
						<tr>
							<th colspan="10"><br>반 석차 조회</th>
						</tr>
						<tr>
							<th>석차</th>
							<th>학번</th>
							<th>평점</th>
							<th>성명</th>
							<th>이수구분</th>
						</tr>
						<c:forEach var="row" items="${enrolCourse}" varStatus="status">
							<tr>
								<td>${status.count}</td>
								<td>${row.enrolCourseStudentNumber }</td>
								<td>${row.insertScoreTotalAverageScore }</td>
								<td>${row.enrolCoursestudentName }</td>
								<td>${row.enrolCourseCompletionDivision }</td>
							</tr>
					   </c:forEach>
					</table>
				</form>
			
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
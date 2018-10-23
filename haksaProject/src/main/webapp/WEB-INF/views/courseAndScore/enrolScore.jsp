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
	#enrolScoreMain{
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
			<table class="table table-bordered">
					<tr align="right">
						<td scope="col" colspan="10">
							<p id = "enrolScoreMain">담당과목성적등록</p>
							<button type="button" class="btn btn-info" onclick="history.go(-1);">이전화면</button>
							<button type="button" class="btn btn-info">성적공개</button>
							<button type="button" class="btn btn-success">성적입력확정</button>
						</td>
				    </tr>
					<tr>
						<td scope="col" colspan="10"></td>
				    </tr>
				    <tr>
				    	<th colspan="10"><br>성적입력</th>
				    </tr>
					    <tr>
					    	<th>과목명</th>
					    	<td>${enrolCourse[0].enrolCourseCourseName}</td>
					    	<th>확정여부</th>
					    	<td></td>
					    	<th>공개여부</th>
					    	<td></td>
					    	<th>학점</th>
					    	<td>${enrolCourse[0].enrolCourseCourseCredit}</td>
					    </tr>
					    <tr>
					    	<th>최대 수강 인원</th>
					    	<td></td>
					    	<th>총 수강 인원</th>
					    	<td></td>
					    </tr>
				    <tr>
				    	<th colspan="10"><br>성적,등급,점수입력</th>
				    </tr>
				    <tr>
				    	<th>번호</th>
				    	<th>학번</th>
				    	<th>성명</th>
				    	<th>이수구분</th>
				    	<th>출석점수</th>
				    	<th>중간점수</th>
				    	<th>기말점수</th>
				    	<th>제출물점수</th>
				    	<th>총점</th>
				    	<th>재수강횟수</th>
				    </tr>
				    <c:forEach var="row" items="${enrolCourse}">
					    <tr>
					    	<td>${row.enrolCourseNo }</td>
					    	<td>${row.enrolCourseStudentNumber }</td>
					    	<td>${row.enrolCoursestudentName }</td>
					    	<td>${row.enrolCourseCompletionDivision }</td>
					    	<td><input id="attendancePoint" type="text"></td>
					    	<td><input id="midPoint" type="text"></td>
					    	<td><input id="finalPoint" type="text"></td>
					    	<td><input id="reportPoint" type="text"></td>
					    	<td><input id="totalPoint" type="text"></td>
					    	<td>${row.enrolCourseCourseRetakeNumber }</td>
					    </tr>
				    </c:forEach>
				    <tr>
				    	<td colspan="10" align="right"><button type="button" id="totalPointCal" class="btn btn-success">총점계산</button></td>
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
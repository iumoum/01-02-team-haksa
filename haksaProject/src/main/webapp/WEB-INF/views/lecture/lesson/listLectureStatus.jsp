<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<title>강의 상황서 관리</title>
	
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
				window.location.href="/lesson/lecture/addLectureStatus";
			})
			
			// 강의상황서 검색
			$("#keyword").keyup(function() {
                var selectBox = $("#selectBox option:selected").val();
                var word = $('#keyword').val();
                $("#lectureStatus > tbody").children().hide();
                if(selectBox == "subject"){
                    var temp = $("#lectureStatus > tbody > tr").find("td:nth-child(2):contains('" + word + "')");
                } else if(selectBox == "score"){
                    var temp = $("#lectureStatus > tbody > tr").find("td:nth-child(4):contains('" + word + "')");
                } else if(selectBox == "theory"){
                    var temp = $("#lectureStatus > tbody > tr").find("td:nth-child(5):contains('" + word + "')");
                } else if(selectBox == "practice"){
                    var temp = $("#lectureStatus > tbody > tr").find("td:nth-child(6):contains('" + word + "')");
                } else if(selectBox == "sum"){
                    var temp = $("#lectureStatus > tbody > tr").find("td:nth-child(7):contains('" + word + "')");
                } else if(selectBox == "professorName"){
                    var temp = $("#lectureStatus > tbody > tr").find("td:nth-child(9):contains('" + word + "')");
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
									<option value="subject">과목</option>
									<option value="score">학점</option>
									<option value="theory">이론시수</option>
									<option value="practice">실습시수</option>
									<option value="sum">총시수</option>
									<option value="professorName">지도교수</option>
								</select>
								&ensp;
								<button class="btn btn-info" type="button" id="addButton">입력</button>
							</div>
						</div>
						<div class="inbox-body">
							<div class="mail-option">
								<table class="table table-inbox table-hover" id="lectureStatus">
									<thead>
										<tr class="unread">
											<td class="view-message  dont-show">강의 상황서 번호</td>
											<td>과목</td>
											<td></td>
											<td></td>
											<td>이수구분</td>
											<td>학점</td>
											<td>이론 시수</td>
											<td>실습 시수</td>
											<td>총 시수</td>
											<td>강의실 명</td>
											<td>강의교수</td>
											<td class="view-message  text-left">시스템 등록일자</td>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="st" items="${list}">
											<tr class="">
												<td class="view-message  dont-show">${st.lectureStatusNumber}</td>
												<td colspan="3" class="view-message">${st.subjectName}</td>
												<td>${st.typeOfCompletionName}</td>
												<td>${st.subjectScoreGraduation}</td>
												<td>${st.subjectHoursTheory}</td>
												<td>${st.subjectHoursPractice}</td>
												<td>${st.subjectHoursTheory+st.subjectHoursPractice}</td>
												<td>${st.roomName}</td>
												<td class="view-message  text-left">${st.humanName}</td>
												<td class="view-message  text-left">${st.lectureStatusRegisteredDate}</td>
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
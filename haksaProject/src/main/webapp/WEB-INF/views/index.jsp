<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<title>학사관리 시스템</title>
	
	<!-- Bootstrap core CSS-->
	<link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- Custom fonts for this template-->
	<link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
	
	<!-- Page level plugin CSS-->
	<link href="/resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
	
	<!-- Custom styles for this template-->
	<link href="/resources/css/sb-admin.css" rel="stylesheet">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<script src="https://code.highcharts.com/highcharts.js"></script>
	<script src="https://code.highcharts.com/modules/exporting.js"></script>
	<script src="https://code.highcharts.com/modules/export-data.js"></script>
	
	<link href="/resources/css/slider.css" rel="stylesheet">
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

</head>

<body id="page-top">

	<jsp:include page="/WEB-INF/views/module/nav.jsp"/>

	<div id="wrapper">

		<jsp:include page="/WEB-INF/views/module/sidebar.jsp"/>

		<div id="content-wrapper">

			<div class="container-fluid">
			<!-- 여기에 내용이 담긴다 -->
				<div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="false"> 
					<!--페이지-->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
					</ol>
					<!--페이지-->
				
					<div class="carousel-inner">
						<!--슬라이드1-->
						<div class="item active"> 
							<img src="http://www.blueb.co.kr/SRC2/_image/w01.jpg" style="width:100%" alt="First slide">
							<div class="container">
								<div class="carousel-caption">
									<h1>교직원 로그인 시</h1>
									<ol style="text-align: left">
										<li>공통코드 관리 : 공통적으로 사용되는 코드를 입력하고 조회할 수 있습니다.</li>
										<li>학적코드 관리 : 학기 및 학사일정과 학적변동 코드, 상담 구분, 결과 코드를 입력하고 조회할 수 있습니다.</li>
										<li>수업코드 관리 : 강의와 관련된 코드를 입력하고 조회할 수 있습니다.</li>
										<li>졸업코드 관리 : 졸업불가사유 코드를 입력하고 조회할 수 있습니다.</li>
										<li>학적 관리 : 학생정보와 장학금 수혜내역, 상담내용, 반 변경 내용을 입력하고 조회할 수 있습니다.</li>
										<li>강의담당 관리 : 강의상황서 및 학과별 반을 입력하고 조회할 수 있습니다.</li>
										<li>시간표 관리 : 시간표를 입력하고 조회할 수 있습니다.</li>
										<li>출석부 관리 : 출석부를 입력하고 조회할 수 있습니다.</li>
										<li>수강신청 : 학생들이 수강신청한 과목을 조회할 수 있습니다.</li>
										<li>성적입력 : 담당과목 성적을 입력하면 학과 석차, 반 석차를 조회할 수 있습니다.</li>
										<li>인사코드 관리 : 인사에 관련된 코드를 입력하고 조회할 수 있습니다.</li>
										<li>인사임명 관리 : 교직원의 정보와 승진처리를 입력하고 조회할 수 있습니다.</li>
									</ol>
								</div>
							</div>
						</div>
						<!--슬라이드1-->
				
						<!--슬라이드2-->
						<div class="item">
							<img src="http://www.blueb.co.kr/SRC2/_image/w03.jpg" style="width:100%" data-src="" alt="Second slide">
							<div class="container">
								<div class="carousel-caption">
									<h1>학생 로그인 시</h1>
									<ol style="text-align: left">
										<li>학적 관리 : 자신의 학생정보를 조회할 수 있습니다.</li>
										<li>시간표 관리 : 시간표를 조회할 수 있습니다.</li>
										<li>수강신청 : 수강신청을 할 수 있습니다.</li>
									</ol>
								</div>
							</div>
						</div>
						<!--슬라이드2-->
					</div>
	
					<!--이전, 다음 버튼-->
					<a class="left carousel-control" href="#myCarousel" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> 
					<a class="right carousel-control" href="#myCarousel" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a> 
				</div>
			
			
				<div class="modal-body">
		            <div class="row">
						<div class="col-sm-6">
							<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
						</div>
						
						<div class="col-sm-6">
							<table border="1">
								<thead>
									<tr>
										<th>월</th>
										<th>시작날짜</th>
										<th>종료날짜</th>
										<th>학사일정</th>
									</tr>
								</thead>
								<tbody id="bodyList">
								</tbody>
							</table>
						</div>
					</div>
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
	
	<script>
		$(document).ready(function(){
			$.ajax({
				url:'/rest/calander'
				, type:'GET'
				, dataType:'JSON'
				, success: function(data){
					$(data).each(function(index, item){
						$('#bodyList').append("<tr>");
						$('#bodyList').append("<td>"+item.month+"월</td>");
						$('#bodyList').append("<td>"+item.calanderBeginDate+"</td>");
						$('#bodyList').append("<td>"+item.calanderEndDate+"</td>");
						$('#bodyList').append("<td>"+item.calanderContent+"</td>");
						$('#bodyList').append("</tr>");
					})
				}
			})
			
			$.ajax({
				url:'/rest/studentState'
				, type:'GET'
				, dataType:'JSON'
				, success: function(data){
					let x1 = data[0].enrolledStudent;
					let y1 = data[0].freshman;
					let x2 = data[1].enrolledStudent;
					let y2 = data[1].freshman;
					let x3 = data[2].enrolledStudent;
					let y3 = data[2].freshman;
					
					Highcharts.chart('container', {
					    chart: {
					        type: 'column'
					    },
					    title: {
					        text: '재학생 및 신입생 현황'
					    },
					    xAxis: {
					        categories: [
					            '2016',
					            '2017',
					            '2018'
					        ],
					        crosshair: true
					    },
					    yAxis: {
					        min: 0,
					        title: {
					            text: '인원수 (명)'
					        }
					    },
					    tooltip: {
					        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
					        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
					            '<td style="padding:0"><b>{point.y:1f} 명</b></td></tr>',
					        footerFormat: '</table>',
					        shared: true,
					        useHTML: true
					    },
					    plotOptions: {
					        column: {
					            pointPadding: 0.2,
					            borderWidth: 0
					        }
					    },
					    
					    series: [{
					        name: '재학생',
					        data: [x1, x2, x3]
				
					    }, {
					        name: '신입생',
					        data: [y1, y2, y3]
				
					    }]
					});
				}
			})
		})
	</script>
</body>
</html>
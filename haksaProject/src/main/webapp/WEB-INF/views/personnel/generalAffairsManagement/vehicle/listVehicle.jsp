<!-- 2018.10.01 28기 전재현 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>vehicle List</title>
		
		<!-- Bootstrap core CSS-->
		<link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		
		<!-- Custom fonts for this template-->
		<link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
		
		<!-- Page level plugin CSS-->
		<link href="/resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
		
		<!-- Custom styles for this template-->
		<link href="/resources/css/sb-admin.css" rel="stylesheet">
		
		<script>
		$(document).ready(function {
			
			$('#check').click(function (e) {
				  e.preventDefault()
				  $(this).tab('show')
				})
				
			$('#approval').click(function (e) {
			  e.preventDefault()
			  $(this).tab('show')
			})
			
			$('#refusal').click(function (e) {
			  e.preventDefault()
			  $(this).tab('show')
			})
		});
		</script>
	</head>
	<body id="page-top">

		<!-- nav Include -->
		<jsp:include page="/WEB-INF/views/module/nav.jsp"/>
	
		<div id="wrapper">
	
			<!-- side Include -->
			<jsp:include page="/WEB-INF/views/module/sidebar.jsp"/>
	
			<div id="content-wrapper">
	
				<!-- 여기에 내용이 담긴다 -->
				<div class="container-fluid">
				
					<!-- 차량 운행 신청 리스트  -->
					<div role="tabpanel">
			
						<!-- Nav tabs -->
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation" class="active"><a href="#check" aria-controls="check" role="tab" data-toggle="tab">차량운행 승인여부 리스트</a></li>
							<li role="presentation"><a href="#approval" aria-controls="approval" role="tab" data-toggle="tab">차량운행 승인 리스트</a></li>
							<li role="presentation"><a href="#refusal" aria-controls="refusal" role="tab" data-toggle="tab">차량운행 승인 불가 리스트</a></li>
						</ul>
						
						<!-- Tab panes -->
						<div class="tab-content">
						
							<!-- 차량 승인여부 리스트 -->
							<div role="tabpanel" class="tab-pane active" id="check">
								<table>
									<thead>
										<tr>
											<td>
												<input type="checkbox" >
											</td>
											<td>부서 명</td>
											<td>직급 명</td>
											<td>성명</td>
											<td>차량 번호</td>
											<td>차량종류</td>
											<td>차량 운행목적</td>
											<td>차량 승인 여부</td>
											<td>등록일자</td>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="s" items="${vehicleList }">
											<tr>
												<td>
													<input type="checkbox" >
												</td>
												<td>${s.deptName }</td>
												<td>${s.rankName }</td>
												<td>${s.humanName }</td>
												<td>${s.vehicleNumber }</td>
												<td>${s.vehicleType }</td>
												<td>${s.vehiclePurpose }</td>
												<c:if test="${s.vehicleApprovalStatus eq null }">
													<td>확인중</td>
												</c:if>
												<td>${s.vehicleRegistrationDay }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							
							<!-- 차량 승인 리스트 -->
							<div role="tabpanel" class="tab-pane active" id="approval">
								<table>
									<thead>
										<tr>
											<td>
												<input type="checkbox" >
											</td>
											<td>부서 명</td>
											<td>직급 명</td>
											<td>성명</td>
											<td>차량 번호</td>
											<td>차량종류</td>
											<td>차량 운행목적</td>
											<td>차량 승인 여부</td>
											<td>등록일자</td>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="s" items="${vehicleList }">
											<tr>
												<td>
													<input type="checkbox" >
												</td>
												<td>${s.deptName }</td>
												<td>${s.rankName }</td>
												<td>${s.humanName }</td>
												<td>${s.vehicleNumber }</td>
												<td>${s.vehicleType }</td>
												<td>${s.vehiclePurpose }</td>
												<c:if test="${s.vehicleApprovalStatus eq null }">
													<td>확인중</td>
												</c:if>
												<c:if test="${s.vehicleApprovalStatus eq Y }">
													<td>승인</td>
												</c:if>
												<c:if test="${s.vehicleApprovalStatus eq N }">
													<td>거부</td>
												</c:if>
												<td>${s.vehicleRegistrationDay }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							
							<!-- 차량 거부 리스트 -->
							<div role="tabpanel" class="tab-pane active" id="refusal">
								<table>
									<thead>
										<tr>
											<td>
												<input type="checkbox" >
											</td>
											<td>부서 명</td>
											<td>직급 명</td>
											<td>성명</td>
											<td>차량 번호</td>
											<td>차량종류</td>
											<td>차량 운행목적</td>
											<td>차량 승인 여부</td>
											<td>등록일자</td>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="s" items="${vehicleList }">
											<tr>
												<td>
													<input type="checkbox" >
												</td>
												<td>${s.deptName }</td>
												<td>${s.rankName }</td>
												<td>${s.humanName }</td>
												<td>${s.vehicleNumber }</td>
												<td>${s.vehicleType }</td>
												<td>${s.vehiclePurpose }</td>
												<c:if test="${s.vehicleApprovalStatus eq null }">
													<td>확인중</td>
												</c:if>
												<c:if test="${s.vehicleApprovalStatus eq Y }">
													<td>승인</td>
												</c:if>
												<c:if test="${s.vehicleApprovalStatus eq N }">
													<td>거부</td>
												</c:if>
												<td>${s.vehicleRegistrationDay }</td>
											</tr>
										</c:forEach>
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
	</body>
</html>
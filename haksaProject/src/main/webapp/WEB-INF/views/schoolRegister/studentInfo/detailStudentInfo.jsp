<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>학생정보</title>
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
				var studentNumber = ${studentInfo.studentNumber};
				
				if("" === $("#graduationCertificateNumber").text()) {
					$("#graduationCertificateNumber").hide();
					$("#graduationNumber").hide();
                }
				if("" === $("#degreeNumber").text()) {
					$("#degreeNumber").hide();
					$("#degree").hide();
                }
                if("" === $("#graduationDepartment").text()) {
                	$("#graduationDepartment").hide();
                	$("#graduation").hide();
                }
                
                $('#scholarshipBenefitButton').click(function(){
                	$.ajax({
    					url:'/rest/scholarshipBenefit'
    					, type:'GET'
    					, dataType:'JSON'
    					, data: {studentNumber: studentNumber}
    					, success: function(data){
    						$('#scholarshipBenefitHead').empty();
    						$('#scholarshipBenefit').empty();
							$('#scholarshipBenefitHead').append("<tr>");
							$('#scholarshipBenefitHead').append("<th>장학금수혜번호</th>");
							$('#scholarshipBenefitHead').append("<th>학번</th>");
							$('#scholarshipBenefitHead').append("<th>장학명</th>");
							$('#scholarshipBenefitHead').append("<th>장학금액</th>");
							$('#scholarshipBenefitHead').append("<th>장학금(구분)</th>");
							$('#scholarshipBenefitHead').append("<th>수여기관</th>");
							$('#scholarshipBenefitHead').append("<th>상세내용</th>");
							$('#scholarshipBenefitHead').append("<th>첨부파일</th>");
							$('#scholarshipBenefitHead').append("<th>지급일자</th>");
							$('#scholarshipBenefitHead').append("</tr>");
							
    						$(data).each(function(index, item){
    							$('#scholarshipBenefit').append("<tr>");
    							$('#scholarshipBenefit').append("<td>"+item.scholarshipBenefitNumber+"</td>");
    							$('#scholarshipBenefit').append("<td>"+item.studentNumber+"</td>");
    							$('#scholarshipBenefit').append("<td>"+item.scholarshipName+"</td>");
    							$('#scholarshipBenefit').append("<td>"+item.scholarship+"</td>");
    							$('#scholarshipBenefit').append("<td>"+item.scholarshipSeparation+"</td>");
    							$('#scholarshipBenefit').append("<td>"+item.scholarshipGiveOrganization+"</td>");
    							$('#scholarshipBenefit').append("<td>"+item.scholarshipDetail+"</td>");
    							$('#scholarshipBenefit').append("<td>"+item.scholarshipFile+"</td>");
    							$('#scholarshipBenefit').append("<td>"+item.scholarshipGiveDate+"</td>");
    							$('#scholarshipBenefit').append("</tr>");
    						})
    					}
    				})
                })
                
                $('#adviceButton').click(function(){
                	$.ajax({
    					url:'/rest/advice'
    					, type:'GET'
    					, dataType:'JSON'
    					, data: {studentNumber: studentNumber}
    					, success: function(data){
    						$('#adviceHead').empty();
    						$('#advice').empty();
							$('#adviceHead').append("<tr>");
							$('#adviceHead').append("<th>상담내역번호</th>");
							$('#adviceHead').append("<th>학생명</th>");
							$('#adviceHead').append("<th>상담구분명</th>");
							$('#adviceHead').append("<th>상담결과명</th>");
							$('#adviceHead').append("<th>상담내용</th>");
							$('#adviceHead').append("<th>상담일자</th>");
							$('#adviceHead').append("<th>지도교수명</th>");
							$('#adviceHead').append("</tr>");
							
    						$(data).each(function(index, item){
    							$('#advice').append("<tr>");
    							$('#advice').append("<td>"+item.adviceHistoryNumber+"</td>");
    							$('#advice').append("<td>"+item.studentName+"</td>");
    							$('#advice').append("<td>"+item.counselTypeName+"</td>");
    							$('#advice').append("<td>"+item.counselResultName+"</td>");
    							$('#advice').append("<td>"+item.adviceContent+"</td>");
    							$('#advice').append("<td>"+item.adviceDate+"</td>");
    							$('#advice').append("<td>"+item.teacherName+"</td>");
    							$('#advice').append("</tr>");
    						})
    					}
    				})
                })
                
                $('#classChangeButton').click(function(){
                	$.ajax({
    					url:'/rest/classChange'
    					, type:'GET'
    					, dataType:'JSON'
    					, data: {studentNumber: studentNumber}
    					, success: function(data){
    						$('#classChangeHead').empty();
    						$('#classChange').empty();
							$('#classChangeHead').append("<tr>");
							$('#classChangeHead').append("<th>반 변경 번호</th>");
							$('#classChangeHead').append("<th>학번</th>");
							$('#classChangeHead').append("<th>변경 전 반</th>");
							$('#classChangeHead').append("<th>변경 후 반</th>");
							$('#classChangeHead').append("<th>변경 전 주야</th>");
							$('#classChangeHead').append("<th>변경 후 주야</th>");
							$('#classChangeHead').append("<th>차수구분</th>");
							$('#classChangeHead').append("<th>변경사유</th>");
							$('#classChangeHead').append("<th>변경일자</th>");
							$('#classChangeHead').append("</tr>");
							
    						$(data).each(function(index, item){
    							$('#classChange').append("<tr>");
    							$('#classChange').append("<td>"+item.classChangeNumber+"</td>");
    							$('#classChange').append("<td>"+item.studentNumber+"</td>");
    							$('#classChange').append("<td>"+item.classChangeBefore+"</td>");
    							$('#classChange').append("<td>"+item.classChangeAfter+"</td>");
    							$('#classChange').append("<td>"+item.classChangeBeforeDayAndNight+"</td>");
    							$('#classChange').append("<td>"+item.classChangeAfterDayAndNight+"</td>");
    							$('#classChange').append("<td>"+item.classChangeDegreeSeparation+"</td>");
    							$('#classChange').append("<td>"+item.classChangeReason+"</td>");
    							$('#classChange').append("<td>"+item.classChangeDate+"</td>");
    							$('#classChange').append("</tr>");
    						})
    					}
    				})
                })
                
                $('#familyButton').click(function(){
                	$.ajax({
    					url:'/rest/family'
    					, type:'GET'
    					, dataType:'JSON'
    					, data: {studentNumber: studentNumber}
    					, success: function(data){
    						$('#familyHead').empty();
    						$('#family').empty();
							$('#familyHead').append("<tr>");
							$('#familyHead').append("<th>가족사항 번호</th>");
							$('#familyHead').append("<th>학번</th>");
							$('#familyHead').append("<th>가족관계</th>");
							$('#familyHead').append("<th>성명</th>");
							$('#familyHead').append("<th>가족 전화번호</th>");
							$('#familyHead').append("<th>생년월일</th>");
							$('#familyHead').append("<th>학력</th>");
							$('#familyHead').append("<th>직업</th>");
							$('#familyHead').append("<th>주소</th>");
							$('#familyHead').append("</tr>");
							
    						$(data).each(function(index, item){
    							$('#family').append("<tr>");
    							$('#family').append("<td>"+item.familyNumber+"</td>");
    							$('#family').append("<td>"+item.studentNumber+"</td>");
    							$('#family').append("<td>"+item.familyRelationship+"</td>");
    							$('#family').append("<td>"+item.familyName+"</td>");
    							$('#family').append("<td>"+item.familyPhoneNumber+"</td>");
    							$('#family').append("<td>"+item.familyBirthday+"</td>");
    							$('#family').append("<td>"+item.familyAcademicBackground+"</td>");
    							$('#family').append("<td>"+item.familyJob+"</td>");
    							$('#family').append("<td>"+item.familyResidence+"</td>");
    							$('#family').append("</tr>");
    						})
    					}
    				})
                })
                
                $('#myProfileButton').click(function(){
                	$.ajax({
    					url:'/rest/myProfile'
    					, type:'GET'
    					, dataType:'JSON'
    					, data: {studentNumber: studentNumber}
    					, success: function(data){
    						$('#myProfileHead').empty();
    						$('#myProfile').empty();
							$('#myProfileHead').append("<tr>");
							$('#myProfileHead').append("<th>학번</th>");
							$('#myProfileHead').append("<th>전화번호</th>");
							$('#myProfileHead').append("<th>이메일</th>");
							$('#myProfileHead').append("<th>주소</th>");
							$('#myProfileHead').append("<th>영문 주소</th>");
							$('#myProfileHead').append("</tr>");
							
    						$(data).each(function(index, item){
    							$('#myProfile').append("<tr>");
    							$('#myProfile').append("<td>"+item.studentNumber+"</td>");
    							$('#myProfile').append("<td>"+item.humanPhoneNumber+"</td>");
    							$('#myProfile').append("<td>"+item.humanEmail+"</td>");
    							$('#myProfile').append("<td>"+item.humanAddress+"</td>");
    							$('#myProfile').append("<td>"+item.humanEnglishAddress+"</td>");
    							$('#myProfile').append("</tr>");
    						})
    					}
    				})
                })
                
                $('#highSchoolButton').click(function(){
                	$.ajax({
    					url:'/rest/highSchool'
    					, type:'GET'
    					, dataType:'JSON'
    					, data: {studentNumber: studentNumber}
    					, success: function(data){
    						$('#highSchoolHead').empty();
    						$('#highSchool').empty();
							$('#highSchoolHead').append("<tr>");
							$('#highSchoolHead').append("<th>학번</th>");
							$('#highSchoolHead').append("<th>학교명</th>");
							$('#highSchoolHead').append("<th>졸업일자</th>");
							$('#highSchoolHead').append("</tr>");
							
    						$(data).each(function(index, item){
    							$('#highSchool').append("<tr>");
    							$('#highSchool').append("<td>"+item.studentNumber+"</td>");
    							$('#highSchool').append("<td>"+item.highSchoolSchoolName+"</td>");
    							$('#highSchool').append("<td>"+item.highSchoolGraduation+"</td>");
    							$('#highSchool').append("</tr>");
    						})
    					}
    				})
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
					<h1>학적 관리 > 학생정보 관리 > 학생정보</h1>
					
					<form id="form">
						<a href="/addFamily"><input type='button' class="btn btn-info" value='가족사항 입력'></a>
						<a href="/addMyProfile"><input type='button' class="btn btn-info" value='신상명세정보 입력'></a>
						<a href="/addHighSchool"><input type='button' class="btn btn-info" value='고등학력사항 입력'></a>
					</form>
					<br>
					
					<div>
						<a href="/listStudentInfo"><button>조회</button></a>
						<button id="scholarshipBenefitButton">장학금 수혜내역</button>
						<button id="adviceButton">상담</button>
						<button id="classChangeButton">반 변경</button>
						<button id="familyButton">가족사항</button>
						<button id="myProfileButton">신상명세정보</button>
						<button id="highSchoolButton">고등학력사항</button>
						<br><br>
					</div>
				
				    <table border="1">
				        <thead>
				            <tr>
				                <th>사진</th>
				            	<th>학번</th>
				                <th>주민번호</th>
				            	<th>성명</th>
				                <th>성명(영어)</th>
				                <th>국가</th>
				                <th>성별</th>
				            	<th>학생상태</th>
				            	<th>병역여부</th>
				                <th>학과</th>
				                <th>학년</th>
				                <th>반</th>
				                <th>주야</th>
				                <th>입학학과</th>
				                <th>입학주야</th>
				                <th>입학일자</th>
				                <th>졸업예정일자</th>
				                <th id="graduationNumber">졸업증서번호</th>
				                <th id="degree">학위번호</th>
				                <th id="graduation">졸업학과</th>
				            </tr>
				        </thead>
				        <tbody>
			                <tr>
			                	<td><img src="${studentInfo.humanPicture}"></td>
			                    <td>${studentInfo.studentNumber}</td>
			                    <td>${studentInfo.humanResidentRegistrationNumber}</td>
			                    <td>${studentInfo.humanName}</td>
			                    <td>${studentInfo.humanNameEnglish}</td>
			                    <td>${studentInfo.countryNameKorean}</td>
			                    <td>${studentInfo.humanGender}</td>
			                    <td>${studentInfo.studentState}</td>
			                    <td>${studentInfo.humanMilitaryService}</td>
			                    <td>${studentInfo.deptNameKorean}</td>
			                    <td>${studentInfo.classByDepartmentGrade}</td>
			                    <td>${studentInfo.classByDepartmentClass}</td>
			                    <td>${studentInfo.classByDepartmentDayAndNight}</td>
			                    <td>${studentInfo.studentEntranceDepartment}</td>
			                    <td>${studentInfo.studentEntranceDayAndNight}</td>
			                    <td>${studentInfo.studentEntranceDate}</td>
			                    <td>${studentInfo.studentGraduationScheduleDate}</td>
			                    <td id="graduationCertificateNumber">${studentInfo.studentGraduationCertificateNumber}</td>
			                    <td id="degreeNumber">${studentInfo.studentDegreeNumber}</td>
			                    <td id="graduationDepartment">${studentInfo.studentGraduationDepartment}</td>
			                </tr>
				        </tbody>
				    </table>
				    <br>
				    
				    <table border="1">
				        <thead id="scholarshipBenefitHead">
				        </thead>
				        <tbody id="scholarshipBenefit">
				        </tbody>
				    </table>
				    <br>
				    
				    <table border="1">
				        <thead id="adviceHead">
				        </thead>
				        <tbody id="advice">
				        </tbody>
				    </table>
				    <br>
				    
				    <table border="1">
				        <thead id="classChangeHead">
				        </thead>
				        <tbody id="classChange">
				        </tbody>
				    </table>
				    <br>
				    
				    <table border="1">
				        <thead id="familyHead">
				        </thead>
				        <tbody id="family">
				        </tbody>
				    </table>
				    <br>
				    
				    <table border="1">
				        <thead id="myProfileHead">
				        </thead>
				        <tbody id="myProfile">
				        </tbody>
				    </table>
				    <br>
				    
				    <table border="1">
				        <thead id="highSchoolHead">
				        </thead>
				        <tbody id="highSchool">
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
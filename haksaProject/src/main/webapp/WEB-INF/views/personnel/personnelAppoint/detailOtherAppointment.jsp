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
	
		<title>무기계약 상세정보</title>
		
		<!-- Bootstrap core CSS-->
		<link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		
		<!-- Custom fonts for this template-->
		<link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
		
		<!-- Page level plugin CSS-->
		<link href="/resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
		
		<!-- Custom styles for this template-->
		<link href="/resources/css/sb-admin.css" rel="stylesheet">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		
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
			function addPersonnelBasic(){
			    window.location.href="/personnelAppoint/addPersonnelBasic?otherAppointmentSchoolPersonnelNumber1="+${detailOtherAppointment.appointmentSchoolPersonnelNumber};
			}
			function addCareer(){
			    window.location.href="/personnelAppoint/addCareer?otherAppointmentSchoolPersonnelNumber="+${detailOtherAppointment.appointmentSchoolPersonnelNumber};
			}
			function addPosition(){
			    window.location.href="/personnelAppoint/addPosition?otherAppointmentSchoolPersonnelNumber="+${detailOtherAppointment.appointmentSchoolPersonnelNumber};
			}
			function addFamily(){
			    window.location.href="/personnelAppoint/addFamily?otherAppointmentSchoolPersonnelNumber="+${detailOtherAppointment.appointmentSchoolPersonnelNumber};
			}
			function addEducation(){
			    window.location.href="/personnelAppoint/addEducation?otherAppointmentSchoolPersonnelNumber="+${detailOtherAppointment.appointmentSchoolPersonnelNumber};
			}
			function addMyProfile(){
			    window.location.href="/personnelAppoint/addMyProfile?otherAppointmentSchoolPersonnelNumber="+${detailOtherAppointment.appointmentSchoolPersonnelNumber};
			}
			function addHighSchool(){
			    window.location.href="/personnelAppoint/addHighSchool?otherAppointmentSchoolPersonnelNumber="+${detailOtherAppointment.appointmentSchoolPersonnelNumber};
			}
			
			// 조회 버튼 눌렀을 시 페이지 이동
			function listOtherAppointment(){
			    window.location.href="/personnelAppoint/listOtherAppointment";
			}
			
			$(document).ready(function(){
				var number = ${detailOtherAppointment.appointmentSchoolPersonnelNumber};
				
				$('#personnelBasicButton').click(function(){
	            	$.ajax({
						url:'/rest/personnelBasic'
						, type:'GET'
						, dataType:'JSON'
						, data: {number: number}
						, success: function(data){
							$('#personnelBasicHead').empty();
							$('#personnelBasic').empty();
							$('#personnelBasicHead').append("<tr>");
							$('#personnelBasicHead').append("<th>인사기본사항번호</th>");
							$('#personnelBasicHead').append("<th>교직원번호</th>");
							$('#personnelBasicHead').append("<th>연봉구분</th>");
							$('#personnelBasicHead').append("<th>채용분류</th>");
							$('#personnelBasicHead').append("<th>현직(전직)기관</th>");
							$('#personnelBasicHead').append("<th>생년월일</th>");
							$('#personnelBasicHead').append("<th>재임용여부</th>");
							$('#personnelBasicHead').append("<th>겸직여부</th>");
							$('#personnelBasicHead').append("<th>사무실 전화번호</th>");
							$('#personnelBasicHead').append("<th>정년보장</th>");
							$('#personnelBasicHead').append("<th>현직(전직)직위</th>");
							$('#personnelBasicHead').append("<th>음양구분</th>");
							$('#personnelBasicHead').append("<th>센터입소일</th>");
							$('#personnelBasicHead').append("</tr>");
							
							$(data).each(function(index, item){
								$('#personnelBasic').append("<tr>");
								$('#personnelBasic').append("<td>"+item.personnelBasicNumber+"</td>");
								$('#personnelBasic').append("<td>"+item.appointmentSchoolPersonnelNumber+"</td>");
								$('#personnelBasic').append("<td>"+item.personnelBasicHireDivision+"</td>");
								$('#personnelBasic').append("<td>"+item.personnelBasicAnnualIncomeDivision+"</td>");
								$('#personnelBasic').append("<td>"+item.personnelBasicOrganization+"</td>");
								$('#personnelBasic').append("<td>"+item.personnelBasicYearsMonthDay+"</td>");
								$('#personnelBasic').append("<td>"+item.personnelBasicReassignCheck+"</td>");
								$('#personnelBasic').append("<td>"+item.personnelBasicOtherOfficial+"</td>");
								$('#personnelBasic').append("<td>"+item.personnelBasicOfficeTelephoneNumber+"</td>");
								$('#personnelBasic').append("<td>"+item.personnelBasicRetirementGuarantee+"</td>");
								$('#personnelBasic').append("<td>"+item.personnelBasicPostposition+"</td>");
								$('#personnelBasic').append("<td>"+item.personnelBasicLunarSolarDivision+"</td>");
								$('#personnelBasic').append("<td>"+item.personnelBasicCenterEnterDay+"</td>");
								$('#personnelBasic').append("</tr>");
							})
						}
					})
	            })
	            
	            $('#careerButton').click(function(){
	            	$.ajax({
						url:'/rest/career'
						, type:'GET'
						, dataType:'JSON'
						, data: {number: number}
						, success: function(data){
							$('#careerHead').empty();
							$('#career').empty();
							$('#careerHead').append("<tr>");
							$('#careerHead').append("<th>경력사항 번호</th>");
							$('#careerHead').append("<th>교직원번호</th>");
							$('#careerHead').append("<th>발령구분</th>");
							$('#careerHead').append("<th>임명일</th>");
							$('#careerHead').append("<th>경력구분</th>");
							$('#careerHead').append("<th>만료일</th>");
							$('#careerHead').append("<th>직군</th>");
							$('#careerHead').append("<th>직종</th>");
							$('#careerHead').append("<th>직급</th>");
							$('#careerHead').append("<th>이전계약부터</th>");
							$('#careerHead').append("<th>이전계약까지</th>");
							$('#careerHead').append("</tr>");
							
							$(data).each(function(index, item){
								$('#career').append("<tr>");
								$('#career').append("<td>"+item.careerNumber+"</td>");
								$('#career').append("<td>"+item.appointmentSchoolPersonnelNumber+"</td>");
								$('#career').append("<td>"+item.careerAppointment+"</td>");
								$('#career').append("<td>"+item.careerAppointmentDate+"</td>");
								$('#career').append("<td>"+item.careerClassification+"</td>");
								$('#career').append("<td>"+item.careerExpirationDate+"</td>");
								$('#career').append("<td>"+item.careerJikun+"</td>");
								$('#career').append("<td>"+item.careerJikjong+"</td>");
								$('#career').append("<td>"+item.careerPosition+"</td>");
								$('#career').append("<td>"+item.careerFromcontract+"</td>");
								$('#career').append("<td>"+item.careerUntillcontract+"</td>");
								$('#career').append("</tr>");
							})
						}
					})
	            })
	            
	            $('#positionButton').click(function(){
	            	$.ajax({
						url:'/rest/position'
						, type:'GET'
						, dataType:'JSON'
						, data: {number: number}
						, success: function(data){
							$('#positionHead').empty();
							$('#position').empty();
							$('#positionHead').append("<tr>");
							$('#positionHead').append("<th>보직사항 번호</th>");
							$('#positionHead').append("<th>교직원번호</th>");
							$('#positionHead').append("<th>보직팀</th>");
							$('#positionHead').append("<th>직위</th>");
							$('#positionHead').append("<th>보직임명일</th>");
							$('#positionHead').append("<th>보직만료일</th>");
							$('#positionHead').append("</tr>");
							
							$(data).each(function(index, item){
								$('#position').append("<tr>");
								$('#position').append("<td>"+item.positionNumber+"</td>");
								$('#position').append("<td>"+item.appointmentSchoolPersonnelNumber+"</td>");
								$('#position').append("<td>"+item.teamCode+"</td>");
								$('#position').append("<td>"+item.jobPositionCode+"</td>");
								$('#position').append("<td>"+item.positionStartOfWork+"</td>");
								$('#position').append("<td>"+item.positionEndOfWork+"</td>");
								$('#position').append("</tr>");
							})
						}
					})
	            })
	            
	            $('#familyButton').click(function(){
	            	$.ajax({
						url:'/rest/teacherFamily'
						, type:'GET'
						, dataType:'JSON'
						, data: {number: number}
						, success: function(data){
							$('#familyHead').empty();
							$('#family').empty();
							$('#familyHead').append("<tr>");
							$('#familyHead').append("<th>가족사항 번호</th>");
							$('#familyHead').append("<th>교직원번호</th>");
							$('#familyHead').append("<th>성명</th>");
							$('#familyHead').append("<th>가족관계</th>");
							$('#familyHead').append("<th>가족전화번호</th>");
							$('#familyHead').append("<th>생년월일</th>");
							$('#familyHead').append("<th>학력</th>");
							$('#familyHead').append("<th>직업</th>");
							$('#familyHead').append("<th>주소</th>");
							$('#familyHead').append("</tr>");
							
							$(data).each(function(index, item){
								$('#family').append("<tr>");
								$('#family').append("<td>"+item.familyNumber+"</td>");
								$('#family').append("<td>"+item.studentTeacherNo+"</td>");
								$('#family').append("<td>"+item.familyName+"</td>");
								$('#family').append("<td>"+item.familyRelationship+"</td>");
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
	            
	            $('#educationButton').click(function(){
	            	$.ajax({
						url:'/rest/education'
						, type:'GET'
						, dataType:'JSON'
						, data: {number: number}
						, success: function(data){
							$('#educationHead').empty();
							$('#education').empty();
							$('#educationHead').append("<tr>");
							$('#educationHead').append("<th>교직원번호</th>");
							$('#educationHead').append("<th>학교명</th>");
							$('#educationHead').append("<th>입학일</th>");
							$('#educationHead').append("<th>졸업일</th>");
							$('#educationHead').append("<th>전공명</th>");
							$('#educationHead').append("<th>전공계열</th>");
							$('#educationHead').append("<th>학점평점</th>");
							$('#educationHead').append("<th>이수학점</th>");
							$('#educationHead').append("</tr>");
							
							$(data).each(function(index, item){
								$('#education').append("<tr>");
								$('#education').append("<td>"+item.studentTeacherNo+"</td>");
								$('#education').append("<td>"+item.educationUniversitySchoolname+"</td>");
								$('#education').append("<td>"+item.educationEntrance+"</td>");
								$('#education').append("<td>"+item.educationUniversityGraduation+"</td>");
								$('#education').append("<td>"+item.educationMajor+"</td>");
								$('#education').append("<td>"+item.educationMajorCategory+"</td>");
								$('#education').append("<td>"+item.educationCredit+"</td>");
								$('#education').append("<td>"+item.educationCreditPoint+"</td>");
								$('#education').append("</tr>");
							})
						}
					})
	            })
	            
	            $('#myProfileButton').click(function(){
	            	$.ajax({
						url:'/rest/teacherMyProfile'
						, type:'GET'
						, dataType:'JSON'
						, data: {number: number}
						, success: function(data){
							$('#myProfileHead').empty();
							$('#myProfile').empty();
							$('#myProfileHead').append("<tr>");
							$('#myProfileHead').append("<th>교직원번호</th>");
							$('#myProfileHead').append("<th>전화번호</th>");
							$('#myProfileHead').append("<th>이메일</th>");
							$('#myProfileHead').append("<th>주소</th>");
							$('#myProfileHead').append("</tr>");
							
							$(data).each(function(index, item){
								$('#myProfile').append("<tr>");
								$('#myProfile').append("<td>"+item.studentTeacherNo+"</td>");
								$('#myProfile').append("<td>"+item.humanPhoneNumber+"</td>");
								$('#myProfile').append("<td>"+item.humanEmail+"</td>");
								$('#myProfile').append("<td>"+item.humanAddress+"</td>");
								$('#myProfile').append("</tr>");
							})
						}
					})
	            })
	            
	            $('#highSchoolButton').click(function(){
	            	$.ajax({
						url:'/rest/teacherHighSchool'
						, type:'GET'
						, dataType:'JSON'
						, data: {number: number}
						, success: function(data){
							$('#highSchoolHead').empty();
							$('#highSchool').empty();
							$('#highSchoolHead').append("<tr>");
							$('#highSchoolHead').append("<th>교직원번호</th>");
							$('#highSchoolHead').append("<th>학교명</th>");
							$('#highSchoolHead').append("<th>졸업일자</th>");
							$('#highSchoolHead').append("</tr>");
							
							$(data).each(function(index, item){
								$('#highSchool').append("<tr>");
								$('#highSchool').append("<td>"+item.studentTeacherNo+"</td>");
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
					<h1>인사관리 > 임명관리</h1>
					<br>
					<p id="enrolScoreMain">* 무기계약 상세정보</p>
					<form id="form">
						<input type="button" class="btn btn-success" onclick="addPersonnelBasic()" value="인사기본사항 입력"/>
						<input type="button" class="btn btn-success" onclick="addCareer()" value="경력사항 입력"/>
						<input type="button" class="btn btn-success" onclick="addPosition()" value="보직사항 입력"/>
						<input type="button" class="btn btn-success" onclick="addFamily()" value="가족사항 입력"/>
						<input type="button" class="btn btn-success" onclick="addEducation()" value="대학교학력사항 입력"/>
						<input type="button" class="btn btn-success" onclick="addMyProfile()" value="신상명세정보 입력"/>
						<input type="button" class="btn btn-success" onclick="addHighSchool()" value="고등학력사항 입력"/>
					</form>
					<br>
					<form id="form">
						<input type="button" class="btn btn-info" onclick="listOtherAppointment()" value="조회"/>
						<input type="button" class="btn btn-info" id="personnelBasicButton" value="인사기본사항"/>
						<input type="button" class="btn btn-info" id="careerButton" value="경력사항"/>
						<input type="button" class="btn btn-info" id="positionButton" value="보직사항"/>
						<input type="button" class="btn btn-info" id="familyButton" value="가족사항"/>
						<input type="button" class="btn btn-info" id="educationButton" value="대학교학력사항"/>
						<input type="button" class="btn btn-info" id="myProfileButton" value="신상명세정보"/>
						<input type="button" class="btn btn-info" id="highSchoolButton" value="고등학력사항"/>
					</form>
					<br>
					<table id="table" class="table table-bordered">
						<thead>
							<tr>
								<th>사진</th>
								<th>교직원번호</th>
								<th>성명</th>
								<th>성명(영어)</th>
								<th>국가</th>
								<th>성별</th>
								<th>주민등록번호</th>
								<th>병역여부</th>
								<th>발령명</th>
								<th>팀명</th>
								<th>직급명</th>
								<th>직종명</th>
								<th>직군명</th>
								<th>임명일</th>
								<th>지급연봉</th>
								<th>경력구분</th>
								<th>계약시작기간</th>
								<th>계약만료기간</th>
								<th>호봉</th>
								<th>호봉승급월</th>
								<th>직위</th>
								<th>보(겸)직팀</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><img src="${detailOtherAppointment.humanPicture}"></td>
								<td>${detailOtherAppointment.appointmentSchoolPersonnelNumber}</td>
								<td>${detailOtherAppointment.humanName}</td>
			                    <td>${detailOtherAppointment.humanNameEnglish}</td>
			                    <td>${detailOtherAppointment.countryNameKorean}</td>
			                    <td>${detailOtherAppointment.humanGender}</td>
			                    <td>${detailOtherAppointment.humanResidentRegistrationNumber}</td>
			                    <td>${detailOtherAppointment.humanMilitaryService}</td>
								<td>${detailOtherAppointment.personnelCommonAppointmentCodeName}</td>
								<td>${detailOtherAppointment.teamNameKorean}</td>
								<td>${detailOtherAppointment.jobRankNameKorean}</td>
								<td>${detailOtherAppointment.jobTypeName}</td>
								<td>${detailOtherAppointment.jobGroupName}</td>
								<td>${detailOtherAppointment.appointmentAppointDay}</td>
								<td>${detailOtherAppointment.otherAppointmentAnnualIncome}</td>
								<td>${detailOtherAppointment.otherAppointmentCareerDivision}</td>
								<td>${detailOtherAppointment.otherAppointmentContractStartTerm}</td>
								<td>${detailOtherAppointment.otherAppointmentContractEndTerm}</td>
								<td>${detailOtherAppointment.otherAppointmentSalaryclass}</td>
								<td>${detailOtherAppointment.otherAppointmentSalaryclassPromotion}</td>
								<td>${detailOtherAppointment.jobPositionCode}</td>
								<td>${detailOtherAppointment.otherAppointmentPositionTeam}</td>
							</tr>
						</tbody>
					</table>
					<br>
				    
				    <table border="1">
				        <thead id="personnelBasicHead">
				        </thead>
				        <tbody id="personnelBasic">
				        </tbody>
				    </table>
				    <br>
				    
				    <table border="1">
				        <thead id="careerHead">
				        </thead>
				        <tbody id="career">
				        </tbody>
				    </table>
				    <br>
				    
				    <table border="1">
				        <thead id="positionHead">
				        </thead>
				        <tbody id="position">
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
				        <thead id="educationHead">
				        </thead>
				        <tbody id="education">
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
				        <thead id="educationHead">
				        </thead>
				        <tbody id="education">
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
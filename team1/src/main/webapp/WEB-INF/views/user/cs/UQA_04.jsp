<!--  2021.11.29 강보석 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />



<div class="container-fluid">

	<div class="row">
		<div class="col-lg-4 offset-lg-4 text-center">
			<h1 class="page_title">고객센터</h1>
		</div>
	</div>

	<div class="row">
		<div class="offset-lg-2 col-lg-4 text-left cs_01_subtitle">
			<h3>1:1 문의 내용 작성</h3>
		</div>
	</div>

	<div class="row">
		<div class="offset-lg-2 col-lg-8 cs_02_02_row">
			<hr>
		</div>
	</div>
	
	<form id="questUpdateForm" action="${contextPath}/cs/questUpdate.do" 
	name="questContent" method="post">
		<div class="row">
			<div class="offset-lg-3 col-lg-2 text-center notice_02_box01">
				<span>제목</span>
			</div>
			<div class="col-lg-4 text-left cs_02_02_box02">
				<input type="text" class="form-control" name="notice_title" value="${pageInfo.notice_title}"
				placeholder="제목을 입력하세요.">
			</div>
		</div>
	
		<div class="row">
			<div class="offset-lg-3 col-lg-2 text-center cs_02_02_box01">
				<span>문의유형</span>
			</div>
			<div class="col-lg-4 text-left cs_02_02_box02">
				<input class="form-control" type="text" name="notice_type" value="${pageInfo.notice_type}" readonly>
			</div>
		</div>
	
		<div class="row">
			<div class="offset-lg-3 col-lg-2 text-center cs_02_02_box01">
				<span>공개여부</span>
			</div>
			<div class="col-lg-4 cs_02_02_box02">
				<input id="NPY" type="radio" name="notice_private" value="1" 
				onClick="this.form.notice_pw.disabled=true" checked="checked"> 공개 
				<input id="NPN" class="cs_02_01_private_btn" type="radio" 
				onClick="this.form.notice_pw.disabled=false"
				name="notice_private" value="0"> 비공개
			</div>
		</div>
	
		<div class="row">
			<div class="offset-lg-3 col-lg-2 text-center notice_02_box01">
				<span>비밀번호</span>
			</div>
			<div class="col-lg-1 text-left cs_02_02_ex01box02">
				<input id="NPPwd" type="password" class="form-control" name="notice_pw" 
				disabled placeholder="비밀번호">
			</div>
			<div class="col-lg-3 text-left cs_02_02_ex02box02"></div>
		</div>
	
		<div class="row">
			<div class="offset-lg-3 col-lg-2 text-center cs_02_02_box03">
				<span>내용</span>
			</div>
			<div class="col-lg-4 text-left cs_02_02_box04">
				<textarea class="form-control" name="notice_body"
				rows="8" placeholder="내용을 입력하세요.">${pageInfo.notice_body}</textarea>
			</div>
		</div>
	
		<div class="row">
			<div class="offset-lg-4 col-lg-2 text-center">
				<div class="cs_correct_btn">
					<input class="" id="cs_02_03_update_btn" type="button" value="수정하기">
				</div>
			</div>
			<div class="col-lg-2 text-center">
				<div class="notice_back_btn">
					<input id="cs_02_03_cancel_btn" type="button" value="돌아가기">
				</div>
			</div>
		</div>
	</form>
	<form id="UpdateFormInfo" action="${contextPath}/cs/questUpdate.do" method="get">
		<input type="hidden" id="cs_02_03_btn" name="notice_id" value="${pageInfo.notice_id}">
	</form>
</div>

<script>
	let form = $("#UpdateFormInfo");
	let uForm = $("#questUpdateForm");
	
	$("#cs_02_03_update_btn").on("click", function(e) {
		uForm.submit();
	});
	
	$("#cs_02_03_cancel_btn").on("click", function(e) {
		form.find("#cs_02_03_btn").remove();
		form.attr("action", "${contextPath}/cs/cs_02.do");
		form.submit();
	});
</script>
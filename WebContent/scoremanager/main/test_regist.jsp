<%-- 学生一覧JSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
	<c:param name="title">得点管理システム</c:param>
	<c:param name="scripts"></c:param>
	<c:param name="content">
		<section class="mp-4">
			<h2 class="h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4">成績管理</h2>
			<div class="my-2 text-end px-4">
			</div>
			<form action="TestRegist.action" method="get">
				<div class="row border mx-3 py-2 align-items-center rounded" id="filter">
					<div class="col-4">
						<label class="form-label" for="student-f1-select">入学年度 </label>
						<select class="form-select " id="student-f1-select" name="f1">
							<option value="0">--------</option>
							<c:forEach var="year" items="${ent_year_set}">
								<%-- 現在のyearと選択されていたf1が一致していた場合selectedを追記 --%>
								<option value="${year}" <c:if test="${year==f1}">selected</c:if>>${year}</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-4">
						<label class="form-label" for="student-f2-select">クラス</label>
						<select class="form-select" id="student-f2-select" name="f2">
							<option value="0">--------</option>
							<c:forEach var="num" items="${class_num_set}">
								<option value="${num}" <c:if test="${num==f2}">selected</c:if>>${num}</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-4">
						<label class="form-label" for="student-f3-select">科目</label>
						<select class="form-select" id="student-f3-select" name="f3">
							<option value="0">--------</option>
							<c:forEach var="subject" items="${subject_list}">
								<option value="${subject.cd}" <c:if test="${subject.cd==f3}">selected</c:if>>${subject.name}</option>
							</c:forEach>
						</select>
						<div class="col-4">
							<label class="form-label" for="student-f1-select">回数</label>
							<select class="form-select" id="student-f1-select" name="f4">
								<option value="0">--------</option>
								<option value="1">1</option>
								<c:forEach var="year" items="${stu_num_set}">
									<option value="${num}" <c:if test="${num==f4}">selected</c:if>>${num}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-12 text-end mt-2">
							<button class="btn btn-secondary" id="filter-button">検索</button>
						</div>
					</div>
				</div>
			</form>
			<c:choose>
				<c:when test="${test_set.size()>0}">
					<%-- <div>科目:${test_set.subject.name}(${test_set.no}回)</div> --%>
					<table class="table table-hover">
						<tr>
							<th>入学年度</th>
							<th>クラス</th>
							<th>学生番号</th>
							<th>氏名</th>
							<th>点数</th>
							<th></th>
							<th></th>
						</tr>
						<c:forEach var="test" items="${test_set}">
							<tr>
								<td>${test.student.entYear}</td>
								<td>${test.student.classNum}</td>
								<td>${test.student.no}</td>
								<td>${test.student.name}</td>
								<td><input type="text" value="${test.point}"></td>
							</tr>
						</c:forEach>
					</table>
					<button class="btn btn-secondary" id="filter-button">登録して終了</button>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
		</section>
	</c:param>
</c:import>

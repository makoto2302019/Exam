<%-- 学生登録JSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/common/base.jsp">

	<c:param name=" title">
		得点管理システム
	</c:param>

	<c:param name="scripts"></c:param>

	<c:param name="content">
		<section class="mp-4">
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">学生情報登録</h2>
			<form method="get" action="StudentCreateExecute.action">
				<div class="col-4">

					<label class="form-label" >入学年度 </label>

					<select class="form-select" name="ent_yaer">
						<option value="0">--------</option>
						<c:forEach var="year" items="${ent_year_set}">
							<%-- 現在のyearと選択されていたf1が一致していた場合selectedを追記 --%>
							<option value="${year}" <c:if test="${year==ent_yaer_set}">selected</c:if>>${year}</option>
							<
						</c:forEach>
					</select>

					<label class="form-label">学生番号</label>
					<input type="text" class="from-text" name="no" size="85" required="requier" maxlength="10" placeholder="学生番号を入力してください"><br>

					<label class="form-label">氏名</label><br>
					<input type="text" name="name" size="85" required="requier" maxlength="30" placeholder="氏名を入力してください"><br>

					<label class="form-label">クラス</label><br>
					<select class="form-select " id="student-f2-select" name="class_num">

						<c:forEach var="num" items="${class_num_set}">
							<%-- 現在のnumと選択されていたf2が一致していた場合selectdを追記 --%>
							<option value="${num}" <c:if test="${num==class_num_set}">selected</c:if>>${num}</option>
						</c:forEach>

					</select>

					<input type="submit" value="登録して終了">
					<a href="StudentList.action">戻る</a>

				</div>
			</form>
		</section>
	</c:param>
</c:import>
<%-- 学生一覧JSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">

	<c:param name="scripts"></c:param>

	<c:param name="content">
		<section class="mp-4">
			<form action = "StudentUpdateExecute.action" method="post">
				<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">学生情報変更</h2>

				<label>入学年度</label><br>
				<input type="text" readonly="readonly" value=${ent_year } name="ent_yaer" style="border:none"><br>

				<label>学生番号</label><br>
				<input type="text" readonly="readonly" value=${no } name="no" style="border:none"><br>

				<label>氏名</label><br>
				<input type="text" name="name" value=${name } required="requier"><br>

				<label>クラス</label><br>
				<select name="class_num"><br>
					<option value="0">${fnum}</option>
					<c:forEach var="num" items="${num}">
						<option>${num}</option>
					</c:forEach>
				</select><br>

				<label>在学中</label>
				<input type="checkbox" name="si_attend"><br>

				<input type="submit" value="変更"><br>

				<a href="StudentList.action">戻る</a>

			</form>
		</section>
	</c:param>
</c:import>
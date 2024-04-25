<%-- 学生登録結果JSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
<c:param name="scripts"></c:param>

	<c:param name="content">
		<section class="mp-4">
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">成績管理</h2>
			<p class="label">変更が完了しました</p>
			<a href="StudentList.action">成績参照</a>
		</section>
	</c:param>
</c:import>
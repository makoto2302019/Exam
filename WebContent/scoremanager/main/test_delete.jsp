<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/common/base.jsp">
<c:param name="title">成績情報削除</c:param>
<c:param name="content">
<section class="me-4">
<h2 class="bg-secondary bg-opacity-10 py-2">成績情報削除</h2>
<form action="SubjectDeleteExecute.action" method="post">
<p>を削除してもよろしいですか</p>
<div class="text-start"> <!-- 左詰めにするための修正 -->
<input type="submit" class="btn btn-danger" value="削除"/>
</div>
</form>
<div class="text-start mt-3"> <!-- 左詰めにするための修正 -->
<a href="SubjectList.action" class="btn btn-secondary">戻る</a>
</div>
</section>
</c:param>
</c:import>
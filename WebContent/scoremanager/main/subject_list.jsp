<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/common/base.jsp">
<c:param name="title">科目管理</c:param>
<c:param name="scripts"></c:param>
<c:param name="content">
<style>
            .table th,
            .table td {
                border: none; /* 周りの罫線を削除 */
            }
            .table-bordered td,
            .table-bordered th {
                border-bottom: 1px solid #dee2e6; /* 横線を追加 */
            }
</style>

        <section class="me-4">
<h2 class="h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4">科目管理</h2>
<div class="my-2 text-end px-4">
<a href="SubjectCreate.action">新規登録</a>
</div>
<table class="table table-bordered table-hover">
<thead>
<tr>
<th>科目コード</th>
<th>科目名</th>
<th>変更</th>
<th>削除</th>
</tr>
</thead>
<tbody>
<tr>
<td>A02</td>
<td>国語</td>
<td><a href="#">変更</a></td>
<td><a href="#">削除</a></td>
</tr>
<tr>
<td>B02</td>
<td>数学</td>
<td><a href="#">変更</a></td>
<td><a href="#">削除</a></td>
</tr>
<tr>
<td>C02</td>
<td>英語コミュニケーション概論</td>
<td><a href="#">変更</a></td>
<td><a href="#">削除</a></td>
</tr>
<tr>
<td>D02</td>
<td>理科</td>
<td><a href="#">変更</a></td>
<td><a href="#">削除</a></td>
</tr>
<tr>
<td>E02</td>
<td>情報処理基礎知識1</td>
<td><a href="#">変更</a></td>
<td><a href="#">削除</a></td>
</tr>
</tbody>
</table>
</section>
</c:param>
</c:import>
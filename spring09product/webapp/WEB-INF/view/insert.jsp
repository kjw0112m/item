<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h1>상품 등록</h1>
<form action="insert" method="post">
<input type="radio" name="type" value="키보드">
키보드
<input type="radio" name="type" value="마우스">
마우스
<input type="text" name="name" placeholder="상품 이름 입력">
<input type="text" name="price" placeholder="상품 가격 입력">
<input type="submit" value="등록">
</form>

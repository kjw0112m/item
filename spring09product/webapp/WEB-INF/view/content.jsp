<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>상품 상세정보</h1>

<c:forEach var="dto" items="${dto}">
<img src="${pageContext.request.contextPath}/image/${dto.name}.jpg">
<div>
	<h3>${dto.name }</h3>
	<h3>${dto.price }</h3>
</div>
</c:forEach>
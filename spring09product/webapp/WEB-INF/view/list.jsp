<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="list" items="${list}">
<img src="${pageContext.request.contextPath}/image/${list.name}.jpg">
<div>
	<a href="${pageContext.request.contextPath}/content?no=${list.no}"><h3>${list.name }</h3></a>
	<h3>${list.price }</h3>
</div>
</c:forEach>

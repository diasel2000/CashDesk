<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Cash Desk</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <!-- MAIN CSS -->
    <link rel="stylesheet" href="/css/tooplate-style.css">
    <link rel="stylesheet" href="/css/login.css">

</head>
<body>
<section id="service2" class="parallax-section">
    <div class="container">
        <div class="row">
            <h2>
                List Checks <br/>
            </h2>
            <c:if test="${not empty sql_error_message}">
                <p class="error">${sql_error_message}</p>
            </c:if>
            <table>
                <tr><th>Id</th><th>Total price</th><th>Time</th></tr>
                <c:forEach var="i" items="${checks}">
                <tr><td><a href="check?id=<c:out value='${i.id}' />"> <c:out value="${i.id}"/></a></td>
                    <td>${i.totalPrice}</td><td>${i.createTime}</td>
                    </c:forEach>
            </table>
            <br>
            <br>
            <a href="${pageContext.request.contextPath}/api/cashier/checks/addPage">Create new check</a>
            <br/>
        </div>
    </div>
</section>
</body>
</html>
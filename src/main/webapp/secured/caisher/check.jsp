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
                The check <br/>
            </h2>
            <c:if test="${not empty sql_error_message}">
                <p class="error">${sql_error_message}</p>
            </c:if>
            <br>
            <table>
                <tr><th>Check Id</th><th>Pozition Price</th>
                <c:forEach var="i" items="${checks}">
                <tr><td><c:out value="${i.id}"/></td>
                   <td>${i.priceSum}</td>

                    </c:forEach>
            </table>
            <br/>
        </div>
    </div>
</section>
</body>
</html>
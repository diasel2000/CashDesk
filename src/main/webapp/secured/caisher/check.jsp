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
            <br>
            <p><h3>Check id: ${check.id}, total price: ${check.totalPrice}, time created: ${check.createTime}</h3></p>
            <br>
            <h2>
                The products: <br/>
            </h2>

            <table>
                <tr><th>Code</th><th>Name</th><th>Price</th><th>Check</th></tr>
                <c:forEach var="i" items="${products}">
                <tr><td><c:out value="${i.code}"/></td>
                    <td>${i.name}</td><td>${i.price}</td>
                    <td>${i.check.id}</td>
                    </c:forEach>
            </table>
            <br/>
        </div>
    </div>
</section>
</body>
</html>
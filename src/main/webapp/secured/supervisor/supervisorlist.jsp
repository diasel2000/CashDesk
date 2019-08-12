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
            <div class="" data-wow-delay="0.2s">
                <!-- SECTION TITLE -->
                <h2>Product List</h2>
            </div>
            <c:if test="${not empty sql_error_message}">
                <p class="error">${sql_error_message}</p>
            </c:if>
            <table>
                <tr>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Price</th>
                </tr>
                <c:forEach var="i" items="${products}">
                    <tr>
                        <th>${i.code}</th>
                        <th>${i.productName}</th>
                        <th>${i.price}</th>
                    </tr>
                </c:forEach>
                <form action="${pageContext.request.contextPath}/key/supervisor/deleteProduct" method="post">
                    <div class="container-login100-form-btn">
                        <button class="login100-form-btn" >
                            Delete
                        </button>
                    </div>
                    <input id="first-name" class="input100" type="text" name="dcode" placeholder="by code">


                </form>
            </table>
        </div>
    </div>
</section>



</body>
</html>
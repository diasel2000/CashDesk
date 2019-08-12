<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<html lang="${param.lang}">
<head>

<meta charset="UTF-8">


<title>Cash Desk</title>

<link rel="stylesheet" href="/css/bootstrap.min.css">

<!-- MAIN CSS -->
<link rel="stylesheet" href="/css/tooplate-style.css">
<link rel="stylesheet" href="/css/login.css">

</head>
<body>

<!-- HOME SECTION -->
<section id="home" class="parallax-section">
     <div class="container">
          <div class="row">

               <div class="col-md-offset-5 col-md-7 col-sm-12">
                    <div class="home-thumb">
                         <h1 class="wow fadeInUp" data-wow-delay="0.4s">Welcome to Cash Desk</h1>
                         <p class="wow fadeInUp white-color" data-wow-delay="0.6s">Work! Have fun with us!</p>
                         <a href="#service" class="wow fadeInUp smoothScroll btn btn-default section-btn" data-wow-delay="1s">Start Work</a>
                    </div>
               </div>

          </div>
     </div>
</section>


<!-- SERVICE SECTION -->
<section id="service" class="parallax-section">
     <div class="container">
          <div class="row">

              <h2>
                  Add product in Check <br/>
              </h2>
              <c:if test="${not empty sql_error_message}">
                  <p class="error">${sql_error_message}</p>
              </c:if>
              <form action="${pageContext.request.contextPath}/key/caisher/checks/add">
              <table>
                  <tr>
                      <th>Product Code</th>
                      <th>Count</th>
                  </tr>
                  <tr>
                      <th><input id="first-name" class="input100" type="text" name="cod" placeholder="Code"></th>
                      <th><input id="first-name" class="input100" type="number" name="quant" placeholder="Count" ></th>
                      <td>
                          <div class="container-login100-form-btn">
                              <button class="login100-form-btn" id="btn1">Add to check</button>
                          </div>
                      </td>
                  </tr>
              </table>
              </form>

              <br>
          </div>
     </div>
</section>


<section id="service" class="parallax-section">
    <div class="container">
        <div class="row">
            <jsp:include page="check.jsp"></jsp:include>
        </div>
    </div>
</section>

<section id="service" class="parallax-section">
    <div class="container">
        <div class="row">
            <jsp:include page="checklist.jsp"></jsp:include>
        </div>
    </div>
</section>



<!-- FOOTER SECTION -->
<footer>
    <div class="container">
        <div class="row">
            <h1><a href="${pageContext.request.contextPath}/key/logout">Logout</a></h1>
               <div class="wow fadeInUp col-md-12 col-sm-12" data-wow-delay="0.8s">
                    <p class="white-color">Anatolii Huzov &copy; 2019 Cash Desk 
                    | Design: Stolen on the internet</p>
                  
          </div>
     </div></div>
</footer>

<!-- SCRIPTS -->
<script src="js/jquery.js"></script>
<script src="js/custom.js"></script>

</body>
</html>
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
                  List Products <br/>
              </h2>
              <button id="btn1">Append text</button>
              <c:if test="${not empty sql_error_message}">
                  <p class="error">${sql_error_message}</p>
              </c:if>
              <table id="prodtable">
                  <tr><th>Id</th><th>Name</th><th>Price</th>
                      <th>Total number</th>
                  </tr>
                  <c:forEach var="i" items="${products}">
                  <tr><td class="id_product"><a href="product?id=<c:out value='${i.id_product}'/>"><c:out value="${i.id_product}"/></a></td>
                      <td class="name">${i.name}</td>
                      <td class="price">${i.price}</td>
                      <td class="numberInput"><input type="number"></td>
                      <td>
                          <button class="addbutton" id="btn1">Add to check</button>
                      </td>
                      </c:forEach>
              </table>
              <br>
              <p>Add check:</p> <br>

              <form class="addToCheck" action="${pageContext.request.contextPath}/key/cashier/checks/add" method="post">
                  <input type="submit" value="Close check"/>
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
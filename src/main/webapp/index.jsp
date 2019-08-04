<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="${sessionScope.bundle}"/>

<html>
<head>

<meta charset="UTF-8">


<title>Cash Desk</title>


<!-- MAIN CSS -->

<style>
        <%@include file="/css/tooplate-style.css" %>
        <%@include file="/css/bootstrap.min.css" %>
</style>

</head>
<body>

<!-- HOME SECTION -->
<section id="home" class="parallax-section">
     <div class="container">
          <div class="row">

               <div class="col-md-offset-5 col-md-7 col-sm-12">
                    <div class="home-thumb">
                         <h1 class="wow fadeInUp" data-wow-delay="0.4s"><fmt:message key="index.welcome"/></h1>
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

               <div class="" data-wow-delay="0.2s">
                    <!-- SECTION TITLE -->
                    <h2>Choose your type of profession.</h2>
               </div>
               
               <a href="/secured/caisher/cashier.jsp">
                    <div class="col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.4s">
                         <div class="service-thumb">
                              <h4>The cashier</h4>
                              <p>Opportunities:
                                   <br>- Open a check
                                   <br>- Add product
                                   <br>- Close a check
                              </p>
                         </div>
                    </div>
              </a>

              <a href="/secured/seniorcaisher/seniorcashier.jsp">
                    <div class="col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.6s">
                         <div class="service-thumb">
                              <h4>Senior Cashier</h4>
                              <p>Opportunities:
                                   <br>- Cancel the check
                                   <br>- Cancel the product in the check
                                   <br>- Make X and Z reports
                              </p>
                         </div>
                    </div>
               </a>
                <a href="/secured/supervisor/supervisor.jsp">
                    <div class="col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.8s">
                         <div class="service-thumb">
                              <h4>Supervisor</h4>
                              <p>Opportunities:
                                   <br>- Add product to warehouse
                                   <br>- Find out the quantity of goods in stock
                              </p>
                         </div>
                    </div>
               </a>
          </div>
     </div>
</section>

<!-- FOOTER SECTION -->
<footer>
    <div class="container">
        <div class="row">
            <a href="/public/login.jsp">Registration</a>
               <div class="wow fadeInUp col-md-12 col-sm-12" data-wow-delay="0.8s">
                    <p class="white-color">Anatolii Huzov &copy; 2019 Cash Desk 
                    | Design: Stolen on the internet</p>
                  <nav>
                  <ul class="topmenu">
                                <li><a href=""><fmt:message key="${locale}" /></a>
                              <ul class="submenu">
                                  <li><a href="?locale=en"><fmt:message key="en" /></a></li>
                                  <li><a href="?locale=ru"><fmt:message key="ru" /></a></li>
                              </ul>
                   </li></ul></nav>
          </div>
     </div>
</footer>


</body>
</html>
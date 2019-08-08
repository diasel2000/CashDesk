<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="${sessionScope.bundle}"/>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">


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
                         <h1 class="wow fadeInUp" data-wow-delay="0.4s"><fmt:message key="index.welcom"/></h1>
                         <p class="wow fadeInUp white-color" data-wow-delay="0.6s"><fmt:message key="have_fun" /></p>
                         <a href="#service" class="wow fadeInUp smoothScroll btn btn-default section-btn" data-wow-delay="1s"><fmt:message key="start_work"/></a>
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
                    <h2><fmt:message key="chouse_y_type_prof" /></h2>
               </div>
               
               <a href="${pageContext.request.contextPath}/key/cashier">
                    <div class="col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.4s">
                         <div class="service-thumb">
                              <h4><fmt:message key="index.caisher" /></h4>
                              <p><fmt:message key="oportunities" />:
                                   <br>- <fmt:message key="open_check" />
                                   <br>- <fmt:message key="add_product" />
                                   <br>- <fmt:message key="close_check" />
                              </p>
                         </div>
                    </div>
              </a>

              <a href="${pageContext.request.contextPath}/key/adminCaisher">
                    <div class="col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.6s">
                         <div class="service-thumb">
                              <h4><fmt:message key="index.seniorcaisher" /></h4>
                              <p><fmt:message key="oportunities" />:
                                   <br>- <fmt:message key="cancel_check" />
                                   <br>- <fmt:message key="cancel_product" />
                                   <br>- <fmt:message key="x_z_reports" />
                              </p>
                         </div>
                    </div>
               </a>
                <a href="${pageContext.request.contextPath}/key/supervisor">
                    <div class="col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.8s">
                         <div class="service-thumb">
                              <h4><fmt:message key="index.supervisor" /></h4>
                              <p><fmt:message key="oportunities" />:
                                   <br>- <fmt:message key="add_new_product_to_warehous" />
                                   <br>- <fmt:message key="quantitu" />
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
            <a href="/public/login.jsp"><fmt:message key="registration" /></a>
               <div class="wow fadeInUp col-md-12 col-sm-12" data-wow-delay="0.8s">
                    <p class="white-color">Anatolii Huzov &copy; 2019 Cash Desk 
                    | Design: Stolen on the internet</p>
                  <nav>
                  <ul class="topmenu">
                                <li><a href=""><fmt:message key="index.language" /></a>
                              <ul class="submenu">
                                  <li><a href="?locale=en"><fmt:message key="en" /></a></li>
                                  <li><a href="?locale=ru"><fmt:message key="ru" /></a></li>
                                  <li><a href="?locale=ua"><fmt:message key="ua" /></a></li>
                              </ul>
                   </li></ul></nav>
          </div>
     </div>
</footer>


</body>
</html>
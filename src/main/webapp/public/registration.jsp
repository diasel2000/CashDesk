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



<!-- MAIN CSS -->
<style>
        <%@include file="/css/tooplate-style.css" %>
        <%@include file="/css/bootstrap.min.css" %>
        <%@include file="/css/login.css" %>
</style>

</head>
<body>

<!-- HOME SECTION -->
<section id="home" class="parallax-section">
     <div class="container">
          <div class="row">

            
          <div class="container-login100">
               <div class="wrap-login100">
                    <form class="login100-form validate-form"  action="${pageContext.request.contextPath}/key/users-register">
                         <span class="login100-form-title p-b-34">
                             <fmt:message key="registration" />
                         </span>
                         
                         <div class="wrap-input100 rs1-wrap-input100 validate-input m-b-20" data-validate="Type user name">
                              <input id="first-name" class="input100" type="text" name="username" placeholder='<fmt:message key="user.name" />'>
                               <c:if test="${not empty username_error_message}">
                                          	<p class="error">${username_error_message}</p>
                                          </c:if>
                              <span class="focus-input100"></span>
                         </div>
                         <div class="wrap-input100 rs2-wrap-input100 validate-input m-b-20" data-validate="Type password">
                              <input class="input100" type="password" name="pass" placeholder='<fmt:message key="user.pass" />'>
                              <c:if test="${not empty password_error_message}">
                                              <p class="error">${password_error_message}</p>
                                          </c:if>
                              <span class="focus-input100"></span>
                         </div>
                         <div class="wrap-input100 rs1-wrap-input100 validate-input m-b-20" data-validate="Type user name">
                              <input id="first-name" class="input100" type="text" name="role" placeholder='<fmt:message key="reg.name" />'>
                              <c:if test="${not empty role_error_message}">
                                    <p class="error">${role_error_message}</p>
                              </c:if>
                              <span class="focus-input100"></span>
                         </div>
                         <div class="wrap-input100 rs1-wrap-input100 validate-input m-b-20" data-validate="Type user name">
                              <input id="first-name" class="input100" type="text" name="lastusername" placeholder='<fmt:message key="reg.lastname" />'>
                              <c:if test="${not empty username_error_message}">
                                    <p class="error">${username_error_message}</p>
                         </c:if>
                              <span class="focus-input100"></span>
                         </div>
                        
                         <div class="container-login100-form-btn">
                              <button class="login100-form-btn">
                                  <fmt:message key="create_accaunt" />
                              </button>
                         </div>

                         <div class="w-full text-center">
                              <a href="/public/login.jsp" class="txt3">
                                   <fmt:message key="login.enter" />...
                              </a>
                         </div>
                    </form>

                    <div class="login100-more" style="background-image: url('../images/bg-01.jpg');"></div>
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

                              <a href="/secured/caisher/cashier.jsp">
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

                             <a href="/secured/seniorcaisher/seniorcashier.jsp">
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
                               <a href="/secured/supervisor/supervisor.jsp">
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

<!-- SCRIPTS -->
<script src="js/jquery.js"></script>
<script src="js/custom.js"></script>

</body>
</html>
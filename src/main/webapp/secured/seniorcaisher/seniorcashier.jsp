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
<%java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy"); %>
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

               <div class="" data-wow-delay="0.2s">
                    <!-- SECTION TITLE -->
                    <h2>Check operations</h2>
               </div>
               <form class="login100-form validate-form">
                    <table>
                         <tr>
                           <th>Check_ID</th>
                           <th>Product Quantity</th>
                           <th>Price Sum</th>
                         </tr>
                         <tr>
                           <td><input id="first-name" class="input100" type="number" name="username" placeholder="check id"></td>
                           <td><input id="first-name" class="input100" type="number" name="username" placeholder=""></td>
                           <td><input id="first-name" class="input100" type="number" name="username" placeholder="price"></td>
                           <td><div class="container-login100-form-btn"><button class="login100-form-btn">Delete Check</button></div></td>
                         </tr>
                    </table>
               </form>
               <table>
                <h2>X report</h2>
                    <tr>
                        <th>Data</th>
                        <th>Content</th>
                    </tr>
                    <tr>
                        <td><%= df.format(new java.util.Date()) %></td>
                        <td>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                        Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                        Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
                        Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</td>
                    </tr>
                </table>
                 <table>
                    <h2>Z report</h2>
                    <tr>
                        <th>Data</th>
                        <th>Content</th>
                    </tr>
                    <tr>
                        <td><%= df.format(new java.util.Date()) %></td>
                        <td>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                            Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                            Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
                            Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</td>
                        </tr>
                 </table>
          </div>
     </div>
</section>

<!-- FOOTER SECTION -->
<footer>
    <div class="container">
        <div class="row">

               <div class="wow fadeInUp col-md-12 col-sm-12" data-wow-delay="0.8s">
                    <p class="white-color">Anatolii Huzov &copy; 2019 Cash Desk 
                    | Design: Stolen on the internet</p>
                  
          </div>
     </div>
</footer>

<!-- SCRIPTS -->
<script src="js/jquery.js"></script>
<script src="js/custom.js"></script>

</body>
</html>
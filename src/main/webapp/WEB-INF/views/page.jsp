<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="author" content="Konstantin Astashonok">

        <title>Room - ${title}</title>

        <script>
        	window.menu = '${title}';
        	window.contextRoot = '${contextRoot}'
        </script>

        <!-- Bootstrap core CSS -->
        <link href="/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="/css/custom.css" rel="stylesheet">

    </head>
    <body>
        <div class="wrapper">
            <!-- Navigation -->
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
                <div class="container">
                    <a class="navbar-brand" href="${contextRoot}/home">Room with light bulbs</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                    aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarResponsive">
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="${contextRoot}/home">Home
                                    <span class="sr-only">(current)</span>
                                </a>
                            </li>
				            <li class="nav-item" id = "registration">
					            <a class="nav-link" href="${contextRoot}/registration">Register Room</a>
				            </li>
                            <li class="nav-item" id="listRooms">
                                <a class="nav-link" href="${contextRoot}/show/all/rooms">View Rooms</a>
                            </li>
                        </ul>
                     </div>
                </div>
            </nav>

            <!-- Page Content -->
                <div class="content">
                    <!-- Loading the home content -->
                    <c:if test="${homeClicked == true}">
                        <%@include file="home.jsp"%>
                    </c:if>

                    <!-- Loading only when user clicks view rooms -->
                    <c:if test="${allRoomsClicked == true}">
                        <%@include file="listRooms.jsp"%>
                    </c:if>

                    <!-- Loading only when user clicks register a room -->
                    <c:if test="${registrationClicked == true}">
                        <%@include file="registration.jsp"%>
                    </c:if>

                    <!-- Loading only when user clicks show the room -->
                    <c:if test="${singleRoomClicked == true}">
                        <%@include file="singleRoom.jsp"%>
                    </c:if>

                    <!-- Loading only when user clicks show the room -->
                    <c:if test="${errorThrown == true}">
                        <%@include file="error.jsp"%>
                    </c:if>
                </div>

            <!-- Footer -->
            <div class="footer">
                <footer class="py-5 bg-dark">
                    <div class="container">
                        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2020</p>
                    </div>
                </footer>
            </div>

            <!-- Bootstrap core JavaScript -->
            <script src="/js/jquery/jquery.min.js"></script>
            <script src="/js/bootstrap.bundle.min.js"></script>

           	<!-- Self coded javascript -->
            <script src="/js/custom.js"></script>
        </div>
    </body>
</html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Register Page</title>
    <link href="<c:url value="/resources/style/style.css" />" rel="stylesheet">
    <meta charset="UTF-8">
    <link href="https://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/4.1.3/flatly/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
          integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.7.1/jquery.contextMenu.min.css">
</head>
<body>
<div class="frm-container">
    <div class="frm-wrapper">
        <form:form method="POST" action="${pageContext.servletContext.contextPath}/register" modelAttribute="user"
                   cssClass="frm">
            <div class="imgcontainer">
                <img src="<c:url value="/resources/pictures/incognito.jpg" />" alt="Avatar" class="avatar">
            </div>
            <h3 align="center" style="color:maroon;"></h3>
            <div class="container auto-width" align="left">
                <label>Username</label>
                <input type="text" name="username" required="required" class="inp auto-width"/>

                <label>Password</label>
                <input type="password" name="password" required="required" class="inp auto-width"/>

                <label>Confirm Password</label>
                <input type="password" name="confirmPassword" required="required" class="inp auto-width"/>

                <p style="color:red">${error}</p>
                <button type="submit" class="btn">Register</button>
                <div align="center" style="padding-bottom: 5px">
                    <a href="${pageContext.servletContext.contextPath}/login">Sign In</a>
                </div>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>

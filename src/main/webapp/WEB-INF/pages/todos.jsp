<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>ToDo</title>
    <link href="<c:url value="/resources/style/style.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/some.js" />"></script>
    <meta charset="UTF-8">
    <link href="https://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/4.1.3/flatly/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
          integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.7.1/jquery.contextMenu.min.css">

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<div align="center">
    <div style="margin-bottom: 10px">
        <h1>Hello
            <security:authorize access="isAuthenticated()">
                <security:authentication property="principal.username"/>
            </security:authorize>!
        </h1>
        <button class="btn add-btn todo-h" type="button" data-toggle="collapse" data-target="#collapseExample"
                aria-expanded="false" aria-controls="collapseExample" style="width: 120px">Add Todo
        </button>
        <button class="btn todo-h" type="button" onclick="location.href='<c:url value="/logout"/>'">Logout</button>

        <div class="collapse" id="collapseExample">
            <div>
                <div class="frm-container">
                    <div class="frm-wrapper">
                        <form:form method="POST" action="${pageContext.servletContext.contextPath}/todo/add-todo"
                                   modelAttribute="todo" cssClass="frm">
                            <div class="container auto-width" align="left" style="width: auto">
                                <label>Title</label>
                                <input type="text" name="title" required="required" class="inp auto-width"/>

<%--                                <label>Due date</label>--%>
<%--                                <input type="date" name="dueDate" required="required" class="inp auto-width"/>--%>

                                <label>Description</label>
                                <input type="text" name="description" class="inp auto-width"/>

                                <input type="hidden" name="userName" value="${user.username}"/>

                                <button id="addTodo" type="submit" class="btn auto-width" style="margin-bottom: 15px">
                                    Create todo
                                </button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="panel panel-primary custom-panel">
            <div class="panel-heading" style="background-color: #0d6112; border: 2px solid #0d6112;">
                <h3>List of TODO's</h3>
            </div>
            <div class="panel-body" style="border: 2px solid grey;">
                <table class="table table-striped" style="margin-bottom: 0px;">
                    <thead>
                    <tr>
                        <th class="custom-th">Status</th>
                        <th class="custom-th">Title</th>
                        <th class="custom-th">Description</th>
                        <th class="custom-th">Last Change</th>
<%--                        <th class="custom-th">Due Date</th>--%>
                        <th class="custom-th">Remove</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${todoList}" var="todo">
                        <tr>
                            <td>
                                <input type="checkbox"
                                       onclick="location.href='<c:url value="/todo/updateTodo/${todo.id}"/>'"
                                       <c:if test="${todo.todoStatus == 'DONE'}">checked="checked"</c:if>/>
                            </td>
                            <td>${todo.title}</td>
                            <td>${todo.description}</td>
                            <td>
                                <fmt:formatDate value="${todo.lastChange}" type="date" pattern="dd MMM HH:mm"/>
                            </td>
<%--                            <td>--%>
<%--                                ${todo.dueDate}--%>
<%--                            </td>--%>
                            <td>
                                <button type="button" class="btn todo-btns todo-h"
                                        onclick="location.href='<c:url value="/todo/delete-by-id/${todo.id}"/>'">X
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>

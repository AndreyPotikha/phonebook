<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 25.03.18
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }

        .row.content {
            height: 450px
        }

        footer {
            background-color: #555;
            color: white;
            padding: 15px;
        }

        @media screen and (max-width: 767px) {
            .row.content {
                height: auto;
            }
        }
    </style>
    <title>All contacts</title>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath}/main">Info</a></li>
                <li class="active"><a
                        href="${pageContext.request.contextPath}/contacts/all_contacts?email=${user.email}">All
                    contacts</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/users/log_out"><span
                        class="glyphicon glyphicon-log-in"></span> Log out</a></li>
            </ul>
        </div>
    </div>
</nav>
<br/>

<div class="container">
    <form method="get" action="${pageContext.request.contextPath}/contacts/filter_contacts">
        <input type="hidden" name="userEmail" value="${user.email}"/>
    <h2>Enter name or surname of phone into line:</h2>
    <div class="col-md-2">
        <input type="text" name="filterName" placeholder="Name, surname, number"/>
        <button type="submit" name="filter" class="btn btn-info">Filer</button>
        </div>
        </form>
    </div>

    <br/>
    <br/>
    <br/>
    <div class="container">
        <c:forEach items="${get_all_contacts}" var="elem">
            <form method="get" action="${pageContext.request.contextPath}/contacts/update_contacts">
                <div class="col-md-2">
                    <input type="hidden" name="userEmail" value="${user.email}"/>
                    <input type="hidden" name="id" value="${elem.id}"/>
                    <label>
                        <input type="text" name="name" value="${elem.name}" class="form-control input-lg"/>
                    </label>
                    <label>
                        <input type="text" name="surname" value="${elem.surname}" class="form-control input-lg"/>
                    </label>
                    <label>
                        <input type="text" name="patronymic" value="${elem.patronymic}" class="form-control input-lg"/>
                    </label>
                    <label>
                        <input type="text" name="phoneNumber" value="${elem.phoneNumber}"
                               class="form-control input-lg"/>
                    </label>
                    <label>
                        <input type="email" name="email" value="${elem.email}" class="form-control input-lg"/>
                    </label>
                    <button type="submit" name="go" class="btn btn-info">Update</button>
                    <a href="${pageContext.request.contextPath}/contacts/del_contacts?id=${elem.id}" name="delete"
                       id="delete" class="btn btn-info">Delete</a>
                    <hr/>
                </div>
            </form>
        </c:forEach>
    </div>

</div>
</body>
</html>

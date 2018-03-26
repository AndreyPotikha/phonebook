<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 25.03.18
  Time: 2:21
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
    <title>New contacts</title>
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
                <li class="active"><a href="${pageContext.request.contextPath}/contacts/all_contacts?email=${user.email}">All contacts</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/users/log_out"><span class="glyphicon glyphicon-log-in"></span> Log out</a></li>
            </ul>
        </div>
    </div>
</nav>
<br/>

<form method="post" action="${pageContext.request.contextPath}/contacts/add_contacts">
<input type="hidden" name="userEmail" value="${user.email}"/>
<input type="text" name="name" placeholder="Name" required class="form-control input-lg"/>
<input type="text" name="surname" placeholder="Surname" required class="form-control input-lg"/>
<input type="text" name="patronymic" placeholder="Patronymic" required class="form-control input-lg"/>
<input type="text" name="phoneNumber" placeholder="Phone number" required class="form-control input-lg"/>
<input type="email" name="email" placeholder="Email" required class="form-control input-lg"/>
<button type="submit" name="go" class="btn btn-lg btn-primary btn-block">Save</button>
</form>
</body>
</html>

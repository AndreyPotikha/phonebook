<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 24.03.18
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
    <link rel="stylesheet" href="css/main.css">
</head>
<body>

<div class="container">

    <div class="row" id="pwd-container">
        <div class="col-md-4"></div>

        <div class="col-md-4">
            <section class="login-form">
                <form method="post" action="${pageContext.request.contextPath}/users/new_user">
                    <input type="email" name="email" placeholder="Email" required class="form-control input-lg"/>
                    <input type="password" name="password" class="form-control input-lg" id="password" placeholder="Password"/>

                    <div class="pwstrength_viewport_progress"></div>

                    <button type="submit" name="go" class="btn btn-lg btn-primary btn-block">Sign Up</button>

                </form>

            </section>
        </div>

        <div class="col-md-4"></div>

    </div>

</div>

</body>
</html>


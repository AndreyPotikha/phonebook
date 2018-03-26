<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
    <link rel="stylesheet" href="css/main.css">
</head>
<body>

<div class="container">

    <div class="row" id="pwd-container">
        <div class="col-md-4"></div>

        <div class="col-md-4">
            <section class="login-form">
                <form method="get" action="/users/login">
                    <input type="email" name="email" placeholder="Email" required class="form-control input-lg"/>
                    <input type="password" name="password" class="form-control input-lg" id="password" placeholder="Password"/>

                    <div class="pwstrength_viewport_progress"></div>

                    <button type="submit" name="go" class="btn btn-lg btn-primary btn-block">Sign in</button>
                    <div>
                        <a href="/new_registration">Create account</a>
                    </div>

                </form>

            </section>
        </div>

        <div class="col-md-4"></div>

    </div>

</div>

</body>
</html>

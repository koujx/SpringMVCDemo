<%--
  Created by IntelliJ IDEA.
  User: KouJiaxing
  Date: 2017-7-24
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Bootstrap</title>

    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet" />

</head>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Spring MVC + Bootstrap</a>
        </div>
    </div>
</nav>

<div class="jumbotron">
    <div class="container">
        <h1>${title}</h1>
        <p>
            <c:if test="${not empty name}">
                Hello ${name}
            </c:if>

            <c:if test="${empty name}">
                Welcome ThinkingInGIS !
            </c:if>
        </p>
        <p>
            <a class="btn btn-primary btn-lg" href="#" role="button">Maps Talk</a>
        </p>
    </div>
</div>

<div class="container">

    <div class="row">
        <div class="col-md-4">
            <h2>Maps</h2>
            <p>maps</p>
            <p>
                <a class="btn btn-default" href="#" role="button">Maps</a>
            </p>
        </div>
        <div class="col-md-4">
            <h2>can</h2>
            <p>can</p>
            <p>
                <a class="btn btn-default" href="#" role="button">can</a>
            </p>
        </div>
        <div class="col-md-4">
            <h2>Talk</h2>
            <p>Talk</p>
            <p>
                <a class="btn btn-default" href="#" role="button">Talk</a>
            </p>
        </div>
    </div>

    <hr>
    <footer>
        <p>© ThinkingInGIS 2016</p>
    </footer>
</div>

<!--引入jquery脚本-->
<script src="/bootstrap/js/jquery-2.2.4.js" type="text/javascript"></script>
<!--引入bootstrap脚本-->
<script src="/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>


</body>
</html>

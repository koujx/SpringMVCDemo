<!DOCTYPE html>
<!-- saved from url=(0045)http://localhost:8080/SpringMVCDemo/admin/api -->
<html lang="zh-CN"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>配置api信息</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="./配置api信息_files/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <h1>api配置页面</h1>
    <hr>
    <form id="user" role="form" action="http://localhost:8080/SpringMVCDemo/admin/users/addP" method="post">
        <div class="form-group">
            <label for="nickName">域名（IP）</label>
            <input type="text" class="form-control" id="nickname" name="nickname" placeholder="Enter Nickname:">
        </div>
        <div class="form-group">
            <label for="firstName">url</label>
            <input type="text" class="form-control" id="firstName" name="firstName" placeholder="Enter FirstName:">
        </div>
        <div class="form-group">
            <label for="lastName">app_key</label>
            <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Enter LastName:">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">提交</button>
        </div>
    </form>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="./配置api信息_files/jquery.min.js.下载"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="./配置api信息_files/bootstrap.min.js.下载"></script>


</body></html>
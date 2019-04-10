<%--
  Created by IntelliJ IDEA.
  User: sysadmin
  Date: 01.04.2019
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>UserMainPage</title>
    <link rel="stylesheet" href="http://localhost:8080/css/style.css">
</head>
<body>
<div class="picture">
    <p><img src="http://localhost:8080/images/picture.png" width="230" alt="Тут должен быть рисунок"></p>
</div>
<div class="refPage" align="center">
    <p style="font-size: 110%">Добро пожаловать, <span style="color: green;">${username}!</span></p>

    <p><a href="/user/select-topic-and-test" class="text">Выбор темы и теста</a></p>
    <p><a  class="text">Личная статистика</a></p>

    <form action="/logout" method="post" >
        <input type="submit" class="logout" value="Выйти" />
    </form>
</div>
</body>
</html>

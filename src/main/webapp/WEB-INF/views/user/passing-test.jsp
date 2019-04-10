<%--
  Created by IntelliJ IDEA.
  User: sysadmin
  Date: 03.04.2019
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <input type="text"  required list="questions" placeholder="Вопросы">

    <datalist id="questions" >
        <c:forEach var="question" items="${allQuestionsById}">
            <option>${question.description}</option>
        </c:forEach>
    </datalist>

    <br><br>
    <input type="text" value="Вопрос_1" />
    <br><br><br>
    <input type="text" value="Ответ_1" />
    <br>
    <input type="text" value="Ответ_2" />
    <br>
    <input type="text" value="Ответ_3" />
    <br>
    <input type="text" value="Ответ_4" />
</div>
</body>
</html>
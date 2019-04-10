<%--
  Created by IntelliJ IDEA.
  User: sysadmin
  Date: 01.04.2019
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SelectTest</title>
    <link rel="stylesheet" href="http://localhost:8080/css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <script src="http://localhost:8080/scripts/SelectTest.js"></script>
</head>
<body>
<div class="picture">
    <p><img src="http://localhost:8080/images/picture.png" width="230" alt="Тут должен быть рисунок"></p>
</div>
<div class="refPage" align="center">



        <input type="text"  required list="topics" placeholder="Выберите тему" id="topic" name="topic" autocomplete="off">

        <datalist id="topics" >
            <c:forEach var="topic" items="${topics}">
                <option>${topic.description}</option>
            </c:forEach>
        </datalist>
        <br>
    <form method="get" action="passing-test?testId=${testId}">
        <div class="tests"></div>

        <input type="submit" value="Пройти тест" />
    </form>

</div>
</body>
</html>
<script>
    function questionsToSelect(){
        var questionsArray = ${questions};
        var questionDescription = '';
        for (var j = 0; j < questionsArray.length; j++) {
            questionDescription += '<option>'+questionsArray[j].description +'</option>';
        }
        return questionDescription;
    }
</script>
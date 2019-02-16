<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.testingSystem.model.services.QuestionStatisticService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question Info</title>
</head>
<body>
    <c:forEach items="${list}" var="element">
        ${element} <br/>
    </c:forEach>
</body>
</html>

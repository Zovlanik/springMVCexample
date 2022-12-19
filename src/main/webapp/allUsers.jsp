<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8"/>
<title> All Users </title>
</head>

<body>
<h1> All Users: </h1>
<c:forEach items="${usersList}" var="user">
    ID: ${user.id} <br> Name: ${user.name}
    <hr>

</c:forEach>


</body>
</html>
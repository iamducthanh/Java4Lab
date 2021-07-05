<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<div class="input-group flex-nowrap">
    <c:if test="${name == null}">
        <form action="lab1" method="post">
            <br/>
            <input name="name" type="text" class="form-control" style="width: 400px" placeholder="Name" aria-label="Username" aria-describedby="addon-wrapping">
            <br/>
            <button type="submit" class="btn btn-warning">Chào đi</button>
        </form>
    </c:if>

    <c:if test="${name != null}">
        <h2>Xin chào: ${name}</h2>
    </c:if>
</div>
</body>
</html>

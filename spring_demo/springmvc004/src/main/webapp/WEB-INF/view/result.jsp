<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
name:${requestScope.name} <br>
age:${age} <br>
sex:${sex} <br>
address:${address} <br>


商品类型：
<select>
    <c:forEach items="${types}" var="type">
        <option value="">${type}</option>
    </c:forEach>
</select>
</body>
</html>

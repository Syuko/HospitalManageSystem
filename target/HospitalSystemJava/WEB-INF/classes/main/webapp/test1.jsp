<%--
  Created by IntelliJ IDEA.
  User: sushu
  Date: 2021/3/30
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored= "false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<c:forEach items="${prescribeList}" var="nd">
    <tr>
        <th scope="row">${nd.nurse.nurseId}</th>
        <td>${nd.nurse.nurseName}</td>
        <td>${nd.drug.drugName}</td>
        <td>${nd.ndNum}</td>
        <td>${nd.ndTime}</td>
    </tr>
</c:forEach>


</body>
</html>

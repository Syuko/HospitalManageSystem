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
<table>
    <c:forEach items="${prescribeList}" var="p">
        <tr>
            <th scope="row">${p.drug.drugId}</th>
            <td>${p.drug.drugName}</td>
            <td>${p.drug.drugType}</td>
            <td>${p.drug.drugPrice}</td>
            <td>${p.drug.drugRate}</td>
            <td style="color: orangered"><strong>${p.total}</strong></td>
        </tr>
    </c:forEach>
</table>



</body>
</html>

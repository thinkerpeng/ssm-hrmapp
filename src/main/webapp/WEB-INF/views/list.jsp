<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>BookList</title>
</head>
<body>
<h2>BookList</h2>
<table width="400" border="1" cellspacing="0" cellpadding="0">
    <tr><td>编号</td><td>书名</td><td>馆藏数量</td></tr>
    <c:forEach items="${requestScope.bookList}" var="book">
        <tr>
            <td>${book.bookId}</td><td>${book.name}</td><td>${book.number}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

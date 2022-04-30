<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>
<h2>
    Book List
</h2>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Isbn</th>
        <th>Title</th>
        <th>Author</th>
        <th>Publisher</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${books}" var="book">
            <tr>
            <td>${book.id}</td>
            <td>${book.isbn}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.publisher}</td>
            <td></td>
            </tr>
        </c:forEach>

    </tr>
    </tbody>
</table>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
              crossorigin="anonymous">
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <title>Форум job4j</title>
    </head>
</head>
<body>
<div class="container-fluid">
    <div class="alert alert-success" role="alert">
        <a href="<c:url value="/"/>">Main page</a>
        <div class="text-right">
            <a href="<c:url value='/logout'/>">Username :
                ${username} | Logout</a>
        </div>
    </div>
    <table class="table table-bordered">
        <tr class="table-primary">
            <td class="font-weight-bold">Topic name: ${topic.name}</td>
        </tr>
        <tr class="table-info">
            <td class="font-italic">Topic description: ${topic.description}</td>
        </tr>
        <tr class="table-info">
            <td class="font-italic">Topic creator: ${topic.author.username}</td>
        </tr>
        <tr>
            <table class="table table-bordered table-hover">
                <c:forEach items="${topic.messages}" var="message">
                    <tr>
                        <td style="width: 15%"><p
                                class="font-weight-bolder">Author:</p>
                                ${message.author.username}</td>
                        <td class="font-weight-normal"
                            style="word-break: break-all; width: 70%">${message.text}</td>
                        <td style="width: 15%">
                            <p class="font-weight-bolder">Created:</p> <fmt:formatDate
                                value="${message.created}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </tr>
    </table>

    <form action="/create_message" method="post">
        <input type="hidden" name="id" value="${topic.id}">
        <input type="hidden" name="username" value="${username}">
        <div class="form-group">
            <label for="text">Enter message:</label>
            <textarea class="form-control" id="text" name="text" rows="3"></textarea>
        </div>
        <input type="submit" class="btn btn-primary" value="Send">
    </form>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">

    <title>Форум job4j</title>
</head>
<body>

<div class="container mt-3">
    <div class="alert alert-success" role="alert">
        <a href="<c:url value="/"/>">Main page</a>
        <div class="text-right">
            <a href="<c:url value='/logout'/>">Username :
                ${username} | Logout</a>
        </div>
    </div>
    <div class="row">
        <h4>
            <c:if test="${topic != null}">
                Edit existing topic
            </c:if>

            <c:if test="${topic == null}">
                Create new topic
            </c:if>
        </h4>
    </div>
    <form action="<c:url value='/save'/>" method='POST'>
        <c:if test="${topic != null}">
            <input type="hidden" name="id" value="${topic.id}">
        </c:if>
        <input type="hidden" name="username" value="${username}">
        <div class="form-group">
            <label for="topicName">Topic name:</label>
            <input type="text" class="form-control" name="name" id="topicName"
                   placeholder="Enter topic name" value="${topic.name}">
        </div>
        <div class="form-group">
            <label for="topicDesc">Topic description:</label>
            <input type="text" class="form-control" name="description" id="topicDesc"
                   placeholder="Enter topic description" value="${topic.description}">
        </div>
        <c:if test="${topic == null}">
            <div class="form-group">
                <label for="text">Enter message:</label>
                <textarea class="form-control" id="text" name="text" rows="5"></textarea>
            </div>
        </c:if>
        <input type="submit" class="btn btn-primary" value="Save"/>
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
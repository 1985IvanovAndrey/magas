<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
            crossorigin="anonymous"></script>
    <title>Title</title>
</head>
<body>

<h4>Print birds in magazine</h4>
<br>
<form action="magazine/getBirdByType">
    <div class="form group">
        <div class="col-6">
            <select name="type">
                <option>duck</option>
                <option>eagl</option>
                <option>parrot</option>
            </select>
            <input class=" btn btn-outline-primary btn-sm" type="submit" value="Select bird">
        </div>
    </div>
</form>
<c:if test="${!empty birdList}">
<h4>Show birds</h4>
<div class="row">
    <div class="col-6">
        <div class="table-responsive-sm">
            <table class="table table-sm table-bordered">
                <thead>
                <tr align="center" class="table-active">
                    <th>Type</th>
                    <th>Weight</th>
                    <th>Price</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${birdList}" var="bird">
                    <tr align="center">
                        <td>${bird.type}</td>
                        <td>${bird.weight}</td>
                        <td>${bird.pricePerUnit}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </c:if>
        </div>
    </div>
</div>
<h4>${comment}</h4>
</body>
</html>

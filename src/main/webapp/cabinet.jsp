<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Cabinet</title>
    <style>
        .container {
            width: 80%;
            max-width: 800px;
            background-color: white;
            margin-top: 20px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        h3 {
            border-bottom: 2px solid #007BFF;
            padding-bottom: 10px;
            margin-bottom: 20px;
        }

        form {
            display: flex;
            flex-direction: column;
            margin-bottom: 20px;
        }

        input[type="text"], select {
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 1em;
        }

        input[type="submit"] {
            padding: 10px;
            background-color: #007BFF;
            border: none;
            border-radius: 4px;
            color: white;
            font-size: 1em;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        ul li {
            background-color: #f9f9f9;
            padding: 10px;
            margin: 5px 0;
            border-radius: 4px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <jsp:include page="header.jsp" />

    <div class="container">
        <form style="${sessionScope.displayStyle}" action="cabinet" method="post">
            <input type="text" name="magazineName" placeholder="Enter magazine name" required>
            <input type="submit" value="Add">
        </form>

        <c:if test="${not empty magazineList}">
            <h3>Magazines List:</h3>
            <ul>
                <c:forEach var="magazine" items="${magazineList}">
                    <li>
                        ${magazine}
                        <form action="addToShop" method="post" style="display:inline;">
                            <input type="hidden" name="magazineName" value="${magazine}">
                            <input type="submit" style="${sessionScope.displayStyle}" value="Add to Shop">
                        </form>
                    </li>
                </c:forEach>
            </ul>
        </c:if>

        <form style="${sessionScope.displayStyle}" action="redactMagazine" method="post">
            <p>
                <label for="shopMagazine">Select Magazine:</label>
                <select id="shopMagazine" name="magazineName">
                    <c:forEach var="magazine" items="${magazineList}">
                        <option value="${magazine}">${magazine}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="Redact">
            </p>
        </form>

        <form action="reload" method="post">
            <input type="submit" value="Reload">
        </form>
    </div>

    <jsp:include page="footer.jsp" />
</body>
</html>

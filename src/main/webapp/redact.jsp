<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Shop - Selected Magazine</title>
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

        h2 {
            border-bottom: 2px solid #007BFF;
            padding-bottom: 10px;
            margin-bottom: 20px;
        }

        form {
            display: flex;
            flex-direction: column;
            margin-bottom: 20px;
        }

        textarea {
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 1em;
            resize: vertical;
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

        a {
            text-decoration: none;
            color: #007BFF;
            transition: color 0.3s ease;
        }

        a:hover {
            color: #0056b3;
        }
    </style>
</head>
<body>
    <jsp:include page="header.jsp" />

    <div class="container">
        <h2>Selected Magazine</h2>
        <c:choose>
            <c:when test="${not empty sessionScope.selectedMagazine}">
                <p>You have chosen: <strong>${sessionScope.selectedMagazine.nameMagazine}</strong></p>
                <form action="redactMagazine" method="post">
                    <input type="hidden" name="magazineName" value="${sessionScope.selectedMagazine.nameMagazine}">
                    <label for="magazineText">Enter magazine text:</label>
                    <textarea id="magazineText" name="magazineText" rows="5" cols="30" required>${sessionScope.selectedMagazine.textMagazine}</textarea><br>
                    <input type="submit" value="Save">
                </form>
            </c:when>
        </c:choose>
        <br>
        <a href="cabinet">Back to Cabinet</a>
    </div>

    <jsp:include page="footer.jsp" />
</body>
</html>
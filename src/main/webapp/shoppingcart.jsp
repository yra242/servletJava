<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Shopping Cart</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 80%;
            max-width: 800px;
            background-color: white;
            margin: 50px auto;
            padding: 20px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        h3 {
            border-bottom: 3px solid #007BFF;
            padding-bottom: 10px;
            margin-bottom: 20px;
            color: #333;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        ul li {
            background-color: #f9f9f9;
            padding: 15px;
            margin: 10px 0;
            border-radius: 6px;
            box-shadow: 0 0 8px rgba(0, 0, 0, 0.05);
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .remove-button {
            padding: 8px 12px;
            background-color: #dc3545;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 0.9em;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .remove-button:hover {
            background-color: #c82333;
        }

        .empty-cart {
            color: #777;
            font-style: italic;
        }
    </style>
</head>
<body>
    <jsp:include page="header.jsp" />

    <div class="container">
        <h3>Your Shopping Cart</h3>
        <c:if test="${not empty shopList}">
            <ul>
                <c:forEach var="magazine" items="${shopList}">
                    <li>
                        <span>${magazine}</span>
                        <!-- Remove button -->
                        <form action="removeFromCart" method="post" style="display:inline;">
                            <input type="hidden" name="magazineName" value="${magazine}" />
                            <button type="submit" class="remove-button">Remove</button>
                        </form>
                    </li>
                </c:forEach>
            </ul>
        </c:if>

        <c:if test="${empty shopList}">
            <p class="empty-cart">Your shopping cart is empty.</p>
        </c:if>
    </div>

    <jsp:include page="footer.jsp" />
</body>
</html>

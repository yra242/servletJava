<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <!-- Login Modal -->
    <div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="loginModalLabel">Login</h5>
                    <!-- Close (X) button with redirect -->
                    <button type="button" class="close" onclick="window.location.href='index.jsp';" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <!-- Login form inside the modal -->
                    <form id="loginForm" action="login" method="post">
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" id="email" name="email" placeholder="Enter email" required>
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
                        </div>
                        <div id="loginError" class="text-danger"></div>
                    </form>
                </div>
                <div class="modal-footer">
                    <!-- Cancel button with redirect -->
                    <button type="button" class="btn btn-secondary" onclick="window.location.href='index.jsp';">Cancel</button>
                    <button type="button" class="btn btn-primary" onclick="submitLogin()">Login</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Include Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <!-- Script to automatically open the modal -->
    <script>
        $(document).ready(function(){
            $('#loginModal').modal('show');
        });

        function submitLogin() {
            // Clear previous error messages
            document.getElementById('loginError').innerHTML = '';

            // Get form data
            const email = document.getElementById('email').value;
            const password = document.getElementById('password').value;

            // Create an XMLHttpRequest object
            const xhr = new XMLHttpRequest();
            xhr.open("POST", "login", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

            // Handle the response from the server
            xhr.onreadystatechange = function() {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.status === 200) {
                        // Successful login - redirect or update UI
                        window.location.href = "cabinet.jsp";
                    } else if (xhr.status === 401) {
                        // Unauthorized - Display specific error message
                        document.getElementById('loginError').innerHTML = 'Email or password incorrect';
                    } else {
                        // Handle other HTTP errors or server issues
                        document.getElementById('loginError').innerHTML = 'An unexpected error occurred. Please try again.';
                    }
                }
            };

            // Send the request with form data
            xhr.send("email=" + encodeURIComponent(email) + "&password=" + encodeURIComponent(password));
        }
    </script>
</body>
</html>

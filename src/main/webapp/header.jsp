<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/header_style.css">
</head>
<style>
    .headd {
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 10px 50px;
        background-color: #ffffff; /* Adjust as needed */
        color: #fff; /* Adjust text color as needed */
    }

    .headd img {
        width: 36px; /* Adjust image width as needed */
        height: auto; /* Maintain aspect ratio */
        margin-right: 10px;
    }

    .headd a {
        text-decoration: none;
        color: #fff; /* Adjust link color as needed */
        margin-left: 10px; /* Adjust spacing between links as needed */
    }

    .headd a:hover {
        text-decoration: underline;
    }
.text{
    color: #0f121c;
    font-family: "Berlin Sans FB";
}
</style>
<body>
<header class="headd">
    <div>
        <p class="text">Welcome Student Registration</p>
    </div>
    <form action="LogoutServlet" method="get">
        <input class="uil uil-navigator" type="submit" value="Logout" >
    </form>
</header>

</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--=== Coding by CodingLab | www.codinglabweb.com === -->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/from.css">

    <title>Responsive Regisration Form </title>
</head>
<style>
    .body{
        background-color: #0f121c;
    }
</style>
<body>
<%@include file="header.jsp"%>
<%--<jsp:include page="header.jsp"/>--%>
<div class="container">
    <div class="header2"><img src="images/view2.png" alt=""> <%=request.getParameter("user")%></div>
    <div class="header1">Registration Form</div>
    <form action="Controller.SubmissionServlet" method="post">
        <div class="form first">
            <div class="details address">
                <span class="title">Details</span>

                <div class="fields">
                    <div class="input-field">
                        <label>Student ID</label>
                        <input type="number" name="studentID" placeholder=" Enter Student ID" required>
                    </div>
                    <div class="input-field">
                        <label>Full Name</label>
                        <input type="text" name="fullName" placeholder="Enter Full Name" required>
                    </div>

                    <div class="input-field">
                        <label>Gender</label>
                        <select required>
                            <option disabled selected>Select gender</option>
                            <option>Male</option>
                            <option>Female</option>
                            <option>Others</option>
                        </select>
                    </div>

                    <div class="input-field">
                        <label>Phone Number</label>
                        <input type="number" value="phoneNumber" placeholder="Enter Phone number" required>
                    </div>

                    <div class="input-field">
                        <label>Faculty</label>
                        <select required>
                            <option disabled selected>Select Faculty</option>
                            <option>Faculty of Business Administration</option>
                            <option>Faculty of Information Technology</option>
                            <option>Faculty of Health Science </option>
                            <option>Faculty of Education </option>
                        </select>
                    </div>

                    <div class="input-field">
                        <label>Course</label>
                        <input type="Text" value="course" placeholder=" Enter Course" required>
                    </div>
                </div>

            </div>

            <form action="upload.php" method="post" enctype="multipart/form-data">
                <!-- Other form fields -->
                <div class="input-field">
                <label>Passport</label>
                <input type="file" name="passport_picture" accept=".jpg, .png" required>
                </div>
                <div class="input-field">
                <label>Certificate</label>
                <input type="file" name="certificate" accept=".pdf" placeholder="Certificate" required>
                </div>

                <div class="buttons">
                    <button class="sumbit" type="submit">
                        <span class="btnText" >Submit</span>
                        <i class="uil uil-navigator"></i>
                    </button>
                </div>
            </form>
            </div>

        </div>
    </form>
</div>

<%--<script src="script/script.js"></script>--%>
</body>
</html>
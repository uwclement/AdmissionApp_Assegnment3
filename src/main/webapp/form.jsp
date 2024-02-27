
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
    /* ===== Google Font Import - Poppins ===== */
    @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600&display=swap');
    *{
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Poppins', sans-serif;
    }
    body{
        min-height: 100vh;
        display: block;
        align-items: center;
        justify-content: center;
        background-color: #0f121c;
    }
    .container{
        position: relative;
        max-width: 1000px;
        width: 100%;
        overflow: hidden;
        max-height: 700px;
        border-radius: 6px;
        padding: 70px;
        margin: 40px 130px;
        background-color: #fff;
        box-shadow: 0 5px 10px rgba(0,0,0,0.1);

    }
    .header3{
        position: relative;
        font-size: 20px;
        font-weight: 600;
        color: #333;
    }
    .header1{
        position: relative;
        font-size: 20px;
        font-weight: 600;
        color: #333;
        margin-left: 350px;
    }
    .size{
        max-width: 20px;
    }
    .header2{
        position: relative;
        font-size: 20px;
        font-weight: 600;
        color: #333;
        margin-left: 600px;
    }

    .container form{
        position: relative;
        margin-top: 10px;
        min-height: 490px;
        background-color: #fff;
        overflow: hidden;
    }
    .container form .form{
        position: absolute;
        background-color: #fff;
        transition: 0.3s ease;
    }
    .container form .form.second{
        opacity: 0;
        pointer-events: none;
        transform: translateX(100%);
    }
    form.secActive .form.second{
        opacity: 1;
        pointer-events: auto;
        transform: translateX(0);
    }
    form.secActive .form.first{
        opacity: 0;
        pointer-events: none;
        transform: translateX(-100%);
    }
    .container form .title{
        display: block;
        margin-bottom: 8px;
        font-size: 16px;
        font-weight: 500;
        margin: 6px 0;
        color: #333;
    }
    .container form .fields{
        display: flex;
        align-items: center;
        justify-content: space-between;
        flex-wrap: wrap;
    }
    form .fields .input-field{
        display: flex;
        width: calc(100% / 3 - 15px);
        flex-direction: column;
        margin: 4px 0;
    }
    .input-field label{
        font-size: 12px;
        font-weight: 500;
        color: #2e2e2e;
    }
    .input-field input, select{
        outline: none;
        font-size: 14px;
        font-weight: 400;
        color: #333;
        border-radius: 5px;
        border: 1px solid #aaa;
        padding: 0 15px;
        height: 42px;
        margin: 8px 0;
    }
    .input-field input :focus,
    .input-field select:focus{
        box-shadow: 0 3px 6px rgba(0,0,0,0.13);
    }
    .input-field select,
    .input-field input[type="date"]{
        color: #707070;
    }
    .input-field input[type="date"]:valid{
        color: #333;
    }
    .container form button, .backBtn{
        display: flex;
        align-items: center;
        justify-content: center;
        height: 45px;
        max-width: 200px;
        width: 100%;
        border: none;
        outline: none;
        color: #fff;
        border-radius: 5px;
        margin: 25px 0;
        box-shadow: 0px 0px 0px 0px;
        background: rgba(87,184,70, 0.8);;
        transition: all 0.3s linear;
        cursor: pointer;
    }
    .container form .btnText{
        font-size: 14px;
        font-weight: 400;
    }
    form button:hover{
        background-color: #1a8f13;
    }
    form button i,
    form .backBtn i{
        margin: 0 6px;
    }
    form .backBtn i{
        transform: rotate(180deg);
    }
    form .buttons{
        display: flex;
        align-items: center;
    }
    form .buttons button , .backBtn{
        margin-right: 14px;
    }

    @media (max-width: 750px) {
        .container form{
            overflow-y: scroll;
        }
        .container form::-webkit-scrollbar{
            display: none;
        }
        form .fields .input-field{
            width: calc(100% / 2 - 15px);
        }
    }

    @media (max-width: 550px) {
        form .fields .input-field{
            width: 100%;
        }
    }



    /* Header styles */

    .headd {
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 10px 50px;
        background-color: #ffffff; /* Adjust as needed */
        color: #fff; /* Adjust text color as needed */
    }


</style>
<body>
<%@include file="header.jsp"%>
<div class="container">
    <div class="header2"><img src="images/view2.png" alt=""><%=request.getParameter("user")%></div>
    <div class="header1">Registration Form</div>
    <form action="Controller.SubmissionServlet" method="get">
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
                        <select required name="gender">
                            <option disabled selected>Select gender</option>
                            <option>Male</option>
                            <option>Female</option>
                            <option>Others</option>
                        </select>
                    </div>

                    <div class="input-field">
                        <label>Phone Number</label>
                        <input type="number" value="phoneNumber" name="phone" placeholder="Enter Phone number" required>
                    </div>

                    <div class="input-field">
                        <label>Faculty</label>
                        <select required name="faculty">
                            <option disabled selected>Select Faculty</option>
                            <option>Faculty of Business Administration</option>
                            <option>Faculty of Information Technology</option>
                            <option>Faculty of Health Science </option>
                            <option>Faculty of Education </option>
                        </select>
                    </div>

                    <div class="input-field">
                        <label>Course</label>
                        <input type="Text"  name="course" placeholder=" Enter Course" required>
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
            <form action="Controller.SubmissionServlet" method="post" id="initForm">
                <input type="hidden" name="init" value="true">
            </form>
            <script>
                document.getElementById('initForm').submit();
            </script>
            </div>


    </form>
</div>

<%--<script src="script/script.js"></script>--%>
</body>
</html>
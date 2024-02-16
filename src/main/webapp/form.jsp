
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
<body>
<%--<%@include file="header.jsp"%>--%>
<jsp:include page="header.jsp"/>
<div class="container">

    <div class="header2"><img src="images/view2.png" alt="">$$$</div>
    <div class="header1">Registration Form</div>
    <div class="header3" >Register</div>
    <form action="#">
<%--        <div class="form first">--%>


        <div class="form first">
            <div class="details address">
                <span class="title">Address Details</span>

                <div class="fields">
                    <div class="input-field">
                        <label>Address Type</label>
                        <input type="text" placeholder="Permanent or Temporary" required>
                    </div>

                    <div class="input-field">
                        <label>Nationality</label>
                        <input type="text" placeholder="Enter nationality" required>
                    </div>

                    <div class="input-field">
                        <label>State</label>
                        <input type="text" placeholder="Enter your state" required>
                    </div>

                    <div class="input-field">
                        <label>District</label>
                        <input type="text" placeholder="Enter your district" required>
                    </div>

                    <div class="input-field">
                        <label>Block Number</label>
                        <input type="number" placeholder="Enter block number" required>
                    </div>

                    <div class="input-field">
                        <label>Ward Number</label>
                        <input type="number" placeholder="Enter ward number" required>
                    </div>
                </div>
            </div>

            <div class="details family">
                <span class="title">Family Details</span>

                <div class="fields">
                    <div class="input-field">
                        <label>Father Name</label>
                        <input type="text" placeholder="Enter father name" required>
                    </div>

                    <div class="input-field">
                        <label>Mother Name</label>
                        <input type="text" placeholder="Enter mother name" required>
                    </div>

                    <div class="input-field">
                        <label>Grandfather</label>
                        <input type="text" placeholder="Enter grandfther name" required>
                    </div>

                    <div class="input-field">
                        <label>Spouse Name</label>
                        <input type="text" placeholder="Enter spouse name" required>
                    </div>

                    <div class="input-field">
                        <label>Father in Law</label>
                        <input type="text" placeholder="Father in law name" required>
                    </div>

                    <div class="input-field">
                        <label>Mother in Law</label>
                        <input type="text" placeholder="Mother in law name" required>
                    </div>
                </div>

                <div class="buttons">
                    <div class="backBtn">
                        <i class="uil uil-navigator" ></i>
                        <span class="btnText" >Back</span>
                    </div>

                    <button class="sumbit">
                        <span class="btnText">Submit</span>
                        <i class="uil uil-navigator"></i>
                    </button>
                </div>
            </div>
        </div>
    </form>
</div>

<%--<script src="script/script.js"></script>--%>
</body>
</html>
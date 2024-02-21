<!DOCTYPE html>
<html>
<head>
    <title>Send Email</title>
</head>
<body>
<h2>Send Email</h2>
<form action="SendEmailServlet" method="post">
    <div>
        <label>To:</label>
        <input type="email" name="to" required>
    </div>
    <div>
        <label>Subject:</label>
        <input type="text" name="subject" required>
    </div>
    <div>
        <label>Body:</label>
        <textarea name="body" rows="5" required></textarea>
    </div>
    <button type="submit">Send Email</button>
</form>
</body>
</html>

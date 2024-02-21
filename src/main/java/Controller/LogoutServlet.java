package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/Controller.LogoutServlet")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String userID = (String) session.getAttribute("email");
        if (session != null) {
            session.invalidate(); // Invalidate the session
        }
        // Redirect to the login page
        response.sendRedirect("Login.jsp");
        ConfEmail.sendEmail(userID, "Logout Notification", "You have successfully logged out.");
    }
}

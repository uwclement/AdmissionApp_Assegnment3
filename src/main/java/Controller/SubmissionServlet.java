package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import static java.lang.System.out;
@WebServlet("/Controller.SubmissionServlet")
public class SubmissionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userID = (String) session.getAttribute("email");

        if (userID != null) {

            out.println("<script>alert('Submitted');</script>");
            ConfEmail.sendEmail(userID, "Submit Notification", "You have successfully Submitted.");
                response.sendRedirect("EmailSent.jsp");
        } else {
            out.println("<script>alert('Not Submitted');</script>");

        }
    }

}
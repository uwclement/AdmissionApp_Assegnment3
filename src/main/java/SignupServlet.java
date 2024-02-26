import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

import static java.lang.System.out;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // get request parameters for userID and password
        String userName = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("passwd");

        if (userName != null && email != null && password != null) {
            Session user = new Session();
            user.setName(userName);
            user.setEmail(email);
            user.setPassword(password);

            HttpSession session = request.getSession();
            Cookie loginCookie = new Cookie("user", userName);
            // setting cookie to expiry in 30 mins
            loginCookie.setMaxAge(30 * 60);
            response.addCookie(loginCookie);

            // Use getter methods to get values
            session.setAttribute("email", user.getEmail());
            session.setAttribute("passwd", user.getPassword());
            session.setAttribute("user", user.getName());

            response.sendRedirect("Login.jsp?email=" + user.getEmail() + "&passwd=" + user.getPassword() + "&user=" + user.getName());
            // Note: It's a good practice to avoid using out.println for script alerts, consider using JavaScript in JSP.
            out.println("<script>alert('User Created');</script>");

        } else {
            response.sendRedirect("signup.jsp.jsp");
            out.println("<script>alert('User not Created');</script>");
        }
    }
}

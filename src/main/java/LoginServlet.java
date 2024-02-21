import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;

/**
 * Servlet implementation class LoginServlet
 */
    @WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;



    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
              String name = (String) session.getAttribute("user");
                String userID = (String) session.getAttribute("email");
                String password = (String) session.getAttribute("passwd");

        // get request parameters for userID and password
        String user = request.getParameter("email");
        String pwd = request.getParameter("password");

        if(userID.equals(user) && password.equals(pwd)){
            Cookie loginCookie = new Cookie("user",user);
            //setting cookie to expiry in 30 mins
            loginCookie.setMaxAge(30*60);
            response.addCookie(loginCookie);
            session.setAttribute("user", user);
            response.sendRedirect("form.jsp?user="+name);

            out.println("<script>alert('Valid Email & Passwd');</script>");
            ConfEmail.sendEmail(userID, "Login Notification", "You have successfully logged in.");

        }else{
            response.sendRedirect("Login.jsp");
            out.println("<font color=red>Either user name or password is wrong.</font>");
            out.println("<script>alert('Invalid Username');</script>");

        }

    }}
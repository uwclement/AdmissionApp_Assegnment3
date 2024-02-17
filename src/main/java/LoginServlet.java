import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
    @WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final String userID = "admin";
    private final String password = "12345";

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        // get request parameters for userID and password
        String user = request.getParameter("email");
        String pwd = request.getParameter("password");

        if(userID.equals(user) && password.equals(pwd)){
            HttpSession session = request.getSession();
            Cookie loginCookie = new Cookie("user",user);
            //setting cookie to expiry in 30 mins
            loginCookie.setMaxAge(30*60);
            response.addCookie(loginCookie);
            session.setAttribute("user", user);
            response.sendRedirect("form.jsp?name=" + user+ loginCookie.getValue());

            out.println("<script>alert('Valid Email & Passwd');</script>");

        }else{
            response.sendRedirect("Login.jsp");
            out.println("<font color=red>Either user name or password is wrong.</font>");
            out.println("<script>alert('Invalid Username');</script>");

        }

    }}
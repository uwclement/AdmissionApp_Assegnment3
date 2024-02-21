package Controller;

import DAO.AccountDao;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import static java.lang.System.out;

/**
 * Servlet implementation class Controller.LoginServlet
 */
    @WebServlet("/Controller.LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private AccountDao accountDao;

    public void init() {

        accountDao = new AccountDao();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String pass = request.getParameter("password");

        User user = new User();
        user.setEmail(email);
        user.setPassword(pass);
        try {
        if (accountDao.validate(user)) {
            HttpSession session = request.getSession();
            Cookie loginCookie = new Cookie("user", email);
            // setting cookie to expiry in 30 mins
            loginCookie.setMaxAge(30 * 60);
            response.addCookie(loginCookie);

            // Use getter methods to get values
            session.setAttribute("email", user.getEmail());
            session.setAttribute("password", user.getPassword());
            session.setAttribute("user", user.getName());
//            session.setAttribute("user", user.getName());
//            response.sendRedirect("form.jsp?user=" + email);

            out.println("<script>alert('Valid Email & Passwd');</script>");
            ConfEmail.sendEmail(email, "Login Notification", "You have successfully logged in.");
            response.sendRedirect("form.jsp?user=" + email);
        } else {
            response.sendRedirect("Login.jsp");
            out.println("<font color=red>Either user name or password is wrong.</font>");
            out.println("<script>alert('Invalid Username');</script>");

        }

    }catch (SQLException ex){
        ex.printStackTrace();
    }
}
    }
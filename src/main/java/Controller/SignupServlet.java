package Controller;

import DAO.AccountDao;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

import static java.lang.System.out;

@WebServlet("/Controller.SignupServlet")
public class SignupServlet extends HttpServlet {

    private AccountDao accountDao;

    public void init() {

        accountDao = new AccountDao();
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("passwd");

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(pass);
        try{
        if (accountDao.Register(user)!=null) {

            response.sendRedirect("Login.jsp?email=" + user.getEmail() + "&passwd=" + user.getPassword() + "&user=" + user.getName());
            out.println("<script>alert('User Created');</script>");

        } else {
            response.sendRedirect("signup.jsp.jsp");
            out.println("<script>alert('User not Created');</script>");
        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

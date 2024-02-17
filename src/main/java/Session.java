import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/Session")
public class Session extends HttpServlet {

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // TODO Auto-generated method stub
        PrintWriter out = response.getWriter();
        out.println("<h1>Welcome to the Servlet.");
        // This will print output on console
        System.out.println("GFGServlet is running");

    }


//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//
//        HashMap<String, String> userDetails = new HashMap<String, String>();
//        userDetails.put("email", email);
//        userDetails.put("password", password);
//
//        // Creating a Session object and storing
//        // HashMap into it
//        HttpSession session = request.getSession();
//        session.setAttribute("user", userDetails);
//        // forwarding request to confirm.jsp page
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/Session.java");
//        dispatcher.forward(request, response);
//
//    }

}

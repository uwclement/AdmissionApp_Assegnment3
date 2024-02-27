package Controller;

import DAO.AccountDao;
import DAO.RegistrationDao;
import Model.Register;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

import static java.lang.System.out;
import static java.lang.System.setOut;

@WebServlet("/Controller.SubmissionServlet")
public class SubmissionServlet extends HttpServlet {

    private RegistrationDao registration;

    public void init() {

        registration = new RegistrationDao();
    }
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userID = (String) session.getAttribute("email");

        String studentIDString = request.getParameter("studentID");
        int studentID = Integer.parseInt(studentIDString);
        String fullName = request.getParameter("fullName");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String faculty = request.getParameter("faculty");
        String course = request.getParameter("course");
        String passport_picture = request.getParameter("passport_picture");
        String certificate = request.getParameter("certificate");

        Register register = new Register();
        register.setStudentId(studentID);
        register.setFullName(fullName);
        register.setPhoneNumber(phone);
        register.setGender(gender);
        register.setFaculty(faculty);
        register.setCourse(course);
        register.setPassportPicture(passport_picture.getBytes());
        register.setCertificate(certificate.getBytes());

        if (registration.registerUser(register)) {

            out.println("<script>alert('Submitted');</script>");
            ConfEmail.sendEmail(userID, "Submit Notification", "You have successfully Submitted.");
                response.sendRedirect("EmailSent.jsp");
        } else {
            out.println("<script>alert('Not Submitted');</script>");

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if ("true".equals(req.getParameter("init"))) {
                HttpSession session = req.getSession();
                String userID = (String) session.getAttribute("email");
                List<Register> registrations = registration.getAllUsers();
                session.setAttribute("registration", registrations);
                out.println("Done selecting");
               resp.sendRedirect("AdminPage.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("An error occurred while initializing registrations: " + e.getMessage());
        }

}}
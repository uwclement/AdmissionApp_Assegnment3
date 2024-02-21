package Controller;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
@WebListener
public class LoginListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Model.User created, do nothing
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Model.User destroyed, send email
        String userEmail = (String) se.getSession().getAttribute("email");
        if (userEmail != null) {
            ConfEmail.sendEmail(userEmail, "Logout Notification", "You have been logged out.");
        }
    }
}

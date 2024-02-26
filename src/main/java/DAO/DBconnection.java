package DAO;

import jakarta.servlet.http.HttpServlet;

public class DBconnection extends HttpServlet {
    private  final String URl ="jdbc:postgresql://localhost/AdmissionDB";
    private  final String username ="postgres";
    private  final String password ="cle111";

    public String getURl() {
        return URl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

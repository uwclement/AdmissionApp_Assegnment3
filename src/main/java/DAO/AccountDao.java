package DAO;
import DAO.DBconnection;
import Model.User;
import java.sql.*;

public class AccountDao {

    public boolean validate(User user) throws SQLException {
        boolean result = false;
         DBconnection con = new DBconnection();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {

            Connection connection = DriverManager.getConnection(con.getURl(), con.getUsername(), con.getPassword());

            PreparedStatement pst = connection.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
            pst.setString(1, user.getEmail());
            pst.setString(2, user.getPassword());

            System.out.println(pst);
            ResultSet rs = pst.executeQuery();
            result = rs.next();
         }catch (SQLException ex){
             printSQLException(ex);
         }


      return result;

    }


    public String Register(User user) throws SQLException {
        DBconnection con = new DBconnection();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {

            Connection connection = DriverManager.getConnection(con.getURl(), con.getUsername(), con.getPassword());

            PreparedStatement pst = connection.prepareStatement("INSERT INTO users (name,email,password) values (?,?,?)");
            pst.setString(1, user.getName());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getPassword());


            System.out.println(pst);
            int rowAffected = pst.executeUpdate();
            if (rowAffected>0){
                return "data saved";
            }else {
                return "data not saved";
            }
        }catch (SQLException ex){
            printSQLException(ex);
        }


        return "server Error";

    }

        private void printSQLException(SQLException ex) {
            for (Throwable e: ex) {
                if (e instanceof SQLException) {
                    e.printStackTrace(System.err);
                    System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                    System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                    System.err.println("Message: " + e.getMessage());
                    Throwable t = ex.getCause();
                    while (t != null) {
                        System.out.println("Cause: " + t);
                        t = t.getCause();
                    }
                }
            }
        }
}

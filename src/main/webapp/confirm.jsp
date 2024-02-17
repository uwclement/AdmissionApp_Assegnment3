<%@ page import = " java.util.* " %>
<%
    String username = request.getParameter("email");
    String passwd = request.getParameter("password");
    if(username.equals("admin") && passwd.equals("12345")){
        session.setAttribute("u_name",username);
        session.setAttribute("u_pass",passwd);
        out.println("<script>window.location='E:\\study\\SEM 7\\Web tech\\Projects\\AdmissionApp_Assegnment3\\src\\main\\webapp\\form.jsp';</script>");
    }else{
        out.println("<script>alert('Invalid Username');</script>");
    }
%>
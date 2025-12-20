import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;

public class signup extends HttpServlet {
    public void doPost(HttpServletRequest req,  HttpServletResponse res) throws ServletExcpetion, IOException{

        String name = req.getParameter("name");

        String password = req.getParameter("password");
        if(email == null || password == null){
            res.sendRedirect("ErrorServlet");
            return;
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/mysql";
            Connection con = DriverManager(url, "root", "root");

            Statement s = con.createStatement();
            String query = "Select * from users where 
            email='"+email+"' and password='"+password+"'";

            ResultSet rs = s.executeQuery(query);
            if(res.next()){
                HttpSession s = req.getSession(true);
                s.setAttribute("email", rs.getString("email"));
                s.setAttribute("name", 
                res.getString("fullname"));
                s.setAttribute("role", rs.getString("role"));

                String role = rs.getString("role");
                if(role.equals("Admin")){
                    res.sendRedirect("AdminPanel");
                }else{
                    res.sendRedirect("Dashboard");
                }

            }else{
                    res.sendRedirect("ErrorServlet");
            }

            s.close();
            con.close();
        } catch (Exception e) {
            res.sendRedirect("ErrorServlet");
        }

    }
    
}
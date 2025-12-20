import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;

public class signup extends HttpServlet {
    public void doPost(HttpServletRequest req,  HttpServletResponse res) throws ServletExcpetion, IOException{

        String name = req.getParameter("name");

        String email = req.getParameter("email");

        String password = req.getParameter("password");
        String ConPassword = req.getParameter("ConfirmPswd");

        String UserType = req.getParameter("role");

        if(name.length() < 3 || name.length() > 50){
            res.sendRedirect("ErrorServlet");
            return;
        }
        if(!password.equals(Confirmpswd)&& password.length()<
        8)      
        {
            response.sendRedirect("ErrorServlet");
            return;
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/mysql";
            Connection con = DriverManager(url, "root", "root");

            Statement s = con.createStatement();
            String query = "INSERT INTO     
            users(fullname,email,password,role) VALUES('"
            + name + "','" + email + "','" + password + "','" + 
            role + "')";

            int res = s.executeUpdate(query);
            if(res == 1){
                res.sendRedirect("login.html");
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
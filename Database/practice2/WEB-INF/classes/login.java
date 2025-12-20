import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;

public class login extends HttpServlet{
    public void doPost(HttpServletRequest req, HttpServletResponse res){
        String email = req.getParameter("email");
        String pswrd = req.getParameter("password");

        if(email == null || pswrd == null){
            //error servlet
        }
        // RequestDispatcher.forward() is used in Java web apps to send a request (often after fetching data from MySQL) to another servlet or JSP without creating a new request, allowing shared data and better performance.

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "";
            Connection con = DriverManager();
            Statement s = con.createStatement();
            String query = "Select * from users where email = 
            '"+email+"' and password = '"+pswrd+"'
            ";

            ResultSet res = s.executeQuery(query);

            if(res.next()){
                RequestDispatcher rd =      
                req.getRequestDispatcher("Dashboard");
                rd.forward(req, res);
                return;
            }else{
                res.sendRedirect("ErrorServlet");
            }
            s.close();
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}
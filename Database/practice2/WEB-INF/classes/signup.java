import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;

public class signup extends HttpServlet{
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        String name = res.getParameter("name");
        String email = res.getParameter("email");
        String password = res.getParameter("password");
        String Conpassword = res.getParameter("ConPassword");

        if(name.length()<3 || name.length()>50){
            res.sendRedirect("ErrorServlet");
            return;
        }
        if(!password.equals(Conpassword) && password.length() < 3){
            res.sendRedirect("ErrorServlet");
            return;

        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/mysql";
            Connection con = DriverManager(url, "root","pswr")
            Statement s = con.createStatement();

            String qu = "insert into info()values()";
            int res = s.executeUpdate(qu);
            if(res==1){
                res.sendRedirect("login.html")
            }
            s.close();;
            con.close();
            
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
    
}
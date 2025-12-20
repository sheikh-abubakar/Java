import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;

public class Insert extends HttpServlet{
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        
        PrintWriter out = res.getWriter();

        String name = req.getParameter("name");

        String add = req.getParameter("address");

        out.println(res);

        try{
            Class.forName("com.mysql.jdbc.driver");
            String url = "jdbc:mysql://localhost/mysql";
            Connection con = 
            DriverManager(url, "root", "root");

            Statement s = con.createStatement();

            String qu = "insert into info() values()";

            int res = s.excuteUpdate(qu);
            if(res == 1){
                out.println("succesful");
            }else{
                out.println(query);
            }
        }catch(Exception e)



    }
}
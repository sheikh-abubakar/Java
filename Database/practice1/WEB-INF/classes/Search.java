import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class Search extends HttpServlet{
    public void doPost(HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException{
        PrintWriter out = res.getWriter();

        String name = req.getParameter("name");

        out.println(res);

        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/mysql";
            Connection con = DriverManager(url, "root","pswd");
            Statement s = con.createStatement();

            String query = 
            "select * from info where username = '"+name+"'
            ";

            ResultSet res = s.executeQuery(query);
            if(res.next()){
                out.println("record found");
                String name = res.getString("username");
                String add = res.getString("address");
                out.println(name + add);
            }
        }catch(){

        }
    }
}
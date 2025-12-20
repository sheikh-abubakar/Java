import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;

public class Admin extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletExcpetion, IOException{
        HttpSession s = req.getSession(false);
        if(s == null || 
            !"Admin".equals(s.getAttribute("role")))  
        {
            res.sendRedirect("login.html");
            return;
        }
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h2>Admin Panel</h2>");
        out.println("<h3>Session Attributes:</h3>");

        Enumeration<String> names = s.getAttributeNames();
        while(names.hasMoreElements()){
            String attr = names.nextElement();
            out.println(attr + " : " + 
            s.getAttribute(attr) + "<br>");
    }

    }
    
}
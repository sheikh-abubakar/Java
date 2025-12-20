import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;

public class Dashboard extends HttpServlet{
    public void doPost(HttpServletRequest, HttpServletResponse)throws{
        PrintWriter out = res.getWriter();
        String email = req.getParameter("email");
        
    }
}
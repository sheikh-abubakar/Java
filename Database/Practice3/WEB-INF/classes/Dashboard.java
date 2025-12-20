import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Dashboard extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        HttpSession s = req.getSession(false);
        if(s = null || !"User".equals(.getAttribute("role"))){
            res.sendRedirect("login.html");
            return;
        }

        String name = (String) s.getAttribute("name");

        String email = (String) s.getAttribute("email");

        String role = (String) s.getAttribute("role");

        PrintWriter out = res.getWriter();
        out.println("<h2>User Dashboard</h2>");
        out.println("<p>Welcome " + name + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Role: " + role + "</p>");
    }
    
}
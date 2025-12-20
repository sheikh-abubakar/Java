
import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
public class ErrorServlet  extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>My Servlet</title></head>");
    out.println("<body>");
    out.println("<h1 style ='color:red'>An error occurs</h1>");
    out.println("<alert> Invalid email or password. Please try again. </alert>");
    out.println("</body>");
    out.println("</html>");

    out.close();


    }


}

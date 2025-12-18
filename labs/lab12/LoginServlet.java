import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String uname = request.getParameter("username");
        String pswd = request.getParameter("password");

        boolean validuname = uname.matches("^[a-zA-Z0-9]+$");
        boolean validpswd = pswd.matches("^[a-zA-Z0-9]+$") && pswd.length() > 4 && pswd.length() < 8;

        if (validuname && validpswd) {
            response.sendRedirect("SuccessServlet");
        } else {
            response.sendRedirect("ErrorServlet");
        }
    }
}


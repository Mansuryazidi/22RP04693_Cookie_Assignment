package LoginForm;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect to the login form if a GET request is made
        response.sendRedirect("login.html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get username and password from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate password strength
        if (password.length() < 8) {
            out.println("<html><body>");
            out.println("<h3>Invalid password. Password must be at least 8 characters long.</h3>");
            out.println("<a href='login.html'>Go back to login</a>");
            out.println("</body></html>");
            return;
        }

        // Simple validation logic (for demonstration purposes)
        if ("user".equals(username) && "pass1234".equals(password)) {
            // If credentials are valid, redirect to welcome page
            response.sendRedirect("welcome.html");
        } else {
            // If credentials are invalid, show error message
            out.println("<html><body>");
            out.println("<h3>Invalid username or password. Please try again.</h3>");
            out.println("<a href='login.html'>Go back to login</a>");
            out.println("</body></html>");
        }
    }
}

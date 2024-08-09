import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/storeCookie")
public class CookieHandlerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userInput = request.getParameter("userInput");

        // Create a cookie with the user input
        Cookie userCookie = new Cookie("userInput", userInput);
        userCookie.setMaxAge(60 * 60 * 24 * 7); // 1 week
        response.addCookie(userCookie);

        // Redirect to the thank you page
        response.sendRedirect("out.html");
    }
}

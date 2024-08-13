package Error404;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/errorResponse")
public class ErrorResponseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Simulating conditions for different HTTP responses
        String condition = request.getParameter("condition");

        if ("notfound".equals(condition)) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
            out.println("<h2>Error 404: Not Found</h2>");
            out.println("<p>The requested resource was not found on this server.</p>");
        } else if ("servererror".equals(condition)) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // 500
            out.println("<h2>Error 500: Internal Server Error</h2>");
            out.println("<p>An unexpected error occurred on the server.</p>");
        } else {
            response.setStatus(HttpServletResponse.SC_OK); // 200
            out.println("<h2>Success</h2>");
            out.println("<p>No errors occurred. Please specify a condition to test error responses.</p>");
            out.println("<p>To simulate an error, use one of the following conditions in the URL:</p>");
            out.println("<ul>");
            out.println("<li><code>?condition=notfound</code> - to simulate a 404 error</li>");
            out.println("<li><code>?condition=servererror</code> - to simulate a 500 error</li>");
            out.println("</ul>");
        }
    }
}

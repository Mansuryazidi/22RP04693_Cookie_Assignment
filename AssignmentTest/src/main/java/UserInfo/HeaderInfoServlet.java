package UserInfo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/headerInfo")
public class HeaderInfoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Header Information</title></head><body>");
        out.println("<h2>Client Request Header Information</h2>");
        out.println("<table border='1'>");
        out.println("<tr><th>Header Name</th><th>Header Value</th></tr>");

        // Retrieve and display various headers
        String userAgent = request.getHeader("User-Agent");
        String host = request.getHeader("Host");
        String acceptLanguage = request.getHeader("Accept-Language");

        out.println("<tr><td>User-Agent</td><td>" + (userAgent != null ? userAgent : "Not Provided") + "</td></tr>");
        out.println("<tr><td>Host</td><td>" + (host != null ? host : "Not Provided") + "</td></tr>");
        out.println("<tr><td>Accept-Language</td><td>" + (acceptLanguage != null ? acceptLanguage : "Not Provided") + "</td></tr>");

        // Display all headers
        out.println("<tr><td colspan='2'><strong>All Headers:</strong></td></tr>");
        request.getHeaderNames().asIterator().forEachRemaining(headerName -> {
            String headerValue = request.getHeader(headerName);
            out.println("<tr><td>" + headerName + "</td><td>" + headerValue + "</td></tr>");
        });

        out.println("</table>");
        out.println("</body></html>");
    }
}

package Quadratic;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/quadratic")
public class QuadraticServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>");
        out.println("<h2>Quadratic Equation Solver</h2>");
        out.println("<form method='post'>");
        out.println("a: <input type='text' name='a'><br>");
        out.println("b: <input type='text' name='b'><br>");
        out.println("c: <input type='text' name='c'><br>");
        out.println("<input type='submit' value='Calculate Roots'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        double a = Double.parseDouble(request.getParameter("a"));
        double b = Double.parseDouble(request.getParameter("b"));
        double c = Double.parseDouble(request.getParameter("c"));
        
        double discriminant = b * b - 4 * a * c;
        out.println("<html><body>");
        out.println("<h2>Results</h2>");

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            out.println("Roots are real and different.<br>");
            out.println("Root 1: " + root1 + "<br>");
            out.println("Root 2: " + root2 + "<br>");
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            out.println("Roots are real and the same.<br>");
            out.println("Root: " + root + "<br>");
        } else {
            out.println("Roots are complex and different.<br>");
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
            out.println("Root 1: " + realPart + " + " + imaginaryPart + "i<br>");
            out.println("Root 2: " + realPart + " - " + imaginaryPart + "i<br>");
        }
        
        out.println("<a href='quadratic'>Back</a>");
        out.println("</body></html>");
    }
}

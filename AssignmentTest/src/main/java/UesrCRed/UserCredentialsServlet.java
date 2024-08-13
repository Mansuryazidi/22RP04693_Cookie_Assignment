package UesrCRed;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/userCredentials")
public class UserCredentialsServlet extends HttpServlet {

    private static final Map<String, String> userCredentials = new HashMap<>();

    @Override
    public void init() throws ServletException {
        // Pre-populating user credentials (in a real app, this should come from a database)
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // This servlet is not meant to handle login, but to simulate storing credentials
    }

    public static boolean validateCredentials(String username, String password) {
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
    }
}

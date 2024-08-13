package FilesUpload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "uploads"; // Directory to save uploaded files

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create upload directory if it doesn't exist
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        // Get the file part
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();

        // Save the file to the server
        try (InputStream inputStream = filePart.getInputStream();
             FileOutputStream outputStream = new FileOutputStream(new File(uploadPath, fileName))) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            response.getWriter().write("<h3>File upload failed: " + e.getMessage() + "</h3>");
            return;
        }

        // Display success message
        response.setContentType("text/html");
        response.getWriter().write("<h3>File uploaded successfully: " + fileName + "</h3>");
    }
}

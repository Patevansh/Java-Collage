package cookie;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayCookies")
public class DisplayCookiesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        Cookie[] cookies = request.getCookies();
        
        out.println("<html><body>");
        out.println("<h2>Cookies:</h2>");
        
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                out.println("<p>Name: " + cookie.getName() + ", Value: " + cookie.getValue() + "</p>");
            }
        } else {
            out.println("<p>No cookies found</p>");
        }
        
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

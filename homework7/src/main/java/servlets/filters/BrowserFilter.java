package servlets.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter("/*")
public class BrowserFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if(req.getHeader("User-Agent").contains("Edge")) {
            res.getWriter().println("<!DOCTYPE html>" +
                    "<html lang=\"en\">" +
                    "<head>" +
                    "    <meta charset=\"UTF-8\">" +
                    "    <title>Title</title>" +
                    "</head>" +
                    "<body>" +
                    "<p>Sorry, you use Edge Browser!</p>" +
                    "</body>" +
                    "</html>");
        }
        else {
            chain.doFilter(req, res);
        }
    }
}

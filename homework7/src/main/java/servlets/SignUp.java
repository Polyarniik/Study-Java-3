package servlets;

import repository.CSVWriter;
import service.Validator;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class SignUp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String passwordRepeat = req.getParameter("passwordRepeat");
        Validator validator = new Validator(name, email, password);
        if(validator.isValid() ||!password.equals(passwordRepeat)) {
            resp.getWriter().println("<!DOCTYPE html>" +
                    "<html lang=\"en\">" +
                    "<head>" +
                    "    <meta charset=\"UTF-8\">" +
                    "    <title>Title</title>" +
                    "</head>" +
                    "<body>" +
                    "<p>Registration Failed!</p>" +
                    "</body>" +
                    "</html>");
        }
        else {
            CSVWriter writer = new CSVWriter();
            writer.writeProfile(name, email, password);
            resp.getWriter().println("<!DOCTYPE html>" +
                    "<html lang=\"en\">" +
                    "<head>" +
                    "    <meta charset=\"UTF-8\">" +
                    "    <title>Title</title>" +
                    "</head>" +
                    "<body>" +
                    "<p>Registration Done!</p>" +
                    "</body>" +
                    "</html>");
        }
    }

}

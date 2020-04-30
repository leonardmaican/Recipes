package ro.siit.web.authors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AuthorServlet extends HttpServlet {
    private AuthorsDAO authorsDAO = new AuthorsDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        List<Author> allAuthors= authorsDAO.getAllAuthors();


    }
}

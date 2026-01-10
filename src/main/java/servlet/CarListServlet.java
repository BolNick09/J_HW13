package servlet;

import dao.CarDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.JPAUtil;

import java.io.IOException;

@WebServlet("/cars")
public class CarListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        var em = JPAUtil.getEntityManager();
        var dao = new CarDao(em);

        req.setAttribute("cars", dao.findAll());

        em.close();
        req.getRequestDispatcher("cars.jsp").forward(req, resp);
    }
}

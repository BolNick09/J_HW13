package servlet;

import dao.CarDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.JPAUtil;

import java.io.IOException;

@WebServlet("/filter")
public class CarFilterServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String manufacturer = req.getParameter("manufacturer");
        String color = req.getParameter("color");
        String type = req.getParameter("type");

        var em = JPAUtil.getEntityManager();
        var dao = new CarDao(em);

        var result = dao.filter(
                color.isEmpty() ? null : color,
                null,
                type.isEmpty() ? null : type
        );

        req.setAttribute("cars", result);
        em.close();

        req.getRequestDispatcher("cars.jsp").forward(req, resp);
    }
}

package servlet;

import dao.CarDao;
import entity.Car;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.JPAUtil;

import java.io.IOException;

@WebServlet("/add")
public class CarCrudServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        var car = new Car();
        car.setManufacturer(req.getParameter("manufacturer"));
        car.setModel(req.getParameter("model"));
        car.setEngineVolume(Double.parseDouble(req.getParameter("engine")));
        car.setYear(Integer.parseInt(req.getParameter("year")));
        car.setColor(req.getParameter("color"));
        car.setType(req.getParameter("type"));

        var em = JPAUtil.getEntityManager();
        new CarDao(em).save(car);
        em.close();

        resp.sendRedirect("cars");
    }
}

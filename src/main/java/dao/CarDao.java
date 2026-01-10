package dao;

import entity.Car;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CarDao {

    private final EntityManager em;

    public CarDao(EntityManager em) {
        this.em = em;
    }

    // Задание 2
    public List<Car> findAll() {
        return em.createQuery("FROM Car", Car.class).getResultList();
    }

    public List<String> findAllManufacturers() {
        return em.createQuery(
                "SELECT DISTINCT c.manufacturer FROM Car c", String.class
        ).getResultList();
    }

    public List<Object[]> countByManufacturer() {
        return em.createQuery(
                "SELECT c.manufacturer, COUNT(c) FROM Car c GROUP BY c.manufacturer",
                Object[].class
        ).getResultList();
    }

    // Задание 3
    public Object[] maxManufacturer() {
        return em.createQuery(
                "SELECT c.manufacturer, COUNT(c) cnt FROM Car c GROUP BY c.manufacturer ORDER BY cnt DESC",
                Object[].class
        ).setMaxResults(1).getSingleResult();
    }

    public Object[] minManufacturer() {
        return em.createQuery(
                "SELECT c.manufacturer, COUNT(c) cnt FROM Car c GROUP BY c.manufacturer ORDER BY cnt ASC",
                Object[].class
        ).setMaxResults(1).getSingleResult();
    }

    public List<Car> findByYear(int year) {
        return em.createQuery(
                "FROM Car c WHERE c.year = :year", Car.class
        ).setParameter("year", year).getResultList();
    }

    public List<Car> findByYearRange(int from, int to) {
        return em.createQuery(
                        "FROM Car c WHERE c.year BETWEEN :from AND :to", Car.class
                )
                .setParameter("from", from)
                .setParameter("to", to)
                .getResultList();
    }

    // Задание 4
    public List<Car> findByManufacturer(String manufacturer) {
        return em.createQuery(
                "FROM Car c WHERE c.manufacturer = :m", Car.class
        ).setParameter("m", manufacturer).getResultList();
    }

    public List<Car> filter(String color, Double engine, String type) {
        return em.createQuery(
                        "FROM Car c WHERE " +
                                "(:color IS NULL OR c.color = :color) AND " +
                                "(:engine IS NULL OR c.engineVolume = :engine) AND " +
                                "(:type IS NULL OR c.type = :type)",
                        Car.class
                )
                .setParameter("color", color)
                .setParameter("engine", engine)
                .setParameter("type", type)
                .getResultList();
    }

    // Задание 5
    public void save(Car car) {
        em.getTransaction().begin();
        em.persist(car);
        em.getTransaction().commit();
    }

    public void delete(Long id) {
        em.getTransaction().begin();
        Car car = em.find(Car.class, id);
        if (car != null) em.remove(car);
        em.getTransaction().commit();
    }

    public void update(Car car) {
        em.getTransaction().begin();
        em.merge(car);
        em.getTransaction().commit();
    }
}

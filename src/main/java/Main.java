import dao.CarDao;
import util.JPAUtil;

public class Main {//Для простого теста
    public static void main(String[] args) {

        var em = JPAUtil.getEntityManager();
        var dao = new CarDao(em);

        dao.findAll().forEach(c ->
                System.out.println(c.getManufacturer() + " " + c.getModel())
        );

        JPAUtil.close();
    }
}

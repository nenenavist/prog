import Entities.*;
import Enums.Gender;
import Place.Building;
import Place.Company;
import Place.Coordinate;

public class Main{
    public static void main(String[] args) {
        Money money = new Money("деньги",1000);
        Money capitals = new Money("капиталы", 3000);
        Order order = new Order();
        Company company = new Company();
        order.setName("приказ");
        Worker workers = new Worker("Рабочие", capitals, Gender.THEY, company);
        Money sprutsCapital = new Money("капитал", 5000);
        Rich rich = new Rich("Богачи", money, Gender.THEY, company);
        CunningRich spruts = new CunningRich("Спрутс", sprutsCapital, Gender.MALE, company);
        Coordinate c1 = new Coordinate(100, 100, 100, 100);
        Building factory = new Building(" заводы", c1);
        Coordinate c2 = new Coordinate(132, 192, 121, 140);
        Building manufactory = new Building(" фабрики", c2);
        Coordinate c3 = new Coordinate(41, 69, 53, 85);
        Building largeTheatre = new Building("большие театры", c3);
        Coordinate c4 = new Coordinate(95, 79, 40, 60);
        Building museum = new Building("музеи", c4);
        Coordinate c5 = new Coordinate(12, 28, 15, 52);
        Building artGallery = new Building("картинные галереи", c5);
        Coordinate c6 = new Coordinate(70, 35, 53, 30);
        Building stadium = new Building("стадионы", c6);
        Coordinate c7 = new Coordinate(31, 30, 42, 17);
        Building swimmingPool = new Building("плавательные бассейны", c7);
        Coordinate c8 = new Coordinate(70, 61, 77, 60);
        Building hospital = new Building("больницы", c8);
        Coordinate c9 = new Coordinate(15, 29, 20, 8);
        Building steamboat = new Building("прогулочные пароходики", c9);

        Building[] buildings = {largeTheatre, museum, artGallery, stadium, swimmingPool, hospital, steamboat};
        company.setOwn(buildings);
        rich.lost(factory, manufactory);
        rich.save(money);
        money.setName("деньги");
        workers.think(money);
        rich.make_money(money);
        money.setName("капиталы");
        rich.pass(money);
        money.setName("денег");
        workers.publish(order);
        order.pass(money);
        System.out.print("и о постройке");
        order.build(company);
        money.setName("деньги");
        rich.hide(money);
        money.setName("капитала");
        spruts.pass(money);
        spruts.giveMoney(workers,spruts.getQuantity().getValue()/2);
        spruts.keep(money);
        money.setName("денежки");
        spruts.think(money);

    }
}
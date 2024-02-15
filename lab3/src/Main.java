import Entities.*;
import Enums.Buildings;
import Enums.Gender;

public class Main{
    public static void main(String[] args) {
        Money money = new Money("деньги",1000);
        Rich rich = new Rich("Богачи", money, Gender.THEY);
        Money capitals = new Money("капиталы", 3000);
        Worker workers = new Worker("Рабочие", capitals, Gender.THEY);
        Order order = new Order();
        order.setName("приказ");
        Money sprutsCapital = new Money("капитал", 5000);
        CunningRich spruts = new CunningRich("Спрутс", sprutsCapital, Gender.MALE);


        rich.lost(Buildings.FACTORY, Buildings.MANUFACTORY);
        rich.save(money);
        money.setName("деньги");
        workers.think(money);
        rich.make_money(money);
        money.setName("капиталы");
        rich.pass(money);
        money.setName("денег");
        workers.publish(order);
        order.pass(money);
        System.out.print("и о ");
        order.build();
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
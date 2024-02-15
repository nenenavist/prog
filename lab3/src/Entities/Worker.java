package Entities;

import Enums.Gender;
import Interfaces.Publishable;
import Interfaces.Thinkable;

public class Worker extends Human implements Thinkable , Publishable {
    Money quantity;

    public Worker(String name, Money quantity, Gender sex){
        this.name = name;
        this.quantity = quantity;
        this.sex = sex;
    }

    public Money getQuantity(){
        return this.quantity;
    }
    public void receiveMoney(int money){
        quantity.setValue(quantity.getValue()+money);
    }
    @Override
    public void think(Money money) {
        System.out.println(this.getName() + " считали, что " + money + " принадлежат народу");
    }

    @Override
    public void publish(Order order) {
        System.out.print(this.getName() + " издали " + order + " o ");
    }

}


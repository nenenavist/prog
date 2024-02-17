package Entities;

import Enums.Gender;
import Interfaces.Publishable;
import Interfaces.Thinkable;
import Place.Company;

public class Worker extends Human implements Thinkable , Publishable {
    private Money quantity;
    private Company company;

    public Worker(String name, Money quantity, Gender sex, Company company){
        super(name, sex);
        this.quantity = quantity;
        this.company = company;
    }

    public void setCompany(Company company){
        this.company = company;
    }
    public Company getCompany(){
        return this.company;
    }
    public void setQuantity(Money quantity){
        this.quantity = quantity;
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


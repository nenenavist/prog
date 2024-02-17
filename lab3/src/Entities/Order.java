package Entities;

import Interfaces.Consistable;
import Place.Building;
import Place.Company;

public class Order extends Substance implements Consistable {
    @Override
    public void pass(Money money) {
        System.out.print("сдаче " + money + " в общую кассу ");
    }

    @Override
    public void build(Company company) {
        for (int i = 0; i < company.getOwn().length; i++) {
            System.out.print(", " + company.getOwn()[i].getName());
        }
        System.out.println("");
    }
}

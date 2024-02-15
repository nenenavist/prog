package Entities;

import Enums.Buildings;
import Enums.Gender;
import Interfaces.*;

public class Rich extends Human implements Lostable , Savable , MakableMoney , Hideable , Passable {
   Money quantity;

   public Rich(String name, Money quantity, Gender sex){
       this.name = name;
       this.quantity = quantity;
       this.sex = sex;
   }
   public Money getQuantity(){
        return quantity;
    }

   public void giveMoney(Worker worker, int value){
       worker.receiveMoney(value);
       quantity.setValue(quantity.getValue()-value);
   }

    @Override
    public void lost(Buildings locations, Buildings local) {
        if(locations == Buildings.FACTORY && local == Buildings.MANUFACTORY){
            System.out.println(getName()+" потеряли" + Buildings.FACTORY + " и" + Buildings.MANUFACTORY);
        }
    }

    @Override
    public void save(Money money) {
        System.out.println(getName()+ " сохранили свои " + money);
    }

    @Override
    public void make_money(Money money) {
        System.out.println(getName()+" нажили " + money + " обманным путём");
    }

    @Override
    public void pass(Money money) {
        System.out.println(getName()+" сдавали свои " + money + " в общую кассу");
    }

    @Override
    public void hide(Money money) {
        System.out.println(getName()+" припрятали " + money + " для себя");
    }

    }

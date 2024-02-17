package Entities;

import Enums.Gender;
import Interfaces.*;
import Place.Building;
import Place.Company;

public class Rich extends Human implements Lostable , Savable , MakableMoney , Hideable , Passable {
    private Money quantity;
    private Company company;
   public Rich(String name, Money quantity, Gender sex, Company company){
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
    public void setQuantity(Money quantity) {
        this.quantity = quantity;
    }
   public Money getQuantity(){
        return quantity;
    }

   public void giveMoney(Worker worker, int value){
       worker.receiveMoney(value);
       quantity.setValue(quantity.getValue()-value);
   }

    @Override
    public void lost(Building factory, Building manufactory) {
       System.out.println(getName()+" потеряли" + factory.getName() + " и" + manufactory.getName());
   }

    @Override
    public void save(Money money) {
        System.out.println(getName()+ " сохранили свои " + money);
    }

    @Override
    public void makeMoney(Money money) {
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

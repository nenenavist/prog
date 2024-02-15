package Entities;

import Enums.Gender;
import Interfaces.Keepable;
import Interfaces.Passable;
import Interfaces.Thinkable;

public class CunningRich extends Rich implements Passable , Keepable , Thinkable {

    public CunningRich(String name, Money quantity, Gender sex){
        super(name,quantity,sex);
    }
    @Override
    public void pass(Money money) {
        System.out.println(this.getName() + " сдал половину своего " + money);
    }

    @Override
    public void keep(Money money) {
        System.out.println("другую часть " + money + " " +this.getName() + " оставил себе");
    }
    @Override
    public void think(Money money) {
        System.out.println(this.getName() + " рассчитывал, что сможет жить не трудясь, имея " + money);
    }
}

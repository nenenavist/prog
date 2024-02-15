package Entities;

import Enums.Buildings;
import Interfaces.Consistable;

public class Order extends Substance implements Consistable {
    @Override
    public void pass(Money money) {
        System.out.print("сдаче " + money + " в общую кассу ");
    }

    @Override
    public void build() {
        System.out.printf("постройке " + Buildings.LARGE_THEATRE+", " + Buildings.MUSEUM+ ", " + Buildings.ART_GALLERY+ ", " + Buildings.STADIUM+ ", " + Buildings.SWIMMING_POOL+ ", " + Buildings.HOSPITAL +" и " + Buildings.STEAMBOAT );
    }
}

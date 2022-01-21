package entity.product;

import java.util.Date;

public class Beverage extends Perishable {
    public Beverage() {
    }

    public Beverage(String name, String brand, double price, Date expirationDate) {
        super(name, brand, price, expirationDate);
    }

    @Override
    public String toString() {
        return "Beverage{} " + super.toString();
    }
}

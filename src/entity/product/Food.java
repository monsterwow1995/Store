package entity.product;

import java.util.Date;

public class Food extends Perishable {
    public Food() {
    }

    public Food(String name, String brand, double price, Date expirationDate) {
        super(name, brand, price, expirationDate);
    }

    @Override
    public String toString() {
        return "Food{} " + super.toString();
    }
}

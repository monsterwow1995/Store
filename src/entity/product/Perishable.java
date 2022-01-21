package entity.product;

import util.Formatter;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public abstract class Perishable extends Product {
    private Date expirationDate;

    public Perishable() {
    }

    public Perishable(String name, String brand, double price, Date expirationDate) {
        super(name, brand, price);
        this.expirationDate = expirationDate;
    }

    @Override
    public double printDiscount(Date date, double quantity) {
        long diffInMillies = Math.abs(date.getTime() - getExpirationDate().getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        double discountAmount = 0;

        if (diff <= 5 && diff >= 0) {
            if (getExpirationDate().getDay() == date.getDay()) {
                discountAmount = Formatter.formatDouble(getPrice() * 0.5);
                System.out.println("#discount 50% " + "-$" + Formatter.formatAmountLabel(discountAmount * quantity));
            } else {
                discountAmount = Formatter.formatDouble(getPrice() * 0.1);
                System.out.println("#discount 10% " + "-$" + Formatter.formatAmountLabel(discountAmount * quantity));
            }
        }

        return discountAmount;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Perishable{" +
                "expirationDate=" + expirationDate +
                "} " + super.toString();
    }
}

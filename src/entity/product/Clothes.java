package entity.product;

import util.Formatter;

import java.util.Date;

public class Clothes extends Product{
    public enum Size {
        XS,
        S,
        M,
        L,
        XL
    }

    private Size size;
    private String color;

    public Clothes() {
    }

    public Clothes(String name, String brand, double price, Size size, String color) {
        super(name, brand, price);
        this.size = size;
        this.color = color;
    }

    @Override
    public double printDiscount(Date date, double quantity) {
        double discountAmount =  0;

        if (date.getDay() >= 1 && date.getDay() <= 5) {
            discountAmount = Formatter.formatDouble(getPrice() * 0.1);
            System.out.println("#discount 10% " + "-$" + Formatter.formatAmountLabel(discountAmount * quantity));
        }

        return discountAmount;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "size=" + size +
                ", color='" + color + '\'' +
                "} " + super.toString();
    }
}

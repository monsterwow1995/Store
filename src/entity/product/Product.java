package entity.product;

import java.text.DecimalFormat;
import java.util.Date;

public abstract class Product {
    private String name;
    private String brand;
    private double price;

    public Product() {
    }

    public Product(String name, String brand, double price) {
        this.name = name;
        this.brand = brand;
        setPrice(price);
    }

    public abstract double printDiscount(Date date, double quantity);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        this.price = Double.parseDouble(decimalFormat.format(price));
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}

package entity.product;

import util.Formatter;
import java.util.Date;

public class Appliances extends Product {
    private String model;
    private Date productionDate;
    private double weight;

    public Appliances() {
    }

    public Appliances(String name, String brand, double price, String model, Date productionDate, double weight) {
        super(name, brand, price);
        this.model = model;
        this.productionDate = productionDate;
        this.weight = weight;
    }

    @Override
    public double printDiscount(Date date, double quantity) {
        double discountAmount = 0;

        if ((date.getDay() == 6 || date.getDay() == 0) && getPrice() > 999) {
            discountAmount = Formatter.formatDouble(getPrice() * 0.1);
            System.out.println("#discount 10% " + "-$" + Formatter.formatAmountLabel(discountAmount * quantity));
        }
        return discountAmount;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Appliances{" +
                "model='" + model + '\'' +
                ", productionDate=" + productionDate +
                ", weight=" + weight +
                "} " + super.toString();
    }
}

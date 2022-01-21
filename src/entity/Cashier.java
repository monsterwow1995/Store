package entity;

import demo.Store;
import entity.cart.Cart;
import entity.cart.CartItem;
import entity.product.Appliances;
import entity.product.Clothes;
import entity.product.Product;
import util.Formatter;

import java.util.Date;


public class Cashier {

    public Cashier() {
    }

    public void printReceipt(Cart cart, Date date) {
        double discountAmount = 0, subtotalAmount = 0;

        printHeader(date);

        for (CartItem cartItem : cart.getCartItemList()) {
            printProductInfo(cartItem.getProduct(), cartItem.getQuantity());

            discountAmount += Formatter.formatDouble(cartItem.getProduct().printDiscount(date, cartItem.getQuantity()) * cartItem.getQuantity());
            subtotalAmount += Formatter.formatDouble(cartItem.getQuantity() * cartItem.getProduct().getPrice());
        }

        Purchase purchase = new Purchase(cart, date, subtotalAmount, discountAmount);
        Store.getPurchaseList().add(purchase);

        printFooter(purchase);
    }

    public void printHeader(Date date) {
        System.out.println("Date: " + Formatter.formatDate(date) + "\n");
        System.out.println("--Products--");
    }

    public void printProductInfo(Product product, double quantity) {
        System.out.println();
        System.out.print(product.getName() + " " + product.getBrand() + " ");

        if (product instanceof Clothes)
            System.out.print(((Clothes) product).getSize() + " " + ((Clothes) product).getColor());
        else if (product instanceof Appliances)
            System.out.print(((Appliances) product).getModel());

        System.out.println();
        System.out.println(Formatter.formatAmountLabel(quantity) + " x " + "$"
                + Formatter.formatAmountLabel(product.getPrice()) + " = " + "$"
                + Formatter.formatAmountLabel(product.getPrice() * quantity));
    }

    public void printFooter(Purchase purchase) {
        System.out.println("-----------------------------------------------------");
        System.out.println("SUBTOTAL: $" + purchase.getSubtotalAmount());
        System.out.println("DISCOUNT: -$" + purchase.getDiscountAmount() + "\n");
        System.out.println("TOTAL: $" + Formatter.formatAmountLabel(purchase.getTotalAmount()));
    }

    @Override
    public String toString() {
        return "Cashier{}";
    }
}

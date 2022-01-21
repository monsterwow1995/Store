package demo;

import entity.*;
import entity.cart.Cart;
import entity.product.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private static List<Purchase> purchaseList = new ArrayList<>();
    private static Cashier cashier = new Cashier();
    private static Cart cart = new Cart();

    public static void main(String[] args) {
        String patternDate = "yyyy-MM-dd";
        String patternDateTime = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patternDate);

        try {
            Product p1 = new Food("apples", "BrandA", 1.50, simpleDateFormat.parse("2021-06-14"));
            Product p2 = new Beverage("milk", "BrandM", 0.99, simpleDateFormat.parse(" 2022-02-02"));
            Product p3 = new Clothes("T-shirt", "BrandT", 15.99, Clothes.Size.M, "violet");
            Product p4 = new Appliances("laptop", "BrandL", 2345, "ModelL", simpleDateFormat.parse("2021-03-03"), 2);

            cart.add(p1, 2.45);
            cart.add(p2, 3);
            cart.add(p3, 2);
            cart.add(p4, 1);

            simpleDateFormat = new SimpleDateFormat(patternDateTime);
            cashier.printReceipt(cart, simpleDateFormat.parse("2021-06-14 12:34:56"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public static void setPurchaseList(List<Purchase> purchaseList) {
        Store.purchaseList = purchaseList;
    }
}

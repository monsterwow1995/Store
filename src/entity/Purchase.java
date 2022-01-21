package entity;

import entity.cart.Cart;

import java.util.Date;

public class Purchase {
    private Cart cart;
    private Date dateTime;
    private double subtotalAmount;
    private double discountAmount;

    public Purchase() {
    }

    public Purchase(Cart cart, Date dateTime, double subtotalAmount, double discountAmount) {
        this.cart = cart;
        this.dateTime = dateTime;
        this.subtotalAmount = subtotalAmount;
        this.discountAmount = discountAmount;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public double getSubtotalAmount() {
        return subtotalAmount;
    }

    public void setSubtotalAmount(double subtotalAmount) {
        this.subtotalAmount = subtotalAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getTotalAmount() {
        return subtotalAmount - discountAmount;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "cart=" + cart +
                ", dateTime=" + dateTime +
                ", subtotalAmount=" + subtotalAmount +
                ", discountAmount=" + discountAmount +
                '}';
    }
}

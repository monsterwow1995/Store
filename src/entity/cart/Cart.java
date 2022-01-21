package entity.cart;

import entity.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItemList = new ArrayList<>();

    public Cart() {
    }

    public Cart(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public void add(Product product, double quantity) {
        CartItem cartItem = new CartItem(product, quantity);
        cartItemList.add(cartItem);
    }

    public void remove(int index) {
        cartItemList.remove(index);
    }

    public void clear() {
        cartItemList = new ArrayList<>();
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartItemList=" + cartItemList +
                '}';
    }
}

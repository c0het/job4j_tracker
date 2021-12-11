package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        if (index != products .length - 1) {
            for (int i = index; i < products.length - 1; i++) {
                products[i] = products[i + 1];
                products[i + 1] = null;
        }
            } else {
                products[index] = null;
            }
        return products;
    }

}
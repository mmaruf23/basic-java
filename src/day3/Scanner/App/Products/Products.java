package day3.Scanner.App.Products;

import java.util.ArrayList;
import java.util.List;

public class Products {
    public String name;
    public double price;
    public String category;

    public Products(String name, double price, String category){
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // inner class
    public static class ProductController {
        private final List<Products> productsList;

        public ProductController() {
            this.productsList = new ArrayList<>();
        }

        // method
        public void addProducts(Products product) {productsList.add(product);}
        public void displayProducts(){
            if (!productsList.isEmpty()){
                for (Products product : productsList){
                    System.out.println("nama: " + product.name + ", price: " + product.price + ", category : " + product.category);
                }
            } else {
                System.out.println("Product tidak tersedia");
            }
        }

        // tambahin method mainnya disini
    }
}

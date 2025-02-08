package day3.Scanner.App.Products;

import java.io.*;
import java.util.*;

public class Products {
    public String name;
    public double price;
    public String category;

    public Products(String name, double price, String category){
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public double getPrice(){return price;}

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

        // METHOD SORT BY PRICE
        public void displayProductsSortedByPrice(){
            if (!productsList.isEmpty()){
//                Collections.sort(productsList, new Comparator<Products>() {
//                    @Override
//                    public int compare(Products o1, Products o2) {
//                        return Double.compare(o1.price, o2.price);
//                    }
//                });
                productsList.sort(Comparator.comparingDouble(Products::getPrice));
                for (Products product : productsList){
                    System.out.println("nama: " + product.name + ", price: " + product.price + ", category : " + product.category);
                }
            } else {
                System.out.println("Product tidak tersedia");
            }
        }

        // METHOD FIND BY NAME
        public void findProductByName(String nameToFind){
            if (!productsList.isEmpty()){
                System.out.println("Menampilkan data product dengan nama : " + nameToFind);
                for (Products product : productsList){
                    if (product.name.equalsIgnoreCase(nameToFind)) {
                        System.out.println("Hasil pencarian : ");
                        System.out.println(" nama: " + product.name + ", price: " + product.price + ", category : " + product.category);
                    }
                }
            } else {
                System.out.println("Product tidak tersedia");
            }
        }

        // METHOD SAVE PRODUCT TO FILE
        public void saveProduct(){
            String fileName = "D:\\bootcamp-aigen\\main-class\\backend\\basic_java\\src\\day3\\Scanner\\App\\Products\\Products.txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                for (Products product : productsList){
                    writer.write("nama: " + product.name + ", price: " + product.price + ", category : " + product.category + ",");
                    writer.newLine();
                }
                writer.close();
                System.out.println("Product berhasil disimpan!");
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        // METHOD READ SAVED PRODUCT
        public void readProductFile(){
            String filePath = "D:\\bootcamp-aigen\\main-class\\backend\\basic_java\\src\\day3\\Scanner\\App\\Products\\Products.txt";
            File file = new File(filePath);
            if (file.exists()){
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
                    String line;
                    while((line = reader.readLine()) != null){
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("File tidak ditemukan \n path : " + file.getAbsolutePath());
            }
        }
    }
}

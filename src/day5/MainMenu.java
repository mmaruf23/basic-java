package day5;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {



        // Menu
        while (true){
            System.out.println("===== HOME =====");
            System.out.println("1. Menu Produk");
            System.out.println("2. Menu Customer");
            System.out.println("0. Exit");
            System.out.println("================");
            System.out.print("Pilih menu : ");

            Scanner input = new Scanner(System.in);
            int menu = input.nextInt();
            input.nextLine();

            switch (menu) {
                case 1:
                    while (true) {
                        System.out.println("===== MENU PRODUK=====");
                        System.out.println("1. Tambah Produk");
                        System.out.println("2. Update Produk");
                        System.out.println("3. Hapus Produk");
                        System.out.println("4. Lihat Produk");
                        System.out.println("5. Update Produk Price");
                        System.out.println("6. Lihat Produk Termahal");
                        System.out.println("7. Lihat Produk Termurah");
                        System.out.println("0. Exit");
                        System.out.println("================");
                        System.out.print("Pilih menu : ");
                        int menuProduct = input.nextInt();
                        input.nextLine();

                        Products products = new Products();

                        switch (menuProduct) {
                            case 1:
                                System.out.println("===== TAMBAH PRODUK =====");
                                products.addProduct();

                                System.out.println("=========================");
                                break;
                            case 2:
                                System.out.println("===== UPDATE PRODUK =====");
                                products.updateProduct();
                                System.out.println("=========================");
                                break;
                            case 3:
                                System.out.println("===== HAPUS PRODUK =====");
                                products.deleteProduct();
                                System.out.println("=========================");
                                break;
                            case 4:
                                System.out.println("===== LIHAT PRODUK =====");
                                products.showProduct();
                                System.out.println("=========================");
                                break;
                            case 5:
                                System.out.println("===== UPDATE HARGA PRODUK =====");
                                products.updateProductPrice();
                                System.out.println("=========================");
                                break;
                            case 6:
                                System.out.println("===== LIHAT PRODUK TERMAHAL =====");
                                products.updateProductPrice();
                                System.out.println("=========================");
                                break;
                            case 7:
                                System.out.println("===== LIHAT PRODUK TERMURAH =====");
                                products.updateProductPrice();
                                System.out.println("=========================");
                                break;
                            case 0:
                                System.out.println("Kembali ke menu awal ...");
                                break;
                            default:
                                System.out.println("Input tidak valid.");
                                break;
                        }
                        if (menuProduct == 0) break;
                    }
                    break;
                case 2:
                    while (true) {
                        System.out.println("===== MENU CUSTOMER=====");
                        System.out.println("1. Tambah Customer");
                        System.out.println("2. Update Customer");
                        System.out.println("3. Hapus Customer");
                        System.out.println("4. Lihat Customer");
                        System.out.println("5. Update Customer Address");
                        System.out.println("6. Lihat Total Belanja All Customer");
                        System.out.println("0. Exit");
                        System.out.println("================");
                        System.out.print("Pilih menu : ");

                        int menuCustomer = input.nextInt();

                        Customers customers = new Customers();

                        switch (menuCustomer) {
                            case 1:
                                System.out.println("===== TAMBAH CUSTOMER =====");
                                customers.addCustomer();
                                System.out.println("=========================");
                                break;
                            case 2:
                                System.out.println("===== UPDATE CUSTOMER =====");
                                customers.updateCustomer();
                                System.out.println("=========================");
                                break;
                            case 3:
                                System.out.println("===== HAPUS CUSTOMER =====");
                                customers.deleteCustomer();
                                System.out.println("=========================");
                                break;
                            case 4:
                                System.out.println("===== LIHAT CUSTOMER =====");
                                customers.showCustomers();
                                System.out.println("=========================");
                                break;
                            case 5:
                                System.out.println("===== UPDATE CUSTOMER ADDRESS =====");
                                customers.updateCustomerAddress();
                                System.out.println("=========================");
                                break;
                            case 6:
                                System.out.println("===== TOTAL BELANJA ALL CUSTOMERS =====");
                                customers.showTotalOrderPerCustomers();
                                System.out.println("=========================");
                                break;
                            case 0:
                                System.out.println("Kembali ke menu awal ...");
                                break;
                            default:
                                System.out.println("Input tidak valid.");
                                break;
                        }
                        if (menuCustomer == 0) break;
                    }
                    break;
                case 0:
                    System.out.println("Terima kasih, sampai jumpa!");
                    input.close();
                    System.exit(0);
                default:
                    System.out.println("Menu yang anda pilih tidak tersedia.");

            }
        }
    }
}

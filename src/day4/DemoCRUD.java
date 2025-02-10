package day4;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class DemoCRUD {
    // connect to database (db)
    String url = "jdbc:postgresql://localhost:5432/bootcamp";
    String username = "postgres";
    String password = "root";
    Scanner input = new Scanner(System.in);


    public void getData(){
        try {
            // DriverManager.getConnection : buat ngehubungun ke database.
            Connection connection = DriverManager.getConnection(url, username, password);

            // pangil object Statement buat ngekksekusi query.
            Statement statement = connection.createStatement();

            // panggil ResultSet buat nampung hasil eksekusi query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products");

            // ambil nama kolom dan tipe data dari tiap kolom
            ResultSetMetaData metaData = resultSet.getMetaData();

            // ambil jumlah kolom
            int columnCount = metaData.getColumnCount();

            // mapping data ke format json
            ObjectMapper mapper = new ObjectMapper(); // library maven : jackson // bikin object kosong

            // ArrayNode buat nampung data ke array of object (JSON);
            ArrayNode arrayNode = mapper.createArrayNode(); // bikin array kosong

            while(resultSet.next()){
                // buat data object untuk setiap baris data.
                ObjectNode objectNode = mapper.createObjectNode();
                for (int i = 1; i < columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    objectNode.put(columnName, resultSet.getString(i));
                }
                // masukin data object yang sudah ada di looping ke array.

                arrayNode.add(objectNode);

            }

            // buat format data ke format json yang lebih rapih
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayNode);
            System.out.println(jsonString);


        } catch (SQLException | com.fasterxml.jackson.core.JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void addData(){
        System.out.print("Masukan nama product : ");
        String name = input.nextLine();

        System.out.print("Masukan harga product : ");
        Double price = input.nextDouble();
        input.nextLine();

        System.out.print("Masukan category product : ");
        String category = input.nextLine();

        try {
            // DriverManager.getConnection : buat ngehubungun ke database.
            Connection connection = DriverManager.getConnection(url, username, password);
            // preparedStatement untuk mengeksekusi query yang punya jumlah data banyak. ( ?, ?, ?) pada values untuk mencegah SQL Injection.
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO products (product_name, product_price, category) values ( ?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, price);
            preparedStatement.setString(3, category);

            preparedStatement.executeUpdate();
            System.out.println("Data berhasil ditambahkan!");


        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void editData(){
        System.out.println("Masukan id product : ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Masukan nama product : ");
        String name = input.nextLine();

        System.out.print("Masukan harga product : ");
        Double price = input.nextDouble();
        input.nextLine();

        System.out.print("Masukan category product : ");
        String category = input.nextLine();

        try {
            // DriverManager.getConnection : buat ngehubungun ke database.
            Connection connection = DriverManager.getConnection(url, username, password);
            // preparedStatement untuk mengeksekusi query yang punya jumlah data banyak. ( ?, ?, ?) pada values untuk mencegah SQL Injection.
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE products SET product_name = ?, product_price = ?, category = ? where id = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, price);
            preparedStatement.setString(3, category);
            preparedStatement.setInt(4, id);
            // eksekusi query
            int rowsUpdated = preparedStatement.executeUpdate();
            // kondisi untuk cek apa ada data yang diupdate
            if (rowsUpdated > 0) {
                System.out.println("Data berhasil diupdate!");
            } else {
                System.out.println("data dengan id = " + id + " tidak ditemukan!");
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void deleteData(){
        System.out.println("Masukan id product : ");
        int id = input.nextInt();
        input.nextLine();

        try {
            // DriverManager.getConnection : buat ngehubungun ke database.
            Connection connection = DriverManager.getConnection(url, username, password);
            // preparedStatement untuk mengeksekusi query yang punya jumlah data banyak. ( ?, ?, ?) pada values untuk mencegah SQL Injection.
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM products where id = ?");
            preparedStatement.setInt(1, id);
            int rowsUpdated = preparedStatement.executeUpdate();
            // kondisi untuk cek apa ada data yang dihapus
            if (rowsUpdated > 0) {
                System.out.println("Data berhasil dihapus!");
            } else {
                System.out.println("data dengan id = " + id + " tidak ditemukan!");
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void orderProducts(){
        System.out.println("Masukan id product yang ingin di order : ");
        int id = input.nextInt();
        input.nextLine();

        System.out.println("Masukan quantity : ");
        int qty = input.nextInt();
        input.nextLine();

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO orders (product_id, order_date, quantity) values (?, ?, ?)");

            preparedStatement.setInt(1, id);
            preparedStatement.setDate(2, Date.valueOf(LocalDate.now()));
            preparedStatement.setInt(3, qty);

            int rowDeleted = preparedStatement.executeUpdate();
            if (rowDeleted > 0) {
                System.out.println("Order berhasil ditambahkan!");
            } else {
                System.out.println("Product dengan id = " + id + " tidak ditemukan!");
            }

        } catch (SQLException e) {
//            throw new RuntimeException(e);
            System.out.println(e.getMessage());
        }
    }



    public static void main(String[] args) {
        DemoCRUD demo = new DemoCRUD();
        Scanner input = new Scanner(System.in);

        while(true){
            System.out.println("====== MENU ======");
            System.out.println("1. View All Products");
            System.out.println("2. Add new Products");
            System.out.println("3. Edit products");
            System.out.println("4. Delete products");
            System.out.println("5. Order Products");
            System.out.println("0. Exit");
            System.out.print("Pilih menu : ");
            int menu = input.nextInt();
            input.nextLine();

            switch (menu){
                case 1:
                    demo.getData();
                    break;
                case 2:
                    demo.addData();
                    break;
                case 3:
                    demo.editData();
                    break;
                case 4:
                    demo.deleteData();
                    break;
                case 5:
                    demo.orderProducts();
                    break;
                case 0:
                    System.out.println("Thank you, Have a kapal api!");
                    input.close();
                    return;
                default:
                    System.out.println("Input tidak valid");
            }
        }
    }
}

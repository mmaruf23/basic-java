package day5;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.sql.*;
import java.util.Scanner;

public class Products {
    String url = "jdbc:postgresql://localhost:5432/task";
    String username = "postgres";
    String password = "root";
    Scanner input = new Scanner(System.in);

    // METHDO TAMBAH PRODUK
    public void addProduct(){

        System.out.println("Silahkan Masukan Data Produk : ");
        System.out.print("Nama : ");
        String name = input.nextLine();
        System.out.print("Harga : ");
        double price = input.nextDouble(); input.nextLine();
        System.out.print("Deskripsi : ");
        String description = input.nextLine();
        System.out.print("ID Category : ");
        int category_id = input.nextInt();
//        input.close();

        try (Connection connection = DriverManager.getConnection(url, username, password); // agar koneksi otomatis tertutup saat query selesai untuk mencegah resource leak
                 PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO products (name, price, description, category_id) VALUES (?, ?, ?, ?)"))
        {
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, price);
            preparedStatement.setString(3, description);
            preparedStatement.setInt(4, category_id);
            preparedStatement.executeUpdate();
            System.out.println("Data berhasil ditambahkan!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // METHDO UPDATE PRODUK
    public void updateProduct(){
        System.out.print("Masukan ID Product yang ingin diupdate : ");
        int id = input.nextInt();input.nextLine();
        System.out.print("Nama Baru : ");
        String name = input.nextLine();
        System.out.print("Harga Baru : ");
        double price = input.nextDouble(); input.nextLine();
        System.out.print("Deskripsi : ");
        String description = input.nextLine();
        System.out.print("ID Category : ");
        int category_id = input.nextInt(); input.nextLine();
//        input.close();


        try (Connection connection = DriverManager.getConnection(url, username, password); // agar koneksi otomatis tertutup saat query selesai untuk mencegah resource leak
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE products SET name = ?, price = ?, description = ?, category_id = ? WHERE id = ?;"))
        {
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, price);
            preparedStatement.setString(3, description);
            preparedStatement.setInt(4, category_id);
            preparedStatement.setInt(5, id);
            int updated = preparedStatement.executeUpdate();

            if (updated > 0){
                System.out.println("Product berhasil di Update");
            } else {
                System.out.println("Product dengan ID : " + id + " tidak ditemukan!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void updateProductPrice(){
        System.out.print("Masukan ID Product yang ingin diupdate : ");
        int id = input.nextInt();input.nextLine();
        System.out.print("Harga Baru : ");
        double price = input.nextDouble(); input.nextLine();
//        input.close();


        try (Connection connection = DriverManager.getConnection(url, username, password); // agar koneksi otomatis tertutup saat query selesai untuk mencegah resource leak
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE products SET price = ? WHERE id = ?;"))
        {
            preparedStatement.setDouble(1, price);
            preparedStatement.setInt(2, id);
            int updated = preparedStatement.executeUpdate();

            if (updated > 0){
                System.out.println("Harga Product berhasil di Update");
            } else {
                System.out.println("Product dengan ID : " + id + "Tidak ditemukan!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // METHOD HAPUS PRODUK
    public void deleteProduct(){
        int id;
        // input value disini
        while (true){
            System.out.print("Masukan i0d product yang ingin dihapus : ");
            id = input.nextInt();input.nextLine();
            if (id > 0){
                break;
            }
            System.out.println("ID produk tidak valid!");
        }
//        input.close();


        try (Connection connection = DriverManager.getConnection(url, username, password); // agar koneksi otomatis tertutup saat query selesai untuk mencegah resource leak
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM products where id = ?;"))
        {
            preparedStatement.setInt(1, id);
            int deleted = preparedStatement.executeUpdate();

            if (deleted > 0){
                System.out.println("Product berhasil dihapus");
            } else {
                System.out.println("Product dengan ID : " + id + "Tidak ditemukan!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // METHOD TAMPIL PRODUK
    public void showProduct(){
        try (Connection connection = DriverManager.getConnection(url, username, password); // agar koneksi otomatis tertutup saat query selesai untuk mencegah resource leak
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM products ORDER BY id"))
        {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            ObjectMapper mapper = new ObjectMapper();
            ArrayNode arrayNode = mapper.createArrayNode();

            while(resultSet.next()){
                ObjectNode objectNode = mapper.createObjectNode();
                for (int i = 1; i < columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    objectNode.put(columnName, resultSet.getString(i));
                }
                arrayNode.add(objectNode);

            }

            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayNode);
            System.out.println(jsonString);

        } catch (SQLException | JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void showMostExpensiveProduct(){
        try (Connection connection = DriverManager.getConnection(url, username, password); // agar koneksi otomatis tertutup saat query selesai untuk mencegah resource leak
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM products WHERE price = (SELECT MAX(price) FROM products)"))
        {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            ObjectMapper mapper = new ObjectMapper();
            ArrayNode arrayNode = mapper.createArrayNode();

            while(resultSet.next()){
                ObjectNode objectNode = mapper.createObjectNode();
                for (int i = 1; i < columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    objectNode.put(columnName, resultSet.getString(i));
                }
                arrayNode.add(objectNode);

            }

            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayNode);
            System.out.println(jsonString);

        } catch (SQLException | JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void showCheapestProduct(){
        try (Connection connection = DriverManager.getConnection(url, username, password); // agar koneksi otomatis tertutup saat query selesai untuk mencegah resource leak
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM products WHERE price = (SELECT MIN(price) FROM products)"))
        {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            ObjectMapper mapper = new ObjectMapper();
            ArrayNode arrayNode = mapper.createArrayNode();

            while(resultSet.next()){
                ObjectNode objectNode = mapper.createObjectNode();
                for (int i = 1; i < columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    objectNode.put(columnName, resultSet.getString(i));
                }
                arrayNode.add(objectNode);

            }

            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayNode);
            System.out.println(jsonString);

        } catch (SQLException | JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

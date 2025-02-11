package day5;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.*;

import java.sql.*;
import java.util.Scanner;

public class Customers {
    String url = "jdbc:postgresql://localhost:5432/store";
    String username = "postgres";
    String password = "root";
    Scanner input = new Scanner(System.in);


    public void addCustomer(){

        String newCustomer;
        // input value disini
        while (true){
            System.out.print("Masukan nama customer : ");
            newCustomer = input.nextLine();
            if (!newCustomer.isBlank()){
                break;
            }

            System.out.println("Nama customer tidak boleh kosong!");
        }
        System.out.print("Masukan alamat customer : ");
        String newAddress = input.nextLine();
        try (Connection connection = DriverManager.getConnection(url, username, password); // agar koneksi otomatis tertutup saat query selesai untuk mencegah resource leak
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customers (name, address) values (?, ?)"))
        {
            preparedStatement.setString(1, newCustomer);
            preparedStatement.setString(2, newAddress);
            preparedStatement.executeUpdate();
            System.out.println("Data berhasil ditambahkan!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateCustomer(){
        System.out.print("Masukan ID Customer yang ingin diupdate : ");
        int id = input.nextInt();input.nextLine();
        System.out.print("Nama Baru : ");
        String name = input.nextLine();
        System.out.print("Address Baru : ");
        String address = input.nextLine();
        input.close();


        try (Connection connection = DriverManager.getConnection(url, username, password); // agar koneksi otomatis tertutup saat query selesai untuk mencegah resource leak
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE customers SET name = ?, address = ? WHERE id = ?;"))
        {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);
            preparedStatement.setInt(3, id);
            int updated = preparedStatement.executeUpdate();

            if (updated > 0){
                System.out.println("Data customer berhasil di Update");
            } else {
                System.out.println("Data customer dengan ID : " + id + " tidak ditemukan!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void updateCustomerAddress(){
        System.out.print("Masukan ID Customer yang ingin diupdate : ");
        int id = input.nextInt();input.nextLine();
        System.out.print("Address Baru : ");
        String address = input.nextLine();


        try (Connection connection = DriverManager.getConnection(url, username, password); // agar koneksi otomatis tertutup saat query selesai untuk mencegah resource leak
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE customers SET address = ? WHERE id = ?"))
        {
            preparedStatement.setString(1, address);
            preparedStatement.setInt(2, id);
            int updated = preparedStatement.executeUpdate();

            if (updated > 0){
                System.out.println("Data customer berhasil di Update");
            } else {
                System.out.println("Data customer dengan ID : " + id + " tidak ditemukan!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void deleteCustomer(){
        int id;
        // input value disini
        while (true){
            System.out.print("Masukan id customer yang ingin dihapus : ");
            id = input.nextInt();input.nextLine();
            if (id > 0){
                break;
            }
            System.out.println("ID tidak valid!");
        }

        try (Connection connection = DriverManager.getConnection(url, username, password); // agar koneksi otomatis tertutup saat query selesai untuk mencegah resource leak
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM customers where id = ?;"))
        {
            preparedStatement.setInt(1, id);
            int deleted = preparedStatement.executeUpdate();

            if (deleted > 0){
                System.out.println("Data customer berhasil dihapus");
            } else {
                System.out.println("Customer dengan ID : " + id + " tidak ditemukan!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showCustomers(){
        try (Connection connection = DriverManager.getConnection(url, username, password); // agar koneksi otomatis tertutup saat query selesai untuk mencegah resource leak
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM customers ORDER BY id"))
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

    public void showTotalOrderPerCustomers(){
        try (Connection connection = DriverManager.getConnection(url, username, password); // agar koneksi otomatis tertutup saat query selesai untuk mencegah resource leak
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT o.id as order_id,c.name as customer_name, SUM(i.qty * p.price) AS total_order FROM orders o INNER JOIN order_items i ON o.id = i.order_id RIGHT JOIN customers c on o.customer_id = c.id FULL JOIN products p on i.product_id = p.id GROUP BY o.id, c.name ORDER BY o.id"))
        {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            ObjectMapper mapper = new ObjectMapper();
            ArrayNode arrayNode = mapper.createArrayNode();

            while(resultSet.next()){
                ObjectNode objectNode = mapper.createObjectNode();
                for (int i = 1; i <= columnCount; i++) {  // harus <= karena kolom dimulai dari 1
                    String columnName = metaData.getColumnName(i);
                    Object value = resultSet.getObject(i);
                    if (value != null) {
                        objectNode.put(columnName, value.toString());
                    } else {
                        objectNode.put(columnName, "0"); // Atau nilai default lain
                    }
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

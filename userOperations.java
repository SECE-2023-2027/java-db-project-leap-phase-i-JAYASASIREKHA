package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class userOperations {

    public static void createUserTable() {
        String sql = "CREATE TABLE IF NOT EXISTS customer ("
                   + "cust_id INT AUTO_INCREMENT PRIMARY KEY, "
                   + "name VARCHAR(50) NOT NULL, "
                   + "email VARCHAR(100) NOT NULL UNIQUE, "
                   + "password VARCHAR(100) DEFAULT NULL, "
                   + "mobile_no VARCHAR(40) DEFAULT NULL)";
        
        try (Connection connection = database_management.getConnection();
             Statement statement = connection.createStatement()) {
            
            statement.executeUpdate(sql);  // Fixed the missing semicolon
            System.out.println("User table created or already exists.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertUser(String name, String email, String password, String phone) {
        String sql = "INSERT INTO customer (name, email, password, mobile_no) VALUES (?, ?, ?, ?)";
        
        try (Connection connection = database_management.getConnection(); // Fixed connection usage
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setString(4, phone);
            int rowsInserted = statement.executeUpdate();
            
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully.");
            }

        } catch (SQLException e) {
            System.err.println("Error inserting user. Possible duplicate email or missing data.");
            e.printStackTrace();
        }
    }

    public static void readUsers() {
        String sql = "SELECT * FROM customer"; // Fixed table and column names
        
        try (Connection connection = database_management.getConnection(); // Fixed connection usage
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            System.out.println("User Records:");
            while (resultSet.next()) {
                int id = resultSet.getInt("cust_id");  // Corrected column name
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String phone = resultSet.getString("mobile_no");  // Corrected column name
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email + ", Password: " + password + ", Phone: " + phone);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateUser(int id, String newName, String newEmail) {
        String sql = "UPDATE customer SET name = ?, email = ? WHERE cust_id = ?";  // Corrected table and column names
        try (Connection connection = database_management.getConnection(); // Fixed connection usage
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, newName);
            statement.setString(2, newEmail);
            statement.setInt(3, id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User updated successfully.");
            } else {
                System.out.println("No user found with ID: " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser(int id) {
        String sql = "DELETE FROM customer WHERE cust_id = ?";  // Corrected table and column names
        
        try (Connection connection = database_management.getConnection(); // Fixed connection usage
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setInt(1, id);
            
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("User with ID " + id + " was deleted successfully.");
            } else {
                System.out.println("No user found with ID: " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createUserTable();
        deleteUser(13);
        insertUser("Jayasasirekha M", "jayasasirekha@gmail.com", "jayasasi@123", "8870455749");
        updateUser(2, "jaya rinitha", "jr@gmail.com");
        readUsers();
    }
}

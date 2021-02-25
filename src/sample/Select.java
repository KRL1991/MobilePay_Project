package sample;

import java.sql.*;
import java.util.Scanner;

public class Select {


    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect() {

        // SQLite connection string
        String url = "jdbc:sqlite:brugere.sqlite";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    /**
     * select all rows in the warehouses table
     */
    public void selectAll() {

        String sql = "SELECT * FROM main.Brugere";


        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("ID") + ".\n" +
                        rs.getString("Navn") + "\n" +
                        rs.getString("Telefon") + "\n" +
                        rs.getString("Adresse") + "\n" +
                        rs.getString("KortNummer") + "\n" +
                        rs.getString("RegistrationsDato") + "\n\n"

                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectOverførsler (){

    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Select app = new Select();
        app.selectAll();
    }
}


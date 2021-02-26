package selector;

import java.sql.*;

public class Select {


    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    public Connection connect() {

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

        String overFørsler = "SELECT * FROM main.Overførsler";


        try (Connection conn = this.connect();
             Statement stmt1 = conn.createStatement();
             ResultSet rs1 = stmt1.executeQuery(overFørsler)) {

            // loop through the result set
            while (rs1.next()) {
                System.out.println(rs1.getInt("ID") + ".\n" +
                        rs1.getString("Til") + "\n" +
                        rs1.getString("Fra") + "\n" +
                        rs1.getString("Beløb") + "\n" +
                        rs1.getString("Dato") + "\n" +"\n+\n"


                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }



    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Select app = new Select();
        app.selectAll();
        app.selectOverførsler();
    }
}


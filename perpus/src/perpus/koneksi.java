package perpus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database connection class
 * @author Frans Bima
 */
public class koneksi {
    private static Connection koneksi;

    public static Connection getKoneksi() {
        if (koneksi == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/db_perpus";
                String user = "root";
                String password = "";
                koneksi = DriverManager.getConnection(url, user, password);
                System.out.println("Berhasil");
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return koneksi;
    }

    public static void main(String[] args) {
        getKoneksi();
    }
}
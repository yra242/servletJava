package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class MagazineService {
    private static MagazineService magazineService;

    private MagazineService() {
    }

    public static MagazineService getMagazineService() {
        if (magazineService == null) {
            magazineService = new MagazineService();
        }
        return magazineService;
    }
    public List<String> getAllMagazineNames() throws SQLException {
        List<String> magazineNames = new ArrayList<>();
        String query = "SELECT name FROM Magazines";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                magazineNames.add(rs.getString("name"));
            }
        }
        return magazineNames;
    }
    public void addMagazine(Magazine magazine) throws SQLException {
        String query = "INSERT INTO Magazines (name, text) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, magazine.getNameMagazine());
            stmt.setString(2, magazine.getTextMagazine());
            stmt.executeUpdate();
        }
    }

    public void addMagazineName(String magazineName) throws SQLException {
        // Corrected query to include both name and an empty text.
        String query = "INSERT INTO Magazines (name, text) VALUES (?, '')";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, magazineName);
            stmt.executeUpdate();
        }
    }

    public Magazine getMagazine(String nameMagazine) throws SQLException {
        String query = "SELECT name, text FROM Magazines WHERE name = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nameMagazine);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Fetching the correct column names.
                    String name = rs.getString("name");
                    String text = rs.getString("text");
                    return new Magazine(name, text);
                }
            }
        }
        return null;
    }
    public void updateMagazineText(String magazineName, String newText) throws SQLException {
        String query = "UPDATE Magazines SET text = ? WHERE name = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newText);
            stmt.setString(2, magazineName);
            stmt.executeUpdate();
        }
    }

}

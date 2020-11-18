package lesson_b;

import java.sql.*;

public class MainDB {

    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;

    public static void main(String[] args) {

        try {
            connect();
            // 1
            createTable("test");

            // 2
            addRecord("test", "smth");

            // 3
            getRecord("test", 1);

            // 4
            deleteRecord("test", 1);

            // 5
            dropTable("test");

            disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void createTable(String name) throws Exception {
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS " + name + "(\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	text text NOT NULL\n"
                + ");");
    }

    private static void addRecord(String name, String text) throws Exception {
        pstmt = connection.prepareStatement("INSERT INTO " + name + " (text) values (?);");
        pstmt.setString(1, text);
        pstmt.addBatch();
        pstmt.executeBatch();
    }

    private static void getRecord(String name, int id) throws Exception {
        ResultSet res = stmt.executeQuery("SELECT * FROM " + name + " WHERE id = " + id);
        System.out.println(res.getString("text"));
    }

    private static void deleteRecord(String name, int id) throws Exception {
        stmt.executeUpdate("DELETE FROM " + name + " WHERE id = " + id + ";");
    }

    private static void dropTable(String name) throws Exception {
        stmt.executeUpdate("DROP TABLE IF EXISTS " + name + ";");
    }

    private static void connect() throws Exception {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
    }

    private static void disconnect() throws SQLException {
        connection.close();
    }

}

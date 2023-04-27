package org.example.Kayak;

import java.sql.*;

public class DbConnection {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/seleniumData";
        String user = "postgres";
        String password = "Pinokis_890";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String hotelsTable = "CREATE TABLE products " +
                        "(id SERIAL PRIMARY KEY, " +
                        "hotel_title VARCHAR(250), " +
                        "price INT, " +
                        "address VARCHAR(250))";

            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(hotelsTable);
                System.out.println("Table created successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


//    public static void main(String[] args) {
////        DbConnection tableCreation = new DbConnection();
////        tableCreation
////    }
//
        public static PreparedStatement databaseConn (String sql){
            String url = "jdbc:postgresql://localhost/seleniumData";
            String user = "postgres";
            String password = "Pinokis_890";

            try{
                Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement pstmt = conn.prepareStatement(sql);
                return pstmt;
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                return null;
            }
        }
    }



//
//            try (Connection con = DriverManager.getConnection(url, user, password);
//                 Statement stmt = con.createStatement()) {
//
//                String hotelsTable = "CREATE TABLE products " +
//                        "(id SERIAL PRIMARY KEY, " +
//                        "hotel_title VARCHAR(250), " +
//                        "price INT, " +
//                        "address VARCHAR(250))";
//
//                stmt.executeUpdate(hotelsTable);
//                System.out.println("Table created successfully!");
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
////        return null;
//        }
//    }
//}

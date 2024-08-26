package org.example;
import java.sql.Connection;
import db.DB;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Connection conn = DB.getConnection();
        DB.closeConnection();
    }
}
package com.juaracoding.rrspringboot4.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConn {
	public static void main(String[] args) {
		String url = "jdbc:sqlserver://localhost;" +
				"instanceName=SQLEXPRESS01;" +
				"databaseName=Batch26;" +
				"encrypt=true;" +
				"trustServerCertificate=true;";

		String user = "sa";
		String password = "password";

		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			System.out.println("Koneksi berhasil!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
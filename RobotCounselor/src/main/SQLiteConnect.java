package main;

import java.sql.*;
import java.util.ArrayList;


public class SQLiteConnect {
	private static Connection conn = null;
	
	
	/**
	 * Creates default database
	 * @param args
	 */
	public static void main(String[] args) {
		connect("Classes.db");
                connect("StudentSchedule.db");
	}
	
	/**
	 * Connects to database file
	 * @return
	 */
	public static Connection connect(String database) {
            String url = "jdbc:sqlite:" + database;
            try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(url);
                        System.out.println("Connected");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return conn;
	}
	
	/**
	 * Updates a student's schedule
	 * @param info
         * @param name
	 */
	public void updateStudent(String name, ArrayList<String> info) {
		String sql = "UPDATE Schedules SET"
				+ " WHERE Name = ? ,"
				+ " Subject1 = ? ,"
				+ " Subject2 = ? ,"
				+ " Subject3 = ? ,"
				+ " Subject4 = ? ,"
				+ " Subject5 = ? ,"
				+ " Subject6 = ? ,"
                                + " Subject7 = ? ,"
                                + " Subject8 = ? ,"
                                + " Subject9 = ?";
		try {
			PreparedStatement input = connect("StudentSchedule.db").prepareStatement(sql);
			input.setString(1, name);
                        for (int i = 0; i <= 10; i++) {
                            input.setString(i+2, info.get(i));
                        }
			input.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Creates a new student from the database
	 * @param info
         * @param name
	 */
	public void addStudent(String name, ArrayList<String> info) {
		String sql = "INSERT INTO Schedules("
				+ " Name = ? ,"
				+ " Subject1 = ? ,"
				+ " Subject2 = ? ,"
				+ " Subject3 = ? ,"
				+ " Subject4 = ? ,"
				+ " Subject5 = ? ,"
				+ " Subject6 = ? ,"
                                + " Subject7 = ? ,"
                                + " Subject8 = ? ,"
                                + " Subject9 = ?)";
		try {
			PreparedStatement input = connect("StudentSchedule.db").prepareStatement(sql);
			input.setString(1, name);
                        for (int i = 0; i <= 10; i++) {
                            input.setString(i+2, info.get(i));
                        }
			input.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Deletes a student from this plane of existence
	 * @param name
	 */
	public void deleteStudent(String name) {
		String sql = "DELETE FROM Schedules WHERE Name = ?";
		try {
			PreparedStatement input = connect("StudentSchedule.db").prepareStatement(sql);
			input.setString(1, name);
                        input.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
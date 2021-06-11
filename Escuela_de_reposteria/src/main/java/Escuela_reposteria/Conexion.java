package Escuela_reposteria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

	public static Connection AbrirConexion(){

		try {

			Class.forName("com.mysql.jdbc.Driver");

			String base = "jdbc:mysql://localhost:3306/Programacion?useSSL=false";
			String usuario = "Program";
			String pass = "root";
			Connection conexion = DriverManager.getConnection(base, usuario, pass);
			return conexion;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("No encontrado");
			return null;
		} catch (SQLException e) {
			System.out.println("Ha habido un fallo al conectar con la base de datos");
			return null;
		}
	}

	public Statement createStatement() {
		// TODO Auto-generated method stub
		return null;
	}
}

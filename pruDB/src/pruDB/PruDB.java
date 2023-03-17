package pruDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class PruDB {
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://127.0.0.1:3307/prueba";
		String user = "alumno";
		String password = "alumno";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			
			//SELECT
//			Statement stmt = con.createStatement();
//			//createStatement para consultas simples sin parametros
//			ResultSet rs = stmt.executeQuery("SELECT * FROM persona");
//			while (rs.next()) {
//			    int id = rs.getInt("id");
//			    String nombre = rs.getString("nombre");
//			    int edad = rs.getInt("edad");
//			    System.out.println("ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad);
//			}
//			rs.close();
//			stmt.close();
			
			//SELECT MÚLTIPLE
		PreparedStatement sel_pstmt = con.prepareStatement("SELECT * FROM persona WHERE edad>?");
			
			sel_pstmt.setInt(1, 2);
			ResultSet rs_sel = sel_pstmt.executeQuery();
			
			while (rs_sel.next()) {
			    int id = rs_sel.getInt("id");
			    String nombre = rs_sel.getString("nombre");
			    int edad = rs_sel.getInt("edad");
			    System.out.println("ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad);
			}
			rs_sel.close();
			sel_pstmt.close();
			
			
						
			//INSERT
//			PreparedStatement ins_pstmt = con.prepareStatement("INSERT INTO persona (id, nombre, edad) VALUES (?, ?, ?)");
			//preparedStament para operaciones con parametros ("?") que hay que rellenar
//			ins_pstmt.setInt(1, 4);
//			ins_pstmt.setString(2, "Moi");
//			ins_pstmt.setDouble(3,45);
//			int rowsInserted = ins_pstmt.executeUpdate();
//			ins_pstmt.close();
			
			//UPDATE
//			PreparedStatement upd_pstmt = con.prepareStatement("UPDATE persona SET edad = ? WHERE id = ?");
//			upd_pstmt.setInt(1, 4);
//			upd_pstmt.setInt(2, 1);
//			int rowsUpdated = upd_pstmt.executeUpdate();
//			upd_pstmt.close();
//			
//			//DELETE
//			PreparedStatement dele_pstmt = con.prepareStatement("DELETE FROM persona WHERE id = ?");
//			dele_pstmt.setInt(1, 1);
//			int rowsDeleted =dele_pstmt.executeUpdate();
//			dele_pstmt.close();

			
			
			
			
			con.close();



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}

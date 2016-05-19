package bbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import clases.Proveedor;

public class BBDDProveedor {
	private static Statement s;
	private static Connection c;
	private static ResultSet reg;
	
	public static void crear(Proveedor proveedor, Connection c){
		String cadena="INSERT INTO ordenador VALUES('" + proveedor.getNombre() 
				+ "','" + proveedor.getDireccion() + "','" + proveedor.getTelefono() +"')"; 	

		try{
			s=c.createStatement();
			s.executeUpdate(cadena);
			s.close();
		}
		catch ( SQLException e){
			System.out.println(e.getMessage());
		}
	}
}

package bbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import clases.Productos;

public class BBDDProductos {
	private static Statement s;
	private static Connection c;
	private static ResultSet reg;
	
	public static void crear(Productos productos, Connection c){
		String cadena="INSERT INTO ordenador VALUES('" + productos.getCod_Productos() 
				+ "','" + productos.getNombre_Proveedor() + "','" + productos.getTipo_de_Productos() 
				+ "','" + productos.getPrecio() + "','" + productos.getNombre() + "','" 
				+ productos.getCantidad() +"')"; 	

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

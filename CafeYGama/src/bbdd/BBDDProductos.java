package bbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;

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

	
		
	public static void pedir(Productos p, Connection c){
		 String cadena="UPDATE productos SET Cantidad'" + "':='" + 20 +
		           "'WHERE Cantidad<='" + 5 + "'";
		
		try{
			s=c.createStatement();
			s.executeUpdate(cadena);
			s.close();
		}
		catch ( SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void realizarPedido(Productos P, Connection c){
		String cadena="UPDATE productos SET cantidad'"+":='" + (P.getCantidad()) + "'-1'" +
				"'WHERE Nombre'"+":="+P.getNombre()+"'";
		
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

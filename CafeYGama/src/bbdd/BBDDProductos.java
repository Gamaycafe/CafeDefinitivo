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
	
	public static void realizarPedido(Productos p, Connection c){
		String cadena="UPDATE productos SET cantidad'"+":='" + (p.getCantidad()) + "'-1'" +
				"'WHERE Nombre'"+":="+p.getNombre()+"'";
		
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

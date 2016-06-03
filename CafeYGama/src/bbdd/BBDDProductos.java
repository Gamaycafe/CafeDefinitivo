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
	
	public static double realizarPedido(Productos p, Connection c){
		String cadenaSQL="select Precio,cantidad from productos where Nombre='" + p.getNombre() + "'";
		
		
		double importe=0;
		int cantidad=0;
		try{
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			if (reg.next()){
				importe=reg.getDouble(1);
				cantidad=reg.getInt(2);
				
				}
			
			String cadena="UPDATE productos SET cantidad"+"='" + (cantidad-1) +
					"'WHERE Nombre"+"='"+p.getNombre()+"'";
			
			s.executeUpdate(cadena);
			s.close();
			return importe;
		}
		catch ( SQLException e){
			System.out.println(e.getMessage());
			return -1;
		}
		
}
}

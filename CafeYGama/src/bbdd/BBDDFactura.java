package bbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import clases.Factura;

public class BBDDFactura {
	private static Statement s;
	private static Connection c;
	private static ResultSet reg;
	
	public static void crear(Factura factura, Connection c){
		String cadena="INSERT INTO ordenador VALUES('" + factura.getNumero_Factura() 
				+ "','" + factura.getCodigo_Empleado()+ "','" + factura.getNumero_Conexion() 
				+ "','" + factura.getImporte() + "','" + factura.getFecha() + "','"
				+ factura.getDescuento() +"')"; 	

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

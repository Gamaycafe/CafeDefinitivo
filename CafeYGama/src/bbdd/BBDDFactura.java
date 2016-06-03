package bbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import clases.Factura;

/**
 * @author Miguel Arada Benavides
 * 
**/

public class BBDDFactura {
	
	private static Statement s;
	private static Connection c;
	private static ResultSet reg;
	
	
	
	public static Connection getC() {
		return c;
	}



	public static void setC(Connection c) {
		BBDDFactura.c = c;
	}



	public static ResultSet getReg() {
		return reg;
	}



	public static void setReg(ResultSet reg) {
		BBDDFactura.reg = reg;
	}



	public static void crear (Factura factura, Connection c){
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
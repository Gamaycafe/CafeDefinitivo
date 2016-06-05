package bbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

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
		String cadena="INSERT INTO factura VALUES(null,'" + factura.getCodigo_Empleado()+ "','" + (int)Math.floor(Math.random()*(100 -1)+1) 
	    + "','"  + factura.Importe + "','" + LocalDate.now()+"')"; 
		
		
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
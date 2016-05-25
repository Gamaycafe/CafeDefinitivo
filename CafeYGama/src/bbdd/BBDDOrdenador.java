package bbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import clases.Ordenador;

/**
 * @author Miguel Arada Benavides
 * 
**/

public class BBDDOrdenador {
	private static Statement s;
	private static Connection c;
	private static ResultSet reg;
	
	/**
	 * 
	 * @param ordenador
	 * @param c
	 */
	public static void alta(Ordenador ordenador, Connection c){
		String cadena="INSERT INTO ordenador VALUES('" + ordenador.getCodigo() +"')"; 	

		try{
			s=c.createStatement();
			s.executeUpdate(cadena);
			s.close();
		}
		catch ( SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void baja(Ordenador ordenador, Connection c){
		String cadena="DELETE FROM ORDENADOR WHERE  Codigo_Ordeandor='" + ordenador.getCodigo() +"'";	
		
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
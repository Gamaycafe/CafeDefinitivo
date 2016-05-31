package bbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import clases.Ordenador;
import clases.Usuario;

/**
 * @author Miguel Arada Benavides
 * 
**/

public class BBDDOrdenador {
	private static Statement s;
	private static Connection c;
	private static ResultSet reg;
	
	public static Connection getC() {
		return c;
	}

	public static void setC(Connection c) {
		BBDDOrdenador.c = c;
	}


	/**
	 * 
	 * @param ordenador
	 * @param c
	 */
	public static void alta(Ordenador ordenador, Connection c){
		String cadena="INSERT INTO ordenadores VALUES('" + ordenador.getCodigo() +"')"; 	

		try{
			s=c.createStatement();
			s.executeUpdate(cadena);
			s.close();
		}
		catch ( SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	public static String buscarOrdenador(Ordenador ordenador, Connection c){
		
		String cadena="SELECT Codigo_Ordenador FROM ordenadores WHERE Codigo_Ordenador='" +ordenador.getCodigo() +"'";
		try{
			s=c.createStatement();
			reg=s.executeQuery(cadena);
			if ( reg.next()){
				String t=reg.getString(1);
				s.close();
				return t;
			}
			s.close();
			return "";
		}
		catch ( SQLException e){
			return null;
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
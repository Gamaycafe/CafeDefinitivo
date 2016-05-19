package bbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import clases.Ordenador;

public class BBDDOrdenador {
	private static Statement s;
	private static Connection c;
	private static ResultSet reg;
	
	public static void crear(Ordenador ordenador, Connection c){
		String cadena="INSERT INTO ordenador VALUES('" + ordenador.getCodigo() + "','" + ordenador.getContador() +"')"; 	

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

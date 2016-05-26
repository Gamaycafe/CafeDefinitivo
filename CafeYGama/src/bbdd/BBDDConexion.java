package bbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.*;

import clases.Conexion;
import clases.Ordenador;

public class BBDDConexion {
	private static Statement s;
	private static Connection c;
	private static ResultSet reg;
	
	
	public static void crear(Conexion conexion, Connection c){
		String cadena="INSERT INTO ordenador VALUES('" + conexion.getNumero_Conexion() 
				+ "','" + conexion.getCodigo_Ordenador() + "','" + conexion.getCodigo_Socio() 
				+ "','" + conexion.getHora_Inicio() + "','" + conexion.getHora_Final() +"')"; 	

		try{
			s=c.createStatement();
			s.executeUpdate(cadena);
			s.close();
		}
		catch ( SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void iniciar(Conexion conexion, Ordenador ordenador, Connection c){
		String cadena="UPDATE conexion SET Hora_Inicio'" + "':='" + LocalTime.now() +
				"'WHERE Codigo_Ordenador'" + "':='" + ordenador.getCodigo() + "'";
		
		try{
			s=c.createStatement();
			s.executeUpdate(cadena);
			s.close();
			}
			catch ( SQLException e){
				System.out.println(e.getMessage());
			}
	}
	
	public static void finalizar(Conexion conexion, Ordenador ordenador,Connection c){
		String cadena="UPDATE conexion SET Hora_Final'" + "':='" + LocalTime.now() +
				"'WHERE Codigo_Ordenador'" + "':='" + ordenador.getCodigo() + "'";
		
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

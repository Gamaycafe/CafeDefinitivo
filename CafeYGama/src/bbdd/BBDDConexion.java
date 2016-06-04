package bbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.*;

import clases.Conexion;
import clases.Ordenador;
import clases.Usuario;

public class BBDDConexion {
	private static Statement s;
	private static Connection c;
	private static ResultSet reg;

	
	
	public static Connection getC() {
		return c;
	}

	public static void setC(Connection c) {
		BBDDConexion.c = c;
	}

	public static void crear(Conexion conexion, Connection c){
	
	
		String cadena="INSERT INTO conexion VALUES('" + conexion.getCodigo_Ordenador() + "','" + conexion.getUsuario() 
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
	
	public static void iniciar(Conexion conexion, Usuario usuario, Ordenador ordenador, Connection c){
		String cadena="INSERT INTO conexion VALUES( null,'" + ordenador.getCodigo() + "','"  + LocalTime.now() + "', 0,'" + usuario.getDNI() 
		+ "')";
		
		//Igualar hora final a null, que sea insert, y ...
		
		
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
		String cadena="UPDATE conexion SET Hora_Final ='" + LocalTime.now() +
				"'WHERE Codigo_Ordenador ='" + ordenador.getCodigo() + "'";
		
		try{
			s=c.createStatement();
			s.executeUpdate(cadena);
			s.close();
			}
			catch ( SQLException e){
				System.out.println(e.getMessage());
			}
	}
	
	public static int getNumeroConexion(Connection c){
		String cadena="SELECT MAX(Numero_Conexion) FROM conexion";
		
		try{
			s=c.createStatement();
			reg=s.executeQuery(cadena);
			if (reg.next()){
				return reg.getInt(1);
			}
			s.close();
			return 0;
			}
			catch ( SQLException e){
				System.out.println(e.getMessage());
				return -1;
			}
	}
	
}


/*		
				//INICIO (acuerdate de inicializar las variables Horainicio y Horafinal).
				
				mibase.abrir();
				BBDDConexion.iniciar(conexion, u, ordenador, mibase.getConexion());
				mibase.cerrar();
				
				Horainicio = LocalTime.now();
				
				
				//FINALIZAR
				
				BBDDConexion.finalizar(conexion, ordenador, mibase.getConexion());
				mibase.cerrar();
				
				Horafinal = LocalTime.now();
				
				mibase.abrir();
				Conexion.tiempo(Horainicio, Horafinal);
				mibase.cerrar();
*/
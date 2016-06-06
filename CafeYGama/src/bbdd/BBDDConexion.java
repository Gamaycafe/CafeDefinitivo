package bbdd;
/**
 * @author: Victor_Alvarez
 * @version: 04/06/2016
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.*;

import clases.Conexion;
import clases.Ordenador;
import clases.Usuario;

public class BBDDConexion {

	//Campos de la clase
	private static Statement s;
	private static Connection c;
	private static ResultSet reg;



	public static Connection getC() {
		return c;
	}

	public static void setC(Connection c) {
		BBDDConexion.c = c;
	}

	/**
	 * Este método está en desuso.
	 * @param conexion Se pasa la conexion
	 * @param c  Se pasa la conexion
	 */
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
	//Cierre del método


	/**
	 * 
	 * @param conexion se pasa la coenxion
	 * @param usuario se pasa la info de usuario
	 * @param c se pasa la conexion
	 * @param ordenador pasas info de ordenador
	 * Este método se utilizará para crear e iniciar la conexión de un ordenador, guardando la hora en la que se accede a él.
	 */
	public static void iniciar(Conexion conexion, Usuario usuario, Ordenador ordenador, Connection c){
		int numeroAlatorio = getNumeroConexion(c) + 1;
		LocalTime horaIni = LocalTime.now();
		String cadena="INSERT INTO conexion VALUES( " + numeroAlatorio + ",'" + ordenador.getCodigo() + "','"  + horaIni + "', 0,'" + usuario.getDNI() 
		+ "')";



		try{
			s=c.createStatement();
			s.executeUpdate(cadena);
			s.close();
			conexion.setNumero_Conexion(numeroAlatorio);
			conexion.setHora_Inicio(horaIni);
		}
		catch ( SQLException e){
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Este método se utilizará para finalizar la conexión de un ordenador, guardando la hora en la que se cierra sesión.
	 * @param conexion pasan los datos de conexion
	 * @param ordenador se pasan los datos de ordenador
	 * @param c se pasa la conexion
	 */
	
	public static void finalizar(Conexion conexion, Ordenador ordenador,Connection c){
		LocalTime horaFin = LocalTime.now();
		String cadena="UPDATE conexion SET Hora_Final ='" + horaFin +
				"' WHERE Codigo_Ordenador ='" + ordenador.getCodigo() + "'";

		try{
			s=c.createStatement();
			s.executeUpdate(cadena);
			s.close();
			conexion.setHora_Final(horaFin);
		}
		catch ( SQLException e){
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Este método está en desuso.
	 * @param c Se pasa la conexion
	 * @return devuleve nconexion
	 */
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


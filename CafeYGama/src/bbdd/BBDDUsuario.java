package bbdd;

/**
 * @author: Jaime_Grisolia
 * @version: 24/05/2016
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import clases.Empleados;
import clases.Usuario;

public class BBDDUsuario {
	private static Statement s;
	private static Connection c;
	private static ResultSet reg;
	
	
	
	public static Connection getC() {
		return c;
	}

	public static void setC(Connection c) {
		BBDDUsuario.c = c;
	}

	/**
     * Método que sera utilizado para la creacion de un nuevo usuario o socio, dependiendo de si tiene o no Codigo_Socio
     */
	public static void crear(Usuario usuario, Connection c){
		String cadena="INSERT INTO Usuarios VALUES('"+ usuario.getNombre() + "','"  + usuario.getContraseña() 
				+ "','" + usuario.getDNI() + "','" 
				+ usuario.getCodigo_Socio()+"')"; 	

		try{
			s=c.createStatement();
			s.executeUpdate(cadena);
			s.close();
		}
		catch ( SQLException e){
			System.out.println(e.getMessage());
		}
	}

	/**
     * Método que sera utilizado como su nombre indica, de buscar un usuario o socio en nuestra BBDD.
     ** @return El codigo de socio del cliente que introduzcamos, siendo " " si el cliente intoducido es usuario, pero no socio,
     * o siendo un codigo de socio del estilo (letra letra letra numero) si es socio.
     */
	public static String buscarUsuario(Usuario u, Connection c){
		
		String cadena="SELECT Codigo_Socio FROM Usuarios WHERE DNI='" +u.getDNI() +"' AND Contraseña='" + u.getContraseña() +"'";
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
	public static void borrar(Usuario u, Connection c){
		String cadena="DELETE FROM Usuarios WHERE DNI='" + u.getDNI()+"'";	
		
		try{
		s=c.createStatement();
		s.executeUpdate(cadena);
		s.close();
		}
		catch ( SQLException e3){
			System.out.println(e3.getMessage());
		}
	}

}

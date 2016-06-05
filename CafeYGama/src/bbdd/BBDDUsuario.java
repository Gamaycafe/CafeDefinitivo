package bbdd;

/**
 * @author: Jaime_Grisolia
 * @version: 05/06/2016
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
	 * @param usuario pasas la informacion del usuario
	 * @param c pasas la conexion
     * M�todo que sera utilizado para la creacion de un nuevo usuario o socio, dependiendo de si tiene o no Codigo_Socio
     */
	public static void crear(Usuario usuario, Connection c){
		String cadena="INSERT INTO Usuarios VALUES('"+ usuario.getNombre() + "','"  + usuario.getContrase�a() 
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
     * M�todo que sera utilizado como su nombre indica, de buscar un usuario o socio en nuestra BBDD.
     *@param u pasas los datos de usuario
     *@param c Pasas la conexion
     *@return El codigo de socio del cliente que introduzcamos, siendo "U" si el cliente intoducido es usuario, pero no socio,
     * o siendo un codigo de socio del estilo (letra letra letra numero) si es socio.
     */
	public static String buscarUsuario(Usuario u, Connection c){
		
		String cadena="SELECT Codigo_Socio FROM Usuarios WHERE DNI='" +u.getDNI() +"' AND Contrase�a='" + u.getContrase�a() +"'";
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
	/**
	 * @param u pasas los datos de usuario
	 * @param  c pasas los datos de conexion
     * M�todo que sera utilizado para la borrar un nuevo usuario o socio, de nuestra base de datos, dependiendo de si tiene o no Codigo_Socio
     */
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

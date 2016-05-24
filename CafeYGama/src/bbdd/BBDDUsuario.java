package bbdd;

//@autor Jaime_Grisolía

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import clases.Usuario;

public class BBDDUsuario {
	private static Statement s;
	private static Connection c;
	private static ResultSet reg;
	
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
	

}

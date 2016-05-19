package bbdd;

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
		String cadena="INSERT INTO ordenador VALUES('" + usuario.getCodigo_Socio() + "','" + usuario.getDNI() + "','" + usuario.getNombre() + "','" + usuario.getContraseña() +"')"; 	

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

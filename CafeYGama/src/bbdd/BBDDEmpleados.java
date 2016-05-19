package bbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import clases.Empleados;

public class BBDDEmpleados {
	private static Statement s;
	private static Connection c;
	private static ResultSet reg;
	
	public static void crear(Empleados empleado, Connection c){
		String cadena="INSERT INTO ordenador VALUES('" + empleado.getCodigo_Empleado() 
				+ "','" + empleado.getDNI() + "','" + empleado.getNombre() + "','" 
				+ empleado.getApellido() + "','" + empleado.getDireccion() + "','" 
				+ empleado.getTelefono() + "','" + empleado.getTipo_de_Contacto() + "','" 
				+ empleado.getAntigüedad() + "','" + empleado.getSueldo() + "','" 
				+ empleado.getCargo() + "','" + empleado.getNumero_SS() +"')"; 	

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

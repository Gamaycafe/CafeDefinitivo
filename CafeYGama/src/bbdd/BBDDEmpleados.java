package bbdd;

/**
 * @author: Jaime_Grisolia
 * @version: 05/06/2016
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import clases.Empleados;

public class BBDDEmpleados {
	private static Statement s;
	private static Connection c;
	private static ResultSet reg;
	
	
	
	public static Connection getC() {
		return c;
	}




	public static void setC(Connection c) {
		BBDDEmpleados.c = c;
	}



	/**
     * Método que sera utilizado para la creacion de un nuevo empleado.
     */
	public static void crear(Empleados empleado, Connection c){
		String cadena="INSERT INTO Empleados VALUES('" + empleado.getCodigo_Empleado() 
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
	

	
	/**
     * Método que sera utilizado como su nombre indica, de buscar un empleado en nuestra BBDD.
     ** @return El cargo del empleado que introduzcamos.
     */
	
	public static String buscarEmple(Empleados e, Connection c){
		
		String cadena="SELECT Cargo FROM Empleados WHERE Codigo_Empleado='" +e.getCodigo_Empleado() +"'";
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
		catch ( SQLException e2){
			return null;
			
		}
}
	
	/**
     * Método que sera utilizado para la borrar un nuevo empleado, de nuestra base de datos.
     */
	public static void borrar(Empleados e, Connection c){
		String cadena="DELETE FROM Empleados WHERE  Codigo_Empleado='" + e.getCodigo_Empleado()+"'";	
		
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


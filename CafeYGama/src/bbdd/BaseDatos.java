package bbdd;
/*
 * 
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */

/**
 
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */

import java.sql.*;


public class BaseDatos {
	private String base;
	private String usuario;
	private String pass;
	private String url;
	private Connection c;
	
	
	
	public BaseDatos(String cibercafe){		
		base=cibercafe;
		usuario="root";
		pass="";
		url="jdbc:mysql://localhost/"+base;
	}
	
	public void abrir(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
		try{
		 	c=DriverManager.getConnection(url,usuario,pass);
		}
		catch (SQLException e ){
			System.out.println(e.getMessage());
		}
	
	}	
	

	public void cerrar(){
		try{
			c.close();
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
			
		}
	}
	
	public Connection getConexion(){
		return c;
	}
}

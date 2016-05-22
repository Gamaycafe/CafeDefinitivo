package main;
import java.nio.*;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.APPEND;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;

import bbdd.BaseDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class Main {
	
	private static String _usuario="root";
	private static String _pwd= "";
	private static String _bd="cibercafe";
	static String _url = "jdbc:mysql://localhost/"+_bd;
	private Connection conn = null;
	
	public static void main(String[] args) throws SQLException {

		Scanner sc = new Scanner(System.in);
		
		/*try {
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		    System.out.println("Registro exitoso");

		} catch (Exception e) {

		    System.out.println(e.toString());

		}
		

		try{
			Class.forName("com.mysql.jdbc.Connection");
			Connection conexion = DriverManager.getConnection (_url,_usuario,_pwd);
			if(conexion != null)
			{
				System.out.println("Conexi-n a base de datos "+"jdbc:mysql://localhost/cibercafe"+" . . . Ok");
			}
		}
		catch(SQLException ex)
		{
			System.out.println("Hubo un problema al intentar conecarse a la base de datos"+"jdbc:mysql://localhost/cibercafe");
		}
		catch(ClassNotFoundException ex)
		{
			System.out.println(ex);
		}		*/
	
		
		BaseDatos mibase=new BaseDatos("cibercafe");
		
		mibase.abrir();
		
		System.out.println("---------------------------");
		System.out.println("Bienvenidos a Gama y Cafe");
		System.out.println("---------------------------");
		System.out.println();
		System.out.println("Acceder zona Cliente=>1");
		System.out.println("Acceder zona Empleado=>2");

		int opcionInicial=sc.nextInt();

		switch (opcionInicial) {
		case 1:
			
			System.out.println("\n1.Conectarse como socio\n2.Conectarse como Usuario \n3.Salir");

			int opcion=sc.nextInt();
			switch (opcion) {
			case 1: 
				System.out.println("Zona Socio\n");
				System.out.println("\n1.Iniciar Sesion\n2.Registro \n3.Salir");
				int opcionSocio=sc.nextInt();
				switch (opcionSocio) {
				case 1:
					System.out.println("Inicio Sesion");
					break;

				case 2:
					System.out.println("Registro");
					break;
				}

				break;
			case 2:  
				System.out.println("Zona Usuario\n");
				System.out.println("\n1.Iniciar Sesion\n2.Registro \n3.Salir");
				int opcionUsuario=sc.nextInt();
				switch (opcionUsuario) {
				case 1:
					System.out.println("Inicio Sesion");
					break;
				case 2:
					System.out.println("Registro");
					break;
				}


			}
			break;
		case 2:
			
			System.out.println("\n1.Conectarse a zona Cafeteria \n2.Conectarse a zona Cibercafe \n3.Salir");

			int opcionCliente=sc.nextInt();
			switch (opcionCliente) {
			case 1: 
				System.out.println("Zona cibercafe\n");
				System.out.println("\n1.Iniciar Sesion \n2.Salir");
				int opcionSocio=sc.nextInt();
				switch (opcionSocio) {
				case 1:
					System.out.println("Inicio Sesion");
					break;

				case 2:
					System.out.println("Estas saliendo");
					break;
				}

				break;
			case 2:  
				System.out.println("Zona cafeteria\n");
				System.out.println("\n1.Iniciando Sesion \n2.Salir");
				int opcionUsuario=sc.nextInt();
				switch (opcionUsuario) {
				case 1:
					System.out.println("Iniciando Sesion");
					break;
				case 2:
					System.out.println("Estas saliendo");
					break;
				}


			}
			break;
		default:
			break;
		}



		
		
	}
	
	
	}
	

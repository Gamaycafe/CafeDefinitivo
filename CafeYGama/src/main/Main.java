package main;

/**
 * @author: Jaime_Grisolia
 * @version: 24/05/2016
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import bbdd.BBDDEmpleados;
import bbdd.BBDDUsuario;
import bbdd.BaseDatos;
import clases.Empleados;
import clases.Usuario;

public class Main {

	private static String _usuario="root";
	private static String _pwd= "";
	private static String _bd="cibercafe";
	static String _url = "jdbc:mysql://localhost/"+_bd;
	private Connection conn = null;

	public static void main(String[] args) throws SQLException {
		String nif="",passwd="",codigo="",codigoE="";
		Scanner sc = new Scanner(System.in);
		Usuario u;
		Usuario usu;
		Empleados e;
		int opcionEmple=0;
		int opcionInicial=0;
		int opcion=0;
		int opcionE=0;
		int opcionUsuario=0;
		int opcionSocio=0;
		boolean registroS=false;
		boolean registroU=false;
		boolean accionRealizada=false;

		BaseDatos mibase=new BaseDatos("cibercafe");
		do{
			//ESTE BUCLE SERA UTILIZADO COMO VUELTA AL PRINCIPIO DEL PROGRAMA
			do{opcionEmple=0;
			opcionInicial=0;
			opcion=0;
			opcionE=0;
			opcionUsuario=0;
			opcionSocio=0;
			registroS=false;
			registroU=false;
			accionRealizada=false;
			System.out.println("---------------------------");
			System.out.println("Bienvenidos a Gama y Cafe");
			System.out.println("---------------------------");
			System.out.println();
			System.out.println("Acceder zona Cliente=>1");
			System.out.println("Acceder zona Empleado=>2");
			System.out.println("Forzar apagado=>3");

			opcionInicial=0;
			opcionInicial=sc.nextInt();

			switch (opcionInicial) {
			case 1:
				do{
					//ESTE BUCLE SERA UTILIZADO COMO VUELTA A LA SELECCION DEL TIPO DE CLIENTE
					opcionEmple=0;
					opcionInicial=0;
					opcion=0;
					opcionE=0;
					opcionUsuario=0;
					opcionSocio=0;
					registroS=false;
					registroU=false;
					accionRealizada=false;
					System.out.println("\n1.Conectarse como socio\n2.Conectarse como Usuario \n3.Volver");
					opcion=0;
					opcion=sc.nextInt();
					switch (opcion) {
					case 1: 
						do{
							//ESTE BUCLE SERA UTILIZADO COMO VUELTA AL MENU DE SOCIOS

							registroS=false;
							System.out.println("Zona Socio\n");
							System.out.println("\n1.Iniciar Sesion\n2.Registro \n3.Volver");
							opcionSocio=0;
							opcionSocio=sc.nextInt();
							sc.nextLine();
							//Prueba
							switch (opcionSocio) {
							case 1:
								sc.nextLine();
								System.out.println("Introduce DNI");
								nif=sc.nextLine();
								System.out.println("Introduce Contraseña");
								passwd=sc.nextLine();


								u = new Usuario(nif,passwd);
								
								mibase.abrir();
								//Abrimos BBDD
								codigo=BBDDUsuario.buscarUsuario(u, mibase.getConexion());
								//Buscamos Socio
								mibase.cerrar();
								//Cerramos BBDD
								if (codigo==null)
									System.out.println("Por motivos técnicos no podemos obtener la información");
								else
									if (codigo.equals(""))
										System.out.println("No es Socio");
									else
										System.out.println("Bienvenido a gama y cafe");





								break;

							case 2:

								System.out.println("Registro Socio");
								sc.nextLine();
								System.out.println("Introduce Nombre");
								String nombre=sc.nextLine();
								System.out.println("Introduce Contraseña");
								passwd=sc.nextLine();
								System.out.println("Introduce DNI");
								nif=sc.nextLine();



								u = new Usuario(nombre.toUpperCase(), passwd,nif.toUpperCase(),"");
								u.generar_codigo();//Generamos codigo de socio
								mibase.abrir();
								//Abrimos BBDD
								BBDDUsuario.crear(u, mibase.getConexion());
								//Creamos Socio
								System.out.println(nombre+" ,has sido registrado exitosamente");
								registroS=true;
								mibase.cerrar();
								//Cerramos BBDD


								break;
							}
						}while(registroS==true);
						break;
					case 2:  
						do{
							//ESTE BUCLE SERA UTILIZADO COMO VUELTA AL MENU DE USUARIO

							registroU=false;
							System.out.println("Zona Usuario\n");
							System.out.println("\n1.Iniciar Sesion\n2.Registro \n3.Volver");
							opcionUsuario=0;
							opcionUsuario=sc.nextInt();
							switch (opcionUsuario) {
							case 1:
								System.out.println("Inicio Sesion");
								sc.nextLine();
								System.out.println("Introduce DNI");
								nif=sc.nextLine();
								System.out.println("Introduce Contraseña");
								passwd=sc.nextLine();


								u = new Usuario(nif,passwd);
								mibase.abrir();
								codigo=BBDDUsuario.buscarUsuario(u, mibase.getConexion());
								mibase.cerrar();

								if (codigo==null)
									System.out.println("Por motivos técnicos no podemos obtener la información");
								else
									if (codigo.equals(" "))
										System.out.println("Bienvenido a zona usuario");
									else

										System.out.println("Usted es socio, Va a ser reedirijido al menu principal");
								opcionUsuario=3;
								break;
							case 2:

								System.out.println("Registro Usuario");
								sc.nextLine();
								System.out.println("Introduce Nombre de usuario");
								String nombre=sc.nextLine();
								System.out.println("Introduce Contraseña");
								passwd=sc.nextLine();
								System.out.println("Introduce DNI");
								nif=sc.nextLine();

								u = new Usuario(nombre.toUpperCase(), passwd,nif.toUpperCase()," ");
								//Abrimos BBDD
								mibase.abrir();
								BBDDUsuario.crear(u, mibase.getConexion());
								//Creamos usuario
								System.out.println(nombre+" ,has sido registrado exitosamente como usuario");
								mibase.cerrar();
								//cerramos BBDD
								registroU=true;


								break;
							}

						}while(registroU==true);

					}

				}while(opcionSocio==3||opcionUsuario==3);

				break;
			case 2:
				do{
					//ESTE BUCLE SERA UTILIZADO COMO VUELTA A LA SELECCION DEL TIPO DE EMPLEADO

					opcionEmple=0;
					opcionInicial=0;
					opcion=0;
					opcionE=0;
					opcionUsuario=0;
					opcionSocio=0;
					registroS=false;
					registroU=false;
					accionRealizada=false;
					System.out.println("\n1.Conectarse a zona Cafeteria \n2.Conectarse a zona Cibercafe \n3.Conectarse a zona ENCARGADO \n4.Salir");
					opcionE=0;
					opcionE=sc.nextInt();
					switch (opcionE) {
					case 1: 
						opcionEmple=0;
						System.out.println("Zona cafeteria\n");
						System.out.println("\n1.Iniciando Sesion \n2.Salir");
						opcionEmple=sc.nextInt();
						switch (opcionEmple) {
						case 1:
							System.out.println("Iniciando Sesion");
							sc.nextLine();
							System.out.println("Introduce Codigo empleado");
							String codS=sc.nextLine();



							e = new Empleados(codS);
							
							//abrimos BBDD
							mibase.abrir();
							codigoE=BBDDEmpleados.buscarEmple(e, mibase.getConexion());
							//Buscamos empleado en la BBDD
							mibase.cerrar();
							//Cerramos BBDD
							if (codigoE==null)
								System.out.println("Por motivos técnicos no podemos obtener la información");
							else
								if (codigoE.equals("CAFETERIA")||codigoE.equals("ENCARGADO"))
									System.out.println("QUE DESEA CONSULTAR?");
								else
									System.out.println("Usted no pertenece a la zona CAFETERIA");

							break;

						case 2:
							System.out.println("Estas saliendo");
							break;
						}

						break;
					case 2:  
						opcionEmple=0;
						System.out.println("Zona cibercafe\n");
						System.out.println("\n1.Iniciando Sesion \n2.Salir");
						opcionEmple=sc.nextInt();
						switch (opcionEmple) {
						case 1:
							System.out.println("Iniciando Sesion");
							sc.nextLine();
							System.out.println("Introduce Codigo empleado");
							String codS=sc.nextLine();



							e = new Empleados(codS);
							//abrimos base de datos
							mibase.abrir();
							codigoE=BBDDEmpleados.buscarEmple(e, mibase.getConexion());
							//Buscamos empleado en la BBDD
							mibase.cerrar();
							//cerramos base de datos

							if (codigoE==null)
								System.out.println("Por motivos técnicos no podemos obtener la información");
							else
								if (codigoE.equals("CIBER")||codigoE.equals("ENCARGADO"))
									System.out.println("QUE DESEA CONSULTAR?");

								else
									System.out.println("Usted no pertenece a la zona CIBER");

							break;
						case 2:
							System.out.println("Estas saliendo");
							break;
						}

					case 3: 
						opcionEmple=0;
						System.out.println("Zona Encargado\n");
						System.out.println("\n1.Iniciando Sesion \n2.Salir");
						opcionEmple=sc.nextInt();
						switch (opcionEmple) {
						case 1:
							System.out.println("Iniciando Sesion");
							sc.nextLine();
							System.out.println("Introduce el CODIGO DEL ENCARGADO");
							String codS=sc.nextLine();



							e = new Empleados(codS);
							//abrimos base de datos
							mibase.abrir();
							codigoE=BBDDEmpleados.buscarEmple(e, mibase.getConexion());
							//Buscamos empleado en la BBDD
							mibase.cerrar();
							//cerramos base de datos
							if (codigoE==null){
								System.out.println("Por motivos técnicos no podemos obtener la información");
							}else
								if (codigoE.equals("ENCARGADO")){
									do{
										//ESTE BUCLE SERA UTILIZADO COMO VUELTA AL MENU DEL ENCARGADO

										accionRealizada=false;
										System.out.println("Bienvenido Señor Encargado");
										System.out.println("\n1.Dar de alta empleado \n2.Dar de baja empleado\n3.Salir");
										opcionEmple=sc.nextInt();
										switch (opcionEmple) {
										case 1:

											sc.nextLine();
											System.out.println("Introduce Nombre");
											String nombreE=sc.nextLine();
											System.out.println("Introduce Apellido");
											String apellidoE=sc.nextLine();
											System.out.println("Introduce DNI");
											nif=sc.nextLine();
											System.out.println("Introduce direccion");
											String direccion=sc.nextLine();
											System.out.println("Introduce telefono");
											String telefono=sc.nextLine();
											System.out.println("Introduce tipo de contrato");
											String Contrato=sc.nextLine();
											System.out.println("Introduce antiguedad");
											int antiguedad=sc.nextInt();
											System.out.println("Introduce sueldo");
											int sueldo=sc.nextInt();
											sc.nextLine();
											System.out.println("Introduce cargo");
											String cargo=sc.nextLine();
											System.out.println("Introduce NSS");
											String NumSS=sc.nextLine();


											e = new Empleados ("",nif,nombreE, apellidoE,direccion,telefono,Contrato, antiguedad,sueldo,cargo,NumSS);
											e.generar_codigo(); //metodo utilizado para generar un codigo aleatorio
											//abrimos base de datos
											mibase.abrir();
											BBDDEmpleados.crear(e, mibase.getConexion());
											//creamos empleado en la BBDD
											System.out.println(nombreE+" ,ha sido usted contratado");
											mibase.cerrar();
											//cerramos base de datos
											accionRealizada=true;

											break;
										case 2:
											sc.nextLine();
											System.out.println("Introduzca codigo del empleado que quiera dar de baja");
											String despido=sc.nextLine();


											e = new Empleados (despido);
											//abrimos base de datos
											mibase.abrir();
											BBDDEmpleados.borrar(e, mibase.getConexion());
											//borramos empleado de BBDD
											System.out.println("El empleado cuyo codigo es " +despido+ " a sido dado de baja");
											mibase.cerrar();
											//cerramos base de datos
											accionRealizada=true;
											break;

										}

									}while(accionRealizada==true);

								}


								else
									System.out.println("(SISTEMA APAGANDOSE)...Usted no es el encargado,estamos avisando a la policia en este momento, toda lo que diga puede ser utilizado en su contra...");
							break;

						}
						break;
					default:
						break;
					}
				}while(opcionEmple==2);
			}

			}while(opcion==3||opcionE==4);
		}while(opcionEmple==3);
	}
}



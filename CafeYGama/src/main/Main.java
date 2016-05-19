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
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("---------------------------");
		System.out.println("Bienvenidos a Gama y Cafe");
		System.out.println("---------------------------");
		System.out.println();
		System.out.println("Conectarse como Socio->1");
		System.out.println();
		System.out.println("Conectarse como Usuario->2");
		int opcion=sc.nextInt();
			        switch (opcion) {
	            case 1: 
	            	System.out.println("Regis");

	                     break;
	            case 2:  
//
	                     break;


	           
	        }

	}

}

package main;

import data.Input;
import data.StringHelper;

public class UserInterface {
	
	
	public interface CheckFormat{
		boolean checkBadFormat(String str); 
	}
	
	
	public static  String scannFile(){
		String filePathandName="C:\\poo\\workspace\\Pets\\Pets.txt";
		String option;
		
		
		System.out.println("Introduzca fichero de contactos: "
				+ "('Enter' para fichero por defecto: " + filePathandName + ")");
		option=Input.scannLine();
		
		//Si usuario no introduce directorio es fichero por defecto
		if (!option.equals("")){
			filePathandName=option;
		}
		return filePathandName;
	}
	
	public static void printfMenu() { 
		System.out.println("Opciones posibles: (multiples separadas por espacio)");
		System.out.println("\t-h o \'Enter\'\t muestra esta ayuda");
		System.out.println("\t-a\t annade pet");
		//System.out.println("\t-l\t lista de contactos");
		System.out.println("\t-l\t lista de pets por nombre");
		System.out.println("\t-sn\t busca pet por nombre");
		System.out.println("\t-se\t busca jpet por email");
		System.out.println("\t-e\t edita pet");
		System.out.println("\t-r\t borra pet");
		System.out.println("\n\texit\t sal del programa\n");
		
	}
	
	public static String scannOption() {
		String input;
		System.out.println("Seleccione opcion: ('Enter' para ayuda)");
		input=Input.scannLine();
		
		while (input.equals("")){
			printfMenu();
			System.out.println("Seleccione opcion: ");
			input=Input.scannLine();
		}
		
		return input;
	}
	
	public static Person scannPropietario(){
		String contacto[]=new String[4];
		
		contacto[0]=scannLabel("Persona",true);
		
		contacto[1]=scannLabel("Telefono",true,new CheckFormat() {
			@Override
			public boolean checkBadFormat(String str) {
				return  !str.equals("") || !StringHelper.isInteger(str);
			}
		});
		
		contacto[2]=scannLabel("Email", true, new CheckFormat() {
			
			@Override
			public boolean checkBadFormat(String str) {
				return !str.equals("") || !StringHelper.isEmail(str);
			}
		});
		
		contacto[3]=scannLabel("Address", true);
		
		return new Person(contacto[0]+";"+contacto[1]+";"+contacto[2]+";"+contacto[3]);
	}
	
	
		private static String scannLabel( String label, boolean compulsory, CheckFormat checkformat){			
			if(checkformat==null)
				throw new RuntimeException("El parametro checkformat no puede ser null"); 
			
			System.out.print("\n" + label + ": ");
			String out = Input.scannLine();
			if (compulsory){
				do{
					System.out.print("\nIntroduzca un " + label + ": ");
					out=Input.scannLine();
				}while(checkformat.checkBadFormat(out)); 
			}
			return out;
		}
	
		private static String scannLabel(String label, boolean compulsory){	   
			return  scannLabel(label, compulsory, new CheckFormat() {
				@Override
				public boolean checkBadFormat(String str) {
					return str.equals(""); 
				}
			});
		}
		
		
		
		/*private static String scannName(boolean compulsory){
			System.out.print("\nNombre: ");
			String out = Input.scannLine();
			if (compulsory){
				while(out.equals("")){
					System.out.print("\nIntroduzca un nombre: ");
					out=Input.scannLine();
				}
			}
			return out;
		}*/
		/*
		private static String scannEmail(boolean compulsory){
	
			System.out.print("\nEmail: ");
			String email=Input.scannLine();
			if(compulsory && email.equals("")){
				while(!StringHelper.isEmail(email)){
					System.out.println("El email tiene que ser "
							+ "email.");
					email=Input.scannLine();
				}
			}
			return email;
		}*/
		
		/*
		private static String scannTelf(boolean compulsory){
			System.out.print("\nTelefono: ");
			String telf = Input.scannLine();
			if (compulsory && !telf.equals("")){
				while(!StringHelper.isInteger(telf)){
					System.out.println("El telefono tiene que ser "
							+ "numerico. No se admiten letras o "
							+ "simbolos");
					telf=Input.scannLine();
				}
			}
			return telf;
		}*/
		/*
		private static String scannAddrs(boolean compulsory){
			System.out.print("\nDireccion: ");
			String adrs = Input.scannLine();
			if (compulsory ){
				while(adrs.equals("")){
					System.out.print("\nIntroduzca una direccion: ");
					adrs=Input.scannLine();
				}
			}
			return adrs;
		}*/
		
		
		
		public static Mascota scannMascota(){
						
			String nombre=scannLabel("Nombre Mascota", true);
			
			String peso =  scannLabel("Peso", true, new CheckFormat() {
				
				@Override
				public boolean checkBadFormat(String str) {
					// TODO Auto-generated method stub
					return str.equals("") || !StringHelper.isInteger(str);
				}
			}); 
			//float altura = new ScannNum("Altura", true).getValue();  
			//float largo = new ScannNum("Largo", true).getValue();
		
			//return new Ave(nombre, peso, altura, largo);
			
			
			return null;
		}
		

		
		
}

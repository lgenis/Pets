package main;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import data.Input;
import data.StringHelper;

public class UserInterface {
	
	private static final String[] ESPECIES = new String[]{"gato", "perro", "ave", "roedor"};
	
	static Map<String, Class> map = new TreeMap<String, Class>();
	/** Adicione las clases que sea necesario */
	 static {
	        map.put(ESPECIES[0],Felino.class);
	        map.put(ESPECIES[1],Canido.class);
	        map.put(ESPECIES[2],Ave.class);
	        map.put(ESPECIES[3],Roedor.class);
	    } 
	 
	 
	
	public interface CheckFormat{
		boolean checkBadFormat(String str); 
	}
	
	
	private static CheckFormat  checkFloat  =  new CheckFormat() {
		@Override
		public boolean checkBadFormat(String str) {
			return str.equals("") || !StringHelper.isFloat(str); 
		}
	}; 
	
	public static  String scannFile(){
		String filePathandName="C:\\poo\\git\\Pets\\Pets.txt";
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
	
	

	private static String scannFormat( String label, CheckFormat checkformat){			
		if(checkformat==null)
			throw new RuntimeException("El parametro checkformat no puede ser null"); 	
		String out; 		
		do{
			System.out.print("\nIntroduzca un " + label + ": ");
			out=Input.scannLine();
		}while(checkformat.checkBadFormat(out)); 		
		return out;
	}
	
	public static String scannAll(String label){			
		return   scannFormat(label, new CheckFormat() {			
			@Override
			public boolean checkBadFormat(String str) {
				return true;
			}
		}); 
	}

	private static String scannNoEmpty( String label){
		return scannFormat(label,new CheckFormat() {			
			@Override
			public boolean checkBadFormat(String str) {
				return str.equals("");
			}
		} ); 
	}
	

	
	
	
	
	public static String scannOption() {
		String input=scannAll("Seleccione opcion: ('Enter' para ayuda)");
		return input;
	}
	
	
	
	
	public static Person scannPropietario(){
		String contacto[]=new String[4];
		
		contacto[0]=scannFormat("Persona", new CheckFormat(){
			@Override
			public boolean checkBadFormat(String str){
				return  str.split(" ").length<2 || str.equals("");
			}
		});
		
		contacto[1]=scannFormat("Telefono",new CheckFormat() {
			@Override
			public boolean checkBadFormat(String str) {
				return  str.equals("") || !StringHelper.isInteger(str);
			}
		});
		
		contacto[2]=scannFormat("Email",new CheckFormat() {
			
			@Override
			public boolean checkBadFormat(String str) {
				return str.equals("") || !StringHelper.isEmail(str);
			}
		});
		
		contacto[3]=scannNoEmpty("Address");
		
		return new Person(contacto[0]+";"+contacto[1]+";"+contacto[2]+";"+contacto[3]);
	}
	
	
	
				
	@SuppressWarnings("unused")
		public static Mascota scannMascota(){
			
			String especies = Arrays.toString(ESPECIES);
			
			String especie=scannFormat("Especie " + especies, new CheckFormat() {
				
				@Override
				public boolean checkBadFormat(String especie) {
					Class typeClass = map.get(especie);  
					return typeClass==null;
				}
			}); 
			
			String nombre=scannNoEmpty("Nombre Mascota");
			
			String pesoStr = scannFormat("Peso",  checkFloat); 
			float peso=Float.valueOf(pesoStr);
			
			String alturaStr = scannFormat("Altura",  checkFloat);
			float altura=Float.valueOf(alturaStr);
			
			String largoStr = scannFormat("Largo",  checkFloat);
			float largo=Float.valueOf(largoStr);
			
			 Class typeClass = map.get(especie);  
			 
			 Mascota mascota  = null; 
			 try {
				 mascota = (Mascota) typeClass.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
				System.exit(1);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(1);
			}

			//return new Ave(nombre, peso, altura, largo);
			
			return null;
		}
		

		
		
}

package main;

import java.util.ArrayList;
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
	
	 static Map<String, String> menu = new TreeMap<String, String>();
		/** Adicione las clases que sea necesario */
		 static {
			 	menu.put("", "tecla 'Enter muestra ayuda");
		        menu.put("-h","muestra esta ayuda");
		        menu.put("-a","annade pet");
		        menu.put("-l","lista de pets por nombre");
		        menu.put("-son","busca pet por nombre propietario");
		        menu.put("-soe","busca pet por email propietario");
		        menu.put("-eon","edita pet por nombre propietario");
		        menu.put("-en","edita pet por nombre mascota");
		        menu.put("-r","borra pet");
		        menu.put("exit","sal del programa\n");
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
		String filePathandName="DataBase.pet";
		String option;
		
		
		System.out.println("Introduzca fichero de contactos: "
				+ "(Presione tecla 'Enter' para fichero por defecto: " + filePathandName + ")");
		option=Input.scannLine();
		
		//Si usuario no introduce directorio es fichero por defecto
		if (!option.equals("")){
			filePathandName=option;
		}
		return filePathandName;
	}
	
	
	public static void printfMenu() { 
		System.out.println("Opciones posibles:");
		for (String key : menu.keySet()){
			System.out.println("\t" + key + "\t" + menu.get(key));
		}
		
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
				return false;
			}
		}); 
	}

	public static String scannNoEmpty( String label){
		return scannFormat(label,new CheckFormat() {			
			@Override
			public boolean checkBadFormat(String str) {
				return str.equals("");
			}
		} ); 
	}
	

	
	
	
	
	public static String scannOption() {
		String input=null;
		do{
			input=scannAll("opcion: "
				+ "(Presionando " + menu.get("")+")");
		}while(!menu.containsKey(input));
		
		return input;
	}
	
	
	
	
	public static Person scannPropietario(){
		String contacto[]=new String[4];
		
		contacto[0]=scannFormat("Persona (Nombre y Apellido)", new CheckFormat(){
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
				Class typeClass = map.get(especie.toLowerCase());  
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
		}catch (InstantiationException e) {
			e.printStackTrace();
			System.exit(1);
		}catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		 
		Person duenno = scannPropietario();
		
		mascota.setNombre(nombre);
		mascota.setPeso(peso);
		mascota.setAltura(altura);
		mascota.setLargo(largo);
		mascota.setPropietario(duenno);
		return mascota;
	}
	
	public static boolean scannConfirm(){
		String ans;
		do{
			System.out.println("Esta seguro? (si/no)");
			ans=Input.scannLine().trim().toLowerCase();
			
		}while(!(ans.equals("si") || ans.equals("no")));
		
		return ans.equals("si")?true:false;
	}
	
	public static Mascota scannSeleccion(ArrayList<Mascota> lista){
		int inp=0;
		ArrayList<Mascota> printMasc = new ArrayList<Mascota>();
		if (lista.size()!=1){
			printListWithNum(lista);
			
			String strInp=scannFormat("indice", new CheckFormat() {
				
				@Override
				public boolean checkBadFormat(String str) {

					if (!StringHelper.isInteger(str)){
						return true;
					}
					return (Integer.valueOf(str)<1 || Integer.valueOf(str)>lista.size());
				}
			});
			inp=Integer.valueOf(strInp)-1;
			
		}
		
		System.out.println("Se eliminara/editara:");
		printMasc = new ArrayList<Mascota>();
		printMasc.add(lista.get(inp));
		printListWithNum(printMasc);
		
		
		
		return scannConfirm()?lista.get(inp):null;
	}
	
	public static Mascota editSelection(Mascota masc){
		Mascota newMasc = scannMascota();
		Person newDuenno = newMasc.getPropietario();
		
		if (newMasc.getNombre().isEmpty()){
			newMasc.setNombre(masc.getNombre());
		}
		if (newMasc.getPeso()==0){
			newMasc.setPeso(masc.getPeso());
		}
		if (newMasc.getAltura()==0){
			newMasc.setAltura(masc.getAltura());
		}
		if (newMasc.getLargo()==0){
			newMasc.setLargo(masc.getLargo());
		}
		if (newDuenno.getFullName()==""){
			newDuenno.setSurname(masc.getPropietario().getSurname());
			newDuenno.setName(masc.getPropietario().getName());
		}
		if (newDuenno.getEmail()==""){
			newDuenno.setEmail(masc.getPropietario().getEmail());
		}
		if (newDuenno.getPhone()==""){
			newDuenno.setPhone(masc.getPropietario().getPhone());
		}
		if (newDuenno.getAddress()==""){
			newDuenno.setAddress(masc.getPropietario().getAddress());
		}
		return newMasc;
	}
	
	public static void printList(ArrayList<Mascota> lista){
		boolean printDuenno=false;
		System.out.println("Mostrar duennos:");
		printDuenno = scannConfirm();
		
		StringBuffer out = new StringBuffer("Nombre mascota\tPeso\tAltura\tLargo\t\t");
		if (printDuenno){
			out.append("Nombre duenno\tTelefono\tEmail\t\t\tAddress\t\t");
		}out.append("\n");
		
		for (Mascota masc: lista){
			out.append(masc.getNombre() + "\t\t");
			out.append(masc.getPeso() + "\t");
			out.append(masc.getAltura() + "\t");
			out.append(masc.getLargo() + "\t\t");
			if (printDuenno){
				out.append(masc.getPropietario().getFullName() + "\t");
				out.append(masc.getPropietario().getPhone() + "\t");
				out.append(masc.getPropietario().getEmail() + "\t");
				out.append(masc.getPropietario().getAddress() + "\t");
			}	
			out.append("\n");
		}
		System.out.println(out.toString());
	}
	
	public static void printListWithNum(ArrayList<Mascota> lista){
		boolean printDuenno=true;
				
		
		StringBuffer out=new StringBuffer("Index\tNombre mascota\tPeso\tAltura\tLargo\t\t");
		if (printDuenno){
			out.append("Nombre duenno\tTelefono\tEmail\t\t\tAddress\t\t");
		}out.append("\n");
		
		for (int i=0; i<lista.size(); i++){
			out.append((i+1) +" :\t");
			out.append(lista.get(i).getNombre() + "\t\t");
			out.append(lista.get(i).getPeso() + "\t");
			out.append(lista.get(i).getAltura() + "\t");
			out.append(lista.get(i).getLargo() + "\t\t");
			if (printDuenno){
				out.append(lista.get(i).getPropietario().getFullName() + "\t");
				out.append(lista.get(i).getPropietario().getPhone() + "\t");
				out.append(lista.get(i).getPropietario().getEmail() + "\t");
				out.append(lista.get(i).getPropietario().getAddress() + "\t");
			}	
			out.append("\n");
		}
		System.out.println(out.toString());
	}
		
}

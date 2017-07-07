package main;

import java.util.ArrayList;

import data.FileHelper;
import data.Finder;
import data.Finder.ContainsChecker;
import data.GsonHelper;
import data.Input;

public class PetsApp {
	

	public static void main(String[] args) {
		String file_Name=UserInterface.scannFile();

		String strJsonPets = FileHelper.readFileAsString(file_Name);
	

		ArrayList<Mascota> list = 
				GsonHelper.jsonFromArrayListMascotaToJson(strJsonPets);
		
		
		boolean exit=false; 
		
		UserInterface.printfMenu();
		
		
		
		
		do{
			String key = UserInterface.scannOption();
			ArrayList<Mascota> foundMascotas = new ArrayList<Mascota>();
			switch (key) {
				
				case "-a": 
					
					list.add(UserInterface.scannMascota(false)); 
					
					break;
				
				case "-eon":
					foundMascotas = findByOwnerName(list);
					if (!foundMascotas.isEmpty()){
						editor(foundMascotas, list);

					}else{
						System.out.println("NOT found");
					}

					break;
				
				case "-en":
					foundMascotas = findByName(list);
					if (!foundMascotas.isEmpty()){
						editor(foundMascotas, list);

					}else{
						System.out.println("NOT found");
					}
					break;
					
				case "-r":

					foundMascotas=findByOwnerName(list);
					if (!foundMascotas.isEmpty()){
						Mascota remMasc=UserInterface.scannSeleccion(foundMascotas);
						if (remMasc != null)
							list.remove(remMasc);

					}else{
						System.out.println("NOT found");
					}
						
					break;
					
				case "-l":
					UserInterface.printList(list);
					break;
					
				case "-son":
					foundMascotas = findByOwnerName(list);
					if (!foundMascotas.isEmpty()){
						UserInterface.printList(foundMascotas);
					}else{
						System.out.println("NOT found");
					}
					break;
						
				case "-soe":
					foundMascotas = findByOwnerEmail(list);
					if (!foundMascotas.isEmpty()){
						UserInterface.printList(foundMascotas);
					}else{
						System.out.println("NOT found");
					}
					break;
			
					
				case "exit":
					exit = true; 
					break;
					
				default:
					UserInterface.printfMenu();
					//key=UserInterface.scannOption();
					break;
				}
			
		}while(!exit);  
		FileHelper.writeFileAsString(GsonHelper.listaMascotasToJson(list), file_Name);
	}
	
	private static ArrayList<Mascota> findByOwnerName(ArrayList<Mascota> list){
		Finder<Mascota> findMascotas = new Finder<Mascota>();
		
		System.out.println("Introduzca nombre completo registro a buscar:");

		String mascRemove=UserInterface.scannNoEmpty("Nombre Propietario").toLowerCase();
				
		return (findMascotas.find(list, mascRemove, new ContainsChecker<Mascota>() {

					@Override
					public boolean containChecker(Mascota object, Object patron) {
						return object.getPropietario().getFullName().toLowerCase()
								.contains((String) patron);
					}
		}));
	}
	
	private static ArrayList<Mascota> findByOwnerEmail(ArrayList<Mascota> list){
		Finder<Mascota> findMascotas = new Finder<Mascota>();
		
		System.out.println("Introduzca Email registro a buscar:");

		String mascRemove=UserInterface.scannNoEmpty("Email Propietario").toLowerCase();
				
		return (findMascotas.find(list, mascRemove, new ContainsChecker<Mascota>() {

					@Override
					public boolean containChecker(Mascota object, Object patron) {
						return object.getPropietario().getEmail().toLowerCase()
								.contains((String) patron);
					}
		}));
	}
	
	private static ArrayList<Mascota> findByName(ArrayList<Mascota> list){
		Finder<Mascota> findMascotas = new Finder<Mascota>();
		
		System.out.println("Introduzca nombre mascota a buscar:");

		String mascRemove=UserInterface.scannNoEmpty("Nombre Mascota").toLowerCase();
				
		return (findMascotas.find(list, mascRemove, new ContainsChecker<Mascota>() {

					@Override
					public boolean containChecker(Mascota object, Object patron) {
						return object.getNombre().toLowerCase()
								.contains((String) patron);
					}
		}));
	}
	
	private static void editor(ArrayList<Mascota> foundMascotas, ArrayList<Mascota> list){
		Mascota newMascota;
		Mascota oldMascota;
		
		System.out.println("Edite los campos necesarios. Si no desea "
				+ "cambiar un campo, dejelo en blanco.");
		oldMascota=UserInterface.scannSeleccion(foundMascotas);
		newMascota=UserInterface.editSelection(oldMascota);
		list.remove(oldMascota);
		list.add(newMascota);
	}

}

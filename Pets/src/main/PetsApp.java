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
			switch (key) {
				
				case "-a": 
					
					list.add(UserInterface.scannMascota()); 
					FileHelper.writeFileAsString(GsonHelper.listaMascotasToJson(list),file_Name);
					
					break;
				/*
				case "-e":
					Person editPerson = null;
					System.out.println("Introduzca nombre completo registro a editar:");
					editPerson=list.findByFullName(UserInterface.scannName(true));
					if (editPerson!=null){
						System.out.println("Edite los campos necesarios. Si no desea "
								+ "cambiar un campo, dejelo en blanco.");
						list.edit(editPerson);
						FileHelper.writeFile(list.toFileFormatList(), file_Name);
					}else{
						System.out.println("NOT found");
					}
					
					
					break;
				*/
				case "-r":
					
					System.out.println("Introduzca nombre completo registro a eliminar:");
					ArrayList<Mascota> foundMascotas = new ArrayList<Mascota>();
					
					Finder<Mascota> findMascotas = new Finder<Mascota>();
					
					String mascRemove=UserInterface.scannNoEmpty("Nombre Propietario").toLowerCase();
							
					foundMascotas=findMascotas.find(list, mascRemove, new ContainsChecker<Mascota>() {

								@Override
								public boolean containChecker(Mascota object, Object patron) {
									return object.getPropietario().getFullName().toLowerCase()
											.contains((String) patron);
								}
					});
							

					if (foundMascotas!=null){
						Mascota remMasc=UserInterface.scannSeleccion(foundMascotas);
						
						//list.remove(remMasc);

					}else{
						System.out.println("NOT found");
					}
						
					break;
					
				case "-l":
					UserInterface.printList(list); 
					break;
					/*
				case "-son":
					
					//tempList =list.findByName(UserInterface.scannNoEmpty("Persona (nombre)"));
					//UserInterface.returnFound(tempList);
					break;
						
				case "-soe":
					tempList = list.findByEmail(UserInterface.scannEmail(true));
					UserInterface.returnFound(tempList);
					break;
			
				*/	
				case "exit":
					exit = true; 
					break;
					
				default:
					UserInterface.printfMenu();
					//key=UserInterface.scannOption();
					break;
				}
			
		}while(!exit);  
		
	}

}

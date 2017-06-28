package main;

import java.util.ArrayList;

import data.FileHelper;
import data.GsonHelper;

public class PetsApp {

	public static void main(String[] args) {
		String file_Name=UserInterface.scannFile();
		String strJsonPets = FileHelper.readFileAsString(file_Name);
		
		if(strJsonPets==null)
			strJsonPets = ""; 
		

		ArrayList<Mascota> list = 
				GsonHelper.jsonFromArrayListMascotaToJson(strJsonPets);
		Person tempList[] = null;
		
		boolean exit=false; 
		
		UserInterface.printfMenu();
		
		
	/*do{
			
			String key = UserInterface.scannOption();
			
			switch (key) {
			
				case "-a": 
					
					list.add(UserInterface.scannContact()); 
					FileHelper.writeFile(list.toFileFormatList(), file_Name);
					
					break;
					
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
					
				case "-r":
					Person foundPerson = null;
					System.out.println("Introduzca nombre completo registro a eliminar:");
					foundPerson=list.findByFullName(UserInterface.scannName(true));
					if (foundPerson!=null){
						list.remove(foundPerson);
						
					}else{
						System.out.println("NOT found");
					}
						
					break;
					
				case "-l":
					UserInterface.printList(list.sort()); 
					break;
					
				case "-sn":
					tempList =list.findByName(UserInterface.scannName(true));
					UserInterface.returnFound(tempList);
					break;
					
				case "-se":
					tempList = list.findByEmail(UserInterface.scannEmail(true));
					UserInterface.returnFound(tempList);
					break;
			
					
				case "exit":
					exit = true; 
					break;
					
				default:
					UserInterface.printfMenu();
					//key=UserInterface.scannOption();
					break;
				}
			
		}while(!exit);  */
		
	}

}

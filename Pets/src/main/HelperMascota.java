package main;

import java.util.ArrayList;
import java.util.Comparator;

public class HelperMascota {
	
	private ArrayList<Mascota> arrayMascotas;
	/*
	public ArrayList<Mascota> findByOwnerName(String name){

		ArrayList<Mascota> retArrayMascota;
		retArrayMascota = new ArrayList<Mascota>();
		
		for (Mascota masc: arrayMascotas){
			if (masc.getPropietario().getFullName().startsWith(name)){
				retArrayMascota.add(masc);
				
			}
		}
		return retArrayMascota;
	}
	
	public ArrayList<Mascota> findByOwnerEmail(String email){
		
		ArrayList<Mascota> retArrayMascota;
		retArrayMascota = new ArrayList<Mascota>();

		for (Mascota masc: arrayMascotas){
			if (masc.getPropietario().getEmail().startsWith(email)){
				retArrayMascota.add(masc);
			}
		}
		return retArrayMascota;
	}
	*/
	public static void sortArrayMascotaByLength(ArrayList<Mascota> list){
		list.sort(new Comparator<Mascota>(){

						@Override
						public int compare(Mascota o1, Mascota o2) {
							int r=0;
							if(o1.getLargo()<o2.getLargo()){
								r=-1;
							}else if(o1.getLargo()>o2.getLargo()){
								r=1;
							}
							return r;
						}
			
				});
	}
	
	public static void sortArrayMascotaByName(ArrayList<Mascota> list){
		list.sort(new Comparator<Mascota>(){

			@Override
			public int compare(Mascota o1, Mascota o2) {
				
				return o1.getNombre().compareTo(o2.getNombre());
			}

	});
	}
	
	public static void sortArrayMascotaByEmailOwner(ArrayList<Mascota> list){
		list.sort(new Comparator<Mascota>(){

			@Override
			public int compare(Mascota o1, Mascota o2) {
		
				return o1.getPropietario().getEmail()
						.compareTo(o2.getPropietario().getEmail());
			}

		});
	}
}

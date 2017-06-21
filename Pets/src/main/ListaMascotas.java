package main;

public class ListaMascotas {
	
	private Mascota[] arrayMascotas;
	
	public ListaMascotas(){
		arrayMascotas = new Mascota[0];
	}
	
	public void add(Mascota mascota){
		Mascota[] tem=new Mascota[arrayMascotas.length + 1];
		int i=0;
		for (i=0; i<arrayMascotas.length; i++)
			tem[i]=arrayMascotas[i];
		
		tem[i]=mascota;
		arrayMascotas=tem;
	}
	
	public Mascota get(int index){
		return arrayMascotas[index];
	}

	public int indexOf(Mascota mascota){
		int index = -1; 
		for(int i=0; i<arrayMascotas.length; i++){
			if(arrayMascotas[i].equals(mascota)){
				index = i;
				 break; 
			}
		}	
		return index; 
	}
	
	public void remove(Mascota mascota) {
		int index = indexOf(mascota);
		remove(index);
	}	
	
	public void remove(int index){
		Mascota copyMascotas[] = new Mascota[arrayMascotas.length-1];
	
			int j=0;
			for(int i=0;i<arrayMascotas.length;i++){
				if(i!=index){
					copyMascotas[j++]=arrayMascotas[i];
				}
			}
			arrayMascotas = copyMascotas;
		
	}
	
	
	
	public Mascota[] findByOwnerName(String name){
		int j=0;
		Mascota retArrayMascota[];
		for (Mascota masc: arrayMascotas){
			if (masc.getPropietario().getFullName().startsWith(name)){
				j++;
			}
		}
		retArrayMascota = new Mascota[j];
		j=0;
		for (Mascota masc: arrayMascotas){
			if (masc.getPropietario().getFullName().startsWith(name)){
				retArrayMascota[j]=masc;
				j++;
			}
		}
		return retArrayMascota;
	}
	
	public Mascota[] findByOwnerEmail(String email){
		int j=0;
		Mascota retArrayMascota[];
		for (Mascota masc: arrayMascotas){
			if (masc.getPropietario().getEmail().startsWith(email)){
				j++;
			}
		}
		retArrayMascota = new Mascota[j];
		j=0;
		for (Mascota masc: arrayMascotas){
			if (masc.getPropietario().getEmail().startsWith(email)){
				retArrayMascota[j]=masc;
				j++;
			}
		}
		return retArrayMascota;
	}
	
	public int size(){
		return arrayMascotas.length;
	}


}

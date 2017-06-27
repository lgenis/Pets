package main;

@Deprecated
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
		checkIndex(index);
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
	
	/**Si el entero es menor que cero o si el entero es mayor que length del
	 * arreglo lanza una excepcion Runtime con un mensaje para el programador
	 * @param index 
	 */
	public void checkIndex(int index){
		if (index<0 || index>=this.size())
			throw new RuntimeException("Indice fuera de rango");
	}
	
	public void remove(Mascota mascota) {
		int index = indexOf(mascota);
		remove(index);
	}	
	
	public void remove(int index){
		checkIndex(index);
		
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

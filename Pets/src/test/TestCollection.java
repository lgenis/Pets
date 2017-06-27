package test;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

import main.Ave;
import main.Canido;
import main.Felino;
import main.Mascota;
import main.Roedor;

public class TestCollection implements Comparator<Mascota> {
	
	Comparator<Mascota> comparator = new Comparator<Mascota>() {
		@Override
		public int compare(Mascota o1, Mascota o2) {
			return (o1.getNombre().toLowerCase()
			.compareTo(o2.getNombre().toLowerCase()));
		}
	};
	
	@Test
	public void testMascotaList(){
		ArrayList<Mascota> list = new ArrayList<Mascota>();
		
		list.add(new Ave("PIolin", 0.5f, 10f, 20f));
		list.add(new Ave("Lukas", 0.6f, 10f, 20f));
		list.add(new Felino("Tom", 4.5f, 15f, 20f));
		list.add(new Canido("Dog", 10.5f, 20f, 20f));
		
		Assert.assertEquals(4,  list.size());
		

		
		showList(list);
		
		ArrayList<Mascota> newList = new ArrayList<Mascota>();
		
		newList.addAll(list);
		
		newList.add(new Roedor("Miki", 0.3f, 1, 1.5f));
	}
	
	//test1
	@Test
	public void testArrayListSort(){
		ArrayList<Mascota> list = new ArrayList<Mascota>();
		
		list.add(new Ave("PIolin", 0.5f, 10f, 20f));
		list.add(new Ave("Lukas", 0.6f, 10f, 20f));
		list.add(new Felino("Tom", 4.5f, 15f, 20f));
		list.add(new Canido("Dog", 10.5f, 20f, 20f));
		
		Assert.assertEquals(4,  list.size());
		
		//Implementacion de Comparator de forma anonima
		list.sort(new Comparator<Mascota>(){

					@Override
					public int compare(Mascota o1, Mascota o2) {
						int r=0;
						if(o1.getAltura()<o2.getAltura()){
							r=-1;
						}else if(o1.getAltura()>o2.getAltura()){
							r=1;
						}
						return r;
					}
				}
			);
	}
	
	
	//test 2
	@Test
	public void testArrayListSort2(){
		ArrayList<Mascota> list = new ArrayList<Mascota>();
		
		list.add(new Ave("PIolin", 0.5f, 10f, 20f));
		list.add(new Ave("Lukas", 0.6f, 10f, 20f));
		list.add(new Felino("Tom", 4.5f, 15f, 20f));
		list.add(new Canido("Dog", 10.5f, 20f, 20f));
		
		Assert.assertEquals(4,  list.size());
		
		// Recibe una interface llama Comparator
		//ver en:
		//https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html
		//no debe implementar la interface en la clase del test, esto es un
		//ejemplo ver test3
		
		//Collections.sort(list, this);
		list.sort(this);
		showList(list);
		
	}
	
	//test3
		@Test
		public void testArrayListSort3(){
			ArrayList<Mascota> list = new ArrayList<Mascota>();
			
			list.add(new Ave("PIolin", 0.5f, 10f, 20f));
			list.add(new Ave("Lukas", 0.6f, 10f, 20f));
			list.add(new Felino("Tom", 4.5f, 15f, 20f));
			list.add(new Canido("Dog", 10.5f, 20f, 20f));
			
			Assert.assertEquals(4,  list.size());
			
			//Implementacion de Comparator de forma anonima
			list.sort(comparator);

		}
	

	/**
	 * Implementacion de comparator para test 1
	 */
	@Override
	public int compare(Mascota arg0, Mascota arg1) {
		int r=0;
		if(arg0.getPeso()<arg1.getPeso()){
			r=-1;
		}else if(arg0.getPeso()>arg1.getPeso()){
			r=1;
		}
		return r;
	}
	
	/**
	 * Muestra una lista
	 * @param list
	 */
	private void showList(ArrayList<Mascota> list){
		System.out.println("");
		System.out.println("ArrayList size: " + list.size());
		for(int i=0; i<list.size();i++){
			System.out.println(list.get(i).getNombre() +
					" \tpesa: " + list.get(i).getPeso()+
					" \talto: " + list.get(i).getAltura());
		}
	}
}

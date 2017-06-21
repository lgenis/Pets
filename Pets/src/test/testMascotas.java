package test;

import org.junit.Assert;
import org.junit.Test;

import main.Ave;
import main.Canido;
import main.Felino;
import main.ListaMascotas;
import main.Roedor;

public class testMascotas {
	
	@Test
	public void testListaMascotas(){
		
		ListaMascotas list = new ListaMascotas();
		
		list.add(new Canido("Firulais", 40, 0.5f, 0.5f));
		list.add(new Felino("Garfield", 20, 0.2f, 0.3f));
		list.add(new Ave("Parro", 0.5f, 0.1f, 0.15f));
		list.add(new Roedor("Hamm", .2f, 0.1f, 0.05f));
	
	
		//Error porque no extiende de Mascota
		//list.add(new Zapato())
		Assert.assertNotNull(list.get(0));
		Assert.assertNotNull(list.get(1));
		Assert.assertNotNull(list.get(2));
		Assert.assertNotNull(list.get(3));
		for(int i=0; i<list.size(); i++){
			System.out.println("Mascota: " 
							+ list.get(i).getNombre()
							+ "\nEstado Nutricion: " + list.get(i).getEstadoNutricion()
							+ "\nPeso Racion comida: " + list.get(i).getPesoRacion());
		
		}
	
	
	}
	
	@Test
	public void testListaMascotas2(){
		
		ListaMascotas list = new ListaMascotas();
		
		list.add(new Canido("Firulais", 40, 0.5f, 0.5f));
		list.add(new Felino("Garfield", 20, 0.2f, 0.3f));
		list.add(new Ave("Parro", 0.5f, 0.1f, 0.15f));
		list.add(new Roedor("Hamm", .2f, 0.1f, 0.05f));
	
	
		//Error porque no extiende de Mascota
		//list.add(new Zapato())
		list.add(new Canido("Firulais2", 40, 0.5f, 0.5f));
		list.add(new Felino("Grafield2", 20, 0.2f, 0.3f));
		list.add(new Ave("Parro2", 0.5f, 0.1f, 0.15f));
		list.add(new Roedor("Hamm2", .2f, 0.1f, 0.05f));
		

		
		
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getClass().isAssignableFrom(Canido.class)){
				Canido canido=(Canido) list.get(i);
				
				System.out.println("\nMascota: " 
								+ canido.getNombre()
								+ "\nCalidad colmillos: " + canido.getCalidadColmillo());
			
			}else if(list.get(i).getClass().isAssignableFrom(Felino.class)){
				Felino felin=(Felino) list.get(i);
				
				System.out.println("\nMascota: " 
								+ felin.getNombre()
								+ "\nCalidad colmillos: " + felin.getCalidadGarras());
							
			}else{
				System.out.println("\nMascota: " 
						+ list.get(i).getNombre()
						+ "\nEstado Nutricion: " + list.get(i).getEstadoNutricion()
						+ "\nPeso Racion comida: " + list.get(i).getPesoRacion());
			}
			
		}
	
	
	}
}

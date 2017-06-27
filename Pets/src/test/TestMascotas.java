package test;

import org.junit.Assert;
import org.junit.Test;

import main.Ave;
import main.Canido;
import main.Felino;
import main.ListaMascotas;
import main.Person;
import main.Roedor;


public class TestMascotas {
	
	
	//@Test
	public void testListaMascotas(){
		
		ListaMascotas list = new ListaMascotas();  
		
		list.add(new Canido("Firulais", 40, 0.50f,0.50f));
		list.add(new Felino("Garffiel", 20, 0.20f,0.30f));
		list.add(new Ave("Parro", 0.5f, 0.10f,0.15f));
		list.add(new Ave("Miki", 0.2f, 0.5f,0.1f));
		
		// Error porque no extiende de Mascota 
		// list.add(new Zapato());
		Assert.assertNotNull(list.get(0));
		Assert.assertNotNull(list.get(1));
		Assert.assertNotNull(list.get(2));
		Assert.assertNotNull(list.get(3));

		for(int i=0; i< list.size(); i++)
		      System.out.println("\nMascota: " 
		    		  	+ list.get(i).getNombre() 
		    		  	+ "\nEstado Nutricion:" + list.get(i).getEstadoNutricion()
		    		  	+ "\nPeso Racion comida: " + list.get(i).getPesoRacion());  
		
	
	 
	 	
	}
	
	

	@Test
	public void testListaMascotas2(){
		
		ListaMascotas list = new ListaMascotas();  
		
		
		// Error porque no extiende de Mascota 
		// list.add(new Zapato());
		list.add(new Canido("Firulais", 40, 0.50f,0.50f));
		list.add(new Felino("Garffiel", 20, 0.20f,0.30f));
		list.add(new Ave("Parro", 0.5f, 0.10f,0.15f));
		list.add(new Roedor("Miki", 0.2f, 0.5f,0.1f));



		for(int i=0; i< list.size(); i++){
			if(list.get(i).getClass().isAssignableFrom(Canido.class)) {
				Canido  canido = (Canido) list.get(i);
				System.out.println("\nMascota: " 
		    		  	+  canido.getNombre() 
		    		  	+ "\nCalidad colmillos:" +  canido.getCalidadColmillo()); 
			}else if(list.get(i).getClass().isAssignableFrom(Felino.class)) {
				Felino  canido = (Felino) list.get(i);
				System.out.println("\nMascota: " 
		    		  	+  canido.getNombre() 
		    		  	+ "\nCalidad colmillos:" +  canido.getCalidadGarras());
			}else{
				 System.out.println("\nMascota: " 
			    		  	+ list.get(i).getNombre() 
			    		  	+ "\nEstado Nutricion:"  
			    		  	+ "\nPeso Racion comida: " + list.get(i).getPesoRacion()); 
			}
		}
		
		
		//Assert.assertEquals(expected, actual, 0.4f); 
		       
		
	}
	
	
	
	    //@Test
		public void testListaMascotasPropietario(){
			
			ListaMascotas list = new ListaMascotas();  
			
			Canido can = new Canido("Firulais", 40, 0.50f,0.50f);
			Person propietario = new Person("Fredy Campino; 0034784512; fredy@fredy.com; Calle busquela"); 
			can.setPropietario(propietario);
			list.add(can);
			
			
			
			list.add(new Felino("Garffiel", 20, 0.20f,0.30f));
			list.add(new Ave("Parro", 0.5f, 0.10f,0.15f));
			list.add(new Ave("Miki", 0.2f, 0.5f,0.1f));
			
			// Error porque no extiende de Mascota 
			// list.add(new Zapato());
			Assert.assertNotNull(list.get(0));
			Assert.assertNotNull(list.get(1));
			Assert.assertNotNull(list.get(2));
			Assert.assertNotNull(list.get(3));

			for(int i=0; i< list.size(); i++)
			      System.out.println("\nMascota: " 
			    		  	+ list.get(i).getNombre() 
			    		  	+ "\nEstado Nutricion:" + list.get(i).getEstadoNutricion()
			    		  	+ "\nPeso Racion comida: " + list.get(i).getPesoRacion());  
					
		}
	
	

}
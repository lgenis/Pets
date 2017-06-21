package test;

import org.junit.Assert;
import org.junit.Test;

import main.Ave;
import main.Canido;
import main.Felino;
import main.ListaMascotas;
import main.Person;
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
	
	@Test
	public void testListaMascotas3(){
		
		ListaMascotas list = new ListaMascotas();
		
		
		Canido can = new Canido("Firulais", 40, 0.5f, 0.5f);
		Person propietario=new Person("Fredy Campino; 0034784515; fredy@fredy.com; Calle del Cifo 1");
		can.setPropietario(propietario);
		list.add(can);
		
		//list.add(new Canido("Firulais", 40, 0.5f, 0.5f));
		list.add(new Felino("Garfield", 20, 0.2f, 0.3f));
		list.get(list.size()-1).setPropietario(new Person("Geronimo Diaz; 0034568488; geronimo@diaz.com; Calle Violeta 2"));
		
		
		list.add(new Ave("Parro", 0.5f, 0.1f, 0.15f));
		list.get(list.size()-1).setPropietario(new Person("Pedro Lopez; 0034561103; pedro@lopez.com; Calle Pere Sert 33"));
		
		list.add(new Roedor("Hamm", .2f, 0.1f, 0.05f));
		list.get(list.size()-1).setPropietario(new Person("Hammond Gomez; 00345818; hammond@gomez.com; Calle Enginyeria 2"));
	
	
		//Error porque no extiende de Mascota
		//list.add(new Zapato())
		Assert.assertNotNull(list.get(0));
		Assert.assertNotNull(list.get(1));
		Assert.assertNotNull(list.get(2));
		Assert.assertNotNull(list.get(3));
		
		String nombresEntrada[]= new String[]{"fredy", "geronimo", "pedro", "hammond"};
		
		for(int i=0; i<list.size(); i++){
			System.out.println("Mascota: " 
							+ list.get(i).getNombre()
							+ "\nDuenno Nombre: " + list.get(i).getPropietario().getFullName() 
							+ "\nDuenno email: " + list.get(i).getPropietario().getEmail()
							+ "\nDuenno phone: " + list.get(i).getPropietario().getPhone()
							+ "\nDuenno direccion: " + list.get(i).getPropietario().getAddress());
			
			Assert.assertEquals(list.get(i).getNombre(), list.findByOwnerName(nombresEntrada[i])[0].getNombre());
			Assert.assertEquals(list.get(i).getNombre(), list.findByOwnerEmail(nombresEntrada[i])[0].getNombre());
		}
		
	
	
	}
}

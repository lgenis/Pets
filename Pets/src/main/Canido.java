package main;

public class Canido extends Mascota{
	
	

	private float calidadColmillo;
	
	
	public Canido(String nombre, float peso, float altura, float largo){
		super(nombre, peso, altura, largo);
		this.calidadColmillo=1;
	}
	
	public Canido(String nombre){
		super(nombre);
	}
	
		
	
	//Este metodo es comun en todas las mascotas PERO se calcula diferente:
	@Override
	public float getEstadoNutricion() {
		// Peso/(altura * largo)
		
		return getPeso()/(getAltura()*getLargo());
	}

	
	
	//Este Override define el metodo abstracto. Implementa el metodo abstracto (triangulito verde)
	//Se usa el mismo nombre que un override/sobreescrbir normal (triangulito blanco)
	@Override
	public float getPesoRacion() {
		// TODO Auto-generated method stub
		return 0.3f*getPeso()*(2f-calidadColmillo);
	}
	
	
	
	public float getCalidadColmillo() {
		return calidadColmillo;
	}

	public void setCalidadColmillo(float calidadColmillo) {
		this.calidadColmillo = calidadColmillo;
	}

	
	@Override
	protected String getTypeClass() {
		return getClass().getName();
	}
	
	@Override
	public String toString() {
		return super.toString() + " tipo Canido"; 
	}
}

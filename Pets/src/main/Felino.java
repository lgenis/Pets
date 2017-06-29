package main;

public class Felino extends Mascota {
	




	private float calidadGarras;
	
	public Felino(String nombre, float peso, float altura, float largo){
		super(nombre, peso, altura, largo);
		this.calidadGarras= 1;
	}
	
	public Felino(){
		super(); 
	}
	
	@Override
	public float getEstadoNutricion() {
		 return getPeso()/(getAltura()*getLargo());
	}
	
	@Override
	public float getPesoRacion(){
		return 0.1f*getPeso()*(2f-calidadGarras);
	}
	
	public float getCalidadGarras() {
		return calidadGarras;
	}

	public void setCalidadGarras(float calidadGarras) {
		this.calidadGarras = calidadGarras;
	}
	
	@Override
	protected String getTypeClass() {
		return getClass().getName();
	}
	
	@Override
	public String toString() {
		return super.toString() + " tipo Felino"; 
	}
}

package main;

public class Ave extends Mascota {



	private float calidadPlumas;
	
	public Ave(String nombre, float peso, float altura, float largo) {
		super(nombre, peso, altura, largo);
		this.setCalidadPlumas(1);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public float getEstadoNutricion() {
	
		return  getPeso()/(0.5f*getAltura()*getLargo());
	}
	@Override
	public float getPesoRacion() {
		return 0.2f*getPeso()*(2f-calidadPlumas);
	}

	public float getCalidadPlumas() {
		return calidadPlumas;
	}

	public void setCalidadPlumas(float calidadPlumas) {
		this.calidadPlumas = calidadPlumas;
	}
	
	

}

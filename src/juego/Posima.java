package juego;

public abstract class Posima {
	private String nombre;
	
	public Posima(String nombre) { 
		this.nombre=nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public abstract Double aplicarPosima(String nombre, double valor);
	
}
